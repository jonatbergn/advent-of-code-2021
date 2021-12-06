package aoc2021.day05

data class Point(
    val x: Int,
    val y: Int,
) {
    operator fun plus(point: Point) = copy(x = x + point.x, y = y + point.y)

    companion object {
        fun fromString(value: String): Point {
            val (x, y) = value.split(",").map(String::toInt)
            return Point(x = x, y = y)
        }
    }
}