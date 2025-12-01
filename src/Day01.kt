fun main() {
    fun part1(input: List<String>): Int {
        val indices = 100
        var currentNumber = 50
        var zeroCounter = 0
        for (line in input) {
            val direction = line[0]
            println("currentNumber: $currentNumber")
            println("nextInstruction: $line")
            when (direction) {
                'L' -> currentNumber = (currentNumber + (indices - line.substring(1).toInt())) % indices
                'R' -> currentNumber = (currentNumber + line.substring(1).toInt()) % indices
            }
            if (currentNumber == 0) {
                zeroCounter += 1
                println("ZERO COUNTER UP ($zeroCounter)")
            }
        }
        return zeroCounter
    }
    //TEST
//    val testInput1 = readInput("Day01_test")
//    println(testInput1)
//    val testAnswer1 = part1(testInput1)
//    println(testAnswer1)
    //FINAL
    //Read the input from the `src/Day01.txt` file.
    val input1 = readInput("Day01")
    val answer1 = part1(input1)
    println(answer1)

    fun part2(input: List<String>): Int {
        return input.size
    }

//    val testInput2 = readInput("Day01_test2")
//    println(testInput2)
//    val testAnswer2 = part2(testInput2)
//    println(testAnswer2)
//    val input2 = readInput("Day01")
//    val answer2 = part1(input2)
//    println(answer2)
}


/*
PART 1
You arrive at the secret entrance to the North Pole base ready to start decorating.
Unfortunately, the password seems to have been changed,
so you can't get in. A document taped to the wall helpfully explains:

"Due to new security protocols, the password is locked in the safe below.
Please see the attached document for the new combination."

The safe has a dial with only an arrow on it;
around the dial are the numbers 0 through 99 in order.
As you turn the dial, it makes a small click noise as it reaches each number.

The attached document (your puzzle input) contains a sequence of rotations,
one per line, which tell you how to open the safe.
A rotation starts with an L or R which indicates whether the rotation should be to the left (toward lower numbers)
or to the right (toward higher numbers).
Then, the rotation has a distance value which indicates how many clicks the dial should be rotated in that direction.

So, if the dial were pointing at 11, a rotation of R8 would cause the dial to point at 19.
After that, a rotation of L19 would cause it to point at 0.

Because the dial is a circle, turning the dial left from 0 one click makes it point at 99.
Similarly, turning the dial right from 99 one click makes it point at 0.

So, if the dial were pointing at 5, a rotation of L10 would cause it to point at 95.
After that, a rotation of R5 could cause it to point at 0.

The dial starts by pointing at 50.

You could follow the instructions,
but your recent required official North Pole secret entrance security training seminar
taught you that the safe is actually a decoy.
The actual password is the number of times the dial is left pointing at 0 after any rotation in the sequence.
*/