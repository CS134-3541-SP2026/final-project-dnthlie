package edu.cs134.storybook.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.cs134.storybook.viewmodel.StoryBookViewModel

@Composable
fun StartScreen(
    viewModel: StoryBookViewModel,
    onCreateNew: () -> Unit,
    onEditPanel: () -> Unit,
    onViewStory: () -> Unit,
    modifier: Modifier = Modifier
) {
    val hasStory = viewModel.pages.collectAsState().value.isNotEmpty()                   // FOR DISABLING EDIT AND READ BUTTONS WHEN NO STORY EXISTSS

    Column {
        Text("Create Your Storyboard")

        Spacer(modifier = Modifier.height(16.dp))

        //CREATE NEW STORY
        Button (
            onClick = onCreateNew
        ) {
            Text("Create New Story")
        }

        // EDIT STORY
        Button (
            onClick = onEditPanel
        ) {
            Text("Edit Current Story")
        }

        // READ STORY
        Button (
            onClick = onViewStory
        ) {
            Text("Read your Story")
        }
    }
}