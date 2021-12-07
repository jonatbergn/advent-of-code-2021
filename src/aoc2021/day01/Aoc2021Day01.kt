package aoc2021.day01

import aoc2021.Aoc2021

object Aoc2021Day01 : Aoc2021<Int>(day = 1) {
    private fun List<String>.toNumbers() = map(String::toInt)
    private fun List<Int>.solve() = zipWithNext().count { it.first < it.second }
    override fun part1(input: List<String>) = input.toNumbers().solve()
    override fun part2(input: List<String>) = input.toNumbers().windowed(3) { it.sum() }.solve()
}