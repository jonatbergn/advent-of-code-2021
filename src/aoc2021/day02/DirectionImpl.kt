package aoc2021.day02

internal enum class DirectionImpl : Direction {
    FORWARD {
        override fun invoke(p1: Pos, p2: Int) = with(p1) {
            copy(x = x + p2)
        }
    },
    DOWN {
        override fun invoke(p1: Pos, p2: Int) = with(p1) {
            copy(y = y - p2)
        }
    },
    UP {
        override fun invoke(p1: Pos, p2: Int) = with(p1) {
            copy(y = y + p2)
        }
    },
}