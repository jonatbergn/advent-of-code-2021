package aoc2021.day04

import aoc2021.Aoc2021

object Aoc2021Day04 : Aoc2021<List<Board>, Int>(day = 4) {
    override val adapter1 = { input: List<String> -> input.game.rounds.last() }
    override val adapter2 = adapter1
    override val part1 = { boards: List<Board> -> boards.minByOrNull { it.draws.size }?.score }
    override val part2 = { boards: List<Board> -> boards.maxByOrNull { it.draws.size }?.score }
}