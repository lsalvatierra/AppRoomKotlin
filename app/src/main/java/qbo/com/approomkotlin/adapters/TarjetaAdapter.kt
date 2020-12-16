package qbo.com.approomkotlin.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_tarjeta.view.*
import qbo.com.approomkotlin.R
import qbo.com.approomkotlin.db.entity.TarjetaEntity
import qbo.com.approomkotlin.viewmodel.TarjetaDialogViewModel

class TarjetaAdapter(private val context: Context)
    : RecyclerView.Adapter<TarjetaAdapter.ViewHolder>()
{
    private var listatarjeta: List<TarjetaEntity>
    init {
        listatarjeta = ArrayList()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvtitulo : TextView = itemView.findViewById(R.id.tvtitulo)
        var tvcontenido : TextView = itemView.findViewById(R.id.tvcontenido)
        var ivtarjeta : ImageView = itemView.findViewById(R.id.ivtarjeta)
        var contenedor: CardView = itemView.findViewById(R.id.contenedor)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarjetaAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tarjeta, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: TarjetaAdapter.ViewHolder, position: Int) {
        val tarjeta = listatarjeta[position]
        holder.tvtitulo.text = tarjeta.titulo
        holder.tvcontenido.text = tarjeta.contenido
        if(tarjeta.importante){
            holder.ivtarjeta.setImageResource(R.drawable.ic_star)
        }else{
            holder.ivtarjeta.setImageResource(R.drawable.ic_star_border)
        }
        when (tarjeta.color){
            "Amarillo" -> holder.contenedor.setCardBackgroundColor(Color.YELLOW)
            "Rojo" -> holder.contenedor.setCardBackgroundColor(Color.RED)
            "Verde" -> holder.contenedor.setCardBackgroundColor(Color.GREEN)
        }
    }
    fun setListaTarjetas(lista: List<TarjetaEntity>){
        listatarjeta = lista
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return listatarjeta.size
    }
}