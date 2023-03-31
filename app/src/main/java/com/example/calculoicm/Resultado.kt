package com.example.calculoicm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        //ADICIONANDO UMA SETA COM A FUNÇÃO VOLTAR NO TOOLBAR DA TELA
        supportActionBar?.setHomeButtonEnabled(true)
        //EXIBIR NO TOOLBAR DA TELA
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val tvResultado = findViewById<TextView>(R.id.textview_resultado)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)
        //DEU ERRO NA LINHA ACIMA, FAZ A LINHA DEPOIS DAS REGAS PARA CORRIGÍ-LO
        //RECUPERAR O resultado VINDO DA PRIMEIRA ACTIVITY
        val resultado = intent.getFloatExtra("EXTRA_RESULTADO",0.1f)
        //SETAR O TEXTO NO TEXTVIEW
        tvResultado.text=resultado.toString()
        //RECUPERAR O textview_classificacao DO XML DA SEGUNDA ACTIVITY

        //REGRAS DE ACORDO COM A TABELA

        //PODEMOS FAZER A CLASSIFICAÇÃO = SOMENTE UMA VEZ CONFORME ABAIXO
        //PODEMOS INICIAR A VARIÁVEL DIRETO NA CONDIÇÃO E ALTERAR var para val para  que a MESMA NUNCA VAI SER MODIFICADA
        //FORA DOS IF´s
        val classificacao = if(resultado < 18.5f) {
            "ABAIXO DO PESO"
        }else if(resultado in 18.5f..24.9f) {
            "NORMAL"
        }else if(resultado in 25.0f..29.9f) {
            "SOBREPESO"
        }else if(resultado in 30.0f..39.9f) {
            "OBESIDADE"
        }else{
            "OBESIDADE GRAVE"
        }
      // tvClassificacao.text = classificacao
        //PEGA UMA LABEL PARA O USUÁRIO
        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)
        //RECEBE O NOME E EXIBE NA TELA
        val nome = intent.getStringExtra("ParametroNome")
        val novoNome = findViewById<TextView>(R.id.txtRecebeNome)
        novoNome.setText(nome).toString()
       }
    //INSERIR UMA AÇÃO NO BOTÃO VOLTAR
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}