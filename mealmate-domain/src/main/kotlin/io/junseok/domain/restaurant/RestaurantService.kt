package io.junseok.domain.restaurant

import io.junseok.domain.restaurant.serviceimpl.RestaurantCreator
import io.junseok.domain.restaurant.serviceimpl.RestaurantDeleter
import io.junseok.domain.restaurant.serviceimpl.RestaurantReader
import io.junseok.domain.restaurant.serviceimpl.RestaurantValidator
import io.junseok.domain.restaurantmenu.serviceimpl.RestaurantMenuReader
import io.junseok.image.FileConversion
import io.junseok.service.S3UploadImage
import org.springframework.stereotype.Service

@Service
class RestaurantService(
    private val s3UploadImage: S3UploadImage,
    private val restaurantValidator: RestaurantValidator,
    private val restaurantCreator: RestaurantCreator,
    private val restaurantDeleter: RestaurantDeleter,
    private val restaurantReader: RestaurantReader,
    private val restaurantMenuReader: RestaurantMenuReader
) {
    fun createRestaurant(
        restaurantRegister: RestaurantRegister,
        imageFile: FileConversion
    ): Long?{
        restaurantValidator.isExist(restaurantRegister.restaurantName)
        val s3Response = s3UploadImage.saveImage(imageFile)
        return restaurantCreator.create(restaurantRegister,s3Response)
    }

    fun removeRestaurant(restaurantId: Long){
        restaurantValidator.isExistRestaurantById(restaurantId)
        restaurantDeleter.delete(restaurantId)
    }

    fun findRestaurants(restaurantType: String?): List<Restaurant> =
        restaurantType?.let { restaurantReader.findAllByRestaurantType(restaurantType) }
            ?: restaurantReader.findAllRestaurant()

    fun showBestRestaurants(): List<Restaurant> = restaurantReader.findBestRestaurant()

    fun findRestaurantInfo(restaurantId: Long): RestaurantDetail{
        val restaurant = restaurantReader.findById(restaurantId)
        val restaurantMenus = restaurantMenuReader.findAllMenu(restaurant)
        return RestaurantDetail(
            restaurant = restaurant,
            restaurantMenu = restaurantMenus
        )
    }

    fun findRestaurantByName(restaurantName: String): List<Restaurant> =
        restaurantReader.findByRestaurantName(restaurantName)

}