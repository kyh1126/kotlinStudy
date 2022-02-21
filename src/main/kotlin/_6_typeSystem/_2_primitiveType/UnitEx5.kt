package _6_typeSystem._2_primitiveType

// Unit type : 자바 void 와 같은 기능을 한다.
fun f(): Unit {
}

// ==
// If a function returns Unit, the return type should be omitted:
fun f2() {
}

fun main() {
    // Unit 은 모든 기능을 갖는 일반적인 타입
    // void 와 달리 타입 인자로 쓸 수 있다. Unit 타입에 속한 값은 단 하나뿐
    // 제네릭 파라미터를 반환하는 함수를 오버라이드 하면서 반환 타입으로 Unit 을 쓸 때 유용하다.
    NoResultProcessor().process()
}
