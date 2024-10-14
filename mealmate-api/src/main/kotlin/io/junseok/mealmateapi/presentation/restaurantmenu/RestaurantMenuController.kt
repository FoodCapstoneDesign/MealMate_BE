package io.junseok.mealmateapi.presentation.restaurantmenu

import io.junseok.domain.restaurantmenu.RestaurantMenuService
import io.junseok.mealmateapi.presentation.restaurantmenu.dto.request.MenuRegisterRequest
import io.junseok.mealmateapi.presentation.restaurantmenu.dto.request.MenuRegisterRequest.Companion.toDomain
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/api/restaurant-menu")
@CrossOrigin
class RestaurantMenuController(
    private val restaurantMenuService: RestaurantMenuService
) {
    @PostMapping("/{restaurantId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    fun createMenu(
        @PathVariable restaurantId: Long,
        @RequestBody menuList: List<MenuRegisterRequest>,
        principal: Principal

    ): ResponseEntity<Unit> {
        restaurantMenuService.registerMenu(restaurantId, menuList.map { it.toDomain() })
        return ResponseEntity.ok().build()
    }

    /*@PatchMapping("/{restaurantMenuId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    fun modifyMenu(
        @PathVariable restaurantMenuId: Long,
        @RequestBody menuRegisterRequest: MenuRegisterRequest,
        principal: Principal
    ): ResponseEntity<Unit> {
        restaurantMenuService.updateMenu(
            restaurantMenuId,
            menuRegisterRequest.toDomain(),
            principal.name
        )
        return ResponseEntity.ok().build()
    }*/

    @DeleteMapping("/{restaurantMenuId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    fun removeMenu(@PathVariable restaurantMenuId: Long, principal: Principal):ResponseEntity<Unit>{
        restaurantMenuService.deleteMenu(restaurantMenuId)
        return ResponseEntity.ok().build()
    }
}
