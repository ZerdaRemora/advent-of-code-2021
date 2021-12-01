fun main() {
    // Part 1
    fun countNumberOfIncreases(input: List<String>): Int {
        var count = 0
        for (i in 1 until input.size) {
            if (input[i].toInt() > input[i - 1].toInt()) {
                count += 1
            }
        }
        return count
    }

    // Part 2
    fun countNumberOfSlidingWindowIncreases(input: List<String>): Int {
        val windowSums = input.windowed(3) { list -> list.sumOf { it.toInt() } }
        var count = 0
        for (i in 1 until windowSums.size) {
            if (windowSums[i] > windowSums[i - 1]) {
                count += 1
            }
        }

        return count
    }


    val testInput = readInput("Day01_test")
    check(countNumberOfIncreases(testInput) == 7)
    check(countNumberOfSlidingWindowIncreases(testInput) == 5)

    val input = readInput("Day01")
    println(countNumberOfIncreases(input))
    println(countNumberOfSlidingWindowIncreases(input))
}
