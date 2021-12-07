package aoc2021.day03

import aoc2021.Aoc2021

object Aoc2021Day03 : Aoc2021<Int>(day = 3) {

    private fun List<String>.toChars() = Array(size) { i -> this[i].toList() }.toList()

    override fun part1(input: List<String>) = with(input.toChars()) { gamma().toInt() * epsilon().toInt() }
    override fun part2(input: List<String>) = with(input.toChars()) { oxygen().toInt() * co02().toInt() }
}