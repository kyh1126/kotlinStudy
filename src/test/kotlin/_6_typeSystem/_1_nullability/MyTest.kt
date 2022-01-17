package _6_typeSystem._1_nullability

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

public class MyTest {
    lateinit var subject: TestSubject

    @BeforeAll
    fun setup() {
        subject = TestSubject()
    }

    @Test
    fun test() {
        subject.method()  // dereference directly
    }
}
