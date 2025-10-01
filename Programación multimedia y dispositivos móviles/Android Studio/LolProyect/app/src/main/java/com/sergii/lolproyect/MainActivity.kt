package com.sergii.lolproyect

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sergii.lolproyect.ui.theme.LolProyectTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LolProyectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    ChampionListItem();
                }
            }
        }
    }
}

@Composable
fun ChampionListItem(
    image: String,
    title: String,
    description:String
){
    val imageModifier = Modifier.size(40.dp).clip(CircleShape)
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = imageModifier,
            painter = painterResource(R.drawable.annie),
            contentDescription = "Champion Image",
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text=title,
                style = MaterialTheme.typography.headlineMedium)
            Text(text=description,
                style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ChampionListItem(){
    ChampionListItem(image = "Annie",title = "Annie", description = "Diosas de la Oscuridad")
}