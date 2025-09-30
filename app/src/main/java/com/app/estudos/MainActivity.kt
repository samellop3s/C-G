package com.app.estudos

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.app.estudos.FirestoreHelper.db
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textRegistro)
        val text = "Don't have an account?   Register now!"
        val spannable = SpannableString(text)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(this@MainActivity, CadastroActivity::class.java)
                startActivity(intent)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                // Defina a cor desejada aqui, ela será aplicada sempre
                ds.color = Color.parseColor("#FFA500")
                ds.isUnderlineText = false // Remove o sublinhado
                // Não é necessário fazer nada específico para o estado "visitado"
                // pois estamos sempre sobrescrevendo a cor.
            }
        }

        val startIndex = text.indexOf("Register now!")
        val endIndex = startIndex + "Register now!".length
        spannable.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)


        textView.text = spannable
        textView.movementMethod = LinkMovementMethod.getInstance()
        // Para garantir que o estado de foco/pressionado também não altere a cor do texto do link para o padrão
        textView.highlightColor = Color.TRANSPARENT // Opcional, remove o realce ao pressionar

        val inputLogin = findViewById<TextInputEditText>(R.id.login)
        val inputSenha = findViewById<TextInputEditText>(R.id.senha)
        val inputButton = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.buttonLogin)

        inputButton.setOnClickListener {
            val login = inputLogin.text.toString()
            val senha = inputSenha.text.toString()

            if (login.isBlank() || senha.isBlank()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            db.collection("usuarios")
                .whereEqualTo("email", login)
                .whereEqualTo("senha", senha)
                .get()
                .addOnSuccessListener { documents ->
                    if (!documents.isEmpty) {
                        Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, HomeActivity::class.java)
                        intent.putExtra("email", login)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Usuário não encontrado.", Toast.LENGTH_SHORT).show()
                    }
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Erro ao realizar login.", Toast.LENGTH_SHORT).show()
                }
        }
    }
}
