package cat.copernic.veterinaryapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import cat.copernic.veterinaryapp.administrador.HoraAdapter
import cat.copernic.veterinaryapp.databinding.FragmentVetGenerarcitaBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class vet_generardiagnosticos : Fragment() {

    private lateinit var binding: FragmentVetGenerarcitaBinding
    var user = Firebase.auth.currentUser
    val horas = ArrayList<String>()
    val formFecha1: SimpleDateFormat = SimpleDateFormat("dd/MM/yy")
    val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVetGenerarcitaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onStart() {
        super.onStart()
        createUI()
    }

    fun createUI(){
        var fecha : Date? = null
        var id : String = ""

        horas.add("7:00")
        horas.add("7:30")
        horas.add("8:00")
        horas.add("8:30")
        horas.add("9:00")
        horas.add("9:30")
        horas.add("10:00")
        horas.add("10:30")
        horas.add("11:00")
        horas.add("11:30")
        horas.add("12:00")
        horas.add("12:30")
        horas.add("13:00")
        horas.add("13:30")
        horas.add("14:00")
        horas.add("14:30")

        val adapador = HoraAdapter(horas)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapador
        binding.calendarView.setOnDateChangeListener{ calendarView, i, i2, i3 ->

            val dd : String = "" + i3 + "/" + (i2 + 1) + "/" + i
            fecha = this.formFecha1.parse(dd)
            id = "" + i3 + "" + (i2 + 1) + "" + i
        }

        binding.addCita.setOnClickListener {
            var mensage = ""
            if(!(binding.editTextTextPersonName7.equals(""))){
                db.collection("Visita").document(id + horaSelec).set(
                    hashMapOf(
                        "Cliente" to binding.editTextTextPersonName7,
                        "Veterinari" to user!!.email,
                        "Fecha" to fecha,
                        "Hora" to horaSelec
                    )
                )
            }else{
                mensage = "Introdizca cliente"
                missatgeEmergent(mensage)
            }

        }
    }

    companion object{
        var horaSelec : String = ""
    }

    fun missatgeEmergent(missatge: String) {
        val builder = android.app.AlertDialog.Builder(context)
        builder.setTitle("Error")
        builder.setMessage(missatge)
        builder.setPositiveButton("Aceptar") { dialog, which -> }
        val dialog: android.app.AlertDialog = builder.create()
        dialog.show()
    }
}