package io.junseok.mealmatestorage.persistence.membercatefgory

import io.junseok.mealmatestorage.persistence.member.MemberEntity
import javax.persistence.*

@Entity
@Table(name = "member_category")
class MemberCategoryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_category_id")
    var memberCategoryId: Long? = null,

    @Column(name = "category_name")
    var categoryName: String,

    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    val memberEntity: MemberEntity
)