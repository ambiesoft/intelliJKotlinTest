fun printFilteredStrings(list: List<String>, predicate: ((String) -> Boolean)?) {
    list.forEach {
        if(predicate?.invoke(it) == true) {
            println(it)
        }
    }
}

val predicate: (String) -> Boolean = {
    it.startsWith("J")
}

fun getPrintPredicate() : (String)-> Boolean {
    return {
        it.startsWith("C")
    }
}
fun testHigher()
{
    val list = listOf("Kotlin", "Java", "C++", "Javascript")
    // printFilteredStrings(list, { it.startsWith("J")})
    printFilteredStrings(list) {
        it.startsWith("J")
    }
    printFilteredStrings(list, predicate)
    printFilteredStrings(list, getPrintPredicate())
    printFilteredStrings(list, null)
}