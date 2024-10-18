package io.junseok.mealmateadminapi.domain

fun Admin.toEntity()=AdminEntity(
    email = this.email,
    restaurantName = this.restaurantName,
    password = this.password,
    authority = this.authority,
    activated = this.activated
)