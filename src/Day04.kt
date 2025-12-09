fun main() {
//    val testInput = readInput("Day04_test")
//    println(testInput)
    fun part1(input: List<String>): Int {
        var count = 0
        //for the box check
        for (strIndex in 0..input.lastIndex) {
            for (charIndex in 0..input[strIndex].lastIndex) {
                if (input[strIndex][charIndex] == '@' &&
                    //can only do box check if not at the top or bottom
                    boxCheck(
                        charIndex,
                        input.getOrNull(strIndex - 1),
                        input[strIndex],
                        input.getOrNull(strIndex + 1)
                    )) {
                    println("+1 on line $strIndex")
                    count += 1
                }
            }
        }
        return count
    }
    //TEST
//    val testAnswer1 = part1(testInput)
//    println(testAnswer1)
    //FINAL
    //Read the input from the `src/Day01.txt` file.
    val input1 = readInput("Day04")
    val answer1 = part1(input1)
    println(answer1)

    fun part2(input: List<String>): Int {
        val count = 0
        return count
    }
    //TEST
//    val testAnswer2 = part2(testInput)
//    println(testAnswer2)
    //FINAL
//    val input2 = readInput("Day03")
//    val answer2 = part2(input2)
//    println(answer2)
}

private fun boxCheck(index: Int, topRow: String?, midRow: String, bottomRow: String?): Boolean {
    val top = if (topRow == null) {
        0
    } else {
        var topCount = 0
        if (topRow.getOrNull(index - 1) == '@') topCount += 1
        if (topRow[index] == '@') topCount += 1
        if (topRow.getOrNull(index + 1) == '@') topCount += 1
        topCount
    }
    val left = if (midRow.getOrNull(index - 1) == '@') 1 else 0
    val right = if (midRow.getOrNull(index + 1) == '@') 1 else 0
    val bottom = if (bottomRow == null) {
        0
    } else {
        var topCount = 0
        if (bottomRow.getOrNull(index - 1) == '@') topCount += 1
        if (bottomRow[index] == '@') topCount += 1
        if (bottomRow.getOrNull(index + 1) == '@') topCount += 1
        topCount
    }
    val total = top + left + right + bottom
    return total < 4
}