package aoc2021.day05

infix fun Int.towards(to: Int): IntProgression = IntProgression.fromClosedRange(
    rangeStart = this,
    rangeEnd = to,
    step = if (this > to) -1 else 1
)