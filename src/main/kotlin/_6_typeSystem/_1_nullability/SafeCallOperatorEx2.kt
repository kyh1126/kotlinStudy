package _6_typeSystem._1_nullability

fun convertUpperCase(s: String?) = if (s != null) s.toUpperCase() else null

fun managerName(employee: Employee): String? = employee.manager?.name

fun main(args: Array<String>) {
    var s: String? = "null"

    println("convertUpperCase :: " + convertUpperCase(s))
    // safe call operator
    // null if value is null
    // not null, result becomes the result of the expression
    // This also works for functions, and it can be chained.
    println("?.toUpperCase :: " + s?.toUpperCase())

    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Smith", ceo)
    println(managerName(developer))
    println(managerName(ceo))
}