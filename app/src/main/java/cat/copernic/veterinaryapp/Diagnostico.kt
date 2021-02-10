package cat.copernic.veterinaryapp

import java.util.*

/**
 * Clase para almacenar los datos de diagnostico
 */
class Diagnostico() {
    var fecha: Date? =
        null //Temporalmente lo pongo a null, aun que deberia tener una fecha obligatoria
    var id: String = ""
    var paciente: String = "" //En el futuro se puede cambiar por la calse mascota.
    var prospecto: String = "" //Si mal no recuerdo era el medicamento
    var prox_visita: Date? = null //Se permite null por si no tiene proxima visita programada
    var veterinario: String =
        "" //En el futuro se puede cambiar por la clase Perfil siempre y cuando tenga el rol de veterinario

    get() = field
    set(value) {
        field = value
    }
}