package ru.mail.park.jpyatachkov.rk1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.single_number.view.*

class SingleNumberAdapter(
    private val items: IntArray,
    private val context: Context
) : RecyclerView.Adapter<SingleNumberAdapter.SingleNumberViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SingleNumberViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_number, viewGroup, false)
        return SingleNumberViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: SingleNumberViewHolder, position: Int) {
        val item = items[position]
        viewHolder.numberTextView.text = item.toString()
        changeBackgroundColorByItem(item, viewHolder)

        viewHolder.minusButton.setOnClickListener {
            updateItem(--items[position], viewHolder)
        }

        viewHolder.plusButton.setOnClickListener {
            updateItem(++items[position], viewHolder)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    private fun updateItem(item: Int, viewHolder: SingleNumberViewHolder) {
        viewHolder.numberTextView.text = item.toString()
        changeBackgroundColorByItem(item, viewHolder)
    }

    private fun changeBackgroundColorByItem(item: Int, viewHolder: SingleNumberViewHolder) {
        val color = if (item >= 0) {
            context.getColor(R.color.positiveBackground)
        } else {
            context.getColor(R.color.negativeBackground)
        }

        viewHolder.itemView.setBackgroundColor(color)
    }

    class SingleNumberViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val minusButton = view.minusButton!!
        val numberTextView = view.numberTextView!!
        val plusButton = view.plusButton!!
    }
}