package com.danielzbarnes.simplerecyclerandroom

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "LibraryMainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var libraryRecyclerView: RecyclerView
    private var libraryAdapter: LibraryAdapter? = LibraryAdapter(emptyList())

    private val libraryViewModel: LibraryViewModel by lazy{
        ViewModelProvider(this).get(LibraryViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        libraryRecyclerView = findViewById(R.id.recycler_view)
        libraryRecyclerView.layoutManager = LinearLayoutManager(this)
        libraryRecyclerView.adapter = libraryAdapter





        // need to check how you do this in the main activity.
        libraryViewModel.bookListLiveData.observe(this, {
            books -> books?.let { updateUI(books) }
        })

    }

    private fun updateUI(books: List<Book>) {
        libraryAdapter = LibraryAdapter(books)
        libraryRecyclerView.adapter = libraryAdapter
    }


    private inner class LibraryViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{

        private lateinit var book: Book


        // set this using databinding instead?
        private lateinit var title: TextView
        private lateinit var author: TextView

        init { itemView.setOnClickListener(this) }

        fun bind(book: Book){

            this.book = book

            title = itemView.findViewById(R.id.title) as TextView
            author = itemView.findViewById(R.id.author) as TextView

            title.text = book.title
            author.text = book.author

        }

        override fun onClick(v: View?) {
            Log.d(TAG, "Book: ${book.title} by ${book.author} selected.")
        }

    }

    private inner class LibraryAdapter(var books: List<Book>): RecyclerView.Adapter<LibraryViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryViewHolder {
            val view = layoutInflater.inflate(R.layout.list_item_layout, parent, false)
            return LibraryViewHolder(view)
        }

        override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
            val book = books[position]
            holder.bind(book)
        }

        override fun getItemCount(): Int = books.size

    }

}