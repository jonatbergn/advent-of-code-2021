package aoc2021.day05

import aoc2021.Aoc2021

object Aoc2021Day05 : Aoc2021<List<Vector>, Int>(day = 5) {
    override val adapter1 = { input: List<String> -> input.map(Vector::straight) }
    override val adapter2 = { input: List<String> -> input.map(Vector::diagonal) }
    override val part1 = { vectors: List<Vector> ->
        vectors.map { it.trace }
            .flatten()
            .groupingBy { it }
            .eachCount()
            .values
            .count { it >= 2 }
    }
    override val part2 = part1

}