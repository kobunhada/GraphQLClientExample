package graphqlpokemon

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import java.lang.Exception

class Example {
    suspend fun get(): MutableIterator<ExampleQuery.Pokemon>? {
        val apolloClient = ApolloClient.builder()
            .serverUrl("http://localhost:5000/graphql/endpoint")
            .build()
        val query = ExampleQuery.builder().build()
        val result: MutableIterator<ExampleQuery.Pokemon>? = try {
            apolloClient.query(query).await().data?.pokemons?.iterator()
        } catch (e: Exception) {
            null
        }

        return result

    }
}
