package _4_classObjectInterface._3_dataClassDelegation

// data 라는 변경자를 클래스 앞에 붙이면 불필요한 메소드를 컴파일러가 자동으로 만들어준다.
fun main(args: Array<String>) {
    // toString override
    val client1 = DataClient("김제니", 4122)
    println(client1)

    // equals override
    val client2 = DataClient("김제니", 4122)
    println(client1 == client2)

    // hashCode override
    val processed = hashSetOf(client1)
    println(processed.contains(DataClient("김제니", 4122)))
}