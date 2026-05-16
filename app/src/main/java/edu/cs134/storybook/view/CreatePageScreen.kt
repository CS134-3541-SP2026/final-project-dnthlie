package edu.cs134.storybook.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.cs134.storybook.viewmodel.StoryBookViewModel

@Composable
fun CreatePageScreen(
    viewModel: StoryBookViewModel,
    onEditPanel: () -> Unit,
    modifier: Modifier = Modifier
) {
    var textCaption by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // TITLE + SHOULD HAVE BUTTONS LEFT AND RIGHT
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            // BACK BUTTON
            Button(
                onClick = { /* Back Button */ }
            ){ Text("Back") }

            // TITLE
            Text("Create Page")
            Spacer(modifier = Modifier.height(16.dp))

            // NEXT BUTTON
            Button(
                onClick = { /* Next Button */ }
            ){ Text("Next") }
        }


        // IMAGE
        imageDisplay()

        // TEXT
        textDisplay(
            // note: pass params
            text = textCaption,
            onTextChange = { textCaption = it }
        )

        // BOTTOM BUTTONS (+)
        // EDIT PANEL
        Button (
            onClick = onEditPanel
        ) {
            Text("Story Panel")
        }
    }
}

@Composable
fun imageDisplay() {
    // todo:
    Text("DEBUG+TEST: Image Display")
}

@Composable
fun textDisplay(
    // note: must pass through param to save state
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        label = { Text("Caption...") },
        modifier = Modifier.fillMaxWidth()
        // note: maybe add style later
    )
}