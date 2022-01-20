package _2_kotlinBasic

import java.util.*

// 1-1. Hello, World!
fun main() {
    println("Hello, World!")
}

// 1-2. 함수
// 블록이 본문인 함수
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// 1-3. 변수
// 조건에 따라 val 값을 다른 여러 값으로 초기화할 수도 있다.
fun initVal() {
    val message: String
    if (max(1, 2) == 2) {
        message = "Success"
        // ... 연산을 수행한다.
    } else {
        message = "Failed"
    }
}

// val 참조 자체는 불변일지라도 그 참조가 가리키는 객체의 내부 값은 변경될 수 있다.
fun addToCollection() {
    val languages = arrayListOf("Java")
    languages.add("Kotlin")
}

// var 키워드를 사용하면 변수의 값을 변경할 수 있지만 변수의 타입은 고정돼 바뀌지 않는다.
fun variableType() {
    var answer = 42
//    answer = "no answer" // 컴파일 오류 발생
}

// 1-4. 더 쉽게 문자열 형식 지정: 문자열 템플릿
fun stringTemplate() {
    val name = "Kotlin"
    println("Hello, $name")
}

// 2-2. 커스텀 접근자
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() { // 프로퍼티 게터 선언
            return height == width
        }
}

// 3-5. 스마트 캐스트 : 타입 검사 + 타입 캐스트
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num // 스마트 캐스팅 때문에 불필요한 코드
        return n.value
    }

    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

// 3-6. 리팩토링 : if를 when으로 변경
fun eval2(e: Expr): Int =
    if (e is Num) {
        e.value
    } else if (e is Sum) {
        eval(e.right) + eval(e.left)
    } else {
        throw IllegalArgumentException("Unknown expression")
    }

// 3-7. if 와 when 의 분기에서 블록 사용
fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value // e의 타입이 Num이면 e.value가 return
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right // e의 타입이 Sum이면 이 식의 값이 return
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }

// 4-2. 수에 대한 이터레이션 : 범위와 수열
fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun range() {
    // range
    for (i in 1..100) {
        print(fizzBuzz(i))
    }

    // downTo, step
    for (i in 100 downTo 1 step 2) {
        println(fizzBuzz(i))
    }

    for (i in 0 until 100) {
        println(fizzBuzz(i))
    }
}

// 4-3. 맵에 대한 이터레이션
// 맵 이터레이션
fun mapBinaryReps() {
    val binaryReps = TreeMap<Char, String>() // 키에 대해 정렬하기 위해 TreeMap 을 사용한다.
    // 초기화
    for (char in 'A'..'F') {
        val binary = Integer.toBinaryString(char.code)
        binaryReps[char] = binary
    }
    // map 의 key, value 를 for 문으로 풀어낼 수 있다.
    for ((letter, binary) in binaryReps) {
        println("${letter} = ${binary}")
    }
}

// 구조 분해 구문을 맵이 아닌 컬렉션에도 활용할 수 있다.
fun collectionWithIndex() {
    val list = arrayListOf("10", "11", "12")
    for ((index, element) in list.withIndex()) {
        println("${index} = ${element}")
    }
}
