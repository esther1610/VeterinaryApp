package cat.copernic.veterinaryapp.administrador

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cat.copernic.veterinaryapp.Perfil
import cat.copernic.veterinaryapp.databinding.FragmentCrearPerfilBinding
import com.google.firebase.auth.FirebaseAuth
import java.text.SimpleDateFormat
import java.util.*

class crear_perfil : Fragment() {


    private lateinit var binding: FragmentCrearPerfilBinding
    private lateinit var mAuth: FirebaseAuth
    var nuev_perf = Perfil();
    val formFecha1: SimpleDateFormat = SimpleDateFormat("dd/MM/yy")
    val formFecha2: SimpleDateFormat = SimpleDateFormat("dd-MM-yy")
    var texto = "10/06/2000"
    var fechita: Date = formFecha1.parse(texto)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCrearPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        mAuth = FirebaseAuth.getInstance()
        updateUI()
        registreUsuari()
    }

    private fun updateUI() {
        binding.regCorreo.setText("")
        binding.regPas.setText("")
        binding.regRepass.setText("")
        binding.regDni.setText("")
        binding.regNom.setText("")
        binding.regApe.setText("")
        binding.regFecha.setText("")
        binding.regTel.setText("")
        binding.regDni.setText("")
    }

    fun createUserWithEmailAndPassword(email: String, passwordd: String){

        mAuth!!.createUserWithEmailAndPassword(email, passwordd)
            .addOnCompleteListener { registro ->
                if (registro.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Èxit", "createUserWithEmail:success")
                    val user = mAuth!!.currentUser
                    updateUI()
                    missatgeEmergent("Informació", "Usuari registrat")
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Error", "createUserWithEmail:failure", registro.exception)
                    missatgeEmergent("Error", "Error en l'autentificació")
                    updateUI()

                }
            }

    }

    private fun registreUsuari(){

        binding.botReg.setOnClickListener(){
            nuev_perf.nombre = binding.regNom.text.toString()



            if(!binding.regCorreo.text.isEmpty() && !binding.regPas.text.isEmpty() && !binding.regRepass.text.isEmpty()){
                if(binding.regPas.text.toString().equals(binding.regRepass.text.toString())){
                    if(binding.regPas.text.toString().length>5){
                        createUserWithEmailAndPassword(binding.regCorreo.text.toString(), binding.regPas.text.toString())
                    }else{
                        missatgeEmergent("Error", "La contrasenya ha de contenir mínim 6 caràcters")
                    }
                }else{
                    missatgeEmergent("Error", "Les contrasenyes no són iguals")
                }
            }else{
                missatgeEmergent("Error", "S'han d'omplir tots els camps")
            }
        }
    }

    fun missatgeEmergent(titol: String, missatge: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(titol)
        builder.setMessage(missatge)
        builder.setPositiveButton("Aceptar") { dialog, which ->
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}