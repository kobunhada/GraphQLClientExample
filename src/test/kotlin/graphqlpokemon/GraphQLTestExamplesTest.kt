package graphqlpokemon

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test


class GraphQLTestExamplesTest {

    @Test
    fun testGet_1_1_ExistData() {
        GlobalScope.launch {
            val pokemons = GraphQLTestExamples().get()
            assert(pokemons != null)
        }
    }

    @Test
    fun testPokemonFirstNo() {
        GlobalScope.launch {
            val pokemons = GraphQLTestExamples().get()
            if (pokemons !== null) {
                pokemons.forEach { pokemon ->
                    assert("001" == pokemon.number)
                    return@forEach
                }


            }
        }
    }
}