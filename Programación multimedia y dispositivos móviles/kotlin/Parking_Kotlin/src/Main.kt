import Exceptions.VehicleAlreadyParkedException
import modelo.Parking
import modelo.Vehicle
import javax.print.attribute.SetOfIntegerSyntax
import kotlin.reflect.KMutableProperty

/** añadir coche, sacar coche, imprimir coches existentes, salir*/
fun main() {
    /**var cochesAparcados = mutableSetOf<String>()

    println("Bienvenido al Parking");

    var seguir = true;
    try {
        while (seguir) {
            println("Selecciona que hacer: 1.Añadir Coche, 2.Sacar Coche, 3.Imprimir Coches Aparcados, 4.Salir");
            val variable = readln().toInt();
            when (variable) {
                1 -> {
                    cochesAparcados = addCar(cochesAparcados);
                }

                2 -> {
                    cochesAparcados = deleteCar(cochesAparcados)
                }

                3 -> {
                    readCarList(cochesAparcados)
                }

                4 -> {
                    seguir = false;
                }

                else -> {
                    println("Seleccione una de las funciones posibles")
                }

            }
        }
    }catch (e:NumberFormatException){
        println("Escribe un numero de la selección")
    }catch (e:Exception){
        println(e)
    }*/
    /**Orientado a Objetos*/
    val parking = Parking(5)
    var exit:Boolean = false;

    do {
        println("Elija una opción: ")
        val option:String = readln()

        val optionAsInt = option.toIntOrNull();

        when (optionAsInt) {
            1 -> {
                val plate = readln()
                try {
                    parking.park(Vehicle(plate))
                }catch (ex: VehicleAlreadyParkedException) {
                    throw VehicleAlreadyParkedException;
                }

            }
            2 -> {}
            3 -> {}
            4 -> exit = true;
            null -> {} //Vuelve a preguntar
        }


    }
}
/**
fun findCar(matricula:String, cochesAparcados:MutableSet<String>): Boolean {
    for(cocheAparcado in cochesAparcados){
        if(cocheAparcado == matricula){
            return true
        }
    }
    return false
}
fun addCar(cochesAparcados:MutableSet<String>): MutableSet<String> {
    println("Escriba la matricula del coche a añadir")
    val matricula = readln();
    var yaExiste = findCar(matricula, cochesAparcados);
    if(yaExiste){
        println("El coche con esta matricula ya esta Aparcado")
        return cochesAparcados
    }else{
        cochesAparcados.add(matricula);
        println("El coche ha sido añadido")
        return cochesAparcados
    }

}
fun deleteCar(cochesAparcados:MutableSet<String>): MutableSet<String> {
    println("Escriba la matricula del coche a quitar")
    val matricula = readln();
    var existe = findCar(matricula, cochesAparcados);
    if(existe){
        cochesAparcados.remove(matricula);
        println("El coche ha sido eliminado")
        return cochesAparcados;
    }else{
        println("Este coches no esta aparcado aquí")
        return cochesAparcados;
    }
}
fun readCarList(cochesAparcados:MutableSet<String>){
    if(cochesAparcados.size > 0){
        println("Lista de Coches Aparcados")
        println("-------------------------")
        for(cocheAparcado in cochesAparcados){
            println(cocheAparcado)
        }
    }else{
        println("No hay coches aparcados")
    }
}*/
