import java.io.File

fun main() {
    fun parseInput(input: String) : List<Int> {
        fun getNext(rest: List<Int?>): Pair<Int,List<Int?>> {
            val next = rest.takeWhile {it != null} as List<Int>
            val temp = rest.dropWhile {it != null}
            val rest = if (temp.isEmpty()) {
                temp
            } else {
                temp.drop(1) //drop null
            }
            return Pair(next.sum(), rest)
        }

        var rest = input.lines().map {it.toIntOrNull()}
        val sums = mutableListOf<Int>()

        while (rest.isNotEmpty()) {
            val (sum, temp) = getNext(rest)
            rest = temp
            sums.add(sum)
        }

        return sums
    }

    fun part1(input: String): Int {
        val data = parseInput(input)
        return data.max()
    }

    fun part2(input:String): Int {
        val data = parseInput(input)
        return data
            .sortedDescending()
            .take(3)
            .sum()
    }

    val input = File("src/Day01.txt").readText()

    println(part1(input))
    println(part2(input))


}
