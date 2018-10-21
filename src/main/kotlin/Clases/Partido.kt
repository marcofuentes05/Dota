package Clases
import Narrador
import Narradores.*

class Partido <T: Narrador>(var listaEquipos : ArrayList<Equipo>) {
    var heroesVivosRadiant : Int = 5
    var heroesVivosDire : Int = 5
    /* TODO:val listaIdiomas : ArrayList <ArrayList<String>> = arrayListOf(
            arrayListOf(
            """
                    Bienvenidos
            """.trimIndent(),
            """
                --------------------------
                    SELECCIÓN DE HEROES
                --------------------------
            """.trimIndent(),
            "Selección de Heroes de ",
            "Ingrese el numero de Heroe que desea en su equipo: ",
            "Ese no es un dato válido :(",
            "No hay heroes en la lista",
            "Lista de heroes de DIRE",
            "Lista de heroes de RADIANT",
            """
                --------------------------
                        EMPEZAMOS
                --------------------------
            """.trimIndent(),
            "Narracion de inicio de juego",
            """
            MENU:
                1. Ocurrieron muertes
                2. Matan torres
            """.trimIndent(),
            "¿Fue radiant quien mato?",
            "¿Cuantas muertes?",
            "Narración para una kill",
            "Narracion para dos o mas kills",
            "Narracion para cinco kills",
            "Narracion para una torre muerta",
            """
            MENU:
                1. Ocurrieron muertes
                2. Matan torres
                3. Matan Ancient
            """.trimIndent(),
            """

            """.trimIndent()
    ),
            arrayListOf()
    )*/


    var ganador : String = ""

    fun bienvenida(){

    }

    fun empezarJuego(){
       // println("${T.empezarJuego()}")

    }
    fun ocurrioUnKill(esRadiant: Boolean){

    }
    fun ocurrieronDosOMasKills(esRadiant : Boolean){

    }
    fun ocurrieronCincoKills(esRadiant:Boolean){

    }
    fun matanUnaTorre(esRadiant: Boolean){

    }
    fun direGana(){
        ganador = "Dire"
    }
    fun radiantGana(){
        ganador = "Radiant"
    }
}