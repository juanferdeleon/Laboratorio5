package levels

import parkingSpots.ParkingSpot
import walls.Wall

class Level(
        private var lvlId: Int,
        private var lvlName: String,
        private var color: String,
        private var walls: ArrayList<Wall> = ArrayList(),
        private var parkingSpots: ArrayList<ParkingSpot> = ArrayList(),
        private var height: Int = 0,
        private var width: Int = 0
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

        print("Height: ${structure.size}")
        print("Width: ${structure[0].size}")
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

    override fun toString(): String {
        var map: String = """
            Level ID: ${getLvlId()}
            Level Name: ${getLvlName()}
            Level Color: ${getLvlColor()}

        """.trimIndent()
        for (j in 0..height){
            for (i in 0..width){
                if (walls[i].getColumn() == i && walls[i].getRow() == j){
                    map += "*"
                }else if (parkingSpots[i].getColumn() == 1 && parkingSpots[i].getRow() == j){
                    map += "" + parkingSpots[i].getParkingId()
                }else{
                    map += " "
                }
            }
            map += "\n"
        }
        return map
    }
}