package projects

import com.arkivanov.decompose.value.Value

interface ProjectsComponent {
    val model: Value<Model>

    fun addProject()
    fun removeProject(at: Int)
    data class Model(
        val projects: List<Project>
    )
}

