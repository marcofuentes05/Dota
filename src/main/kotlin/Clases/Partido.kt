package Clases
import Narrador
import Narradores.*

class Partido (var T: Narrador, var listaEquipos : ArrayList<Equipo>) {
    //Los atributos de la clase nos ayudan a ver el estado del juego
    var heroesVivosRadiant : Int = 5
    var heroesVivosDire : Int = 5
    //Los metodos ayudan a la interfaz (consola)
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
    fun cuantasMuertes():String{
        return T.narra("7")
    }
    fun menu2():String{
        return T.narra("8")
    }
    fun error():String{
        return T.narra("13")
    }
    fun ocurrioUnKill(esRadiant: Boolean): String{
        var r : String
        if (esRadiant == true){
            r = T.narra("14")
        }else{
            r = T.narra("17")
        }
        return r
    }

    fun ocurrieronDosOMasKills(esRadiant : Boolean):String{
        var r : String
        if (esRadiant == true){
            r = T.narra("15")
        }else{
            r = T.narra("18")
        }
        return r
    }
    fun ocurrieronCincoKills(esRadiant:Boolean): String{
        var r : String
        if (esRadiant == true){
            r =T.narra ("16")
        }else{
            r = T.narra("19")
        }
        return r
    }

    fun matanUnaTorre(esRadiant: Boolean): String{
        var r : String
        if (esRadiant == true){
            r = T.narra("20")
        }else{
            r = T.narra("21")
        }
        return r
    }
    fun direGana(): String{
        return T.narra("12")
    }
    fun radiantGana(): String{
        return T.narra("11")
    }
}