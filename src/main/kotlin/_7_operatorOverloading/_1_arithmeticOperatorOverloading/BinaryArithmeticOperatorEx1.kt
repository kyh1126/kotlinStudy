package _7_operatorOverloading._1_arithmeticOperatorOverloading

//  Arithmetic operators
//  Expression	Translated to
//  a + b	    a.plus(b)
//  a - b	    a.minus(b)
//  a * b	    a.times(b)
//  a / b	    a.div(b)
//  a % b	    a.rem(b) (Kotlin 1.1 부터), a.mod(b) (deprecated)
//  a..b	    a.rangeTo(b)

data class Point(val x: Int, val y: Int) {
    // plus 연산자 함수 정의
    // To implement an operator, we provide a member function or an extension function with a fixed name, for the corresponding type.
    // Functions that overload operators need to be marked with the operator modifier.
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    fun minus(other: Point): Point {
        return Point(x - other.x, y - other.y)
    }
}

// 연산자를 확장 함수로 정의할 수도 있다.
operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}

// 연산자를 정의할 때 두 피연산자가 같은 타입일 필요는 없다. (연산자 함수의 두 파라미터)
// 연산자 함수의 반환 타입이 꼭 두 피연산자 중 하나와 일치해야만 하는 것도 아니다.
operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

fun main(args: Array<String>) {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    // plus 함수 호출
    println(p1 + p2)
    // operator modifier is required.
//     println(p1 - p2)

    println('a' * 3)
}
