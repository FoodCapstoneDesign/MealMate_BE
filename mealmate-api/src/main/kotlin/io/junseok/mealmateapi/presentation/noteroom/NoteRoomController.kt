package io.junseok.mealmateapi.presentation.noteroom

import io.junseok.domain.noteroommember.NoteRoomMemberService
import io.junseok.mealmateapi.presentation.noteroom.dto.request.NoteRoomRequest
import io.junseok.mealmateapi.presentation.noteroom.dto.response.NoteRoomResponse
import io.junseok.mealmateapi.presentation.noteroom.dto.response.NoteRoomResponse.Companion.toNoteRoomResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@CrossOrigin
@RequestMapping("/api/noteroom")
class NoteRoomController(
    private val noteRoomMemberService: NoteRoomMemberService,
) {
    /**
     * TODO
     * 방 생성
     */
    @PostMapping
    fun createRoom(
        @RequestBody noteRoomRequest: NoteRoomRequest,
        principal: Principal,
    ): ResponseEntity<Long> =
        ResponseEntity.status(HttpStatus.CREATED).body(
            noteRoomMemberService.generateRoom(noteRoomRequest.opponentId, principal.name)
        );

    /**
     * TODO
     * 방 나가기
     */
    @DeleteMapping
    fun goOutRoom(principal: Principal): ResponseEntity<Unit> {
        noteRoomMemberService.deleteRoom(principal.name)
        return ResponseEntity.ok().build()
    }

    /**
     * TODO
     * 쪽지방 목록 불러오기
     */
    @GetMapping("/list")
    fun showAllNoteRoom(principal: Principal): ResponseEntity<List<NoteRoomResponse>> =
        ResponseEntity.ok(
            noteRoomMemberService.getRoomList(principal.name).map { it.toNoteRoomResponse() }
        )
}