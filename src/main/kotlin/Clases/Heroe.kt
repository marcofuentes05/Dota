package Clases

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
//Un objeto heroe tiene un nombre y un ID, que son obtenidos de internet a traves de Graddle
data class Heroe(val name: String,
                 val id: Int,
                 val localized_name: String) {

    class HeroeArrayDeserializer : ResponseDeserializable<Array<Heroe>> {
        override fun deserialize(content: String): Array<Heroe> {
            return Gson().fromJson(content, Array<Heroe>::class.java)
        }
    }
    override fun toString(): String{
        return "${localized_name}"
    }

}