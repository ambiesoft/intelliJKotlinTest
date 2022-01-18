interface IDProvider {
    fun getId(): String
}

class Tntity private constructor(val id: String) {

    companion object Factory : IDProvider {
        override fun getId(): String {
            return "123"
        }
        const val id = "id"
        fun create() = Tntity(getId())
    }
}

fun testEntity()
{
    // val entity = Entity.Companion.create()
    // val entity = Entity.create()
    val tntity = Tntity.Factory.create()
    println(Tntity.id)
    println(tntity.id)
}