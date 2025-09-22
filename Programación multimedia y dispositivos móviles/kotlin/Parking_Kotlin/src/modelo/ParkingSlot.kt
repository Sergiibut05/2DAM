package modelo


import java.time.Clock
import java.time.Instant

data class ParkingSlot(val vehicle: Vehicle?, val occupiedSince: Instant?) {

}

class Parking(private val maxSlots:Int = 100){
    private val parkingSlots: MutableList<ParkingSlot> = mutableListOf()
    private fun isFull():Boolean = if (parkingSlots.size == maxSlots) true else false

    fun park(vehicle: Vehicle){
        if (!isFull()) {
            val exists = parkingSlots.any {
                slot -> slot.vehicle?.plate == vehicle.plate;
            }

            if (!exists) {
                val slot = ParkingSlot(vehicle, Instant.now())
                parkingSlots.add(slot)
            }
        }
    }

    fun unPark(vehicle: Vehicle){

        val whereIs = parkingSlots.indexOfFirst {
            parkingSlot -> parkingSlot.vehicle?.plate == vehicle.plate
        }

        if (whereIs >= 0) {
            parkingSlots.removeAt(whereIs)
        }
    }

    fun getParkedVehicles():List<Vehicle> {
        val vehicles:MutableList<Vehicle> = mutableListOf();
        for (slot in parkingSlots) {
            vehicles.add(slot.vehicle!!)
        }
        return vehicles.sortedBy { it.plate }
    }
}