package Narradores
import Narrador
class Espanol : Narrador{
//Tanto esta clase como la de ENGLISH sirven para mostrar mensajes en distintos idiomas
    override fun narra(tipoEvento: String): String{
        var ret : String = ""
        when(tipoEvento){
            "1"->{
                ret = """
                    INICIO - SINGLE DRAFT
                """.trimIndent()
            }
            "2"->{
                ret = "Selección de heroes de: "
            }
            "3" ->{
                ret = "Ingrese el numero de heroe que desea en su equipo: "
            }
            "4"->{
                ret = """
                    --------------------------------
                            EMPEZANDO EL JUEGO
                    --------------------------------
                """.trimIndent()
            }
            "5" ->{
                ret = """
                    MENU:
                        1. Ocurrieron Muertes
                        2. Matan Torres
                """.trimIndent()
            }
            "6" -> {
                ret = "¿Fue Radiant quien mato? 1(si)/2(no)"
            }
            "7" -> {
                ret  = "¿Cuantas muertes?"
            }
            "8" -> {
                ret = """
                    MENU:
                        1. Ocurrieron Muertes
                        2. Matan Torres
                        3. Matan Ancient
                """.trimIndent()
            }
            "9" ->ret = "Ese no es und dato valido"
            "10" -> ret = "HEROES DEL EQUIPO: "
            "11" -> ret ="""
                ------------------------------------
                        RADIANT HA GANADO
                ------------------------------------
            """.trimIndent()
            "12" -> ret = """
                ------------------------------------
                           DIRE HA GANADO
                ------------------------------------
            """.trimIndent()
            "13" -> {
                ret = "Ese equipo todavia tiene torres vivas..."
            }
            "14" ->{
                ret = "Un gurrero de Dire ha muerto"
            }
            "15"->{
                ret = "Dos o mas gurerreros de Dire han muerto"
            }
            "16" ->{
                ret = "Cinco gurerreros de Dire han muerto"
            }
            "17" -> {
                ret = "Un guerrero de Radiant ha muerto"
            }
            "18" -> {
                ret = "Dos o mas guerreros de Radiant han muerto"
            }
            "19" ->{
                ret = "Cinco guerreros de Radiant han muerto"
            }
            "20" ->{
                ret = "Dire hacaba de perder una torre"
            }
            "21" -> {
                ret = "Radiant acaba de perder una torre"
            }
            else -> {
                ret = tipoEvento
            }
        }
        return ret
    }

    fun bienvenida():String{
        return """
            BIENVENIDOS
        """.trimIndent()
    }
}