package _4_classObjectInterface._2_constructorProperty

class FacebookUser(val accountId: Int) : AbstractPropertyUser {
    override val nickname = getFacebookName(accountId)
    private fun getFacebookName(accountId: Int): String {
        return "Jenny $accountId"
    }
}
