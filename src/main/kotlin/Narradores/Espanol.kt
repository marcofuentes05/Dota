package Narradores
import Narrador
class Espanol : Narrador{

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
                ret = "¿Fue Radiant quien mato? s/n"
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