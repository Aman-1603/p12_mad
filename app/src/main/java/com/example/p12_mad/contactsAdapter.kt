package com.example.p12_mad

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

    class contactsAdapter(private var context: Context, var items:ArrayList<Contact>): BaseAdapter() {
        override fun getCount(): Int {
            return items.size
        }

        override fun getItem(position: Int): Any {
            return items[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

            val view = LayoutInflater.from(context).inflate(R.layout.card_post, parent, false)

            val id:TextView = view.findViewById(R.id.text_id)
            val name: TextView =view.findViewById(R.id.text_name)
            val num: TextView =view.findViewById(R.id.text_num)
            val address: TextView = view.findViewById(R.id.text_address)
            // contact first name
            // val txt_ltr:TextView=view.findViewById(R.id.text_ltr)
            val n=items[position].name
            id.text=items[position]._id
        name.text=items[position].name
        num.text=items[position].num
        address.text=items[position].addr

       //contact First Name
        //txt_ltr.text= n[0].toString()


        return view
    }


}