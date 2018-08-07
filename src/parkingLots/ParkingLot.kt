package parkingLots

import java.io.File
import levels.Level

class ParkingLot(
        private var lvls: ArrayList<Level>
){
    fun createLvl(){

        print("Nombre: ")
        var lvlName = readLine()!!
        print("Identificador: ")
        var lvlId = readLine()!!
        print("Color: ")
        var lvlColor = readLine()!!
        print("Archivo de estructura: ")
        var structure = readLine()!!

        var lvl = Level(lvlName = lvlName, lvlId = lvlId.toInt(), color = lvlColor, structure = readMap(structure))

        this.lvls.add(lvl)
    }

    fun readMap(userFile: String): MutableList<List<String>>{

        var arrayLine: ArrayList<String> = ArrayList()
        var colCtr: Int = 0

        File("$userFile").forEachLine {
            arrayLine.add(it)
        }

        var structure = mutableListOf<List<String>>()
        arrayLine.forEach {
            structure.add(it.split(""))
        }

        return structure

    }
}