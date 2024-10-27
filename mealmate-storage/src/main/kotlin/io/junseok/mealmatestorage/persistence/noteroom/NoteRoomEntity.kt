package io.junseok.mealmatestorage.persistence.noteroom

import javax.persistence.*

@Entity
@Table(name = "note_room")
class NoteRoomEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name =" room_id")
    var noteRoomId:Long?=null,

    @Column(name = "creator")
    val creator: String
) {
}