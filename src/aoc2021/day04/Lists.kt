package aoc2021.day04

private val List<String>.board
    get() = Board(
        numbers = map {
            it.chunked(3)
                .map(String::trim)
                .filterNot(String::isBlank)
                .map(String::toInt)
        }
    )

val List<String>.game
    get() = with(filterNot(CharSequence::isBlank)) {
        Game(
            draws = first().split(",").map(String::toInt),
            boards = drop(1).chunked(5).map { it.board }
        )
    }
