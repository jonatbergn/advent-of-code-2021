package aoc2021.day02

import aoc2021.Aoc2021
import kotlin.math.absoluteValue

internal object Aoc2021Day02 : Aoc2021<Int>(day = 2) {

    private fun List<String>.toDirections() = toInstructions { DirectionImpl.valueOf(it) }
    private fun List<String>.toDirectionsAimed() = toInstructions { DirectionAimed.valueOf(it) }
    private fun List<Instruction>.solve() = fold(Pos()) { acc, instruction -> acc + instruction }
        .run { x * y.absoluteValue }
    override fun part1(input: List<String>) = input.toDirections().solve()
    override fun part2(input: List<String>) = input.toDirectionsAimed().solve()
}