class Cccls(name: String) {
    val name_ = name;
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }

    fun func() {
        println(name_);
        println(firstProperty);
        println(secondProperty);
    }
}

fun testCls()
{
    val c = Cccls("myname");
    c.func();
}