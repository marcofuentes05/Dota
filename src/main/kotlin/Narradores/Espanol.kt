package Narradores
import Narrador
class Espanol : Narrador{

    fun bienvenida():String{
        return """
            BIENVENIDOS
        """.trimIndent()
    }
}