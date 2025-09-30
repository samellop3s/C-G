package com.app.estudos


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.estudos.adapter.PostoAdapter
import com.app.estudos.model.Posto


class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerPostos: RecyclerView
    private lateinit var listaDePostos: List<Posto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        // RecyclerView
        recyclerPostos = findViewById(R.id.recyclerPostos)
        recyclerPostos.layoutManager = LinearLayoutManager(this)

        // Lista de exemplo (pode vir do Firestore depois)
        listaDePostos = listOf(
            Posto("Posto Alpha"),
            Posto("Posto Beta"),
            Posto("Posto Gama"),
            Posto("Posto Delta"),
            Posto("Posto SimasTurbo")
        )

        // Adapter
        recyclerPostos.adapter = PostoAdapter(listaDePostos)
    }

}