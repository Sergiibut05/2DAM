package com.sergii.proyecto1compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider

import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sergii.proyecto1compose.ui.theme.Proyecto1ComposeTheme

import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.text.*

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Proyecto1ComposeTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = {Text("Mi App")})
                    },



                ) {
                        padding ->
                    Column(
                        modifier = Modifier
                            .padding(padding)
                            .fillMaxSize()
                    ) {
                        EjemploMaterial3();
                    }
                }
            }
        }
    }


}



@Composable
fun EjemploMaterial3() {
    var checked by remember { mutableStateOf(true) }
    var cantidad by remember { mutableStateOf("") }
    var comensales by remember { mutableStateOf("") }
    var sliderPosition by remember { mutableStateOf(0f) }

    var resultado_con_propina: Float by remember { mutableStateOf(0f)}
    var resultado_por_persona: Float by remember { mutableStateOf(0f)}

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

    ) {


        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = cantidad,
            onValueChange = { cantidad = it },
            label = { Text("Cantidad") }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = comensales,
            onValueChange = { comensales = it },
            label = { Text("Comensales") }
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
            Text("Redondear Propina")

            Switch(
                checked = checked,
                onCheckedChange = { checked = it }
            )
        }

        Column {
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.secondary,
                    activeTrackColor = MaterialTheme.colorScheme.secondary,
                    inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                ),
                steps = 4,
                valueRange = 0f..25f
            )
        }

        Button(onClick = {
            resultado_con_propina = cantidad.toInt() + cantidad.toInt() * (sliderPosition / 100)
            resultado_por_persona = resultado_con_propina / comensales.toInt()
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Calcular")
        }

        Text("Cantidad total: "+resultado_con_propina.toString())
        Text("Cada uno: "+resultado_por_persona.toString())
    }
}









