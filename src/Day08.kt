fun main() {
//    val testInput = readInput("Day08_test")
//    println(testInput)
    fun part1(input: List<String>, unions: Int): Long {
        val coords = input.map { it.split(',').map { it.toInt() } }
//        println(coords)
        val connections: MutableList<Triple<Int, Int, Long>> = mutableListOf()

        for (i in 0 until coords.size) {
            for (j in i + 1 until coords.size) {
                connections += Triple(i, j, getDistSq(coords[i], coords[j]))
            }
        }
        //sort by distance
        connections.sortBy { it.third }
        //println(connections)

        val uf = UnionFind(coords.size)
        //number of unions
        for (i in 0 until unions) {
            val (a, b, _) = connections[i]
            uf.union(a, b)
        }

        return uf.getTop3Sizes()
    }
    //TEST
//    val testAnswer1 = part1(testInput, 10)
//    println(testAnswer1)
    //FINAL
    //Read the input from the `src/Day01.txt` file.
//    val input1 = readInput("Day08")
//    val answer1 = part1(input1, 1000)
//    println(answer1)

    fun part2(input: List<String>): Long {
        val coords = input.map { it.split(',').map { it.toInt() } }
//        println(coords)
        val connections: MutableList<Triple<Int, Int, Long>> = mutableListOf()

        for (i in 0 until coords.size) {
            for (j in i + 1 until coords.size) {
                connections += Triple(i, j, getDistSq(coords[i], coords[j]))
            }
        }
        //sort by distance
        connections.sortBy { it.third }
        //println(connections)

        val uf = UnionFind(coords.size)
        //number of unions
        for (connection in connections) {
            val (a, b, _) = connection
            uf.union(a, b)
            if (uf.count <= 1) {
                val x1 = coords[a][0].toLong()
                val x2 = coords[b][0].toLong()
                return x1 * x2
            }
        }
        return 0
    }
    //TEST
//    val testAnswer2 = part2(testInput)
//    println(testAnswer2)
    //FINAL
    val input2 = readInput("Day08")
    val answer2 = part2(input2)
    println(answer2)
}

private fun getDistSq(coord1: List<Int>, coord2: List<Int>): Long {
    val x = (coord1[0] - coord2[0]).toLong()
    val y = (coord1[1] - coord2[1]).toLong()
    val z = (coord1[2] - coord2[2]).toLong()
    return x*x + y*y + z*z
}

private class UnionFind(size: Int){
    val parent = IntArray(size) { it }
    val groupSizes = IntArray(size) { 1 }
    var count = size

    fun find(i: Int): Int {
        if (parent[i] == i) return i
        parent[i] = find(parent[i])
        return parent[i]
    }

    fun union(i: Int, j: Int) {
        val rootI = find(i)
        val rootJ = find(j)
        if (rootI != rootJ) {
            parent[rootI] = rootJ
            groupSizes[rootJ] += groupSizes[rootI]
            groupSizes[rootI] = 0
            count--
        }
    }

    fun getTop3Sizes(): Long {
        val sorted = groupSizes.sortedDescending()
        return sorted[0].toLong() * sorted[1].toLong() * sorted[2].toLong()
    }
}