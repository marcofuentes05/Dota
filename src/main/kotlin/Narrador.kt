interface Narrador {
    //La interfaz narrador sirve para que podamos imprimir el juego en varios idiomas si tener que hacer todo muchas veces
    fun narra(tipoEvento:String):String{
        return tipoEvento
    }
}