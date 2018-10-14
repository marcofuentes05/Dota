package Clases

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class LecturaHeroe(
    val name : String,
    val id: String,
    val localized_name: String) {
    class LecturaHeroeArrayDeserializer : ResponseDeserializable<Array<LecturaHeroe>> {
        override fun deserialize(content: String): Array<LecturaHeroe>? {
            return Gson().fromJson(content, Array<LecturaHeroe>::class.java)
        }
    }
}