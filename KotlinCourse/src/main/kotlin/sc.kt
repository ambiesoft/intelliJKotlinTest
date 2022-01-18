
fun isOdd(x: Int) = x % 2 != 0
val x = 1

fun scfun() {
    run {
        val str = "Hello"
        // this
        str.run {
            println("The string's length: $length")
            //println("The string's length: ${this.length}") // does the same
        }
        // it
        str.let {
            println("The string's length is ${it.length}")
        }
    }
    run {
        val strs = listOf("a", "bc", "def")
        val m = strs.map(String::length)
        println("str.map is ${m}")
    }
    run {
        val a = isOdd(5)
        println(a)
    }

    run {
        val numbers = listOf(1, 2, 3)
        println(numbers.filter(::isOdd))


        // property reference
        // ::x is KProperty<Int>
        println(::x.get())
        println(::x.name)
    }
}
