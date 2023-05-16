import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import navigation.DefaultNavigationComponent
import navigation.NavigationComponent
import projects.DefaultProjectManagerComponent
import projects.ProjectContent
import projects.ProjectManagerComponent
import projects.ProjectManagerContent


@Composable
@Preview
fun App(projectManagerComponent: ProjectManagerComponent, navigationComponent: NavigationComponent) {
    MaterialTheme(colors = lightColors(primary = Color.Black)) {
        Row {
            ProjectManagerContent(
                projectManagerComponent, navigationComponent,
                onProjectClicked = { navigationComponent.setSelectedProject(it) })
            Divider(
                color = Color.Black,
                modifier = Modifier
                    .fillMaxHeight()  //fill the max height
                    .width(1.dp)
            )
            ProjectContent(projectManagerComponent, navigationComponent)
        }
    }
}

fun main() = application {
    val defaultProjectManagerComponent = DefaultProjectManagerComponent()
    val defaultNavigationComponent = DefaultNavigationComponent()
    Window(onCloseRequest = ::exitApplication) {
        App(defaultProjectManagerComponent, defaultNavigationComponent)
    }
}
