package io.junseok.mealmatestorage.persistence.restaurantadmin

import io.junseok.domain.restaurantadmin.Admin
import io.junseok.domain.restaurantadmin.AdminInfo

fun Admin.toEntity()=AdminEntity(
    email = this.email,
    restaurantName = this.restaurantName,
    password = this.password,
    authority = this.authority,
    activated = this.activated
)

fun AdminEntity.toAdminInfo()= AdminInfo(
    restaurantName = this.restaurantName
)

fun AdminEntity.toAdmin()= Admin(
    email = this.email,
    restaurantName = this.restaurantName,
    password = this.password,
    authority = this.authority,
    activated = this.activated
)