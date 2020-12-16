package qbo.com.approomkotlin.ui

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import qbo.com.approomkotlin.R
import qbo.com.approomkotlin.db.entity.TarjetaEntity
import qbo.com.approomkotlin.viewmodel.TarjetaDialogViewModel

class TarjetaDialogFragment : DialogFragment() {

    private lateinit var viewModel: TarjetaDialogViewModel
    private lateinit var ettitulo: TextInputEditText
    private lateinit var etcontenido: TextInputEditText
    private lateinit var rgcolor: RadioGroup
    private lateinit var rbtnamarillo: RadioButton
    private lateinit var rbtnrojo: RadioButton
    private lateinit var rbtnverde: RadioButton
    private lateinit var swimportante: Switch


    companion object {
        fun newInstance() = TarjetaDialogFragment()
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        viewModel = ViewModelProvider(activity!!).get(TarjetaDialogViewModel::class.java)
        val inflater= activity!!.layoutInflater
        val view = inflater.inflate(R.layout.tarjeta_dialog_fragment, null)
        ettitulo = view.findViewById(R.id.ettitulo)
        etcontenido = view.findViewById(R.id.etcontenido)
        rgcolor = view.findViewById(R.id.rgcolor)
        rbtnamarillo = view.findViewById(R.id.rbtnamarillo)
        rbtnrojo = view.findViewById(R.id.rbtnrojo)
        rbtnverde = view.findViewById(R.id.rbtnverde)
        swimportante = view.findViewById(R.id.swimportante)
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setTitle("Nueva Tarjeta")
        builder.setMessage("Introduzca los datos de la tarjeta")
            .setPositiveButton("Guardar", DialogInterface.OnClickListener { dialog, which ->
                val titulo : String = ettitulo.text.toString()
                val contenido : String = etcontenido.text.toString()
                var color = "Amarillo"
                when(rgcolor.checkedRadioButtonId){
                    R.id.rbtnrojo -> color = "Rojo"
                    R.id.rbtnverde -> color = "Verde"
                }
                val esimportante: Boolean = swimportante.isChecked
                viewModel.insertar(
                    TarjetaEntity(0, titulo, contenido,esimportante, color)
                )
                dialog.dismiss()
            })
            .setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
        builder.setView(view)
        return builder.create()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TarjetaDialogViewModel::class.java)
        // TODO: Use the ViewModel
    }

}