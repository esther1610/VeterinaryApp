package cat.copernic.veterinaryapp.Objects

import java.sql.Date
import java.sql.Time

/**
 *
 */
class Cita {
    var veterinari:String = ""
    var dia: String? = null
    var hora: Time? = null
    var client: String = ""

    get() = field
    set(value) {
        field = value
    }
}