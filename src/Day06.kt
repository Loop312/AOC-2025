fun main() {
//    val testInput = readInput("Day06_test")
//    println(testInput)
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
//    val input1 = readInput("Day06")
//    val answer1 = part1(input1)
//    println(answer1)

    fun part2(input: List<String>): Long {
        var total = 0L
        val mutableInput = input.toMutableList()
        var tempTotal = 0L
        val ops = mutableInput.removeLast().toCharArray().filterNot { it == ' ' }.toMutableList()
//        println(ops)
        var op = ops.removeLast()
        while (mutableInput.any {it.isNotEmpty()}) {
            var numStr = ""

            for (row in 0 until mutableInput.size) {
//                println("mutableInput[$row]: " + mutableInput[row])
                for (char in mutableInput[row].reversed()) {
                    numStr += char
//                    println("numStr: $numStr")
                    mutableInput[row] = mutableInput[row].dropLast(1)
//                    println("mutableInput: $mutableInput")
                    break
                }
            }
            numStr = numStr.filterNot { it == ' ' }
//            println("FINAL NUMBER: $numStr")
//            println("FINAL OPERATION: $op")
            when (val num = numStr.toLongOrNull()) {
                null -> {
                    total += tempTotal
                    op = ops.removeLast()
                    tempTotal = when (op) {
                        '*' -> 1L
                        '+' -> 0L
                        else -> -1L
                    }
                }
                else -> when (op) {
                    '*' -> tempTotal *= num
                    '+' -> tempTotal += num
                }
            }
            println("tempTotal: $tempTotal")
            println("TOTAL: $total")
        }
        total += tempTotal
        return total
    }
    //TEST
//    val testAnswer2 = part2(testInput)
//    println(testAnswer2)
    //FINAL
    val input2 = readInput("Day06")
    val answer2 = part2(input2)
    println(answer2)
}