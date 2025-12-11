fun main() {
//    val testInput = readInput("Day05_test")
//    println(testInput)
    fun part1(input: List<String>): Int {
        //parsing
        val ids = input.slice(input.indexOf("") + 1..input.lastIndex).map {it.toLong()}
        val rangeStrings = input.slice(0..<input.indexOf(""))
        val ranges = rangeStrings.map {
            val parts = it.split('-')
            parts[0].toLong()..parts[1].toLong()
        }
        return validIDs(ids, ranges, 0)
    }
    //TEST
//    val testAnswer1 = part1(testInput)
//    println(testAnswer1)
    //FINAL
    //Read the input from the `src/Day01.txt` file.
//    val input1 = readInput("Day05")
//    val answer1 = part1(input1)
//    println(answer1)

    fun part2(input: List<String>): Long {
        //parsing
        val rangeStrings = input.slice(0..<input.indexOf(""))
        val ranges = rangeStrings.map {
            val parts = it.split('-')
            parts[0].toLong()..parts[1].toLong()
        }
        val sortedRanges = ranges.sortedBy { it.first }
        val condensedRanges = mutableListOf<LongRange>()

        //merging
        var currentRange = sortedRanges.first()
        for (nextRange in sortedRanges.drop(1)) {
            //if ranges merge/continuous
            if (currentRange.last + 1 >= nextRange.first) {
                currentRange = currentRange.first..maxOf(currentRange.last, nextRange.last)
            } else {
                condensedRanges += currentRange
                currentRange = nextRange
            }
        }
        //add in final range
        condensedRanges += currentRange

        println(condensedRanges)

        var total = 0L
        for (range in condensedRanges) {
            total += range.last - range.first + 1
        }

        return total
    }
    //TEST
//    val testAnswer2 = part2(testInput)
//    println(testAnswer2)
    //FINAL
    val input2 = readInput("Day05")
    val answer2 = part2(input2)
    println(answer2)
}

private fun validIDs(ids: List<Long>, ranges: List<LongRange>, index: Int): Int {
    if (ids.isEmpty() || index >= ranges.size) return 0
    val currentRange = ranges[index]

    val validIds = ids.filter { it in currentRange }
    val remainingIds = ids.filterNot { it in currentRange }

    return validIds.size + validIDs(remainingIds, ranges, index + 1)
}