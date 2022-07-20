package graphqlpokemon

import kotlinx.coroutines.*
import kotlin.jvm.JvmStatic
import kotlin.system.exitProcess

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        GlobalScope.launch {
            val pokemons = GraphQLTestExamples().get()
            if (pokemons == null) {
                return@launch
            }
            pokemons.forEach { pokemon ->
                delay(100)
                println(
                    "number:%s, name:%s, hp:%s, cp:%s, image url:%s".format(
                        pokemon.number,
                        pokemon.name,
                        pokemon.maxHP,
                        pokemon.maxCP,
                        pokemon.image
                    )
                )
            }
        }

        while (true) {
            Thread.sleep(10000)
            System.exit(0)
        }


    }
}