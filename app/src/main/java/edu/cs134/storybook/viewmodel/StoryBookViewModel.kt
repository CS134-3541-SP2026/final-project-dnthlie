package edu.cs134.storybook.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import edu.cs134.storybook.model.Page
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StoryBookViewModel : ViewModel() {

    private val _pages = MutableStateFlow<List<Page>>(emptyList())
    val pages: StateFlow<List<Page>> = _pages

    fun addPage(page: Page) {
        val currentPages = _pages.value.toMutableList()
        val newPage = page.copy(pageNumber = currentPages.size + 1)
        currentPages.add(newPage)
        _pages.value = currentPages
    }

    fun deletePage(page: Page) {
        val currentPages = _pages.value.toMutableList()
        currentPages.remove(page)
        _pages.value = currentPages
    }

//    fun updatePage(updatedPage: Page) {
//        // TODO:
//    }
//
//    fun saveStory(context: Context) {
//        // TODO:
//    }
//
//    fun loadStory(context: Context) {
//        // TODO:
//    }

}