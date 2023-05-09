import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import projects.*


@Composable
@Preview
fun App(projectsComponent: ProjectsComponent) {
    MaterialTheme {
        ProjectsContent(projectsComponent)
    }
}

fun main() = application {
    val defaultProjectsComponent = DefaultProjectsComponent()
    Window(onCloseRequest = ::exitApplication) {
        App(defaultProjectsComponent)
    }
}
