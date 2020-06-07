package _4_classObjectInterface._4_object

fun main(args: Array<String>) {
    // 동반 객체 : 팩토리 메소드와 정적 멤버가 들어갈 장소
    A.bar()

    val subscribingUser = FactoryUser.newSubscribingUser("test@kakaocommerce.com")
    val facebookUser = FactoryUser.newFacebookUser(333)
    println(subscribingUser.nickname)
    println(facebookUser.nickname)
}