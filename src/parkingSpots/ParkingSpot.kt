package parkingSpots

class ParkingSpot(
        private var parkingId: String,
        private var row: Int,
        private var column: Int,
        private var isOccupied: Boolean = false
){

    fun isOccupied(){
        this.isOccupied = !isOccupied
    }

    fun getIsOccupied(): Boolean{
        return this.isOccupied
    }

    fun getParkingId(): String{
        return this.parkingId
    }

    fun getRow(): Int{
        return this.row
    }

    fun getColumn(): Int{
        return this.column
    }

}