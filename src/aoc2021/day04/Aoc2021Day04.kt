package aoc2021.day04

import aoc2021.Aoc2021

object Aoc2021Day04 : Aoc2021<Int>(day = 4) {
    override fun part1(input: List<String>) = input.game.rounds.last().minByOrNull { it.draws.size }?.score
    override fun part2(input: List<String>) = input.game.rounds.last().maxByOrNull { it.draws.size }?.score
}