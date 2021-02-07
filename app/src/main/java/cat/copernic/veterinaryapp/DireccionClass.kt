package cat.copernic.veterinaryapp


/**
 * La clase DireccionClass almacenará los datos de la direccion, de momento se permiten los datos null por comodidad a la hora de crear la aplicacion
 * despues se podran poner datos obligatorios.
 *
 */
class DireccionClass(ciudad: String? = null, cp: String? = null, direc: String? = null, piso: Integer? = null, puerta: String? = null) {
    init {
        //Aqui por si hay que inicializar algun dato
    }
}