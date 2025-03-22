package com.booknest.community.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.booknest.community.R
import com.booknest.community.model.Books

class NewBooksAdapter(private val books: List<Books>, private val context: Context) :
    RecyclerView.Adapter<NewBooksAdapter.NewBooksVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewBooksVH {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.book_item_container_view, parent, false)
        return NewBooksVH(view)
    }

    override fun onBindViewHolder(holder: NewBooksVH, position: Int) {
        val book = books[position]

        holder.bookName.text = book.name
        holder.authorName.text = book.author
        holder.price.text = "$" + book.price.toString()
        holder.image.setImageResource(book.image)
        holder.rating.text = book.rating.toString()
        holder.addToCartBtn.setOnClickListener {
            Toast.makeText(context, "Added to cart", Toast.LENGTH_SHORT).show()
        }


    }

    override fun getItemCount(): Int = books.size

    class NewBooksVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bookName: TextView = itemView.findViewById(R.id.textView21)
        val authorName: TextView = itemView.findViewById(R.id.textView25)
        val price: TextView = itemView.findViewById(R.id.textView27)
        val rating: TextView = itemView.findViewById(R.id.textView26)
        val image: ImageView = itemView.findViewById(R.id.imageView3)
        val addToCartBtn: Button = itemView.findViewById(R.id.button6)
    }
}