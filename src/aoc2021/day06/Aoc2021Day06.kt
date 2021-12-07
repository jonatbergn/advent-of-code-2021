package aoc2021.day06

import aoc2021.Aoc2021

object Aoc2021Day06 : Aoc2021<Long>(day = 6) {

    private fun List<String>.toNumbers() = first().split(",").map(String::toInt)
    private fun List<String>.solve(days: Int): Long {
        val start = toNumbers().groupingBy { it }.eachCount()
        val population = LongArray(10) { start.getOrElse(it) { 0 }.toLong() }
        repeat(days) {
            population[9] = population[0]
            population[7] = population[0] + population[7]
            for (i in 1 until population.size) population[i - 1] = population[i]
            population[9] = 0
        }
        return population.sum()
    }

    override fun part1(input: List<String>) = input.solve(days = 80)
    override fun part2(input: List<String>) = input.solve(days = 256)
}
