package io.junseok.mealmateapi.presentation.memberwish

import io.junseok.domain.memberwish.MemberWishService
import io.junseok.mealmateapi.presentation.memberwish.dto.response.WishListResponse
import io.junseok.mealmateapi.presentation.memberwish.dto.response.WishListResponse.Companion.fromWistList
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/api/wish")
@CrossOrigin
class WishController(
    private val memberWishService: MemberWishService
) {

    @GetMapping("/save/{restaurantId}")
    fun saveWishList(
        @PathVariable restaurantId: Long,
        principal: Principal
    ): ResponseEntity<Long> =
        ResponseEntity.ok(memberWishService.createWishList(restaurantId, principal.name))


    @GetMapping
    fun getMemberWishLists(principal: Principal): ResponseEntity<List<WishListResponse>> =
        ResponseEntity.ok(memberWishService.getWishList(principal.name).map { it.fromWistList() })

    @GetMapping("/{restaurantId}")
    fun getWishList(
        @PathVariable restaurantId: Long,
        principal: Principal
    ): ResponseEntity<Boolean> = ResponseEntity.ok(
        memberWishService.findWishList(principal.name,restaurantId)
    )

    @DeleteMapping("/{restaurantId}")
    fun deleteWishList(
        @PathVariable restaurantId: Long,
        principal: Principal
    ): ResponseEntity<Unit> {
        memberWishService.removeWishList(restaurantId)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/count")
    fun getWishListCount(principal: Principal): ResponseEntity<Int> =
        ResponseEntity.ok(memberWishService.showWishListCount(principal.name))
}
