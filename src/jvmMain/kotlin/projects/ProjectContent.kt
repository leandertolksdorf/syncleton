package projects

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import navigation.NavigationComponent

@Composable
fun ProjectContent(projectManagerComponent: ProjectManagerComponent, navigationComponent: NavigationComponent) {
    val projectManagerModel by projectManagerComponent.model.subscribeAsState()
    val navigationModel by navigationComponent.model.subscribeAsState()

    if (navigationModel.selectedProject == null) {
        Text("Select a project to work with.")
        return
    }

    val selectedProject = projectManagerModel.projects.find { it.id == navigationModel.selectedProject }
        ?: throw Error("Selected project id not found in project managers")

    Column {
        Text("Selected Project")
        Text(selectedProject.id.toString())
        Text(selectedProject.name)
        Text(selectedProject.path)
    }
}