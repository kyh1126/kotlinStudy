package _4_classObjectInterface._2_constructorProperty

class SubscribingUser(val email: String) : AbstractPropertyUser {
    override val nickname: String
        get() = email.substringBefore('@')
}