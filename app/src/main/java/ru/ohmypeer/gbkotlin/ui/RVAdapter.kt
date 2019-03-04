package ru.ohmypeer.gbkotlin.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_card.view.*
import ru.ohmypeer.gbkotlin.R
import ru.ohmypeer.gbkotlin.data.Note

class RVAdapter : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    var notes: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                            R.layout.item_card,
                            parent,
                            false
                    )
            )

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(vh: ViewHolder, pos: Int) = vh.bind(notes[pos])


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(note: Note) = with(itemView) {
            with(note){
                item_text.text = title
                item_text.setTextColor(color)
                item_switch.textOff = textOff
                item_switch.textOn = textOn
                item_switch.isChecked = powerOn
            }

        }

    }
}