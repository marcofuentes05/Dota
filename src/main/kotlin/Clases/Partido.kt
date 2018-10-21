package Clases
import Narrador
import Narradores.*

class Partido (var T: Narrador, var listaEquipos : ArrayList<Equipo>) {
    var heroesVivosRadiant : Int = 5
    var heroesVivosDire : Int = 5

    var ganador : String = ""

    fun bienvenida():String{
        return T.narra("1")
    }
    fun draft(): String{
        return T.narra("2")
    }
    fun pedirNo():String{
        return T.narra("3")
    }
    fun datoInvalido() : String{
        return T.narra("9")
    }
    fun algo () :String {
        return T.narra ("10")
    }
    fun empezarJuego(): String{
       return (T.narra("4"))
    }
    fun menu1 () :String{
        return T.narra("5")
    }
    fun pregunta(): String{
        return T.narra("6")
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