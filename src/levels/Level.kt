package levels

import parkingSpots.ParkingSpot

class Level(
        private var lvlId: Int,
        private var lvlName: String,
        private var color: String,
        private var structure: MutableList<List<String>>,
        private var parkingSpots: ArrayList<ParkingSpot> = ArrayList()
){

    //TODO: setStructure()

    fun setParkingSpot(parkingId: String, row: Int, column: Int){
        val parkingSpot = ParkingSpot(parkingId, row, column)
        this.parkingSpots.add(parkingSpot)
    }
}