package _6_typeSystem._3_CollectionArray

import java.io.BufferedReader
import java.io.StringReader

fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()
    for (line in reader.lineSequence()) {
        // Kotlin 1.1부터 String.toIntOrNull 사용해 파싱 실패하면 null 반환 가능.
        try {
            val number = line.toInt()
            result.add(number)
        } catch (e: NumberFormatException) {
            result.add(null)
        }
    }
    return result
}

fun addValidNumbers(numbers: List<Int?>) {
    var sumOfValidNumbers = 0
    var invalidNumbers = 0
    for (number in numbers) {
        if (number != null) {
            sumOfValidNumbers += number
        } else {
            invalidNumbers++
        }
    }
    println("Sum of valid numbers : $sumOfValidNumbers")
    println("Invalid numbers : $invalidNumbers")
}

fun addValidNumbers2(numbers: List<Int?>) {
    var validNumbers = numbers.filterNotNull()

    println("Sum of valid numbers : ${validNumbers.sum()}")
    println("Invalid numbers : ${numbers.size - validNumbers.size}")
}

fun main() {
    // List<Int?> : 리스트 안의 각 값이 널이 될 수 있다.
    // List<Int>? : 전체 리스트가 널이 될 수 있다.
    // List<Int?>? 도 가능.
    val reader = BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readNumbers(reader)
    addValidNumbers(numbers)
    addValidNumbers2(numbers)
}
