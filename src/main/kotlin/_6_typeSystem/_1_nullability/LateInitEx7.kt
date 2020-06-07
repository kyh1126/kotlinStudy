package _6_typeSystem._1_nullability

fun main(args: Array<String>) {
    // Normally, properties declared as having a non-null type must be initialized in the constructor.
    // However, fairly often this is not convenient. For example, properties can be initialized through dependency injection, or in the setup method of a unit test.
    // You cannot supply a non-null initializer in the constructor,
    // but you still want to avoid null checks when referencing the property inside the body of a class.

    // The lateinit modifier can be used on var properties declared inside the body of a class
    // (not in the primary constructor, and only when the property does not have a custom getter or setter)
    // since Kotlin 1.2, for top-level properties and local variables.
    // The type of the property or variable must be non-null, and it must not be a primitive type.

    // Checking whether a lateinit var is initialized (since 1.2)
    // .isInitialized : To check whether a lateinit var has already been initialized
//    if (foo::bar.isInitialized) {
//        println(foo.bar)
//    }

    // See test -> MyTest
}