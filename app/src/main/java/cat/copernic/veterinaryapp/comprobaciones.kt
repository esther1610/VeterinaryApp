package cat.copernic.veterinaryapp

class comprobaciones {

    /* En esta clase podemos añadir varias comprobaciones
    * por ejemplo que una cadena contenga algo
    * que un némero este comprendido entre n valores, etc*/


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
}