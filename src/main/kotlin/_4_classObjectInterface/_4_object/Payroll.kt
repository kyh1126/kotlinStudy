package _4_classObjectInterface._4_object

// object declaration (makes Singleton)
object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
        for (person in allEmployees) {
            // calculate
            println("${person.name}'s salary calculation is done!")
        }
    }
}
