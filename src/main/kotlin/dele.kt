import kotlin.properties.Delegates.notNull
import kotlin.properties.Delegates.observable
import kotlin.properties.Delegates.vetoable

// Here lazy is a property delegate that Kotlin provides us.
// It’s one of the four built-in delegates from the stdlib,
// and probably the most used and most well-known.
val myString by lazy { "Some Value" }


var maxCount: Int by observable(initialValue = 0) { property, oldValue, newValue ->
    println("${property.name} is being changed from $oldValue to $newValue")
}

var age: Int by vetoable(initialValue = 0) { property, oldValue, newValue ->
    newValue > 0
}

var mm by notNull<Int>()

// Creating your own delegates
// https://americanexpress.io/advanced-kotlin-delegates/
// https://americanexpress.io/advanced-kotlin-use-site-targets/#:~:text=Simply%20put%2C%20annotation%20use-site,Java%20code%20generated%20by%20kapt%20.
fun dele() {
    maxCount++
    maxCount++
    maxCount += 10

    println("age = ${age}");
    age = 1;
    println("age = ${age}");
    age = -1;
    println("age = ${age}");

    mm = 0;
    println(mm);
}