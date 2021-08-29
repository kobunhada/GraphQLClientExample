package graphqlpokemon

import kotlinx.coroutines.*
import kotlin.jvm.JvmStatic
import kotlin.system.exitProcess

object Main {
    private var isExit = false
    @JvmStatic
    fun main(args: Array<String>) {
        GlobalScope.launch {
            val pokemons = Example().get()
            if (pokemons == null) {
                println("no pokemon")
                isExit = true
            } else {
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
                    );
                }
                isExit = true
            }
        }
        while (true) {
            Thread.sleep(100)
            if (isExit) exitProcess(0)
        }
    }
}