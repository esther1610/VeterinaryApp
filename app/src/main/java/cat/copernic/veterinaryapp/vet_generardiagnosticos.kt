package cat.copernic.veterinaryapp

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import cat.copernic.veterinaryapp.administrador.HoraAdapter
import cat.copernic.veterinaryapp.databinding.FragmentVetGenerarcitaBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class vet_generardiagnosticos : Fragment() {

    private lateinit var binding: FragmentVetGenerarcitaBinding
    val horas = ArrayList<String>()
    @SuppressLint("SimpleDateFormat")
    val formFecha1: SimpleDateFormat = SimpleDateFormat("dd/MM/yy")
    val db = FirebaseFirestore.getInstance()
    //var horaSelec : String = ""

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
        var fecha : Date

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
            Log.w("Dia", dd)

        }
    }

    companion object{
        var horaSelec : String = ""
    }
}