package navigation

import com.arkivanov.decompose.value.MutableValue
import java.util.*

interface NavigationComponent {
    val model: MutableValue<Model>
    fun setSelectedProject(uuid: UUID)
    data class Model(
        val selectedProject: UUID? = null
    )
}

