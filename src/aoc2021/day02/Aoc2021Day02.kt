package aoc2021.day02

import aoc2021.Aoc2021
import kotlin.math.absoluteValue

internal object Aoc2021Day02 : Aoc2021<List<Instruction>, Int>(day = 2) {

    private fun List<String>.toInstructions(
        direction: (String) -> Direction
    ) = map { it.split(" ") }
        .map { InstructionImpl(direction(it[0].uppercase()), it[1].toInt()) }

    override val adapter1 = { lines: List<String> -> lines.toInstructions { DirectionImpl.valueOf(it) } }
    override val adapter2 = { lines: List<String> -> lines.toInstructions { DirectionAimed.valueOf(it) } }
    override val part1 = { input: List<Instruction> -> input.fold(Pos()) { acc, instruction -> acc + instruction }
            .run { x * y.absoluteValue }
    }
    override val part2 = part1
}