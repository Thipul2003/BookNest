package com.booknest.community.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.booknest.community.R
import com.booknest.community.adapter.FeaturedBooksAdapter
import com.booknest.community.adapter.NewBooksAdapter
import com.booknest.community.model.Books
import com.google.android.material.appbar.MaterialToolbar

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val context = view.context;
        val toolbar = view.findViewById<MaterialToolbar>(R.id.materialToolbar2)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val recyclerView1 = view.findViewById<RecyclerView>(R.id.recyclerView1)
        val fragmentId = R.id.fragmentContainerView


        //load featured books
        val featuredBooks: MutableList<Books> = mutableListOf()

        featuredBooks.add(Books("The Silent Echo","Sarah Mitchell",19.99,4.5,R.drawable.book_5))
        featuredBooks.add(Books("Dark Matter","John Blake",50.99,4.5,R.drawable.book_1))
        featuredBooks.add(Books("Lost Dreams","Emma Roberts",30.99,4.5,R.drawable.book_3))
        val featuredBooksAdapter = FeaturedBooksAdapter(featuredBooks, context)

        val manager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.layoutManager = manager
        recyclerView.adapter = featuredBooksAdapter

        //load new Books
        val newBooks: MutableList<Books> = mutableListOf()

        newBooks.add(Books("The Last Secret","Mitchell Ross",23.99,4.5,R.drawable.book_3))
        newBooks.add(Books("Summer Love","Lisa Shen",18.99,4.5,R.drawable.book_4))
        newBooks.add(Books("Lost Dreams","Emma Roberts",30.99,4.5,R.drawable.book_5))
        val newBooksAdapter = NewBooksAdapter(newBooks, context)

        val manager2 = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView1.layoutManager = manager2
        recyclerView1.adapter = newBooksAdapter

        toolbar.setNavigationOnClickListener {
            requireActivity().findViewById<androidx.drawerlayout.widget.DrawerLayout>(R.id.drawerLayout)
                .open()
        }
        toolbar.setTitle(getString(R.string.app_name))
        toolbar.setTitleTextColor(context.getColor(R.color.text_color1))

        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.app_bar_search -> {
                    // Handle search action
                    true
                }

                R.id.nav_checkout -> {
                    // Handle cart action
                    toolbar.setNavigationIcon(R.drawable.arrow_left_solid)
                    toolbar.isTitleCentered = true
                    toolbar.setTitle("Checkout")
                    toolbar.menu.clear()

                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(fragmentId, CheckoutFragment())?.commit()
                    true
                }
                else -> false
            }
        }
        return view;

    }

}