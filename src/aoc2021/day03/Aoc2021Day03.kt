package aoc2021.day03

import aoc2021.Aoc2021

object Aoc2021Day03 : Aoc2021<List<List<Char>>, Int>(day = 3) {

    override val adapter1 = { input: List<String> -> Array(input.size) { i -> input[i].toList() }.toList() }
    override val adapter2 = adapter1
    override val part1 = { input: List<List<Char>> -> input.gamma().toInt() * input.epsilon().toInt() }
    override val part2 = { input: List<List<Char>> -> input.oxygen().toInt() * input.co02().toInt() }
}