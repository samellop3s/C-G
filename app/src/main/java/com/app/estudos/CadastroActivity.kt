package com.app.estudos

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.app.estudos.R.id.buttonRegister
import com.google.android.material.textfield.TextInputEditText

class CadastroActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro2)

        val db = FirestoreHelper.db

        val inputNome = findViewById<TextInputEditText>(R.id.cadastroName)
        val inputEmail = findViewById<TextInputEditText>(R.id.cadastroEmail)
        val inputSenha = findViewById<TextInputEditText>(R.id.cadastroSenha)
        val inputButtonRegister = findViewById<Button>(buttonRegister)

        inputButtonRegister.setOnClickListener {
            val nome = inputNome.text.toString()
            val email = inputEmail.text.toString()
            val senha = inputSenha.text.toString()

            if (nome.isBlank() || email.isBlank() || senha.isBlank()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val usuario = hashMapOf(
                "nome" to nome,
                "email" to email,
                "senha" to senha
            )

            db.collection("usuarios")
                .add(usuario)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                    // Após cadastro bem-sucedido, abre a MainActivity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Erro ao cadastrar usuário: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }
}
