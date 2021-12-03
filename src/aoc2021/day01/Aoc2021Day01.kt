package aoc2021.day01

import aoc2021.Aoc2021

object Aoc2021Day01 : Aoc2021<List<Int>, Int>(day = 1) {
    override val adapter1 = { lines: List<String> -> lines.map(String::toInt) }
    override val adapter2 = adapter1
    override val part1 = { input: List<Int> -> input.zipWithNext().count { it.first < it.second } }
    override val part2 = { input: List<Int> -> part1(input.windowed(3) { it.sum() }) }
}