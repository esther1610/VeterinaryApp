package cat.copernic.veterinaryapp

data class Mascota (
    var nom: String = "",
    var rassa: String = "",
    var dataNaixement: String?="",
    var numCgip:String="",
    var pes:String=""
)