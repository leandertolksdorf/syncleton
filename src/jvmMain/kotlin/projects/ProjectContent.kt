package projects

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import navigation.NavigationComponent

@Composable
fun ProjectContent(projectManagerComponent: ProjectManagerComponent, navigationComponent: NavigationComponent) {
    val projectManagerModel by projectManagerComponent.model.subscribeAsState()
    val navigationModel by navigationComponent.model.subscribeAsState()

    if (navigationModel.selectedProject == null) {
        Column(modifier = Modifier.width(240.dp).fillMaxWidth().fillMaxHeight().padding(16.dp)) {
            Text("Select a project to work with.")
        }
        return
    }

    val selectedProject = projectManagerModel.projects.find { it.id == navigationModel.selectedProject }
        ?: throw Error("Selected project id not found in project managers")

    Column(modifier = Modifier.width(240.dp).fillMaxSize().padding(16.dp)) {
        Text("Selected Project")
        Text(selectedProject.id.toString())
        Text(selectedProject.name)
        Text(selectedProject.path)
    }
}