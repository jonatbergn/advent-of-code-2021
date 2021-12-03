package aoc2021.day03

import aoc2021.Aoc2021

object Aoc2021Day03 : Aoc2021<List<List<Char>>, Int>(day = 3) {

    private fun List<List<Char>>.columns() = first().size
    private fun List<Char>.toInt() = toCharArray().concatToString().toInt(2)
    private fun Char.flip() = if (this == '0') '1' else '0'
    private fun List<List<Char>>.transposed() = Array(columns()) { column -> map { it[column] } }.toList()
    private fun List<Char>.hasMore(char: Char) = count { it == char }.let { it > size - it }

    private fun List<List<Char>>.gamma() = transposed().map { if (it.hasMore('1')) '1' else '0' }
    private fun List<List<Char>>.epsilon() = gamma().map { it.flip() }

    private fun List<Char>.onesAndZeros() = count { it == '1' } to count { it == '0' }
    private fun List<List<Char>>.rating(target: List<Char>.() -> Char): List<Char> {
        var rating = this
        var i = 0
        while (rating.size > 1) {
            val transposed = rating.transposed()
            val char = transposed[i].target()
            rating = rating.filter { it[i] == char }
            i++
        }
        return rating.first()
    }

    private fun List<List<Char>>.oxygen() = rating {
        val (ones, zeros) = onesAndZeros()
        if (ones >= zeros) '1' else '0'
    }

    private fun List<List<Char>>.co02() = rating {
        val (ones, zeros) = onesAndZeros()
        if (zeros <= ones) '0' else '1'
    }

    override val adapter1 = { input: List<String> -> Array(input.size) { i -> input[i].toList() }.toList() }
    override val adapter2 = adapter1
    override val part1 = { input: List<List<Char>> -> input.gamma().toInt() * input.epsilon().toInt() }
    override val part2 = { input: List<List<Char>> -> input.oxygen().toInt() * input.co02().toInt() }
}