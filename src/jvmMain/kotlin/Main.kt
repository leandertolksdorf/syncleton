import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import navigation.DefaultNavigationComponent
import navigation.NavigationComponent
import projects.*


@Composable
@Preview
fun App(projectManagerComponent: ProjectManagerComponent, navigationComponent: NavigationComponent) {
    MaterialTheme {
        Row(modifier = Modifier.padding(16.dp)) {
            ProjectManagerContent(
                projectManagerComponent,
                onProjectClicked = { navigationComponent.setSelectedProject(it) })
            Spacer(modifier = Modifier.width(16.dp))
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
