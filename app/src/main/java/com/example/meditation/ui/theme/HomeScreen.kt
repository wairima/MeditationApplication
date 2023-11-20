package com.example.meditation.ui.theme

import android.app.AlertDialog
import android.content.Context
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.meditation.BottomMenuContent
import com.example.meditation.Feature
import com.example.meditation.R
import com.example.meditation.navigation.MeditationSoundList1
import com.example.meditation.navigation.NightIslandScreen1
import com.example.meditation.navigation.ROUTE_MUSIC
import com.example.meditation.navigation.ROUTE_PROFILE
import com.example.meditation.navigation.ROUTE_SIGNIN
import com.example.meditation.navigation.SleepMeditationScreen1
import com.example.meditation.navigation.Tip_for_sleeping
import com.example.meditation.standardQuadFromTo

@Composable
fun HomeScreen(navController: NavHostController) {

        Box(modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
        )
    Box(modifier = Modifier.fillMaxSize()) {
        // Load the background image
        val backgroundImage = painterResource(id = R.drawable.your_background_image)

        // Display the background image
        Image(
            painter = backgroundImage,
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
        )
            Column {
                GreetingSection()
                ChipSection(chips = listOf("Sweet sleep","Insomnia","Forgiveness","The Breathe"))
                CurrentMeditation()
                FeatureSection(navController,
                    features = listOf(
                        Feature(
                            title = "Sleep meditation",
                            R.drawable.ic_headphone,
                            BlueViolet1,
                            BlueViolet2,
                            BlueViolet3
                        ),
                        Feature(
                            title = "Tips for sleeping",
                         R.drawable.ic_videocam,
                            LightGreen1,
                            LightGreen2,
                            LightGreen3
                        ),
                        Feature(
                            title = "Night island",
                            R.drawable.ic_headphone,
                            OrangeYellow1,
                            OrangeYellow2,
                            OrangeYellow3
                        ),
                        Feature(
                            title = "Calming sounds",
                            R.drawable.ic_headphone,
                            Beige1,
                            Beige2,
                            Beige3
                        )
                    )

                )
            }
            BottomMenu(navController,items = listOf(
                BottomMenuContent(
                    "Home",
                    R.drawable.ic_home,
                    Modifier.clickable {(navController.navigate(ROUTE_SIGNIN)) }),

                BottomMenuContent(
                    "Music",
                    R.drawable.ic_music,
                    Modifier.clickable {

                        //CustomDialog(navController.context)

                        //(navController.navigate(ROUTE_MPESA))

                    }),
                BottomMenuContent("Profile",R.drawable.ic_profile,
                    modifier = Modifier.clickable {(navController.navigate(ROUTE_PROFILE)) }),
            ), modifier = Modifier
                .align(Alignment.BottomCenter))

        }
}

class CustomDialog(context: Context) : AlertDialog.Builder(context) {

    fun show(title: String, message: String) {

        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        // Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()

        // Set other dialog properties
        alertDialog.setCancelable(false)

        alertDialog.show()

    }

}


@Composable
fun BottomMenu(navController : NavHostController,
    items: List<BottomMenuContent>,
    modifier: Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableIntStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(navController,
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(navController : NavHostController,
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit,

) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier
                    .size(20.dp)
                    .clickable {

                        if (item.title == "Music") {
                            //Open music
                            navController.navigate(ROUTE_MUSIC)

                        } else if (item.title == "Home") {
                            //Open Home

                        } else if (item.title == "Profile") {
                            //Open Profile
                            navController.navigate(ROUTE_PROFILE)

                        }
                    })
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor
        )
    }
}
@Composable
fun GreetingSection(  name: String = "Tinah")
{
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ){
        Column(

            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Good morning, $name",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )

            Text(text = "We wish you have a wonderful day!",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
//            Icon(painter = painterResource(id = R.drawable.ic_search),
//                contentDescription = "search icon",
//                tint = Color.White,
//                modifier = Modifier.size(24.dp))
        }
}

@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableIntStateOf(0)
    }
        LazyRow{
            items(chips.size){
                Box(modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp)
//                    .clickable { selectedChipIndex = it }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
                ){
                    Text(text = chips[it], color = TextWhite)
                }
            }
        }
}

