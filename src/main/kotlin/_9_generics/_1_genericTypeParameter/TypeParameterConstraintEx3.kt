package _9_generics._1_genericTypeParameter

// 타입 파라미터 제약 : 클래스나 함수에 사용할 수 있는 타입 인자를 제한하는 기능
// 어떤 타입을 제네릭 타입의 타입 파라미터에 대한 상한(upper bound)으로 지정하면 (corresponds to Java's extends keyword)
// 그 제네릭 타입을 인스턴스화할 때 사용하는 타입 인자는 반드시 그 상한 타입이거나 그 상한 타입의 하위 타입이어야 한다.
// 타입 파라미터 이름 뒤에 콜론(:)을 표시하고 그 뒤에 상한 타입을 적으면 된다.

// T가 타입 파라미터, Comparable<T> 가 상한
fun <T : Comparable<T>> max(first: T, second: T): T {
    // 이 함수의 인자들은 비교 가능해야 한다.
    return if (first > second) first else second
}

// 디폴트 upper bound (if none specified) 는 Any? 다.
// If the same type parameter needs more than one upper bound, we need a separate where-clause:
// 타입 인자가 CharSequence 와 Appendable 인터페이스를 반드시 구현해야 한다.
fun <T> ensureTrailingPeriod(seq: T) where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}

fun main(args: Array<String>) {
    println(max("kotlin", "java"))
    // Type parameter bound for T is not satisfied.
//    println(max("kotlin", 42))

    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld)
}