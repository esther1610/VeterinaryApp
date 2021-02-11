package cat.copernic.veterinaryapp

import java.util.*

/**
 * Clase para almacenar los datos de diagnostico
 */
data class Diagnostico(
    var fecha: Date? = null,
    var id: String = "",
    var paciente: String = "",
    var diagnostico: String = "",
    var medicamento: String = "",
    var prox_visita: Date? = null,
    var veterinario: String = ""
)