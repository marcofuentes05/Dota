import Clases.Equipo
import Clases.Heroe
import Clases.Partido
import Narradores.English
import Narradores.Espanol
import com.github.kittinunf.fuel.Fuel

fun main (args : Array<String>){

    val narradorES = Espanol()
    val narradorEN = English()

    //URL del api
    //Este URL no es el mismo que se proporciono con el documento ya que el poporcionado iba a un repositorio en GitHub,
    //esto hacia que Fuel no detectara el JSON y daba errores. Por tanto copie el JSON a JSONGenerator y generé un link nuevo
    // este link nuevo es el que se usa a continuacion.
    val url = "http://www.json-generator.com/api/json/get/cfrjqHclbC?indent=2"
    //Extraccion del api
    val (request, response, result) = Fuel.get(url).responseObject(Heroe.HeroeArrayDeserializer())
    val (heroes,err) = result

    // El sleep es paraesperar la respuesta del server
    Thread.sleep(5000)

    //Se declaran los equipos y se inicializan
    val listaEquipos : ArrayList <Equipo> = arrayListOf()
    listaEquipos.add(Equipo("Radiant"))
    listaEquipos[0].agregarTorres()
    listaEquipos.add(Equipo("Dire"))
    listaEquipos[1].agregarTorres()

    //La funcion arrayToArrayList solo convierte el Array en ArrayList
    val listaHeroes : ArrayList <Heroe> = arrayToArrayList(result.get())
    var control : Boolean = true

    println("""
        IDIOMA/LANGUAGE:
            1. ESPAÑOL
            2. ENGLISH
        """.trimIndent())
    var idioma = readLine()!!.toString()
    var c : Narrador
    if (idioma == "1"){
        c = Espanol()
    }else{
        c = English()
    }
    var partida = Partido (c, listaEquipos)
    //Aqui si empezamos el draft
    println(partida.bienvenida())
    if (listaHeroes?.size != 0){
        var contador = 0
        for (i in (0..9)){
            println("${partida.draft()} ${partida.listaEquipos[contador].nombre}")
            for (a  in (0..listaHeroes.size-1)){
                println("$a. ${listaHeroes[a].toString()}")
            }
            var datoIncorrecto : Boolean = true
            while (datoIncorrecto){
                println(partida.pedirNo())
                try{
                    var respuesta = readLine()!!.toInt()
                    partida.listaEquipos[contador].heroes.add(listaHeroes[respuesta])
                    listaHeroes.removeAt(respuesta)
                    datoIncorrecto = false
                }catch(e: Exception){
                    println(partida.datoInvalido())
                }
            }
            contador = (contador + 1) % 2
        }
    }else{
        println("No hay héroes en la lista :(")
    }
    println("${partida.algo()} RADIANT")
    listaEquipos[0].heroes.forEach{println(it.toString())}

    println("""
        ------------------------------------------------
    """.trimIndent())

    println("${partida.algo()} DIRE")
    listaEquipos[1].heroes.forEach{println(it.toString())}
    //Teoricamente aqui acaba el draft

    println(partida.empezarJuego())
    println(partida.menu1())
    var respuesta2 : String = readLine()!!.toString()
    when (respuesta2){
        "1"->{
            println(partida.pregunta())
            var radiantMato = readLine()!!
            when (radiantMato){
                "s"->{
                    
                }
                "n"->{

                }
            }
        }
        "2" ->{
            println(partida.pregunta())
        }
    }


}

fun arrayToArrayList(array : Array<Heroe>) : ArrayList<Heroe>{
    var arrayList : ArrayList<Heroe> = arrayListOf ()
    for (i in 0..array.size-1){
        arrayList.add(array[i])
    }
    return arrayList
}

