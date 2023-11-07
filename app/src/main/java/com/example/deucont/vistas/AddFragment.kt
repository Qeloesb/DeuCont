package com.example.deucont.vistas


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.deucont.databinding.FragmentAddBinding
import com.google.android.material.snackbar.Snackbar





class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddBinding.inflate(inflater,container,false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButton()
    }

    private fun setupButton() {
        binding.btnGuardar.setOnClickListener { sendDataToServer() }
    }

    private fun sendDataToServer() {

        try {
            if (validateForm()){
                val dataStr = "Name ${binding.etNombreDeuda.text.toString()}, "+
                        "ValorDeuda ${binding.etValorTotal.text.toString()}, "+
                        "ValorCuota ${binding.etValorCuota.text.toString()}, "+
                        "FechaVencimiento ${binding.etFechaVen.text.toString()}, "
                Log.i("data sent",dataStr)
                Snackbar.make(binding.root, "Datos enviados exitosamente", Snackbar.LENGTH_LONG)
                    .show()
            }
        }catch (e: Exception){
            Log.e("Error!", e.message.toString())
        }
    }

    private fun validateForm(): Boolean {
        var isValid = true
        with(binding){
            if (etNombreDeuda.text.toString().isBlank()){
                isValid = false
                tflNombreDeuda.error="Campo Requerido"
            }else{
                tflNombreDeuda.error=null
            }
            if (etValorTotal.text.toString().isBlank()){
                isValid = false
                tflValorTotal.error="Campo Requerido"
            }else{
                tflValorTotal.error=null
            }
            if (etValorCuota.text.toString().isBlank()){
                isValid = false
                tflValorCuota.error="Campo Requerido"
            }else{
                tflValorCuota.error=null
            }
            if (etFechaVen.text.toString().isBlank()){
                isValid = false
                tflFechaVen.error="Campo Requerido"
            }else{
                tflFechaVen.error=null
            }
        }
        return isValid
    }





    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}