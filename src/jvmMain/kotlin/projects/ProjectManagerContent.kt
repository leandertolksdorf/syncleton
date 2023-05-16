package projects

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import navigation.NavigationComponent
import java.util.*

@Composable
fun ProjectManagerContent(
    projectManagerComponent: ProjectManagerComponent,
    navigationComponent: NavigationComponent,
    onProjectClicked: (uuid: UUID) -> Unit,
) {
    val projectManagerModel by projectManagerComponent.model.subscribeAsState()
    val navigationModel by navigationComponent.model.subscribeAsState()
    var menuExpanded by remember { mutableStateOf(false) }

    val selectedProject = projectManagerModel.projects.find { navigationModel.selectedProject == it.id }

    Column(modifier = Modifier.width(240.dp).fillMaxHeight().padding(16.dp)) {
        Text("Syncleton", fontWeight = FontWeight.Medium, fontSize = 24.sp)
        Spacer(Modifier.height(8.dp))
        Box {
            Button(modifier = Modifier.fillMaxWidth(), onClick = { menuExpanded = true }) {
                Text(selectedProject?.name ?: "Select project")
            }
            DropdownMenu(
                expanded = menuExpanded,
                onDismissRequest = { menuExpanded = false }) {
                DropdownMenuItem(onClick = { projectManagerComponent.addProject() }) {
                    Text("Add project")
                }
                Divider()
                for ((index, project) in projectManagerModel.projects.withIndex()) {
                    DropdownMenuItem(onClick = { onProjectClicked(project.id) }) {
                        Text(project.name)
                    }
                }
            }
        }
    }

}