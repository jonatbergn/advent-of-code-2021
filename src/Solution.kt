import aoc2021.day01.Aoc2021Day01
import aoc2021.day02.Aoc2021Day02
import aoc2021.day03.Aoc2021Day03
import aoc2021.day04.Aoc2021Day04
import aoc2021.day05.Aoc2021Day05
import aoc2021.day06.Aoc2021Day06
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
        private val all = listOf(
            Aoc2021Day06 to Solution(5934, 26984457539),
            Aoc2021Day05 to Solution(5, 12),
            Aoc2021Day04 to Solution(4512, 1924),
            Aoc2021Day03 to Solution(198, 230),
            Aoc2021Day02 to Solution(150, 900),
            Aoc2021Day01 to Solution(7, 5),
        )

        private fun <Input, Output> Riddle<Input, Output>.solve(dir: String): Solution<Output> {
            val lines = inputFile(dir).readLines()
            val part1 = part1(lines.let(adapter1))
            val part2 = part2(lines.let(adapter2))
            return Solution(part1 = part1, part2 = part2)
        }

        private fun Riddle<*, *>.inputFile(dir: String) = File("$dir/aoc${year}/day${day.pad}", "_input.txt")
        private val Int.pad
            get() = toString().padStart(2, '0')

        fun checkAll() {
            all.map { (riddle, solution) -> check(solution == riddle.solve("test")) }
        }

        fun printCurrent() {
            all.first().first.solve("src").print()
        }
    }
}