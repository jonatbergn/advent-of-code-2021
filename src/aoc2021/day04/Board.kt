package aoc2021.day04

import aoc2021.day03.transposed

data class Board(
    val numbers: List<List<Int>>,
    val draws: List<Int> = emptyList(),
) {
    private val List<Int>.bingo get() = all { it in draws }
    private val misses = numbers.flatten().filter { it !in draws }
    private val bingo = numbers.any { it.bingo } || numbers.transposed().any { it.bingo }
    val score = if (bingo) draws.lastOrNull()?.times(misses.sum()) else null
    operator fun plus(draw: Int) = if(bingo) this else copy(draws = draws + draw)
}
