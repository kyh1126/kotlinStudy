package _6_typeSystem._1_nullability

import org.junit.Before
import org.junit.Test

public class MyTest {
    lateinit var subject: TestSubject

    @Before
    fun setup() {
        subject = TestSubject()
    }

    @Test
    fun test() {
        subject.method()  // dereference directly
    }
}