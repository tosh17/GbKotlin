package ru.ohmypeer.gbkotlin.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import ru.ohmypeer.gbkotlin.data.Note
import ru.ohmypeer.gbkotlin.data.NotesRepository

class MainViewModel : ViewModel() {

    private val viewStateLiveData : MutableLiveData<List<Note>> = MutableLiveData()

    init {
        viewStateLiveData.value = NotesRepository.getNotes()
    }

    fun viewState(): LiveData<List<Note>> = viewStateLiveData
}