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

    //Primero se le pide al usuario que seleccione el idioma en el que desea jugar
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


    //Aqui si empezamos el draft (y con el juego)
    println(partida.bienvenida())
    //primero se hace el draft con todos los datos de los heroes que se tienen
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

    //Se muestran los heroes que tiene cada equipo
    println("${partida.algo()} RADIANT")
    listaEquipos[0].heroes.forEach{println(it.toString())}

    println("""
        ------------------------------------------------
    """.trimIndent())

    println("${partida.algo()} DIRE")
    listaEquipos[1].heroes.forEach{println(it.toString())}


    //Teoricamente aqui acaba el draft

    println(partida.empezarJuego())

    //Se comienza con el juego por turnos hasta que un equipo se quede sin torres
    while(partida.listaEquipos[0].torres.size != 0 && partida.listaEquipos[1].torres.size!=0){
        println(partida.menu1())
        var respuesta2 : String = readLine()!!.toString()
        when (respuesta2){
            "1"->{
                println(partida.pregunta())
                var radiantMato = readLine()!!
                when (radiantMato){
                    "1"->{
                        println(partida.cuantasMuertes())
                        var n = readLine()!!.toInt()
                        partida.heroesVivosDire = partida.heroesVivosDire-n
                        if (n == 1){
                            println(partida.ocurrioUnKill(true))
                        }else if (n >1 && n<5){
                            println(partida.ocurrieronDosOMasKills(true))
                        }else{
                            println(partida.ocurrieronCincoKills(true))
                        }
                    }
                    "2"->{
                        println(partida.cuantasMuertes())
                        var n = readLine()!!.toInt()
                        partida.heroesVivosRadiant = partida.heroesVivosRadiant - n
                        if (n == 1){
                            println(partida.ocurrioUnKill(false))
                        }else if (n >1 && n<5){
                            println(partida.ocurrieronDosOMasKills(false))
                        }else{
                            println(partida.ocurrieronCincoKills(false))
                        }
                    }
                }
            }
            "2" ->{
                println(partida.pregunta())
                var radiantMato = readLine()!!
                when (radiantMato){
                    "1"->{
                        partida.listaEquipos[1].torres.removeAt(0)
                        println(partida.matanUnaTorre(true))
                    }
                    "2"->{
                        partida.listaEquipos[0].torres.removeAt(0)
                        println(partida.matanUnaTorre(false))
                    }
                }
            }
        }
        //Luego de cada turno se imprime el estado de cada equipo (nuero de torres y heroes vivos
        println("""
        ESTADO DE RADIANT:
            No. de Torres vivas: ${partida.listaEquipos[0].torres.size}
            No. de Heroes Vivos: ${partida.heroesVivosRadiant}

        ESTADO DE DIRE:
            No. de Torres vivas: ${partida.listaEquipos[1].torres.size}
            No. de Heroes vivos: ${partida.heroesVivosDire}
    """.trimIndent())
    }
    //Cuando un equipo se queda sin torres, se habilita la opcion de matar al ancient
    while(partida.listaEquipos[0].ancient.estaMuerto == false && partida.listaEquipos[1].ancient.estaMuerto==false){
        println(partida.menu2())
        var r = readLine()!!.toString()
        when (r){
            "1"->{
                println(partida.pregunta())
                var radiantMato = readLine()!!
                when (radiantMato){
                    "1"->{
                        println(partida.cuantasMuertes())
                        var n = readLine()!!.toInt()
                        partida.heroesVivosDire = partida.heroesVivosDire-n
                        if (n == 1){
                            println(partida.ocurrioUnKill(true))
                        }else if (n >1 && n<5){
                            println(partida.ocurrieronDosOMasKills(true))
                        }else{
                            println(partida.ocurrieronCincoKills(true))
                        }
                    }
                    "2"->{
                        println(partida.cuantasMuertes())
                        var n = readLine()!!.toInt()
                        partida.heroesVivosRadiant = partida.heroesVivosRadiant - n
                        if (n == 1){
                            println(partida.ocurrioUnKill(false))
                        }else if (n >1 && n<5){
                            println(partida.ocurrieronDosOMasKills(false))
                        }else{
                            println(partida.ocurrieronCincoKills(false))
                        }
                    }
                }
            }
            "2" ->{
                println(partida.pregunta())
                var radiantMato = readLine()!!
                when (radiantMato){
                    "1"->{

                        partida.listaEquipos[1].torres.removeAt(0)
                        println(partida.matanUnaTorre(true))
                    }
                    "2"->{
                        partida.listaEquipos[0].torres.removeAt(0)
                        println(partida.matanUnaTorre(false))
                    }
                }
            }
            "3" ->{
                //Para matar al ancient se verifica que ese equipo ya no tenga torres
                println(partida.pregunta())
                var res = readLine()!!.toString()
                when(res){
                    "1"->{
                        if (partida.listaEquipos[1].torres.size == 0){
                            println(partida.radiantGana())
                        }else{
                            println(partida.error())
                        }
                    }
                    "2" ->{
                        if(partida.listaEquipos[0].torres.size == 0){
                            println(partida.direGana())
                        }else{
                            println(partida.error())
                        }
                    }
                }

            }
        }
    }
}

//Fuel debuelve la lista de objetos en una lista de tipo Array. Como nosotrso queremos un ArrayList, este metodo nos ayuda a colocarlo de una forma que nos sea util
fun arrayToArrayList(array : Array<Heroe>) : ArrayList<Heroe>{
    var arrayList : ArrayList<Heroe> = arrayListOf ()
    for (i in 0..array.size-1){
        arrayList.add(array[i])
    }
    return arrayList
}