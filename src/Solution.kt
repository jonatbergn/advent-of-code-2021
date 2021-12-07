import java.io.File

data class Solution<Output>(
    val part1: Output?,
    val part2: Output?,
) {

    fun print() {
        println("part1: $part1")
        println("part2: $part2")
    }

    companion object {

        fun checkAll() = all.map { (riddle, solution) -> check(solution == riddle.solve("test")) }
        fun printCurrent() = all.first().first.solve("src").print()

        private fun <Output> Riddle<Output>.solve(dir: String): Solution<Output> {
            val lines = inputFile(dir).readLines()
            val part1 = part1(lines)
            val part2 = part2(lines)
            return Solution(part1 = part1, part2 = part2)
        }

        private fun Riddle<*>.inputFile(dir: String) = File("$dir/aoc${year}/day${day.pad}", "_input.txt")
        private val Int.pad get() = toString().padStart(2, '0')

        private val all = listOf(
            Aoc.aoc2021,
        ).flatten()
    }
}