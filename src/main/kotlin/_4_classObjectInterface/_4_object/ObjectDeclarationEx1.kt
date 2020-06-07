package _4_classObjectInterface._4_object

fun main(args: Array<String>) {
    // object
    // 클래스 선언과 그 클래스에 속한 단일 인스턴스의 선언을 합친 선언
    Payroll.allEmployees.add(Person("Jenny2"))
    Payroll.allEmployees.add(Person("Jenny3"))

    Payroll.calculateSalary()
}