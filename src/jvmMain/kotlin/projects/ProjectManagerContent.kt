package projects

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import java.util.*

@Composable
fun ProjectManagerContent(component: ProjectManagerComponent, onProjectClicked: (uuid: UUID) -> Unit) {
    val model by component.model.subscribeAsState()

    Column {
        Text("Syncleton", fontWeight = FontWeight.Bold)
        Button(onClick = { component.addProject() }) { Text("Add a new project") }
        for ((index, project) in model.projects.withIndex()) {
            Row {
                Text(project.name, modifier = Modifier.clickable { onProjectClicked(project.id) })
                Button(onClick = {
                    component.removeProject(index)
                }) {
                    Text("Remove")
                }
            }
        }

    }
}