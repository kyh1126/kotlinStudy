package _4_classObjectInterface._4_object

class FactoryUser private constructor(val nickname: String) {

    companion object {
        private var facebookUsers = mutableMapOf<String, FactoryUser>()
        fun newSubscribingUser(email: String) = FactoryUser(email.substringBefore('@'))
        fun newFacebookUser(accountId: Int): FactoryUser {
            if (getFacebookName(accountId) !in facebookUsers.keys) {
                facebookUsers[getFacebookName(accountId)] = FactoryUser(getFacebookName(accountId))
            }
            return facebookUsers.get(getFacebookName(accountId))!!
        }

        private fun getFacebookName(accountId: Int): String = "Jenny"
    }
}