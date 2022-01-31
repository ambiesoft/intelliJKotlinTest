

class CompanionTest {
    var a = "a";
    companion object {
        var b = "b"
    }
}

fun testCompanion() {
    // Unresolved reference: a
    // CompanionTest.a = "f"
    CompanionTest.b = "c"

    val ct = CompanionTest()
    println(ct.a)

    // Unresolved reference: b
    // println(ct.b)

    ct.a = "aaa";
    println(ct.a)
}