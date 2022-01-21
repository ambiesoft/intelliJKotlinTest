fun printLine() { println("Top-level function") }

class IT {
    fun printLine() { println("Member function") }

    fun invokePrintLine(omitThis: Boolean = false)  {
        if (omitThis) printLine()
        else this.printLine()
    }
}

fun testImplicitThis() {
    IT().invokePrintLine() // Member function
    IT().invokePrintLine(omitThis = true) // Top-level function
}


