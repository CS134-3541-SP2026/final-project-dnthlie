package edu.cs134.storybook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.cs134.storybook.ui.theme.StoryBookTheme
import edu.cs134.storybook.view.CreatePageScreen
import edu.cs134.storybook.view.StartScreen
import edu.cs134.storybook.view.StoryPanelScreen
import edu.cs134.storybook.view.ViewStoryScreen
import edu.cs134.storybook.viewmodel.StoryBookViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StoryBookTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    StoryBoardApp()
                }
            }
        }
    }
}


object Destination {
    const val START_SCREEN = "start_screen"
    const val CREATE_PAGE_SCREEN = "create_page_screen"
    const val STORY_PANEL_SCREEN = "story_panel_screen"
    const val VIEW_STORY_SCREEN = "view_story_screen"

}

@Composable
fun StoryBoardApp() {
    val screenNavController = rememberNavController()
    val viewModel: StoryBookViewModel = viewModel()

    NavHost (
        navController = screenNavController,
        startDestination = Destination.START_SCREEN,
        modifier = Modifier.fillMaxSize()
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
                viewModel = viewModel,
                onEditPanel = { screenNavController.navigate(Destination.STORY_PANEL_SCREEN) }
            )
        }

        // STORY PANEL SCREEN
        composable(route = Destination.STORY_PANEL_SCREEN) {
            StoryPanelScreen(
                viewModel = viewModel,
                onStartScreen = { screenNavController.navigate(Destination.START_SCREEN) },
                onViewStory = { screenNavController.navigate(Destination.VIEW_STORY_SCREEN) }
            )
        }

        // VIEW STORY SCREEN
        composable(route = Destination.VIEW_STORY_SCREEN) {
            ViewStoryScreen(
                viewModel = viewModel,
                onStartScreen = { screenNavController.navigate(Destination.START_SCREEN) },
                onEditPanel = { screenNavController.navigate(Destination.STORY_PANEL_SCREEN) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StoryBoardAppPreview() {
    StoryBoardApp()
}
