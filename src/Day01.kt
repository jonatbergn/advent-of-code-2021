fun main() {
    fun part1(input: List<Int>) = input.zipWithNext().count { it.first < it.second }
    fun part2(input: List<Int>) = part1(input.windowed(size = 3, partialWindows = false) { it.sum() })

    val testInput = readInputAsInts("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInputAsInts("Day01")
    println(part1(input))
    println(part2(input))
}
