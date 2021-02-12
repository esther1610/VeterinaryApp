package cat.copernic.veterinaryapp

interface OperacionsBDMascota {

    fun guardar(mascota: Mascota): Boolean
    fun eliminar(mascota: Mascota): Boolean
    fun modificar(mascota: Mascota): Boolean
    fun buscar(mascota: Mascota): Boolean
}