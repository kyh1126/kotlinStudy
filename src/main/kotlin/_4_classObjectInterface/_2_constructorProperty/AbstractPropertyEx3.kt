package _4_classObjectInterface._2_constructorProperty

fun main(args: Array<String>) {
    println(PrivateUser("test@kakkaocommerce.com").nickname)
    println(SubscribingUser("test@kakkaocommerce.com").nickname)

    val facebookUser = FacebookUser(2)
    println(facebookUser.nickname)
    println(facebookUser.accountId)
}
