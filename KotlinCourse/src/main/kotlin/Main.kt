
fun main(args: Array<String>) {
    println(KotlinVersion.CURRENT)

    diTest()
    nazo()
    scfun()
    imuu()
    imuu2()
    reifymain()
    fold()
    testCls()
    dele()
    testPerson()
    testPersonInfoProvider()
    testHigher()
    testEntity()
    testObdec()
    testDelePro()
    testDataClass()
    testLazyHolded()

    println("--------------------------------")
    testListItemUiModel()
    println("--------------------------------")

    println("--------------------------------")
    testinnernested()
    println("--------------------------------")

    println("--------------------------------")
    testImplicitThis()
    println("--------------------------------")

    println("--------------------------------")
    testCompanion()
    println("--------------------------------")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}


