package com.example.appdenoticiasusuario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appdenoticiasusuario.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var biding: ActivityMainBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)
        recuperarNoticia()


    }
    private fun recuperarNoticia(){
        db.collection("noticias").document("noticia2").get()
            .addOnCompleteListener{ documento ->
                if(documento.isSuccessful){
                    val titulo = documento.result.get("titulo").toString()
                    val noticia = documento.result.get("noticia").toString()
                    val data = documento.result.get("data").toString()
                    val autor = documento.result.get("autor").toString()

                    biding.txtTituloNoticia.text = titulo
                    biding.txtNoticia.text= noticia
                    biding.txtDataNoticia.text = data
                    biding.txtAutorNoticia.text = autor
                }

            }
    }
}