package _4_classObjectInterface._3_dataClassDelegation

// Client 는 그냥 클래스, Ex2가 data class
fun main(args: Array<String>) {
    // toString override
    val client1 = Client("김제니", 4122)
    println(client1)

    // equals override
    val client2 = Client("김제니", 4122)
    println(client1 == client2)

    // hashCode override
    val processed = hashSetOf(client1)
    println(processed.contains(Client("김제니", 4122)))
}