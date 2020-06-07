package _4_classObjectInterface._3_dataClassDelegation

fun main(args: Array<String>) {
    val k = Client("김제니", 4122)
    // 객체를 복사하면서 일부 프로퍼티를 바꿀 수 있게 해주는 copy 메소드
    println(k.copy(postalCode = 4000))
}