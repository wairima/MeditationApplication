package com.example.meditation.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.meditation.R

@Composable
fun SleepingTipsList(navController: NavHostController) {
    Image(
        painter = painterResource(id = R.drawable.your),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

    Column(modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {


        Text(
            text = "Sleeping Tips",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(20.dp),
            textDecoration = TextDecoration.Underline

        )

        Card(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .shadow(elevation = 4.dp, shape = RoundedCornerShape(8.dp)),
           elevation= CardDefaults.cardElevation(defaultElevation = 10.dp)
        )

        {
            Text(
                "1. Try to relax before bed",
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(16.dp)
            )
        }
        Card(modifier = Modifier.padding(bottom = 16.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(8.dp)),
            elevation= CardDefaults.cardElevation(defaultElevation = 10.dp)) {
            Text(
                "2. Keep a consistent sleep schedule",
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(16.dp)
            )
        }
        Card(modifier = Modifier.padding(bottom = 16.dp),
            elevation= CardDefaults.cardElevation(defaultElevation = 10.dp)) {
            Text(
                "3. Maintain a comfortable sleeping environment",
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(16.dp)
            )
        }

        Card(modifier = Modifier.padding(bottom = 16.dp),
            elevation= CardDefaults.cardElevation(defaultElevation = 10.dp)) {
            Text(
                "4. Keep your bedroom dark, cool, and calm",
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(16.dp)
            )
        }

        Card(modifier = Modifier.padding(bottom = 16.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(8.dp)),
            elevation= CardDefaults.cardElevation(defaultElevation = 10.dp)) {
            Text(
                "5. Limit naps to no more than 30 minutes, and avoid napping close to bedtime",
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(16.dp)
            )
        }

        Card(modifier = Modifier.padding(bottom = 16.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(8.dp)),
            elevation= CardDefaults.cardElevation(defaultElevation = 10.dp)) {
            Text(
                "6. Get regular exercise, but avoid heavy workouts before bed",
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(16.dp)
            )
        }
        Card(modifier = Modifier.padding(bottom = 16.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(8.dp)),
            elevation= CardDefaults.cardElevation(defaultElevation = 10.dp)) {
            Text(
                "7. Practice relaxation techniques before bed",
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(16.dp)
            )
        }

        Card(modifier = Modifier.padding(bottom = 16.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(8.dp)),
            elevation= CardDefaults.cardElevation(defaultElevation = 10.dp)) {
            Text(
                "8. Limit screen time before bed",
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(16.dp)
            )
        }
        // Add more tips as needed
    }
}

@Preview
@Composable
fun SleepingTipsListprev() {
    SleepingTipsList(rememberNavController())
}

data class MeditationSound(val title: String, val description: String, val url: String)

data class Song1(val name: String, val description: String, val link: String)

val songList1 = listOf(
    Song1("Meditation Sound 1","Meditative ambiance", "https://pixabay.com/music/meditationspiritual-dunbarton-meditative-ambient-soundscape-for-learning-and-relaxing-95403/"),
    Song1("Meditation Sound 2","Just relax", "https://pixabay.com/music/beautiful-plays-just-relax-11157/"),
    Song1("Meditation Sound 3", "Chill lofi song","https://pixabay.com/music/beats-chill-lofi-song-8444/"),
    Song1("Meditation Sound 4", "Flying in the dream", "https://pixabay.com/music/meditationspiritual-a-meditation-flying-in-the-dream-118554/"),
    Song1("Meditation Sound 5","Sleep volume", "https://pixabay.com/music/meditationspiritual-sleep-music-vol5-173983/"),
    Song1("Meditation Sound 6","Sleep volume", "https://pixabay.com/music/solo-piano-sleep-141321/"),
    Song1("Meditation Sound 7", "Magic island", "https://pixabay.com/music/meditationspiritual-magic-island-175480/")
)



@Composable
fun MeditationSoundList1(sounds: List<MeditationSound>) {
    LazyColumn {
        items(sounds) { sound ->
            MeditationSoundItem(sound = sound)
        }
    }
}

@Composable
fun MeditationSoundList(navhostController: NavHostController) {
    Image(
        painter = painterResource(id = R.drawable.your),
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
            items(songList1) { song ->
                SongRow(song)
            }
        }
    }
}

@Composable
fun SongRow(song: Song1) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Navigate to the song's link */ }
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(text = song.name, fontWeight = FontWeight.Bold)
            Text(text = song.description, fontWeight = FontWeight.Bold)
            Text(text = song.link, color = Color.White,
                    modifier = Modifier.clickable {

                        // Handle sound click event here
                        // For example, open the sound URL in a browser
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(song.link))
                        context.startActivity(intent)
                    })
        }
    }
}



