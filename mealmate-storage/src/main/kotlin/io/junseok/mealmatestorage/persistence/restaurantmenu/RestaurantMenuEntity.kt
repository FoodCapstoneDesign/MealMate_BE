package io.junseok.mealmatestorage.persistence.restaurantmenu

import io.junseok.mealmatestorage.persistence.restaurant.RestaurantEntity
import javax.persistence.*

@Entity
@Table(name = "restaurant_menu")
class RestaurantMenuEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_menu_id")
    val restaurantMenuId: Long? = null,

    @Column(name = "menu_name")
    var menuName: String,

    @Column(name = "menu_price")
    var menuPrice: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    val restaurant: RestaurantEntity
) {
    fun update(menuName: String, menuPrice: String){
        this.menuName = menuName
        this.menuPrice = menuPrice
    }
}