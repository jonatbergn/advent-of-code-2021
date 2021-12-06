package aoc2021.day05

data class Vector(
    val p0: Point,
    val p1: Point,
    val diagonal: Boolean,
) {

    private val horizontal = p0.y == p1.y
    private val vertical = p0.x == p1.x
    private val horizontalSteps = (p0.x towards p1.x)
    private val verticalSteps = (p0.y towards p1.y)
    val trace = when {
        horizontal -> horizontalSteps.map { p0.copy(x = it) }
        vertical -> verticalSteps.map { p0.copy(y = it) }
        diagonal -> horizontalSteps.zip(verticalSteps).map { (x, y) -> Point(x = x, y = y) }
        else -> emptyList()
    }

    companion object {
        private fun fromString(value: String, diagonal: Boolean): Vector {
            val (p0, p1) = value.split(" -> ")
            return Vector(
                p0 = Point.fromString(p0),
                p1 = Point.fromString(p1),
                diagonal = diagonal
            )
        }
        fun straight(value: String) = fromString(value = value, diagonal = false)
        fun diagonal(value: String) = fromString(value = value, diagonal = true)
    }
}