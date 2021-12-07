package aoc2021.day07

import aoc2021.Aoc2021
import kotlin.math.absoluteValue

object Aoc2021Day07 : Aoc2021<Int>(day = 7) {

    private val Pair<Int, Int>.distance get() = (first - second).absoluteValue
    private val Int.sum get() = times(inc()) / 2
    private fun List<String>.toNumbers() = first().split(",").map(String::toInt)
    private fun staticConsumption(pair: Pair<Int, Int>) = pair.distance
    private fun linearGrowthConsumption(pair: Pair<Int, Int>) = pair.distance.sum

    private fun List<Int>.solve(consumption: (Pair<Int, Int>) -> Int): Int {
        val targets = (minOf { it }..maxOf { it }).associateWith { target -> sumOf { consumption(it to target) } }
        val optimum = targets.minByOrNull { it.value }?.key!!
        return sumOf { consumption(it to optimum) }
    }

    override fun part1(input: List<String>) = input.toNumbers().solve(::staticConsumption)
    override fun part2(input: List<String>) = input.toNumbers().solve(::linearGrowthConsumption)
}