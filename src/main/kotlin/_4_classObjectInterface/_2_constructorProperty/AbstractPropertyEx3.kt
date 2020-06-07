package _4_classObjectInterface._2_constructorProperty

fun main(args: Array<String>) {
    println(PrivateUser("test@kakkaocommerce.com").nickname)
    println(SubscribingUser("test@kakkaocommerce.com").nickname)

    println(FacebookUser(2).nickname)
}