import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import projects.Project

@Composable
@Preview
fun App() {
    var path by remember { mutableStateOf("") }
    val projects = remember { mutableStateListOf<Project>() }

    MaterialTheme {
        Column(modifier = Modifier.padding(8.dp)) {
            TextField(value = path, onValueChange = { path = it }, label = { Text("New project (enter path):") })
            Button(onClick = {
                val newProject = Project(path)
                projects.add(newProject)
                path = ""
            }) { Text("Add project") }
            for ((index, project) in projects.withIndex()) {
                Row {
                    Text(project.path)
                    Button(onClick = {
                        projects.removeAt(index)
                    }) {
                        Text("Remove")
                    }
                }
            }

        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
