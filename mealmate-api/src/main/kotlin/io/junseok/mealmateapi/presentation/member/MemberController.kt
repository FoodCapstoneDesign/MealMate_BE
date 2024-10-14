package io.junseok.mealmateapi.presentation.member

import io.junseok.domain.member.MemberService
import io.junseok.mealmateapi.presentation.member.dto.request.EmailCheck
import io.junseok.mealmateapi.presentation.member.dto.request.EmailCheck.Companion.toMemberEmail
import io.junseok.mealmateapi.presentation.member.dto.request.ModifyMemberInfo
import io.junseok.mealmateapi.presentation.member.dto.request.ModifyMemberInfo.Companion.toMemberModify
import io.junseok.mealmateapi.presentation.member.dto.request.SignUpDto
import io.junseok.mealmateapi.presentation.member.dto.request.SignUpDto.Companion.toMemberSignUp
import io.junseok.mealmateapi.presentation.member.dto.response.MemberInfoDto
import io.junseok.mealmateapi.presentation.member.dto.response.MemberInfoDto.Companion.fromMember
import io.junseok.mealmateapi.presentation.restaurant.dto.response.RestaurantInfo
import io.junseok.mealmateapi.presentation.restaurant.dto.response.RestaurantInfo.Companion.fromRestaurant
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/api/member")
@CrossOrigin
class MemberController(
    private val memberService: MemberService,
) {
    @PostMapping("/signup")
    fun signUp(@RequestBody signUpDto: SignUpDto): ResponseEntity<Long> {
        return ResponseEntity.ok(memberService.createMember(signUpDto.toMemberSignUp()));
    }

    @GetMapping
    fun getMemberInfo(principal: Principal): ResponseEntity<MemberInfoDto> {
        return ResponseEntity.ok(
            memberService.showMemberInfo(principal.name).fromMember()
        )
    }

    @DeleteMapping
    fun deleteMember(principal: Principal): ResponseEntity<Unit> {
        memberService.resignMember(principal.name);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/check-email")
    fun checkEmail(@RequestBody emailCheck: EmailCheck): ResponseEntity<Unit> {
        memberService.validEmail(emailCheck.toMemberEmail());
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    fun updateMemberInfo(
        @RequestBody modifyMemberInfo: ModifyMemberInfo,
        principal: Principal,
    ): ResponseEntity<Unit> {
        memberService.updateMember(
            modifyMemberInfo.toMemberModify(),
            principal.name
        )
        return ResponseEntity.ok().build();
    }

    @GetMapping("/suggestion")
    fun recommendRestaurant(principal: Principal): ResponseEntity<List<RestaurantInfo>> =
        ResponseEntity.ok(memberService.suggestRestaurant(principal.name).map { it.fromRestaurant() })
}
