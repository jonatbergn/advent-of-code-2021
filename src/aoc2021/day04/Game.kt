package aoc2021.day04

data class Game(
    private val draws: List<Int>,
    private val boards: List<Board>
) {
    val rounds = draws.scan(boards) { boards, draw -> boards.map { it + draw } }
}
