package parkingSpots

class ParkingSpot(
        private var parkingId: String,
        private var row: Int,
        private var column: Int,
        private var isOccupied: Boolean = false
){
    fun ParkingSpot(parkingId: String, row: Int, column: Int){
        setParkingId(parkingId)
        setRow(row)
        setColumn(column)
    }

    fun setParkingId(id: String){
        this.parkingId = id
    }

    fun setRow(row: Int){
        this.row = row
    }

    fun setColumn(column: Int){
        this.column = column
    }

    fun isOccupied(){
        this.isOccupied = !isOccupied
    }
}