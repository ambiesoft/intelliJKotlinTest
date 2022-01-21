class Outer {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }
}

class Outer2 {
    private val bar: Int = 1
    // A nested class marked as inner can access the members of its outer class.
    inner class Inner {
        fun foo() = bar
    }
}
fun testinnernested() {
    val demo = Outer.Nested().foo() // == 2

    //  Unresolved reference: Nested
    // val ddemo = Outer().Nested().foo()

    // Constructor of inner class Inner can be called only with receiver of containing class
    // val demo2 = Outer2.Inner().foo()
    val demo2 = Outer2().Inner().foo() // == 1
    println("$demo, $demo2")

}
