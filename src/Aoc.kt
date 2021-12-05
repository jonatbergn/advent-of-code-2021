import aoc2021.day01.Aoc2021Day01
import aoc2021.day02.Aoc2021Day02
import aoc2021.day03.Aoc2021Day03
import aoc2021.day04.Aoc2021Day04
import java.io.File


fun main() {
    solutions.map { (riddle, solution) ->
        check(solution == riddle.solve("test"))
        riddle.solve("src")
    }.first().print()
}

private val solutions = listOf(
    Aoc2021Day04 to Solution(4512, 1924),
    Aoc2021Day03 to Solution(198, 230),
    Aoc2021Day02 to Solution(150, 900),
    Aoc2021Day01 to Solution(7, 5),
)

interface Riddle<Input, Output> {
    val year: Int
    val day: Int
    val adapter1: (List<String>) -> Input
    val adapter2: (List<String>) -> Input
    val part1: (Input) -> Output?
    val part2: (Input) -> Output?
}

fun <Input, Output> Riddle<Input, Output>.solve(dir: String): Solution<Output> {
    val lines = inputFile(dir).readLines()
    val part1 = part1(lines.let(adapter1))
    val part2 = part2(lines.let(adapter2))
    return Solution(part1 = part1, part2 = part2)
}

data class Solution<Output>(
    val part1: Output?,
    val part2: Output?,
) {
    fun print() {
        println("part1: $part1")
        println("part2: $part2")
    }
}

private fun Riddle<*, *>.inputFile(dir: String) = File("$dir/aoc${year}/day${day.pad}", "_input.txt")
private val Int.pad
    get() = toString().padStart(2, '0')
