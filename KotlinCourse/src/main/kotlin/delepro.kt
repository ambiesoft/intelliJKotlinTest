import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}
class Example {
    var p: String by Delegate()
    val lazyValue: String by lazy {
        println("computed!")
        "Hello"
    }
    var name: String by Delegates.observable("<no name>") {
            prop, old, new ->
        println("$old -> $new")
    }
}

class MyClass {
    var newName: Int = 0
    @Deprecated("Use 'newName' instead", ReplaceWith("newName"))
    var oldName: Int by this::newName
}

class User(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}

fun testDelePro() {
    val e = Example();
    println(e.p)
    e.p="NEW"
    println(e.p)

    println(e.lazyValue)
    println(e.lazyValue)

    e.name = "first"
    e.name = "second"

    val myClass = MyClass()
    // Notification: 'oldName: Int' is deprecated.
    // Use 'newName' instead
    myClass.oldName = 42
    println(myClass.newName) // 42


    val user = User(mapOf(
        "name" to "John Doe",
        "age"  to 25
    ))
    println(user.name) // Prints "John Doe"
    println(user.age)  // Prints 25
}