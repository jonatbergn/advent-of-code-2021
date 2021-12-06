package aoc2021.day06

import aoc2021.Aoc2021

object Aoc2021Day06 : Aoc2021<List<Int>, Long>(day = 6) {

    private fun count(fishes: List<Int>, days: Int): Long {
        val start = fishes.groupingBy { it }.eachCount()
        val population = LongArray(10) { start.getOrElse(it) { 0 }.toLong() }
        repeat(days) {
            population[9] = population[0]
            population[7] = population[0] + population[7]
            for (i in 1 until population.size) population[i - 1] = population[i]
            population[9] = 0
        }
        return population.sum()
    }

    override val adapter1 = { input: List<String> -> input.first().split(",").map(String::toInt) }
    override val adapter2 = adapter1
    override val part1 = { input: List<Int> -> count(fishes = input, days = 80) }
    override val part2 = { input: List<Int> -> count(fishes = input, days = 256) }
}
