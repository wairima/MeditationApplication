package com.example.meditation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.meditation.R


//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            Content()
//        }
//    }
//}

data class Song(val name: String, val link: String, val image: String)

val songList = listOf(
    Song("Meditation sounds", "https://pixabay.com/music/meditationspiritual-meditation-sounds-122698/", "https://cdn.pixabay.com/audio/2022/10/30/16-41-49-34_200x200.jpg"),
    Song("Relaxing Music", "https://pixabay.com/music/ambient-relaxing-music-119247/", "https://cdn.pixabay.com/audio/2023/08/11/07-36-14-410_200x200.jpeg"),
    Song("Peaceful mind", "https://pixabay.com/music/meditationspiritual-peaceful-garden-healing-light-piano-for-meditation-zen-landscapes-112199/", "https://cdn.pixabay.com/audio/2023/03/09/01-03-14-992_200x200.jpg"),
    Song("Music for relax,yoga", "https://pixabay.com/music/meditationspiritual-music-for-relax-yoga-meditation-7783/", "https://cdn.pixabay.com/audio/2022/08/29/14-14-35-93_200x200.jpg"),
    Song("Rainy sounds", "https://pixabay.com/music/meditationspiritual-rain-in-the-paradise-forest-yoga-zen-relaxation-positive-sleep-music-140636/", "https://cdn.pixabay.com/audio/2023/02/27/19-59-53-918_200x200.jpg"),
    Song("Sleeping sounds", "https://pixabay.com/music/ambient-fall-asleep-like-a-baby-relax-music-blubon-relaxon-9643/", "https://cdn.pixabay.com/audio/2022/04/04/06-16-57-110_200x200.jpg"),
    Song("Love Meditation", "https://pixabay.com/music/meditationspiritual-love-meditation-i-want-to-be-in-peace-115568/", "https://cdn.pixabay.com/audio/2023/05/05/07-53-46-434_200x200.png")
)

@Composable
fun Musicscreen(navhostController: NavHostController) {
    Image(
        painter = painterResource(id = R.drawable.your_image),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

    Column(
        modifier = Modifier.fillMaxSize(),
//            .background(Color.LightGray)
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Music Screen",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(20.dp),
            textDecoration = TextDecoration.Underline
        )
        LazyColumn(modifier = Modifier.padding(20.dp)) {
            items(songList) { song ->
                SongRow(song)
            }
        }
    }
}

@Composable
fun SongRow(song: Song) {



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Navigate to the song's link */ }
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberImagePainter(song.image),
            contentDescription = song.name,
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(5.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(text = song.name, fontWeight = FontWeight.Bold)
            Text(text = song.link, color = Color.White)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MusicscreenPreview() {
    Musicscreen(rememberNavController())
}