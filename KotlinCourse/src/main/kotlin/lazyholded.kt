class Lazyholded(intval: Int) {
    val theInt: Int by lazy {
        println("theInt")
        intval + 10
    }
    init {
        println("init")
    }
}

fun testLayholdFunc(intval: Int = 1000) {
    // Val cannot be reassigned
    // intval = 1000
    println("testLayholdFunc: $intval")
}
fun testLazyHolded() {
    val lazyholded = Lazyholded(111)
    println(lazyholded.theInt)
    testLayholdFunc()
    testLayholdFunc(1)
}