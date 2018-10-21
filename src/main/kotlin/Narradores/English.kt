package Narradores
import Narrador

class English: Narrador {
    override fun narra (tipoEvento : String):String{
        var ret: String = ""
        when(tipoEvento){
            "1"->{
                ret = """
                    START - SINGLE DRAFT
                """.trimIndent()
            }
            "2"->{
                ret = "Hero selection of: "
            }
            "3" ->{
                ret = "Please enter the number of the hero you like on your team"
            }
            "4"->{
                ret = """
                    --------------------------------
                              GAME STARTING
                    --------------------------------
                """.trimIndent()
            }
            "5" ->{
                ret = """
                    MENU:
                        1. There were kills
                        2. Towers down
                """.trimIndent()
            }
            "6" -> {
                ret = "Did Radiant killed? 1 (yes)/2 (n0)"
            }
            "7" -> {
                ret  = "How many kills?"
            }
            "8" -> {
                ret = """
                    MENU:
                        1. There were kills
                        2. Towers down
                        3. Ancient got killed
                """.trimIndent()
            }
            "9" ->ret = "Not a valid input"
            "10" -> ret = "HEROES OF THE TEAM : "
            "11" -> ret ="""
                ------------------------------------
                        RADIANT HAS WON
                ------------------------------------
            """.trimIndent()
            "12" -> ret = """
                ------------------------------------
                           DIRE HAS WON
                ------------------------------------
            """.trimIndent()
            "13" -> {
                ret = "This team still has towers up..."
            }
            "14" ->{
                ret = "One dire soldier has died"
            }
            "15"->{
                ret = "Two or more dire soldiers have died"
            }
            "16" ->{
                ret = "Five dire soldiers have died"
            }
            "17" -> {
                ret = "One radiant soldier has died"
            }
            "18" -> {
                ret = "Two or more radiant soldiers have died"
            }
            "19" ->{
                ret = "Five radiant soldiers have died"
            }
            "20" ->{
                ret = "Dire has lost a tower"
            }
            "21" -> {
                ret = "Radiant has lost a tower"
            }
            else -> {
                ret = tipoEvento
            }
        }
        return ret
    }
}