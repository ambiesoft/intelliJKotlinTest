fun imuu() {
    val mutableList = mutableListOf(1, 2, 3)
    val list: List<Int> = mutableList

    mutableList.add(9)

    println(mutableList)
    println(list)
}

fun imuu2() {
    val list = listOf(null, 1, 2, 3, null)
    val notNullList = listOfNotNull(null, 1, 2, 3, null)

    println(list)
    println(notNullList)
}