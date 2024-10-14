package io.junseok.mealmatestorage.persistence.memberwish

import io.junseok.mealmatestorage.persistence.member.MemberEntity
import io.junseok.mealmatestorage.persistence.restaurant.RestaurantEntity
import javax.persistence.*

@Entity
@Table(name = "member_wish")
class MemberWishEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_wish_id")
    var memberWishId: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val member: MemberEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    val restaurant: RestaurantEntity
) {
}