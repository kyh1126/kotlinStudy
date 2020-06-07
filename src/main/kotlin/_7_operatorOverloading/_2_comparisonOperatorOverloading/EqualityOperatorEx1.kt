package _7_operatorOverloading._2_comparisonOperatorOverloading

//  Equality and inequality operators
//  Expression	Translated to
//  a == b	    a?.equals(b) ?: (b === null)
//  a != b	    !(a?.equals(b) ?: (b === null))

class Point(val x: Int, val y: Int) {
    // 다른 연산자 오버로딩과 달리 equals 는 Any 에 정의된 메소드라 override 가 필요하다.
    // 상위 클래스의 operator 지정이 있어 operator 변경자를 붙이지 않아도 자동 적용된다.
    override fun equals(obj: Any?): Boolean {
        // === and !== (identity checks) are not overloadable, so no conventions exist for them.
        // 식별자 비교 연산자는 자바 == 연산자와 같다. 서로같은 객체를 가리키는지 비교한다.
        if (obj === this) return true
        if (obj !is Point) return false
        return obj.x == x && obj.y == y
    }
}

// 확장 함수로 안된다.
fun Point.equals(obj: Any?): Boolean {
    println("ddd")
    return true;
}

fun main(args: Array<String>) {
    println(Point(10, 20) == Point(10, 20))
}