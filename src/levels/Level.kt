package levels

import parkingSpots.ParkingSpot

class Level(
        private var lvlId: Int,
        private var lvlName: String,
        private var color: String,
        private var structure: ArrayList<String>,
        private var parkingSpots: ArrayList<ParkingSpot>
){
    fun setLvlId(id: Int){
        this.lvlId = id
    }

    fun setLvlName(lvlName: String){
        this.lvlName = lvlName
    }

    fun setColor(color: String){
        this.color = color
    }

    //TODO: setStructure()

    fun setParkingSpot(parkingId: String, row: Int, column: Int){
        val parkingSpot = ParkingSpot(parkingId, row, column)
        this.parkingSpots.add(parkingSpot)
    }
}