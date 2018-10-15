package Clases
import Narrador

class Partido(T: Any): Narrador {
    var listaEquipos : ArrayList<Equipo> = arrayListOf()
    var muertesEquipos : ArrayList <Int> = arrayListOf()
    var ganador : String = ""

    fun bienvenida(){
        narra("Bienvenidos!")
    }
    fun empezarJuego(){

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