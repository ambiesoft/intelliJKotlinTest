class Person(val firstName: String, val lastName: String) {
//    val firstName: String = _firstName
//    val lastName: String = _lastName

//    init {
//        firstName = _firstName
//        lastName = _lastName
//    }
    var nickName: String? = null
        set(value) {
            field = value
            println("the new nickname is $value")
        }
        get() {
            println("the returned value $field")
            return field
        }

    fun printInfo() {
        // val nickNameToPrint = if(nickName != null) nickName else "no nickname"
        val nickNameToPrint = nickName ?: "no nickname"
        println("$firstName ($nickNameToPrint) $lastName")
    }
    init {
        println("init 1")
    }
    constructor(): this("Peter", "Parker") {
        println("Secondary constructor")
    }
    init {
        println("init 2")
    }
}


fun testPerson() {
    val person = Person("Nate", "Kaz")
    val per2 = Person()

    person.nickName = "Shades"
    person.nickName = "New Nickname"

    println(person.nickName)

    person.printInfo()
    per2.printInfo()
}