
import java.util.*

// Object Declaration
// Creating thread-safe singletons

enum class EntityType {
    HELP,EASY,MEDIUM,HARD;

    fun getFormattedName() = name.lowercase().capitalize()
}
object EntityFactory {
    fun create(type: EntityType) : Entity {
        val id = UUID.randomUUID().toString()
        val name = when(type){
            EntityType.EASY -> type.name
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
            EntityType.HELP -> "help"
        }
        return when(type) {
            EntityType.EASY -> Entity.Easy(id,name)
            EntityType.MEDIUM -> Entity.Medium(id,name)
            EntityType.HARD -> Entity.Hard(id,name,2f)
            EntityType.HELP -> Entity.Help
        }
    }
}

// sealed: Can not instantiate
// Entity is same as enum but data class takes different properties
sealed class Entity() {
    // Generic static Help Entity
    object Help : Entity() {
        val name = "Help"
    }
    data class Easy(val id:String, val name: String): Entity()
    data class Medium(val id:String, val name: String): Entity()
    data class Hard(val id:String, val name: String, val multiplier: Float): Entity()
}

fun testObdec() {
    // val entity = Entity.Companion.create()
    // val entity = Entity.create()

//    val entity = EntityFactory.create(EntityType.EASY)
//    println(entity)
//
//    val mediumEntity = EntityFactory.create(EntityType.MEDIUM)
//    println(mediumEntity)

    val entity: Entity = EntityFactory.create(EntityType.HELP)
    val msg = when(entity) {
        Entity.Help -> "help class"
        is Entity.Easy -> "easy class"
        is Entity.Hard -> "hard class"
        is Entity.Medium -> "medium class"
    }
    println(msg)

    dataclass()
}

fun dataclass() {
    val entity1 = EntityFactory.create(EntityType.EASY)
    val entity2 = EntityFactory.create(EntityType.EASY)

    if(entity1 == entity2) {
        println("they are equal")
    } else {
        // because they have not unique id
        // In data class '==' compares its values
        println("they are not equal")
    }

    dataclass2()
}

fun dataclass2() {
    val entity1 = Entity.Easy("id","name")
    val entity2 = Entity.Easy("id","name")

    if(entity1 == entity2) {
        // because all properties are same
        println("they are equal")
    } else {
        println("they are not equal")
    }

    dataclass3()
}

fun dataclass3() {
    val entity1 = Entity.Easy("id","name")
    val entity2 = entity1.copy()

    if(entity1 == entity2) {
        // because all properties are same
        println("they are equal")
    } else {
        println("they are not equal")
    }

    dataclass4()
}

fun dataclass4() {
    val entity1 = Entity.Easy("id","name")
    val entity2 = entity1.copy(name = "new name")

    if(entity1 == entity2) {
        // because all properties are same
        println("they are equal")
    } else {
        println("they are not equal")
    }
    dataclass5()
}

fun dataclass5() {
    val entity1 = Entity.Easy("id","name")
    val entity2 = Entity.Easy("id","name")

    if(entity1 === entity2) {
        println("they are equal")
    } else {
        // not referential equal
        println("they are not equal")
    }

    extfun()
}

fun Entity.Medium.printInfo() {
    println("Mediam class: $id")
}

val Entity.Medium.info: String
    get() = "some info"

fun extfun() {
    Entity.Medium("id","name").printInfo()

    // val entity1 = Entity.Easy("id","name")
    val entity2 = EntityFactory.create(EntityType.MEDIUM)

    if(entity2 is Entity.Medium) {
        entity2.printInfo()
        entity2.info
    }
}