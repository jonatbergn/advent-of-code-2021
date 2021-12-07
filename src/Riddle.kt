interface Riddle<Output> {
    val year: Int
    val day: Int
    fun part1(input: List<String>): Output?
    fun part2(input: List<String>): Output?
}