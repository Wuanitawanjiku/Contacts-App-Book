package com.example.contactspage

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.contactspage.model.Contacts
import com.example.contactspage.ui.ViewContactsActivity
import com.squareup.picasso.Picasso

class ContactsAdapter(var contactslist:List<Contacts>, var context: Context):RecyclerView.Adapter<ContactsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
      var itemView=LayoutInflater.from(parent.context)
          .inflate(R.layout.contacts_lists_item,parent,false)
        return ContactsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
      var contact=contactslist.get(position)
        holder.tvName.text=contact.name
        holder.tvPhoneNumber.text=contact.phoneNumber
        holder.tvEmail.text=contact.email
        if(contact.imageUrl.isNotEmpty()){
            Picasso
                .get()
                .load(contact.imageUrl)
                .placeholder(R.drawable.option) //adding the default image
                .into(holder.imgcontacts)
        }


        holder.cvContact.setOnClickListener {
            var intent=Intent(context, ViewContactsActivity::class.java)
            intent.putExtra("name",contact.name)
            intent.putExtra("phoneNumber",contact.phoneNumber)//import info to the next activity
            intent.putExtra("email",contact.email)
            intent.putExtra("image",contact.imageUrl)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return contactslist.size

    }
}

class ContactsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvName=itemView.findViewById<TextView>(R.id.tvName)
    var tvPhoneNumber=itemView.findViewById<TextView>(R.id.tvContact)
    var tvEmail=itemView.findViewById<TextView>(R.id.tvEmail)
    var imgcontacts=itemView.findViewById<ImageView>(R.id.imgContact)
    var cvContact=itemView.findViewById<CardView>(R.id.cvContact)
}