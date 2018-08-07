package parkingLots

import java.io.File
import levels.Level
import kotlin.collections.ArrayList

class ParkingLot(
        private var lvls: ArrayList<Level> = ArrayList()
){
    fun createLvl() {

        print("Nombre: ")
        var lvlName = readLine()!!
        print("Identificador: ")
        var lvlId = readLine()!!
        print("Color: ")
        var lvlColor = readLine()!!
        print("Archivo de estructura: ")
        var structure = readLine()!!

        if (lvls.size != 0){
            for (lvl in lvls) {
                if (lvlName == lvl.getLvlName() || lvlId.toInt() == lvl.getLvlId() || lvlColor == lvl.getLvlColor()) {
                    println("Ya existe un nivel con estas caracteristicas.")
                }else{
                    var lvl = Level(lvlId.toInt(), lvlName, lvlColor)

                    if (lvl.setObject(readMap(structure))){
                        println("Nivel agregado exitosamente!")
                        print(lvl.toString())
                        this.lvls.add(lvl)
                    }else{
                        println("Existe un error con la estructura del parqueo.")
                    }
                }

            }
        }else{
            var lvl = Level(lvlId.toInt(), lvlName, lvlColor)

            if (lvl.setObject(readMap(structure))){
                println("Nivel agregado exitosamente!")
                print(lvl.toString())
                this.lvls.add(lvl)
            }else{
                println("Existe un error con la estructura del parqueo.")
            }
        }

    }

    fun readMap(userFile: String): MutableList<List<String>>{

        var arrayLine: ArrayList<String> = ArrayList()

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