package io.junseok.mealmateapi.presentation.board

import io.junseok.domain.board.BoardService
import io.junseok.mealmateapi.presentation.board.dto.request.BoardRequest
import io.junseok.mealmateapi.presentation.board.dto.request.BoardRequest.Companion.toDomain
import io.junseok.mealmateapi.presentation.board.dto.response.BoardResponse
import io.junseok.mealmateapi.presentation.board.dto.response.BoardResponse.Companion.fromBoard
import io.junseok.mealmateapi.presentation.board.dto.response.BoardResponse.Companion.fromBoardByPaging
import io.junseok.page.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/api/board")
@CrossOrigin
class BoardController(
    private val boardService: BoardService,
) {

    @PostMapping
    fun writeBoard(
        @RequestBody boardRequest: BoardRequest,
        principal: Principal,
    ): ResponseEntity<Long> =
        ResponseEntity.ok(
            boardService.createBoard(
                boardRequest.toDomain(),
                boardRequest.restaurantId,
                principal.name,
            )
        )

    /**
     * NOTE
     * 게시판 목록 조회
     */
    @GetMapping
    fun boardList(
        @RequestParam(value = "page") page: Int,
        @RequestParam(value = "size") size: Int,
        @RequestParam(value = "department", required = false) department: String,
    ): ResponseEntity<Page<BoardResponse>> =
        ResponseEntity.ok(boardService.showBoardList(page, size, department).fromBoardByPaging())


    /**
     * NOTE
     * 단일 게시판 조회
     */
    @GetMapping("/{boardId}")
    fun findBoard(@PathVariable boardId: Long): ResponseEntity<BoardResponse> =
        ResponseEntity.ok(boardService.getBoard(boardId).fromBoard())


    @DeleteMapping("/{boardId}")
    fun deleteBoard(@PathVariable boardId: Long): ResponseEntity<Unit> {
        boardService.remove(boardId)
        return ResponseEntity.ok().build()
    }

    @PatchMapping("/{boardId}")
    fun modifyBoard(
        @PathVariable boardId: Long,
        @RequestBody boardRequest: BoardRequest,
    ): ResponseEntity<Long> =
        ResponseEntity.ok(
            boardService.modifyBoard(boardId, boardRequest.toDomain())
        )

    /**
     * NOTE
     * 식당에 관한 게시글 조회
     */
    @GetMapping("/{restaurantId}/list")
    fun bringBoardByRestaurant(
        @PathVariable restaurantId: Long,
        @RequestParam(value = "page") page: Int,
        @RequestParam(value = "size") size: Int,
    ): ResponseEntity<Page<BoardResponse>> =
        ResponseEntity.ok(
            boardService.getBoardByRestaurant(restaurantId, page, size).fromBoardByPaging()
        )

    /**
     * NOTE
     * 모집 상태 변경 API
     */
    @PatchMapping("/update/recruitment/{boardId}")
    fun updateRecruitmentStatus(
        @PathVariable boardId: Long,
        principal: Principal,
    ): ResponseEntity<Unit> =
        ResponseEntity.ok(boardService.modifyRecruitment(boardId, principal.name))

}