package io.junseok.mealmateadminapi.domain

import javax.persistence.*

@Entity
@Table(name = "admin")
class AdminEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    var adminId: Long? = null,

    @Column(name = "email")
    var email: String,

    @Column(name = "restaurant_name")
    var restaurantName: String,

    @Column(name = "password")
    var password: String,

    @Column(name = "activated")
    var activated: Boolean,

    @Column(name = "authority")
    val authority: String

) {
}