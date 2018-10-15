import Clases.Equipo
import Clases.Heroe
import com.github.kittinunf.fuel.Fuel

fun main (args : Array<String>){
    var menu1 : String = """
        MENU:
            1. Ocurrieron muertes
            2. Matan torres
    """.trimIndent()


    //URL del api
    val url = "http://www.json-generator.com/api/json/get/cfrjqHclbC?indent=2"
    //Extraccion del api
    val (request, response, result) = Fuel.get(url).responseObject(Heroe.HeroeArrayDeserializer())
    val (heroes,err) = result

    Thread.sleep(5000)
    //La funcion arrayToArrayList solo convierte el Array en ArrayList
    val listaHeroes : ArrayList <Heroe> = arrayToArrayList(result.get())
    //listaHeroes.forEach{println(it.toString())}

    //EMPEZAMOS CON EL SINGLE DRAFT

    //Se declaran los equipos y se inicializan
    val listaEquipos : ArrayList <Equipo> = arrayListOf()
    listaEquipos.add(Equipo("Radiant"))
    listaEquipos[0].agregarTorres()
    listaEquipos.add(Equipo("Dire"))
    listaEquipos[1].agregarTorres()

    //Aqui si empezamos el draft
    if (listaHeroes?.size != 0){
        var contador = 0
        for (i in (0..9)){
            println("Selección de Heroes de ${listaEquipos[contador].nombre}")
            for (a  in (0..listaHeroes.size-1)){
                println("$a. ${listaHeroes[a].name}")
            }
            var datoIncorrecto : Boolean = true
            while (datoIncorrecto){
                println("Ingrese el numero de heroe que desea en su equipo: ")
                try{
                    var respuesta = readLine()!!.toInt()
                    listaEquipos[contador].heroes.add(listaHeroes[respuesta])
                    listaHeroes.removeAt(respuesta)
                    datoIncorrecto = false
                }catch(e: Exception){
                    println("Ese no es un dato valido")
                }
            }
            contador = (contador + 1) % 2
        }
    }else{
        println("No hay héroes en la lista :(")
    }
    println("HEROES EQUIPO RADIANT")
    listaEquipos[0].heroes.forEach{println(it.toString())}

    println("""
        ------------------------------------------------
    """.trimIndent())

    println("HEROES EQUIPO DIRE")
    listaEquipos[1].heroes.forEach{println(it.toString())}



    //Teoricamente aqui acaba el draft
   /* var empezando : String = """
        -------------------
             EMPEZANDO
        -------------------
    """.trimIndent()
    println(empezando)

    println("""


    """.trimIndent())
    println(menu1)

    var respuesta2 : String = readLine()!!.toString()*/


}
fun arrayToArrayList(array : Array<Heroe>) : ArrayList<Heroe>{
    var arrayList : ArrayList<Heroe> = arrayListOf ()
    for (i in 0..array.size-1){
        arrayList.add(array[i])
    }
    return arrayList
}

