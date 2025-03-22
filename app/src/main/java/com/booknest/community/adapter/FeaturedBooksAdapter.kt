package com.booknest.community.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.booknest.community.R
import com.booknest.community.model.Books

class FeaturedBooksAdapter(private val books: List<Books>, private val context: Context) :
    RecyclerView.Adapter<FeaturedBooksAdapter.FeaturedBooksVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedBooksVH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.book_item_card_view, parent, false)
        return FeaturedBooksVH(view)
    }

    override fun onBindViewHolder(holder: FeaturedBooksVH, position: Int) {
        val book = books[position]

        holder.bookName.text = book.name
        holder.authorName.text = book.author
        holder.price.text = "$" + book.price.toString()
        holder.image.setImageResource(book.image)


    }

    override fun getItemCount(): Int = books.size

    class FeaturedBooksVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bookName: TextView = itemView.findViewById(R.id.textView22)
        val authorName: TextView = itemView.findViewById(R.id.textView23)
        val price: TextView = itemView.findViewById(R.id.textView24)
        val image: ImageView = itemView.findViewById(R.id.imageView)
    }
}