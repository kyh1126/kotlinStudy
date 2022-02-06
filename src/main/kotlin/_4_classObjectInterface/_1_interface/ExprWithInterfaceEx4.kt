package _4_classObjectInterface._1_interface

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

// 인터페이스 구현을 통해 식 표현하기
fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        else -> // "else" 분기가 꼭 있어야 한다.
            throw IllegalArgumentException("Unknown expression")
    }

//

sealed class Expr2 {
    class Num2(val value: Int) : Expr2()
    class Sum2(val left: Expr2, val right: Expr2) : Expr2()
}

// 기반 클래스를 sealed 로 봉인하면 when 식이 모든 하위 클래스를 검사하므로 별도의 else 분기가 없어도 된다.
fun eval2(e: Expr2): Int =
    when (e) {
        is Expr2.Num2 -> e.value
        is Expr2.Sum2 -> eval2(e.right) + eval2(e.left)
//        else -> throw IllegalArgumentException("Unknown expression")
    }

fun main() {
    println(eval2(Expr2.Sum2(Expr2.Num2(2), Expr2.Num2(3))))
}
