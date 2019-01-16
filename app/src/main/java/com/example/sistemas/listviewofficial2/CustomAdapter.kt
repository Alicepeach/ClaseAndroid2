package com.example.sistemas.listviewofficial2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(var context: Context, var artist: ArrayList<Artist>): BaseAdapter(){
    //Un ViewHolder describe una vista de elementos sobre un lugar dentro del ListView
    private class ViewHolder(row: View?){
        //Las siguientes variables funcionan como almacenamiento caché 
	var txtName: TextView
        var ivImagen: ImageView
	//Inicialización
        init {
            this.txtName = row?.findViewById(R.id.txtArtista) as TextView
            this.ivImagen = row?.findViewById(R.id.ivArtista) as ImageView
        }
    }
    
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //Variable para el View
        var view: View?
	//Variable por Item
        var viewHolder: ViewHolder
	//El siguiente if, crear una nueva vista o "recicla" la que ya tenía del 
	//item anterior para no crear un objeto completamente nuevo
        if(convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.artist_item_list,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
	//En caso de que no se requiera crear una nueva vista, se devolverá la que ya estaba lista
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
	//Devolvemos los elementos del artista
        var artist: Artist = getItem(position) as Artist
        viewHolder.txtName.text = artist.name
        viewHolder.ivImagen.setImageResource(artist.image)
	//El tipo de valor de retorno de esta función es una vista. 
        return view as View
    }

    //Obtiene el artista en la posición
    override fun getItem(position: Int): Any {
        return artist.get(position)
    }
    //Obtiene la posición id
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //Obtiene el número de artistas
    override fun getCount(): Int {
        return artist.count()
    }
}