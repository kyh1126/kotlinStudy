package _9_generics._1_genericTypeParameter

//  1.타입 파라미터 선언
//          2.타입 파라미터가 수신 객체와 반환 타입에 쓰인다3.
fun <T> List<T>.slice(indices: IntRange): List<T> {
    if (indices.isEmpty()) return listOf()
    return this.subList(indices.start, indices.endInclusive + 1).toList()
}

// 수신 객체 타입을 보고 T를 추론한다.
fun <T> List<T>.filter(predicate: (T) -> Boolean): List<T> {
    var destination = mutableListOf<T>()
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

// Generic extension property
val <T> List<T>.penultimate: T
    get() = this[size - 1]

// type parameter of a property must be used in its receiver type
// 클래스 프로퍼티에 여러 타입의 값을 저장할 수 없기 때문.
//val <T> a: T = TODO()

// 자바와 달리 코틀린에서는 제네릭 타입의 타입 인자를 프로그래머가 명시하거나 컴파일러가 추론할 수 있어야 한다.
fun main(args: Array<String>) {
    val letters = ('a'..'z').toList()
    // 컴파일러는 반환 타입 T를 추론할 수 있다.
    println(letters.slice<Char>(0..2))
    println(letters.slice(0..2))

    // 제네릭 고차 함수 호출하기
    val authors = listOf("Jenny", "Dmitry")
    val readers = mutableListOf("Mut", "able")
    println(readers.filter { it !in authors })

    // 제너릭 확장 프로퍼티 호출
    // 확장 프로퍼티만 제네릭하게 만들 수 있다.
    println(listOf(1, 2, 3, 4).penultimate)
}