package com.fadhiil2010.pertemuan03

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fadhiil2010.pertemuan03.model.ModelBuku
import com.fadhiil2010.pertemuan03.model.ModelMovie

class DetailPage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_page)

        val buku: ModelBuku? = intent.getParcelableExtra("animal")

        // Temukan TextView di layout
        val imgDetail: ImageView = findViewById(R.id.img_itemMovie)
        val tvDetailName: TextView = findViewById(R.id.tvDetailName)
        val tvDetailDescription: TextView = findViewById(R.id.tvDetailDescription)

        // Set data ke TextView
        buku?.let {
            tvDetailName.text = it.title
            tvDetailDescription.text = it.penulis
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}