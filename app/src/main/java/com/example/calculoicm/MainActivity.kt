package com.example.calculoicm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtNome = findViewById<EditText>(R.id.edittext_nome)
        val edtPeso = findViewById<EditText>(R.id.edittext_peso)
        val edtAltura = findViewById<EditText>(R.id.edittext_altura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            //EXIBIR MENSAGEM DE VALIDAÇÃO NOS DADOS DE ENTRADA AOS USUÁRIOS
            //CRIAR AS DUAS VARIÁVEIS ABAIXO  alturaValida E pesoVakida PARA RECEBER OS VALORES DAS STRINGS
            val alturaValida = edtAltura.text.toString()
            val pesoValido = edtPeso.text.toString()
            if (alturaValida.isEmpty() && pesoValido.isEmpty()) {
                Toast.makeText(this, "Favor informar o Peso e a Altura", Toast.LENGTH_LONG).show()
            }else {
                if (pesoValido.isEmpty()) {
                    Toast.makeText(this, "Favor informar o peso", Toast.LENGTH_LONG).show()
                } else if (alturaValida.isEmpty()) {
                    Toast.makeText(this, "Favor informat a altura", Toast.LENGTH_LONG).show()
                } else {
                    val altura: Float = edtAltura.text.toString().toFloat()
                    val peso: Float = edtPeso.text.toString().toFloat()
                    val alturaFinal: Float = altura * altura
                    val resultado: Float = peso / alturaFinal
                    //CRIAR UMA INTENT EXPLICITA
                    val intent = Intent(this, Resultado::class.java)
                        //UTILIZA A intent ACIMA P/PASSAR INFS DO resultado PARA SEGUNDA TELA
                        //UTILIZANDO A FUNÇÃO .apply
                        .apply {
                            putExtra("EXTRA_RESULTADO", resultado)
                        }
                    //ENVIA NOME COMO PARÂMETRO PARA SEGUNTA ACTIVITY
                    intent.putExtra("ParametroNome",edtNome.getText().toString())
                    startActivity(intent)
                }
                //APAGA OS CAMPOS
                edtNome.setText("")
                edtPeso.setText("")
                edtAltura.setText("")
            }
        }
    }

}
           /*
            //daqui VERIFICA SE OS DOIS CAMPOS ESTÃO VAZIOS
            if(alturaValida.isNotEmpty() && pesoValido.isNotEmpty()) {
                val altura: Float = edtAltura.text.toString().toFloat()
                val peso: Float = edtPeso.text.toString().toFloat()
                val alturaFinal: Float = altura * altura
                val resultado: Float = peso / alturaFinal
                //CRIAR UMA INTENT EXPLICITA
                val intent = Intent(this, Resultado::class.java)
                    //UTILIZA A intent ACIMA P/PASSAR INFS DO resultado PARA SEGUNDA TELA
                    //UTILIZANDO A FUNÇÃO .apply
                    .apply {
                        putExtra("EXTRA_RESULTADO", resultado)
                    }
                startActivity(intent)
            }else {
                Toast.makeText(this, "Favor preencher todos os campos", Toast.LENGTH_LONG).show()
            } //aqui */
       // }
//    }
//}