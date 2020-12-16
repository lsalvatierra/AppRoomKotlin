package qbo.com.approomkotlin.ui
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import qbo.com.approomkotlin.R
import qbo.com.approomkotlin.adapters.TarjetaAdapter
import qbo.com.approomkotlin.viewmodel.TarjetaDialogViewModel
class MainActivity : AppCompatActivity() {
    private var adapter : TarjetaAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = TarjetaAdapter(this)
        rvdatos.layoutManager = LinearLayoutManager(this)
        rvdatos.adapter = adapter
        fabagregar.setOnClickListener {
            val fragmentManager: FragmentManager = this.supportFragmentManager
            val dialogFragment = TarjetaDialogFragment()
            dialogFragment.show(fragmentManager, "NuevaTarjetaDialogFragment")
        }
        ListarTarjetasViewModel()
    }

    private fun ListarTarjetasViewModel() {
        val viewModel = ViewModelProvider(this)
            .get(TarjetaDialogViewModel::class.java)
        viewModel.listarTarjetas().observe(this, { tarjetaEntities->
            adapter!!.setListaTarjetas(tarjetaEntities)
        })
    }
}