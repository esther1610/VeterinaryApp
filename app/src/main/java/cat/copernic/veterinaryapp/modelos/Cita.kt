package cat.copernic.veterinaryapp.modelos

data class Cita (
    val dia: String,
    val hora: String,
    val veterianrio: String?,
    val cliente: String,
    val animal: String
)