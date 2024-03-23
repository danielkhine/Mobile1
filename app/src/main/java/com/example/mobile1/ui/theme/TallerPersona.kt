package com.example.mobile1.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
impor
t androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TallerPersona() {
    var nombre by remember {
        mutableStateOf("")
    }
    var edad by remember {
        mutableStateOf("")
    }
    val personas = remember {
        mutableStateListOf<Persona>()
    }

    Column(modifier = Modifier.padding(15.dp)) {
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Age") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
        )
        Button(
            onClick = {
                if (nombre.isNotBlank() && edad.toIntOrNull() != null) {
                    personas.add(Persona(name = nombre, age = edad.toInt()))
                    nombre = " "
                    edad = " "
                }
            },
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
        ) {
            Text("Añadir")
        }

        personas.forEach { persona ->
            Text(text = "Nombre: ${persona.name}, Edad: ${persona.age}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    TallerPersona()
}