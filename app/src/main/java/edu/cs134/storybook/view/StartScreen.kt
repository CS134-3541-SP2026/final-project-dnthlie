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
import androidx.compose.ui.Alignment
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
    val hasStory = viewModel.pages.collectAsState().value.isNotEmpty()

    // TODO: FIX UI LATER. BASIC NAV. BUTTONS WORK TO CHANGE SCREENS
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TITLE FIXME: FIX UI LATER
        Text("Create Your Storyboard")

        Spacer(modifier = Modifier.height(16.dp))

        //CREATE NEW STORY
        Button (
            onClick = onCreateNew
        ) {
            Text("Create New Story")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // EDIT PANEL
        Button (
            onClick = onEditPanel,
            // TEST: REMOVE COMMENT LATER. DISABLE SHOWS, BUT NEED TO TEST FURTHER WHEN STORY IS CREATED
            // enabled = hasStory
        ) {
            Text("Edit Current Story")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // READ STORY
        Button (
            onClick = onViewStory,
            // TEST: REMOVE COMMENT LATER. DISABLE SHOWS, BUT NEED TO TEST FURTHER WHEN STORY IS CREATED
            //enabled = hasStory
        ) {
            Text("Read your Story")
        }
    }
}
