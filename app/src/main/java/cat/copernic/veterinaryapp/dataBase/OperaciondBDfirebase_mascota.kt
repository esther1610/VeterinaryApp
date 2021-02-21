package cat.copernic.veterinaryapp.dataBase

import cat.copernic.veterinaryapp.modelos.Mascota
import com.google.firebase.firestore.FirebaseFirestore

class OperaciondBDfirebase_mascota: OperacionsBDMascota {

    private val db = FirebaseFirestore.getInstance()
    override fun guardar(mascota: Mascota): Boolean {
        db.collection("Mascota").document(mascota.numCgip).set(
            hashMapOf(
                // "id"  to mascota.idMascota.toString() ,
                "nom" to mascota.nom.toString(),
                "rassa" to mascota.rassa.toString(),
                "data_naixement" to mascota.dataNaixement.toString(),
                "numero_chip" to mascota.numCgip.toString(),
                "pes" to mascota.pes.toString()


            )
        )
        return true
    }

    override fun eliminar(mascota: Mascota): Boolean {
        TODO("Not yet implemented")
    }

    override fun modificar(mascota: Mascota): Boolean {
        TODO("Not yet implemented")
    }

    override fun buscar(mascota: Mascota): Boolean {
        TODO("Not yet implemented")
    }
}