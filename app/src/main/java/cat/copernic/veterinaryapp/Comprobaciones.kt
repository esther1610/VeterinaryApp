package cat.copernic.veterinaryapp

import java.util.regex.Pattern

class Comprobaciones {

    /**
     En esta clase podemos añadir varias comprobaciones
    * por ejemplo que una cadena contenga algo
    * que un némero este comprendido entre n valores, etc
    * */


    /**
     * Comprueba que una cadena de texto contiene algo
     *
     * @return verdadero si tiene contenido
     */
    public fun contieneTexto(txt: String): Boolean{
        var resultado = false
        if (txt != null){
            if (!txt.equals("")){
                resultado = true
            }else{
                resultado = false
            }
        }else{
            resultado = false
        }
        return resultado
    }

    /**
     * Analiza si un número de telefono es valido
     *
     * @return verdadero si es valido
     */
    public fun validarMovil(movil: String): Boolean {
        val pattern: Pattern = Pattern.compile("[0-9]{9}")
        return pattern.matcher(movil).matches()
    }
}