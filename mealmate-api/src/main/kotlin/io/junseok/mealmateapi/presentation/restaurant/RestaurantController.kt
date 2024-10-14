package io.junseok.mealmateapi.presentation.restaurant

import io.junseok.domain.restaurant.RestaurantService
import io.junseok.mealmateapi.presentation.restaurant.dto.request.RestaurantRegisterRequest
import io.junseok.mealmateapi.presentation.restaurant.dto.request.RestaurantRegisterRequest.Companion.toDomain
import io.junseok.mealmateapi.presentation.restaurant.dto.request.SearchRequest
import io.junseok.mealmateapi.presentation.restaurant.dto.response.RestaurantDetailInfo
import io.junseok.mealmateapi.presentation.restaurant.dto.response.RestaurantDetailInfo.Companion.fromRestaurantDetailInfo
import io.junseok.mealmateapi.presentation.restaurant.dto.response.RestaurantInfo
import io.junseok.mealmateapi.presentation.restaurant.dto.response.RestaurantInfo.Companion.fromRestaurant
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@CrossOrigin
@RequestMapping("/api/restaurant")
class RestaurantController(
    private val restaurantService: RestaurantService,
) {
    @PostMapping(value = [""], consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun registerRestaurant(
        @RequestPart(value = "imageFile", required = true) imageFile: MultipartFile,
        @RequestPart(value = "restaurantRegister") restaurantRegisterRequest: RestaurantRegisterRequest,
    ): ResponseEntity<Long?> =
        ResponseEntity.ok(
            restaurantService.createRestaurant(
                restaurantRegisterRequest.toDomain(),
                imageFile
            )
        )

    /**
     * 식당 정보 삭제
     */
    @DeleteMapping("/{restaurantId}")
    fun deleteRestaurant(@PathVariable restaurantId: Long): ResponseEntity<Unit> {
        restaurantService.removeRestaurant(restaurantId)
        return ResponseEntity.ok().build()
    }

    /**
     * 검색한 타입에 맞는 식당 목록 반환
     */
    @GetMapping
    fun getRestaurantList(
        @RequestParam(value = "type", required = false) restaurantType: String?
    ): ResponseEntity<List<RestaurantInfo>?> =
        ResponseEntity.ok(
            restaurantService.findRestaurants(restaurantType).map { it.fromRestaurant() }
        )

    @GetMapping("/best")
    fun bestRestaurantList(): ResponseEntity<List<RestaurantInfo>> =
        ResponseEntity.ok(restaurantService.showBestRestaurants().map { it.fromRestaurant() })

    /**
     * 식당 세부정보 조회
     */
    @GetMapping("/{restaurantId}")
    fun getRestaurantInfo(@PathVariable restaurantId: Long): ResponseEntity<RestaurantDetailInfo> =
        ResponseEntity.ok(restaurantService.findRestaurantInfo(restaurantId).fromRestaurantDetailInfo())

    @PostMapping("/search")
    fun searchRestaurant(@RequestBody searchRequest: SearchRequest): ResponseEntity<List<RestaurantInfo>> =
        ResponseEntity.ok(
            restaurantService.findRestaurantByName(searchRequest.restaurantName)
                .map { it.fromRestaurant() }
        )
}