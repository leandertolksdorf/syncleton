import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import projects.Project
import java.awt.FileDialog
import java.awt.Frame
import java.io.FilenameFilter

@Composable
@Preview
fun App() {
    val projects = remember { mutableStateListOf<Project>() }

    fun addProject() {
        val fileDialog = FileDialog(null as Frame?, "Add a new project")
        fileDialog.mode = FileDialog.LOAD
        fileDialog.filenameFilter = FilenameFilter { _, name -> name.endsWith(".als") }
        fileDialog.isVisible = true
        if (fileDialog.directory == null || fileDialog.file == null) return
        val newProject = Project(fileDialog.directory + fileDialog.file)
        projects.add(newProject)
    }

    fun removeProject(at: Int) {
        projects.removeAt(at)
    }

    MaterialTheme {
        Column(modifier = Modifier.padding(8.dp)) {
            Button(onClick = { addProject() }) { Text("Add a new project") }
            for ((index, project) in projects.withIndex()) {
                Row {
                    Text(project.path)
                    Button(onClick = {
                        removeProject(index)
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
