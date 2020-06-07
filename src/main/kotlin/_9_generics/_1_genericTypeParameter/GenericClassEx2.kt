package _9_generics._1_genericTypeParameter

// List 인터페이스에 T 라는 타입 파라미터를 정의
interface LList<S> {
    // 인터페이스 안에서 T를 일반 타입처럼 사용할 수 있다.
    operator fun get(index: Int): S
}

// 제네릭 타입 파라미터 T를 List 의 타입 인자로 넘긴다.
class StringList<T>(val list: MutableList<T>) : LList<T> {
    override fun get(index: Int): T {
        return list[index]
    }
}

interface CComparable<T> {
    fun compareTo(other: T): Int
}

// 클래스가 자기 자신을 타입 인자로 참조할 수도 있다. Comparable 인터페이스를 구현하는 클래스가 이런 패턴의 예.
class C : CComparable<C> {
    // 비교 가능한 모든 값은 자신을 같은 타입의 다른 값과 비교하는 방법을 제공해야 한다.
    override fun compareTo(other: C): Int {
        if (this == other) return 0
        return 1
    }
}

fun main(args: Array<String>) {
    println(StringList(mutableListOf(1, 2, 3))[1])

    println(C().compareTo(C()))
}