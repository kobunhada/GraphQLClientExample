package graphqlpokemon

import kotlinx.coroutines.delay
import kotlin.system.exitProcess

class GraphQLTestExamples {
    private var isExit = false

    suspend fun get(): MutableIterator<ExampleQuery.Pokemon>? {
        return Example().get()
    }
}