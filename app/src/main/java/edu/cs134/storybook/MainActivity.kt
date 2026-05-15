package edu.cs134.storybook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.cs134.storybook.view.CreatePageScreen
import edu.cs134.storybook.view.StartScreen
import edu.cs134.storybook.view.StoryPanelScreen
import edu.cs134.storybook.view.ViewStoryScreen
import edu.cs134.storybook.viewmodel.StoryBookViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StoryBoardApp()
        }
    }
}


object Destination {
    const val START_SCREEN = "start_screen"
    const val CREATE_PAGE_SCREEN = "create_page_screen"
    const val STORY_PANEL_SCREEN = "story_panel_screen"
    const val VIEW_STORY_SCREEN = "view_story_screen"

}

@Preview
@Composable
fun StoryBoardApp() {
    val screenNavController = rememberNavController()
    val viewModel: StoryBookViewModel = viewModel()

    NavHost (
        navController = screenNavController,
        startDestination = Destination.START_SCREEN
    ) {
        // START HERE - START SCREEN
        composable (route = Destination.START_SCREEN) {
            StartScreen (
                viewModel = viewModel,
                onCreateNew = { screenNavController.navigate(Destination.CREATE_PAGE_SCREEN) },
                onEditPanel = { screenNavController.navigate(Destination.STORY_PANEL_SCREEN) },
                onViewStory = { screenNavController.navigate(Destination.VIEW_STORY_SCREEN) },
            )
        }

        // CREATE PAGE SCREEN
        composable(route = Destination.CREATE_PAGE_SCREEN) {
            CreatePageScreen(
                viewModel = viewModel
            )
        }

        // STORY PANEL SCREEN
        composable(route = Destination.STORY_PANEL_SCREEN) {
            StoryPanelScreen(
                viewModel = viewModel
            )
        }

        // VIEW STORY SCREEN
        composable(route = Destination.VIEW_STORY_SCREEN) {
            ViewStoryScreen(
                viewModel = viewModel
            )
        }
    }
}
