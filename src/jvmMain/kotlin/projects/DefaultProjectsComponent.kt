package projects

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.reduce
import java.awt.FileDialog
import java.awt.Frame
import java.io.FilenameFilter

class DefaultProjectsComponent : ProjectsComponent {
    override val model: MutableValue<ProjectsComponent.Model> =
        MutableValue(ProjectsComponent.Model(projects = mutableListOf()))

    override fun addProject() {
        val fileDialog = FileDialog(null as Frame?, "Add a new project")
        fileDialog.mode = FileDialog.LOAD
        fileDialog.filenameFilter = FilenameFilter { _, name -> name.endsWith(".als") }
        fileDialog.isVisible = true

        if (fileDialog.directory == null || fileDialog.file == null) return
        val newProject = Project(fileDialog.directory + fileDialog.file)
        model.reduce { it.copy(projects = it.projects + listOf(newProject)) }
    }

    override fun removeProject(at: Int) {
        model.reduce {
            it.copy(
                projects = it.projects.filterIndexed { index, _ -> index != at }
            )
        }
    }
}