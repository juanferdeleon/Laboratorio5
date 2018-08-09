package parkingLots

import java.io.File
import levels.Level
import kotlin.collections.ArrayList

class ParkingLot(
        private var lvls: ArrayList<Level> = ArrayList()
){
    fun createLvl() {

        print("\nNombre: ")
        var lvlName = readLine()!!
        print("Identificador: ")
        var lvlId = readLine()!!
        print("Color: ")
        var lvlColor = readLine()!!
        print("Archivo de estructura: ")
        var structure = readLine()!!

        if (lvls.size != 0){
            lvls.forEach {
                if (lvlName == it.getLvlName() || lvlId.toInt() == it.getLvlId() || lvlColor == it.getLvlColor()) {
                    println("Ya existe un nivel con estas caracteristicas.")
                    return
                }else{
                    var lvl = Level(lvlId.toInt(), lvlName, lvlColor)

                    if (lvl.setObject(readMap(structure))){
                        println("\nNivel agregado exitosamente!\n")
                        print(lvl.toString())
                        this.lvls.add(lvl)
                        return
                    }else{
                        println("Existe un error con la estructura del parqueo.")
                        return
                    }
                }

            }
        }else{
            var lvl = Level(lvlId.toInt(), lvlName, lvlColor)

            if (lvl.setObject(readMap(structure))){
                println("\nNivel agregado exitosamente!\n")
                print(lvl.toString())
                this.lvls.add(lvl)
                return
            }else{
                println("Existe un error con la estructura del parqueo.")
                return
            }
        }

    }

    fun deletLevel(){

        print("\nIngrese el identificador del nivel que desea eliminar: ")
        var deletLevel = readLine()!!

        if (lvls.size != 0){
            for (lvl in lvls){
                if(lvl.getLvlId() == deletLevel.toInt()){
                    lvls.remove(lvl)
                    print("El nivel se a removido exitosamente!\n")
                    return
                }
            }
        }else{
            print("\nAun no existen niveles\n")
        }

    }

    fun showLvls(){
        lvls.forEach {
            print(it.toString())
        }
    }

    fun isParked(licensePlate: String): Boolean{
        for (lvl in lvls){
            if (lvl.searchCar(licensePlate)){
                print(lvl.toString())
                return true
            }
        }
        return false
    }

    fun showAvailableLvls(){
        lvls.forEach{
            if (it.isAvailable()){
                print(it.toString())
            }
        }
    }

    fun searchLvl(userLvl: String, licensePlate: String){
        lvls.forEach {
            if (it.getLvlName() == userLvl){
                print(it.toString())
                it.parkCar(licensePlate)
                return
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