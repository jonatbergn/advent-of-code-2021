import kotlin.math.absoluteValue

fun main() {
    val result = readInputAsInstructions("Day02")
        .fold(Pos()) { acc, instruction -> acc + instruction }
        .run { x * y.absoluteValue }
    println(result)
}