@Composable
fun CurrentMeditation(
    color: Color= LightRed
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()


    )
    {
        Text(text = "Today's Quote",
            style = MaterialTheme.typography.headlineMedium,
            textDecoration = TextDecoration.None,

        )

        Text(text = " " +
                ":I attract more so i can give more,and be more",
            style = MaterialTheme.typography.bodyMedium,
            color= TextWhite,
            fontWeight = FontWeight.ExtraBold,

        )
    }
//    Box (
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .size(40.dp)
//            .clip(CircleShape)
//            .background(ButtonBlue)
//            .padding(10.dp)
//    )
//    {
//        Icon(painter = painterResource(id = R.drawable.ic_play),
//            contentDescription = "Play",
//            tint = Color.Black,
//            modifier = Modifier.size(16.dp)
//                .clickable {  })
//    }

}

@Composable
fun FeatureSection(navController : NavHostController,
    features: List<Feature>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(15.dp),
            fontWeight = FontWeight.ExtraBold
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier
                .fillMaxHeight()


        ) {
            items(features.size){
            FeatureItem(navController, feature = features[it])
            }
        }

    }
}

@Composable
fun FeatureItem(navController : NavHostController,
    feature: Feature
) {
   BoxWithConstraints (
       modifier = Modifier
           .padding(7.5.dp)
           .aspectRatio(1f)
           .clip(RoundedCornerShape(10.dp))
           .background(feature.darkColor)
   ) {
       val width = constraints.maxWidth
       val height = constraints.maxHeight

//       medium colored path
       val mediumColoredPoint1 = Offset(0f, height * 0.3f)
       val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
       val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
       val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
       val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())


       val mediumColoredPath = Path().apply {
           moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
           standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
           standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
           standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
           standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
           lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
           lineTo(-100f, height.toFloat() + 100f)
           close()
       }
       // Light colored path
       val lightPoint1 = Offset(0f, height * 0.35f)
       val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
       val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
       val lightPoint4 = Offset(width * 0.65f, height.toFloat())
       val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

       val lightColoredPath = Path().apply {
           moveTo(lightPoint1.x, lightPoint1.y)
           standardQuadFromTo(lightPoint1, lightPoint2)
           standardQuadFromTo(lightPoint2, lightPoint3)
           standardQuadFromTo(lightPoint3, lightPoint4)
           standardQuadFromTo(lightPoint4, lightPoint5)
           lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
           lineTo(-100f, height.toFloat() + 100f)
           close()

       }
       Canvas(
           modifier = Modifier
               .fillMaxSize()
       ) {
           drawPath(
               path = mediumColoredPath,
               color = feature.mediumColor
           )
           drawPath(
               path = lightColoredPath,
               color = feature.lightColor
           )
       }
       Box(
           modifier = Modifier
               .fillMaxSize()
               .padding(15.dp)
       ) {
           Text(
               text = feature.title,
               style = MaterialTheme.typography.titleLarge,
               lineHeight = 26.sp,
               modifier = Modifier.align(Alignment.TopStart)
           )
           Icon(
               painter = painterResource(id = feature.iconId),
               contentDescription = feature.title,
               tint = Color.Black,
               modifier = Modifier
                   .align(Alignment.BottomStart)
                   .clickable {


                   }
           )
           Text(
               text = "Start",
               color = TextWhite,
               fontSize = 14.sp,
               fontWeight = FontWeight.Bold,
               modifier = Modifier
                   .clickable {
                       // Handle the click
                       if (feature.title == "Tips for sleeping") {
                           (navController.navigate(Tip_for_sleeping))

                       } else if (feature.title == "Night island") {
                           (navController.navigate(NightIslandScreen1))

                       } else if (feature.title == "Calming sounds") {
                           (navController.navigate(MeditationSoundList1))

                       } else if (feature.title == "Sleep meditation") {
                           (navController.navigate(SleepMeditationScreen1))
                       }


                   }
                   .align(Alignment.BottomEnd)
                   .clip(RoundedCornerShape(10.dp))
                   .background(ButtonBlue)
                   .padding(vertical = 6.dp, horizontal = 15.dp)
           )
       }
   }
}

@Preview
@Composable
fun HomeScreenpreview() {
    HomeScreen(rememberNavController())
}