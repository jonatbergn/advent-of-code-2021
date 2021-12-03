package aoc2021.day02

internal data class Pos(
    val x: Int = 0,
    val y: Int = 0,
    val aim: Int = 0,
) {
    operator fun plus(instruction: Instruction) = instruction(this)
}