package ru.ohmypeer.gbkotlin.data


object NotesRepository {

    private val notes: List<Note>

    init {
        notes = listOf(
            Note(
                "Первая заметка",
                    false,
                "Вкл",
                    "Выкл",
                0xfff36292.toInt()
            ),
                Note(
                        "2я заметка",
                        false,
                        "Вкл",
                        "Выкл",
                        0xfff062cc.toInt()
                ),
                Note(
                        "3я заметка",
                        true,
                        "Вкл",
                        "Выкл",
                        0xffc062f2.toInt()
                ),
                Note(
                        "4я заметка",
                        false,
                        "Вкл",
                        "off",
                        0xfff05292.toInt()
                ),
                Note(
                        "5я заметка",
                        true,
                        "on",
                        "off",
                        0xfff7dd72.toInt()
                )
        )
    }

    fun getNotes(): List<Note> {
        return notes
    }
}