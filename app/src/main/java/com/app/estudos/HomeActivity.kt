package com.app.estudos


import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
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
            Posto("Posto Alpha", "Rua A - 123", "23.5 km"),
            Posto("Posto Beta", "Avenida Central - 456", "24.0 km"),
            Posto("Posto Gama", "Rua das Palmeiras - 789", "22.8 km"),
            Posto("Posto Delta", "Alameda Santos - 321", "23.2 km"),
            Posto("Posto SimasTurbo", "Rodovia BR-101 - Km 45", "24.5 km"),
            Posto("Posto Omega", "Rua Nova Esperança - 654", "23.9 km"),
            Posto("Posto Solaris", "Avenida Brasil - 987", "22.7 km"),
            Posto("Posto Orion", "Rua XV de Novembro - 852", "23.6 km"),
            Posto("Posto Estrela", "Avenida das Nações - 741", "23.3 km"),
            Posto("Posto TurboMax", "Rodovia SP-75 - Km 120", "24.2 km")
        )

        // Adapter
        recyclerPostos.adapter = PostoAdapter(listaDePostos)

        val buttonProfile = findViewById<ImageButton>(R.id.buttonProfile)
        buttonProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

    }

}