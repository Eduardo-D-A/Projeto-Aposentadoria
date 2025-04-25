package com.eduardo.exercicio2

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.eduardo.exercicio2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sexo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Seta items da lista
        val items = listOf("Masculino", "Feminino");

        // Configura o adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Associa o adapter ao spinner
        binding.spinner.adapter = adapter

        // Percebe o clique do botão
        binding.buttonMostrar.setOnClickListener {
            // captura elemento selecionado no spinner
            sexo = binding.spinner.selectedItem.toString()
            // idade recebe texto escrito no edit_text
            var idade = binding.edittextIdade.text.toString().toIntOrNull()
            var resultado: Int
            if (idade != null) {
                if (sexo == "Masculino") {
                    resultado = 65 - idade
                } else{
                    resultado = 62 - idade
                }
                binding.textviewMensagem.text = "Faltam $resultado anos para você se aposentar."
            } else {
                binding.textviewMensagem.text = "Informe uma idade"
            }

        }
    }
}