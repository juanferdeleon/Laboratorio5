package cars

import parkingSpots.ParkingSpot

class Car(
        private var licensePlate: String,
        private var parkingSpot: ParkingSpot
){
    fun getLicensePlate(): String{
        return this.licensePlate
    }

    fun whereIsParked(): String{
        return parkingSpot.getParkingId()
    }
}