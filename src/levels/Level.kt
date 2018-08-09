package levels

import cars.Car
import parkingSpots.ParkingSpot
import walls.Wall

class Level(
        private var lvlId: Int,
        private var lvlName: String,
        private var color: String,
        private var walls: ArrayList<Wall> = ArrayList(),
        private var parkingSpots: ArrayList<ParkingSpot> = ArrayList(),
        private var height: Int = 0,
        private var width: Int = 0,
        private var carsParked: ArrayList<Car> = ArrayList()
){

    fun setObject(structure: MutableList<List<String>>): Boolean{

        var row: Int = 0
        var column: Int = 0

        for (j in structure){
            for (i in j){
                when (i){
                    " " -> {}
                    "" -> {}
                    "*" -> {
                        var wall = Wall(row, column)
                        this.walls.add(wall)
                    }
                    else -> {
                        if (parkingSpots.size != 0){
                            for (a in parkingSpots){
                                if (i == a.getParkingId()){
                                    return false
                                }
                            }
                        }
                        var parkingSpot = ParkingSpot(i, row, column)
                        this.parkingSpots.add(parkingSpot)
                    }
                }
                column++
            }
            column = 0
            row++

        }

        setHeight(structure.size)
        setWidth(structure[0].size)

        return true
    }

    private fun setHeight(height: Int){
        this.height = height
    }

    private fun setWidth(width: Int){
        this.width = width
    }

    fun getLvlName(): String{
        return this.lvlName
    }

    fun getLvlId(): Int{
        return this.lvlId
    }

    fun getLvlColor(): String{
        return this.color
    }

    fun isWall(row: Int, column: Int): Boolean{
        walls.forEach {
            if (it.getRow() == row && it.getColumn() == column){
                return true
            }
        }
        return false
    }

    fun isParkingSpot(row: Int, column: Int): Boolean{
        parkingSpots.forEach {
            if (it.getRow() == row && it.getColumn() == column){
                return true
            }
        }
        return false
    }

    fun isAvailable(): Boolean{
        for (parkingSpot in parkingSpots){
            if (!parkingSpot.getIsOccupied()){
                return true
            }
        }
        return false
    }

    fun checkAvailability(row: Int, column: Int): String{
        parkingSpots.forEach {
            if (it.getRow() == row && it.getColumn() == column){
                if (it.getIsOccupied()){
                    return "@"
                }else{
                    return "${it.getParkingId()}"
                }
            }
        }
        return ""
    }

    fun searchCar(licensePlate: String): Boolean{
        carsParked.forEach {
            if (it.getLicensePlate() == licensePlate){
                print("\nSu auto esta estacionado en el parqueo: ${it.whereIsParked()}\n")
                return true
            }
        }
        return false
    }

    fun parkCar(licensePlate: String){
        print("Seleccione estacionamiento: ")
        var userParkingSpot = readLine()!!
        for (parkingSpot in parkingSpots){
            if (parkingSpot.getParkingId() == userParkingSpot){
                var car = Car(licensePlate, parkingSpot)
                parkingSpot.isOccupied()
                print("\nSu carro fue estacionado exitosamente!\n")
                carsParked.add(car)
                return
            }
        }
    }

    override fun toString(): String {
        var map: String = """
            Level ID: ${getLvlId()}
            Level Name: ${getLvlName()}
            Level Color: ${getLvlColor()}

        """.trimIndent()
        for (j in 0..height){
            for (i in 0..width) {
                if (isWall(j, i)){
                    map += "*"
                }else if(isParkingSpot(j, i)){
                    map += checkAvailability(j, i)
                }else{
                    map += " "
                }
            }
            map += "\n"
        }
        return map
    }
}