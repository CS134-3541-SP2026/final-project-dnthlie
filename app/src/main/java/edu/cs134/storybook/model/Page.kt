package edu.cs134.storybook.model

import java.util.UUID

// DATA CLASS
data class Page(
    val id: String = UUID.randomUUID().toString(),  // NOTE: Creates unique ID when page is created
    var pageNumber: Int = 0,                        // Page Number
    val imagePath: String = "",                     // Image
    val text: String = ""                           // Text
)