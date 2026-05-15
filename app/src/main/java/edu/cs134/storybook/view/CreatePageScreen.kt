package edu.cs134.storybook.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.cs134.storybook.viewmodel.StoryBookViewModel

@Composable
fun CreatePageScreen(
    viewModel: StoryBookViewModel,
    onEditPanel: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Create Page")

        Spacer(modifier = Modifier.height(16.dp))

        // EDIT PANEL
        Button (
            onClick = onEditPanel
        ) {
            Text("Story Panel")
        }
    }
}
