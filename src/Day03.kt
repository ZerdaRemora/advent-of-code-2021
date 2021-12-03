fun main() {
    fun calculateBitCounts(input: List<String>): List<List<Int>> {
        val wordSize = input[0].length
        val colsArray = List(wordSize) { MutableList(2) { 0 } }

        for (line in input) {
            for (i in 0 until wordSize) {
                if (line[i] == '0') {
                    colsArray[i][0]++
                } else {
                    colsArray[i][1]++
                }
            }
        }

        return colsArray
    }

    fun reduceInputForMostCommonBits(input: List<String>, colNumber: Int): String {
        val bitCounts = calculateBitCounts(input)
        val col = bitCounts[colNumber]
        val reducedInput = input.filter {
            if (col[0] == col[1]) {
                it[colNumber] == '1'
            } else {
                it[colNumber] == (col.indexOf(col.maxOrNull()) + 48).toChar()
            }
        }

        return if (reducedInput.size == 1) {
            reducedInput[0]
        } else {
            reduceInputForMostCommonBits(reducedInput, colNumber + 1)
        }

    }

    fun reduceInputForLeastCommonBits(input: List<String>, colNumber: Int): String {
        val bitCounts = calculateBitCounts(input)
        val col = bitCounts[colNumber]
        val reducedInput = input.filter {
            if (col[0] == col[1]) {
                it[colNumber] == '0'
            } else {
                it[colNumber] == (col.indexOf(col.minOrNull()) + 48).toChar()
            }
        }

        return if (reducedInput.size == 1) {
            reducedInput[0]
        } else {
            reduceInputForLeastCommonBits(reducedInput, colNumber + 1)
        }

    }

    // Part 1
    fun calculateGammaEpsilonRate(input: List<String>): Int {
        val colsArray = calculateBitCounts(input)

        var gammaBitString = ""
        var epsilonBitString = ""
        for (col in colsArray) {
            gammaBitString += col.indexOf(col.maxOrNull())
            epsilonBitString += col.indexOf(col.minOrNull())
        }

        return (gammaBitString.toInt(2) * epsilonBitString.toInt(2))
    }

    // Part 2
    fun calculateOxygenCo2Rating(input: List<String>): Int {
        val oxygenRating = reduceInputForMostCommonBits(input, 0).toInt(2)
        val co2Rating = reduceInputForLeastCommonBits(input, 0).toInt(2)

        return oxygenRating * co2Rating
    }


    val testInput = readInput("Day03_test")
    check(calculateGammaEpsilonRate(testInput) == 198)
    check(calculateOxygenCo2Rating(testInput) == 230)

    val input = readInput("Day03")
    println(calculateGammaEpsilonRate(input))
    println(calculateOxygenCo2Rating(input))
}
