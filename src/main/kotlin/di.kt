

class GreetingRepositoryMock : GreetingRepositoryInterface {
    override fun greet(): String {
        return "Hello from Mock"
    }
}
class GreetingRepository : GreetingRepositoryInterface {
    override fun greet(): String {
        return "Hello from Repository"
    }
}

interface GreetingRepositoryInterface {
    fun greet(): String
}

class GreetingViewModel(private val greetingRepository: GreetingRepositoryInterface) {
    fun greet(): String {
        return this.greetingRepository.greet()
    }
}

fun diTest() {
    val viewModel = GreetingViewModel(greetingRepository = GreetingRepositoryMock())
    print(viewModel.greet())
}