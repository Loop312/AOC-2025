fun main() {
    val testInput = readInput("Day07_test")
    println(testInput)
    fun part1(input: List<String>): Int {
        val firstLine = input[0]
        var beamLocations = mutableSetOf(firstLine.length / 2)
        var splitCount = 0
        for (line in input) {
            val temp = beamLocations.toMutableSet()
            for (i in beamLocations) {
                if (line[i] == '^') {
                    println("split on line $line at $i")
                    splitCount += 1
                    temp -= i
                    temp += i + 1
                    temp += i - 1
                }
            }
            beamLocations = temp
        }
        return splitCount
    }
    //TEST
//    val testAnswer1 = part1(testInput)
//    println(testAnswer1)
    //FINAL
    //Read the input from the `src/Day01.txt` file.
    val input1 = readInput("Day07")
    val answer1 = part1(input1)
    println(answer1)

    fun part2(input: List<String>): Long {
        return 0L
    }
    //TEST
//    val testAnswer2 = part2(testInput)
//    println(testAnswer2)
    //FINAL
//    val input2 = readInput("Day06")
//    val answer2 = part2(input2)
//    println(answer2)
}