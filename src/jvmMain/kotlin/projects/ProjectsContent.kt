package projects

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun ProjectsContent(component: ProjectsComponent) {
    val model by component.model.subscribeAsState()

    Column(modifier = Modifier.padding(8.dp)) {
        Button(onClick = { component.addProject() }) { Text("Add a new project") }
        for ((index, project) in model.projects.withIndex()) {
            Row {
                Text(project.path)
                Button(onClick = {
                    component.removeProject(index)
                }) {
                    Text("Remove")
                }
            }
        }

    }
}