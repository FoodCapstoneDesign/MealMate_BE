package io.junseok.mealmateapi.presentation.noteroom

import io.junseok.domain.noteroom.NoteRoomService
import io.junseok.mealmateapi.presentation.noteroom.dto.request.NoteRoomRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@CrossOrigin
@RequestMapping("/api/noteroom")
class NoteRoomController(
    private val noteRoomService: NoteRoomService,
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
            noteRoomService.generateRoom(noteRoomRequest.opponentId, principal.name)
        );

    /**
     * TODO
     * 방 나가기
     */
    @DeleteMapping
    fun goOutRoom(principal: Principal): ResponseEntity<Unit> {
        noteRoomService.deleteRoom(principal.name)
        return ResponseEntity.ok().build()
    }


    /**
     * TODO
     * 방 들어가기
     */
    @GetMapping("/{noteRoomId}")
    fun getNoteRoom(@PathVariable noteRoomId: Long, principal: Principal) {

    }
}