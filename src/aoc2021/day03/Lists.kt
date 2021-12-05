package aoc2021.day03

private fun Char.flip() = if (this == '0') '1' else '0'
private fun List<Char>.hasMore(char: Char) = count { it == char }.let { it > size - it }
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

fun List<List<Char>>.gamma() = transposed().map { if (it.hasMore('1')) '1' else '0' }
fun List<List<Char>>.epsilon() = gamma().map { it.flip() }
fun List<List<Char>>.oxygen() = rating {
    val (ones, zeros) = onesAndZeros()
    if (ones >= zeros) '1' else '0'
}

fun List<List<Char>>.co02() = rating {
    val (ones, zeros) = onesAndZeros()
    if (zeros <= ones) '0' else '1'
}

fun List<List<*>>.columns() = first().size
fun <T> List<List<T>>.transposed() = Array(columns()) { column -> map { it[column] } }.toList()
fun List<Char>.toInt() = toCharArray().concatToString().toInt(2)
