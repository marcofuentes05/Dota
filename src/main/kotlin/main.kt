import Clases.Heroe
import com.github.kittinunf.fuel.Fuel
import Clases.LecturaHeroe

fun main (args : Array<String>){
    //URL del api
    val url = "https://github.com/kronusme/dota2-api/blob/master/data/heroes.json"
    //Extraccion del api
    val (request, response, result) = Fuel.get(url).responseObject(LecturaHeroe.LecturaHeroeArrayDeserializer())
    val (heroes,err) = result

    println(result.toString())


}