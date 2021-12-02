fun main() {
    // Part 1
    fun calculateFinalPosition(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0

        for (line in input) {
            val (instruction, amount) = line.split(" ")
            when (instruction.lowercase()) {
                "forward" -> horizontalPosition += amount.toInt()
                "up" -> depth -= amount.toInt()
                "down" -> depth += amount.toInt()
            }
        }

        return horizontalPosition * depth
    }

    // Part 2
    fun calculateFinalPositionUsingAim(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0
        var aim = 0

        for (line in input) {
            val (instruction, amount) = line.split(" ")
            when (instruction.lowercase()) {
                "forward" -> {
                    horizontalPosition += amount.toInt()
                    depth += aim * amount.toInt()
                }
                "up" -> aim -= amount.toInt()
                "down" -> aim += amount.toInt()
            }
        }
        return horizontalPosition * depth
    }


    val testInput = readInput("Day02_test")
    check(calculateFinalPosition(testInput) == 150)
    check(calculateFinalPositionUsingAim(testInput) == 900)

    val input = readInput("Day02")
    println(calculateFinalPosition(input))
    println(calculateFinalPositionUsingAim(input))
}
