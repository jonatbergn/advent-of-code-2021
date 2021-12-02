import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

enum class Direction(val invoke: Pos.(Int) -> Pos) {
    FORWARD({ copy(x = x + it, y = y + aim * it) }),
    DOWN({ copy(aim = aim + it) }),
    UP({ copy(aim = aim - it) }),
}

data class Instruction(val direction: Direction, val value: Int)
data class Pos(val x: Int = 0, val y: Int = 0, val aim: Int = 0,) {
    operator fun plus(instruction: Instruction) = with(instruction.direction) { invoke(instruction.value) }
}

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()
fun readInputAsInts(name: String) = readInput(name).map { it.toInt() }
fun readInputAsInstructions(name: String) = readInput(name).map {
    val (key, value) = it.split(" ")
    Instruction(Direction.valueOf(key.uppercase()), value.toInt())
}

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
