package io.junseok.mealmatestorage.persistence.board

import io.junseok.domain.board.Board
import io.junseok.mealmatestorage.persistence.base.BaseTimeEntity
import io.junseok.mealmatestorage.persistence.member.MemberEntity
import io.junseok.mealmatestorage.persistence.restaurant.RestaurantEntity
import javax.persistence.*

@Entity
@Table(name = "board")
class BoardEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    var boardId: Long? = null,

    @Column(name = "title")
    var title: String,

    @Column(name = "content")
    var content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val member: MemberEntity,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    val restaurant: RestaurantEntity
) :BaseTimeEntity(){
    fun updateBoard(board: Board) {
        this.title = board.title
        this.content = board.content
    }
}