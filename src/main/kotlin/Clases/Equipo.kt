package Clases

class Equipo(val nombre:String,
             var heroes: ArrayList<Heroe> = arrayListOf(),
             var torres: ArrayList<Torre> = arrayListOf(),
             val ancient: Ancient = Ancient()){
    //Un equipo esta conformado por 5 heroes, 5 torres y un ancient
    fun agregarTorres(){
        torres.add(Torre())
        torres.add(Torre())
        torres.add(Torre())
        torres.add(Torre())
        torres.add(Torre())
        torres.add(Torre())
    }
}