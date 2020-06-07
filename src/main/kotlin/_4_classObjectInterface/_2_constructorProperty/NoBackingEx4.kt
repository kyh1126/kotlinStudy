package _4_classObjectInterface._2_constructorProperty

// NoBackingUser 인터페이스 go
class NoBackUser(override val email: String): NoBackingUser

fun main(args: Array<String>) {
    val u = NoBackUser("test@kakaocommerce.com")
    println(u.nickname)
    println(u.email)
}