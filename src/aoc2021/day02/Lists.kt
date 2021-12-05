package aoc2021.day02

internal fun List<String>.toInstructions(
    direction: (String) -> Direction
) = map { it.split(" ") }
    .map { InstructionImpl(direction(it[0].uppercase()), it[1].toInt()) }