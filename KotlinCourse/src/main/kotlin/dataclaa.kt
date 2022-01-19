data class UserData(val name: String, val age: Int)

fun testDataClass() {
    val userData = UserData("taro", 33)
    println(userData)
}

