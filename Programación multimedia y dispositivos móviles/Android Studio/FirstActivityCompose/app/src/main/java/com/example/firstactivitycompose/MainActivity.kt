package com.example.firstactivitycompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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

import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.text.*

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.firstactivitycompose.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(
                    topBar = {

                        TopAppBar(title = {Text(stringResource(R.string.app_name))})
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

    var resultado_con_propina by remember { mutableStateOf(0f) }
    var resultado_por_persona by remember { mutableStateOf(0f) }
    var calculado by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = cantidad,
            onValueChange = { cantidad = it },
            label = { Text(stringResource(R.string.people)) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = comensales,
            onValueChange = { comensales = it },
            label = { Text(stringResource(R.string.quantity)) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(style = MaterialTheme.typography.headlineSmall,
                text = "Redondear Propina")

            Switch(
                checked = checked,
                onCheckedChange = { checked = it }
            )
        }

        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = 4,
            valueRange = 0f..25f,
            enabled = checked
        )
        if (!checked){
            sliderPosition = 0f
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val cantidadInt = cantidad.toIntOrNull() ?: 0
                val comensalesInt = comensales.toIntOrNull() ?: 0

                if (cantidadInt > 0 && comensalesInt > 0) {
                    resultado_con_propina = cantidadInt + cantidadInt * (sliderPosition / 100)
                    resultado_por_persona = resultado_con_propina / comensalesInt
                } else {
                    resultado_con_propina = 0f
                    resultado_por_persona = 0f
                }

                calculado = true
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,

            ){
                Icon(
                    painter = painterResource(id = R.drawable.circles),
                    contentDescription = "Icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text("Calcular")
            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        if (calculado) {
            Resultado(resultado_con_propina, resultado_por_persona, cantidad, comensales)
        }
    }
}

@Composable
fun Resultado(
    resultado_con_propina: Float,
    resultado_por_persona: Float,
    cantidad: String,
    comensales: String
) {
    val cantidadInt = cantidad.toIntOrNull() ?: 0
    val comensalesInt = comensales.toIntOrNull() ?: 0

    Column {
        if (cantidadInt == 0) {
            Text("Indique una cantidad mayor que 0")
        } else {
            Text("Cantidad total: $resultado_con_propina")
        }

        if (comensalesInt == 0) {
            Text("Indique uno o más participantes")
        } else {
            Text("Cada uno: $resultado_por_persona")
        }
    }
}
