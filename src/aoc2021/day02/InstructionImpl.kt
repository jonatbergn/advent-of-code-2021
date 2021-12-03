package aoc2021.day02

internal data class InstructionImpl(
    val direction: Direction,
    val value: Int,
) : Instruction {
    override fun invoke(p1: Pos) = direction.invoke(p1, value)
}