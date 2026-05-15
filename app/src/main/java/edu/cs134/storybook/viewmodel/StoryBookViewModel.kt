package edu.cs134.storybook.viewmodel

import androidx.lifecycle.ViewModel
import edu.cs134.storybook.model.Page
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StoryBookViewModel : ViewModel() {

    private val _pages = MutableStateFlow<List<Page>>(emptyList())
    val pages: StateFlow<List<Page>> = _pages

    fun addPage(page: Page) {
        // TODO:
    }

    fun deletePage(page: Page) {
        // TODO:
    }

    fun updatePage(page: Page) {
        // TODO:
    }

    fun saveStory() {
        // TODO:
    }

    fun loadStory() {
        // TODO:
    }

}