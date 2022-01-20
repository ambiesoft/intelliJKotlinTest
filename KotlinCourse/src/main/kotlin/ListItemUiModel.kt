open class ListItemUiModel {
    data class Title(val title: String) : ListItemUiModel()
    data class Cat(val data: CatUiModel) : ListItemUiModel()
}

class CatUiModel {

}


fun testListItemUiModel() {
    val listItemUiModel = ListItemUiModel()
    val title = ListItemUiModel.Title("title")
    val cat = ListItemUiModel.Cat(CatUiModel())

    println(listItemUiModel.javaClass.name)                 // double
    println(listItemUiModel.javaClass.kotlin)               // class kotlin.Double
    println(listItemUiModel.javaClass.kotlin.qualifiedName) // kotlin
    println()

    println(title.javaClass.name)                 // double
    println(title.javaClass.kotlin)               // class kotlin.Double
    println(title.javaClass.kotlin.qualifiedName) // kotlin
    println()

    println(cat.javaClass.name)                 // double
    println(cat.javaClass.kotlin)               // class kotlin.Double
    println(cat.javaClass.kotlin.qualifiedName) // kotlin
    println()

    if(cat is ListItemUiModel)
        println("cat is ListItemUiModel")
    else
        println("cat is not ListItemUiModel")

    // Nested class 'Title' accessed via instance reference
    // val isok = listItemUiModel.Title
}