package Clases

class Equipo(val nombre:String,
             var heroes: ArrayList<Heroe> = arrayListOf(),
             var torres: ArrayList<Torre> = arrayListOf(),
             val ancient: Ancient = Ancient()){
    fun agregarTorres(){
        torres.add(Torre())
        torres.add(Torre())
        torres.add(Torre())
        torres.add(Torre())
        torres.add(Torre())
        torres.add(Torre())
    }
}