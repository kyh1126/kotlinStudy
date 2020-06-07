package _6_typeSystem._1_nullability

// Elvis operator also called null coalescing operator
fun strLenSafeDefault(s: String?): Int {
    // get the result of the expression unless it's null
    // otherwise, get 0 instead (which ought to be of a non-nullable type).
    return s?.length ?: 0
}

fun printShippingLabel(person: Person) {
    val address = person.company?.address ?: throw IllegalArgumentException("No address")
    with(address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

fun main(args: Array<String>) {
    println(strLenSafeDefault("Jenny"))
    println(strLenSafeDefault(null))

    val address = Address("Elsestr. 47", 80867, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val person = Person("Dmitry", jetbrains)

    printShippingLabel(person)
    printShippingLabel(Person("jenny", null))
}

/* Function selection

Function	Object reference	Return value	Is extension function
let	        it	                Lambda result	Yes
run	        this	            Lambda result	Yes
run	        -	                Lambda result	No: called without the context object
with	    this	            Lambda result	No: takes the context object as an argument.
apply	    this	            Context object	Yes
also	    it	                Context object	Yes

Here is a short guide for choosing scope functions depending on the intended purpose:
- Executing a lambda on non-null objects: let
- Introducing an expression as a variable in local scope: let
- Object configuration: apply
- Object configuration and computing the result: run
- Running statements where an expression is required: non-extension run
- Additional effects: also
- Grouping function calls on an object: with

 */