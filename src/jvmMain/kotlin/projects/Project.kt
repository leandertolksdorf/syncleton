package projects

import java.util.UUID

data class Project(
    val id: UUID,
    val path: String,
    val name: String
)
