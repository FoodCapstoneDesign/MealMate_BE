package io.junseok.mealmatestorage.persistence.memberwish

import io.junseok.domain.member.Member
import io.junseok.domain.memberwish.MemberWish
import io.junseok.domain.memberwish.MemberWishRepository
import io.junseok.domain.restaurant.Restaurant
import io.junseok.mealmatestorage.persistence.member.toEntity
import io.junseok.mealmatestorage.persistence.restaurant.toEntity
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class MemberWishEntityRepository(
    private val memberWishJpaRepository: MemberWishJpaRepository
) : MemberWishRepository {
    override fun existsByRestaurantAndMember(member: Member, restaurant: Restaurant) =
        memberWishJpaRepository.existsByRestaurantAndMember(restaurant.toEntity(),member.toEntity())

    @Transactional
    override fun save(memberWish: MemberWish) =
        memberWishJpaRepository.save(memberWish.toEntity()).memberWishId!!

    @Transactional(readOnly = true)
    override fun findAllMember(member: Member): List<MemberWish> =
        memberWishJpaRepository.findAllByMember(member.toEntity()).map { it.toDomain() }

    @Transactional
    override fun deleteByRestaurant(restaurant: Restaurant) {
        memberWishJpaRepository.deleteByRestaurant(restaurant.toEntity())
    }

    @Transactional(readOnly = true)
    override fun countByMember(member: Member) =
        memberWishJpaRepository.countByMember(member.toEntity())

}