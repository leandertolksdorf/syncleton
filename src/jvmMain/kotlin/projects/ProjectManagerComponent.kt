package projects

import com.arkivanov.decompose.value.MutableValue

interface ProjectManagerComponent {
    val model: MutableValue<Model>

    fun addProject()
    fun removeProject(at: Int)
    data class Model(
        val projects: List<Project>
    )
}

