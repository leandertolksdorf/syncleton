package navigation

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.reduce
import java.util.*

class DefaultNavigationComponent : NavigationComponent {
    override val model: MutableValue<NavigationComponent.Model> =
        MutableValue(NavigationComponent.Model())

    override fun setSelectedProject(uuid: UUID) {
        model.reduce { it.copy(selectedProject = uuid) }
    }
}