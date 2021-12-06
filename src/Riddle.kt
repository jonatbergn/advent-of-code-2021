interface Riddle<Input, Output> {
    val year: Int
    val day: Int
    val adapter1: (List<String>) -> Input
    val adapter2: (List<String>) -> Input
    val part1: (Input) -> Output?
    val part2: (Input) -> Output?
}