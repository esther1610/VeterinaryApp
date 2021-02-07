package cat.copernic.veterinaryapp

import android.media.Image
import java.util.*

/**
 * Clase Kotlin del tipo cat.copernic.veterinaryapp.Perfil para almacenar los datos de perfil de usuarios de la aplicación
 * @nombre, Nombre del perfil
 * @apellidos, Apellidos del Perfil
 * @telefono, Telefono del perfil
 * @fecha_nac, fecha de nacimiento en formato Date puede ser null
 * @usuario, email con el registro del usuario, es el que se utiliza en Firebase
 * @dni, DNI del perfil
 * @rol, administrador, cliente o veterinario
 * @foto, imagen del usuario *por definir si es el formato correcto
 * @direccion, direccion del perfil
 *
 */
class Perfil (nombre: String = "", apellidos: String = "", telefono: String = "", fecha_nac: Date? = null, usuario: String = "", dni: String = "",
              rol: String = "Cliente", foto: Image? = null, direccion: String = "") {
/**
 *
 * Se permite crear el constructor vació, si es el caso los valores seran cadena de texto sin nada o null, excepto el rol
 * si el campo rol se deja en blanco por defecto se pone el rol Cliente, que es el rol normal de un cliente (el rol mas bajo)
 *
 *
 * El campo fecha de nacimiento es del tipo Date, que despues podemos cambiar por otra clase si la hay que interese mas
 * El campo foro es del tipo Image y puede ser null, si hay otra clase que sea mas idonea lo podemos cambiar en el futuro
 */

/*
* Si necesitamos hacer la sobrecarga compatible con java deberiamos cambiar la clase de esta manera
class cat.copernic.veterinaryapp.Perfil @JvmOverloads constructor(nombre: String = "", apellidos: String = "", telefono: String = "", fecha_nac: Date? = null, usuario: String = "", dni: String = "",
              rol: String = "Cliente", foto: Image? = null, direccion: String = "")
*
* */
    init {
        //Aqui codigo de inicialización por si lo necesitamos.

    }

}