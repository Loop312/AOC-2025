fun main() {
    val testInput = readInput("Day03_test")
    println(testInput)
    fun part1(input: List<String>): Int {
        var sum = 0
        for (line in input) {
            val largestCombo = getLargest(line, 2)
            println(largestCombo)
            sum += largestCombo.toInt()
        }
        return sum
    }
    //TEST
//    val testAnswer1 = part1(testInput)
//    println(testAnswer1)
    //FINAL
    //Read the input from the `src/Day01.txt` file.
    val input1 = readInput("Day03")
    val answer1 = part1(input1)
    println(answer1)

    fun part2(input: List<String>): Int {
        return 0
    }
    //TEST
//    val testAnswer2 = part2(testInput)
//    println(testAnswer2)
    //FINAL
//    val input2 = readInput("Day03")
//    val answer2 = part2(input2)
//    println(answer2)
}

private fun getLargest(line: String, digits: Int): String {
    if (digits == 0) {
        return ""
    }
    if (line.length <= digits) {
        return line
    }
    for (i in 9 downTo 0) {
        val target = i.toString()
        val index = line.indexOf(target)

        // If the digit exists...
        if (index != -1) {
            // Check if there are enough characters AFTER this digit to fill the rest
            val charsRemaining = line.length - (index + 1)
            val charsNeeded = digits - 1

            if (charsRemaining >= charsNeeded) {
                return target + getLargest(line.substring(index + 1), digits - 1)
            }
        }
    }
    return ""
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

--- Part Two ---
You're sure that's the right password, but the door won't open.
You knock, but nobody answers. You build a snowman while you think.

As you're rolling the snowballs for your snowman,
you find another security document that must have fallen into the snow:

"Due to newer security protocols,
please use password method 0x434C49434B until further notice."

You remember from the training seminar that "method 0x434C49434B" means
you're actually supposed to count the number of times any click causes the dial to point at 0,
regardless of whether it happens during a rotation or at the end of one.
*/