@Composable
fun MeditationSoundItem(sound: MeditationSound) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                // Handle sound click event here
                // For example, open the sound URL in a browser
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(sound.url))
                context.startActivity(intent)
            }
    ) {
        Text(text = sound.title, style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = sound.description, style = MaterialTheme.typography.bodyMedium)
    }
}

val meditationSounds = listOf(
    MeditationSound(
        title = "Meditation Sound 1",
        description = "Meditative ambiance",
        url = "https://pixabay.com/music/meditationspiritual-dunbarton-meditative-ambient-soundscape-for-learning-and-relaxing-95403/"
    ),

    MeditationSound(
        title = "Meditation Sound 2",
        description = "Just relax",
        url = "https://pixabay.com/music/beautiful-plays-just-relax-11157/"
    ),
    MeditationSound(
        title = "Meditation Sound 3",
        description = "Chill lofi song",
        url = "https://pixabay.com/music/beats-chill-lofi-song-8444/"
    ),

    MeditationSound(
        title = "Meditation Sound 4",
        description = "Flying in the dream",
        url = "https://pixabay.com/music/meditationspiritual-a-meditation-flying-in-the-dream-118554/"
    ),

    MeditationSound(
        title = "Meditation Sound 5",
        description = "Sleep volume",
        url = "https://pixabay.com/music/meditationspiritual-sleep-music-vol5-173983/"
    ),

    MeditationSound(
        title = "Meditation Sound 6",
        description = "Slow sleep",
        url = "https://pixabay.com/music/solo-piano-sleep-141321/"
    ),

    MeditationSound(
        title = "Meditation Sound 7",
        description = "Magic island",
        url = "https://pixabay.com/music/meditationspiritual-magic-island-175480/"
    ),
    // ... other MeditationSound objects
)

@Preview
@Composable
fun MeditationSoundListprev() {
    MeditationSoundList(rememberNavController())
}


@Composable
fun NightIslandScreen(navController: NavHostController) {
    Surface(color = Color.White) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "NightIsland views",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp),
                textDecoration = TextDecoration.Underline
            )
            val nightIslandImages = listOf(
                R.drawable.island1,
                R.drawable.island2,
                R.drawable.island3,
                R.drawable.island4,
                R.drawable.island5,
                R.drawable.island6,
                R.drawable.island7
            )

            nightIslandImages.forEach { imageId ->
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = "Night Island",
                    modifier = Modifier
                        .width(200.dp)
                        .height(150.dp)
                        .padding(10.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Preview
@Composable
fun NightIslandScreenprev() {
    NightIslandScreen(rememberNavController())
}


@Composable
fun SleepMeditationScreen(navController: NavHostController) {
    val meditations = listOf(
        "4-7-8 Breathing",
        "Body Scan",
        "Mindfulness of Breathing",
        "Progressive Muscle Relaxation",
        "Shifting Counting",
        "Loving-Kindness Meditation",
        "Guided Imagery"
    )

    Image(
        painter = painterResource(id = R.drawable.your),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Choose a Meditation:",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textDecoration = TextDecoration.Underline
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier.width(300.dp)) {
            meditations.forEach { meditation ->
                SleepMeditationItem(meditation = meditation)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview
@Composable
fun SleepMeditationScreenprev() {
    SleepMeditationScreen(rememberNavController())
}
@Composable
fun SleepMeditationItem(meditation: String) {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(80.dp)
//            .clip(RoundedCornerShape(8.dp))
//            .background(Color.DarkGray)
//            .shadow(elevation = 4.dp, shape = RoundedCornerShape(8.dp)),
//           Alignment.Center
//
//    )


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.DarkGray)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(8.dp)),
             verticalAlignment = Alignment.CenterVertically,


    )

    {

        Image(
            painter = painterResource(id = R.drawable.ic_sleep),
            contentDescription = "Sleep Icon",
            modifier = Modifier.size(60.dp),
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = meditation,
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }

}