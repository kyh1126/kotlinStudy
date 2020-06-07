package _7_operatorOverloading._5_delegatedProperty

// ObservableProperty 에 작업을 위임하는 준비 코드가 필요한 버전
class PersonSalary2(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    val _age = ObservableProperty("age", age, changeSupport)
    var age: Int
        get() = _age.getValue()
        set(value) = _age.setValue(value)

    val _salary = ObservableProperty("salary", salary, changeSupport)
    var salary: Int
        get() = _salary.getValue()
        set(value) = _salary.setValue(value)
}