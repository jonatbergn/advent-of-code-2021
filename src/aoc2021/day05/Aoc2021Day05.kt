package aoc2021.day05

import aoc2021.Aoc2021

object Aoc2021Day05 : Aoc2021<Int>(day = 5) {
    private fun List<Vector>.solve() = map { it.trace }.flatten().groupingBy { it }.eachCount().values.count { it >= 2 }
    override fun part1(input: List<String>) = input.map(Vector::straight).solve()
    override fun part2(input: List<String>) = input.map(Vector::diagonal).solve()
}