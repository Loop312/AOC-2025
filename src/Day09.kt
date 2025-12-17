import kotlin.math.abs
import kotlin.time.measureTime

fun main() {
    val testInput = readInput("Day09_test")
    println(testInput)
    fun part1(input: List<String>): Long {
        val parsedInput = input.map { line ->
            line.split(',').map {
                it.toLong()
            }
        }
        var largestRectArea = 0L
        for (i in 0 until parsedInput.size) {
            for (j in i + 1 until parsedInput.size) {
                largestRectArea = maxOf(largestRectArea, getSquare(parsedInput[i], parsedInput[j]))
            }
        }
        return largestRectArea
    }
    //TEST
//    measureTime {
//        val testAnswer1 = part1(testInput)
//        println(testAnswer1)
//    }.println()
    //FINAL
    //Read the input from the `src/Day01.txt` file.
    measureTime {
        val input1 = readInput("Day09")
        val answer1 = part1(input1)
        println(answer1)
    }.println()

    fun part2(input: List<String>): Long {
        return 0
    }
    //TEST
//    val testAnswer2 = part2(testInput)
//    println(testAnswer2)
    //FINAL
//    val input2 = readInput("Day08")
//    val answer2 = part2(input2)
//    println(answer2)
}

private fun getSquare(first: List<Long>, second: List<Long>): Long {
    return (abs(second[0] - first[0]) + 1) * (abs(second[1] - first[1]) + 1)
}