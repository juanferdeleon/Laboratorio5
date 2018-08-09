import parkingLots.ParkingLot

fun main(args: Array<String>){

    val parkingLot = ParkingLot()

    do {
        var opSel: Int = 0
        println(getMenu(opSel))
        print("Ingrese una opcion: ")
        val strOp = readLine()!!
        opSel = strOp.toInt()
        
        when (strOp){
            "1" -> {
                do {
                    println(getMenu(opSel))
                    print("Ingrese una opcion: ")
                    val admOp = readLine()!!

                    when(admOp){
                        "1" -> parkingLot.createLvl()
                        "2" -> parkingLot.deletLevel()
                        "3" -> parkingLot.showLvls()
                    }
                }while (admOp != "4")
            }
            "2" -> {
                do {
                    println(getMenu(opSel))
                    print("Ingrese una opcion: ")
                    val usOp = readLine()!!

                    when (usOp){
                        "1" -> {
                            print("\nIngrese placa de su vehiculo: ")
                            var licensePlate = readLine()!!
                            if (!parkingLot.isParked(licensePlate)){
                                parkingLot.showAvailableLvls()
                                print("Seleccione un nivel: ")
                                var userLvl = readLine()!!
                                parkingLot.searchLvl(userLvl, licensePlate)
                            }
                        }
                    }
                }while (usOp != "2")
            }
        }

    }while (opSel != 3)
}

fun getMenu(opSel: Int): String{
    when (opSel){
        1 -> return """

            Menu:
            1. Crear nivel
            2. Eliminar nivel
            3. Ver todos los niveles
            4. Salir
        """.trimIndent()
        2 -> return """

            Menu:
            1. Ingresar placa
            2. Salir
        """.trimIndent()
        else -> return """

            Menu:
            1. Administrador
            2. Conductor
            3. Salir
        """.trimIndent()
    }
}