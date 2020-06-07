package _9_generics._3_variance

// 무공변(invariant) : 제네릭 타입을 인스턴스화할 때 타입 인자로 서로 다른 타입이 들어가면, 인스턴스 타입 사이의 하위 타입 관계가 성립하지 않으면, 그 제네릭 타입을 무공변이라고 한다. (default)
// 자바에서는 모든 클래스가 무공변이다. Generic types in Java are invariant, meaning that List<String> is not a subtype of List<Object>

// MutableList<Any> 는 MutableList<String> 의 하위 타입이 아니고 MutableList<String> 는 MutableList<Any> 의 하위 타입이 아니다. -> invariant
// 코틀린에서 A가 B의 하위 타입이면 List<A>는 List<B>의 하위 타입이다, 공변적(covariant)이다.
// https://medium.com/kotlin-thursdays/introduction-to-kotlin-generics-9d18d3719e1d

fun test(i: Int) {
    // Int 가 Number 의 하위 타입이어서 컴파일된다.
    val n: Number = i

    fun f(s: String) {}
    // Int 가 String 의 하위 타입이 아니어서 컴파일되지 않는다.
//    f(i)
}