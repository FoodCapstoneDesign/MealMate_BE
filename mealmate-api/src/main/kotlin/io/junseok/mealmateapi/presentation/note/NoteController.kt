package io.junseok.mealmateapi.presentation.note

import io.junseok.domain.note.NoteService
import io.junseok.mealmateapi.presentation.note.dto.request.NoteRequest
import io.junseok.mealmateapi.presentation.note.dto.request.NoteRequest.Companion.toDomain
import io.junseok.mealmateapi.presentation.note.dto.response.NoteResponse
import io.junseok.mealmateapi.presentation.note.dto.response.NoteResponse.Companion.fromDomain
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@CrossOrigin
@RequestMapping("/api/note")
class NoteController(
    private val noteService: NoteService,
) {

    /**
     * TODO
     * 쪽지 전달
     */
    @PostMapping
    fun sendNote(
        @RequestBody noteRequest: NoteRequest,
        principal: Principal,
    ): ResponseEntity<Long> =
        ResponseEntity.ok(
            noteService.transmitNote(
                noteRequest.toDomain(), principal.name
            )
        )

    /**
     * TODO
     * 쪽지 불러오기
     */
    @GetMapping("/{noteRoomId}")
    fun getNoteList(@PathVariable noteRoomId: Long): ResponseEntity<List<NoteResponse>> =
        ResponseEntity.ok(noteService.showAllNotes(noteRoomId).map { it.fromDomain() })
}