

fun main(args: Array<String>){
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

                }while (admOp != "4")
            }
            "2" -> {
                do {
                    println(getMenu(opSel))
                    print("Ingrese una opcion: ")
                    val usOp = readLine()!!

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