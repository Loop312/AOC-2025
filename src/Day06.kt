fun main() {
    val testInput = readInput("Day06_test")
    println(testInput)
    fun part1(input: List<String>): Long {
        //parsing
        val list2d = MutableList(input.size){emptyList<String>()}
        var row = 0
        for (line in input) {
            val splitLine = line.split(Regex(" "))
            //remove empty values that are still in the split
            val filteredLine = splitLine.filterNot { it.isEmpty() }
            list2d[row] += filteredLine
            println(splitLine)
            println(filteredLine)
            row += 1
        }
        val ops = list2d.removeLast()
        println(list2d)
        println(ops)
        //operations
        var total = 0L
        for (i in 0 until ops.size) {
            val col = mutableListOf<Long>()
            for (j in 0 until list2d.size) {
                println(list2d[j][i])
                col += list2d[j][i].toLong()
            }
//            println("col: $col")
//            println("op:" + ops[i])
//            println("total: $total")
            when (ops[i]) {
                "*" -> total += col.reduce {acc, i -> acc * i}
                "+" -> total += col.sum()
                else -> println("OP ERROR")
            }
//            println("total after op: $total")
        }
        return total
    }
    //TEST
//    val testAnswer1 = part1(testInput)
//    println(testAnswer1)
    //FINAL
    //Read the input from the `src/Day01.txt` file.
    val input1 = readInput("Day06")
    val answer1 = part1(input1)
    println(answer1)

    fun part2(input: List<String>): Long {
        return 0L
    }
    //TEST
//    val testAnswer2 = part2(testInput)
//    println(testAnswer2)
    //FINAL
//    val input2 = readInput("Day05")
//    val answer2 = part2(input2)
//    println(answer2)
}