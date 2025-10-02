package com.example.lolproyecto


import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import com.example.lolproyecto.ui.theme.LolProyectoTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LolProyectoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                        padding ->
                    Column(
                        modifier = Modifier.padding(padding)
                    ){
                        DinamicChampionListItem();
                    }



                }
            }
        }
    }
}

data class Champion( val image: Int, val title: String, val description: String, val imageUrl: String? = null)

@Composable
fun ChampionListItem(
    champion: Champion
){
    val imageModifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp).size(40.dp).clip(CircleShape)
    Row(
        modifier = Modifier.fillMaxWidth().background(color = Color.LightGray),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = imageModifier,
            painter = painterResource(champion.image),
            contentDescription = "Champion Image",
            contentScale = ContentScale.Crop
        )
        Column (
            modifier = Modifier.padding(vertical = 8.dp)
        ){
            Text(text=champion.title,
                style = MaterialTheme.typography.headlineMedium)
            Text(text=champion.description,
                style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun DinamicChampionListItem(){
    val dinamicCHampionList: List<Champion> = listOf(
        Champion(image = R.drawable.annie, title = "Annie", description = "Hija de la Oscuridad"),
        Champion(image = R.drawable.diana,title = "Diana", description = "El Desdén de la Luna"),
        Champion(image = R.drawable.fizz,title = "Fizz", description = "El Bromista de las Mareas"),
        Champion(image = R.drawable.irelia,title = "Irelia", description = "La Bailarina de las Cuchillas"),
        Champion(image = R.drawable.leona,title = "Leona", description = "El Amanecer Radiante"),
        Champion(image = R.drawable.mordekaiser,title = "Mordekaiser", description = "La Pesadilla de Hierro"),
        Champion(image = R.drawable.neeko,title = "Neeko", description = "La Camaleona Curiosa"),
        Champion(image = R.drawable.senna,title = "Senna", description = "La Redentora"),
        Champion(image = R.drawable.taric,title = "Taric", description = "El Escudo de Valoran"),
        Champion(image = R.drawable.teemo,title = "Teemo", description = "El Explorador Veloz"),
        Champion(image = R.drawable.vi,title = "Vi", description = "Los Puños de Hierro"),
        Champion(image = R.drawable.ziggs,title = "Ziggs", description = "El Yordle Explosivo"))

    LazyColumn (){
        items(dinamicCHampionList){
            ChampionListItem(it)
        }
    }

}