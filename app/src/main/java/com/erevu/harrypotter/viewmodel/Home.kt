import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.google.gson.Gson

data class Wand(
    val wood: String,
    val core: String,
    val length: Int
)

data class CharacterModel(
    val id: String,
    val name: String,
    val alternateNames: List<String>,
    val species: String,
    val gender: String,
    val house: String,
    val dateOfBirth: String,
    val yearOfBirth: Int,
    val wizard: Boolean,
    val ancestry: String,
    val eyeColour: String,
    val hairColour: String,
    val wand: Wand,
    val patronus: String,
    val hogwartsStudent: Boolean,
    val hogwartsStaff: Boolean,
    val actor: String,
    val alternateActors: List<String>,
    val alive: Boolean,
    val image: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayCharacterInfo()
        }
    }
}
val jsonData = """
{
    "id": "9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8",
    "name": "Harry Potter",
    "alternateNames": ["The Boy Who Lived", "The Chosen One"],
    "species": "human",
    "gender": "male",
    "house": "Gryffindor",
    "dateOfBirth": "31-07-1980",
    "yearOfBirth": 1980,
    "wizard": true,
    "ancestry": "half-blood",
    "eyeColour": "green",
    "hairColour": "black",
    "wand": {
        "wood": "holly",
        "core": "phoenix feather",
        "length": 11
    },
    "patronus": "stag",
    "hogwartsStudent": true,
    "hogwartsStaff": false,
    "actor": "Daniel Radcliffe",
    "alternateActors": [],
    "alive": true,
    "image": "https://ik.imagekit.io/hpapi/harry.jpg"
}
"""


//@Preview
@Composable
fun CharacterBaseInfo(characterModel: com.erevu.harryporter.models.CharacterModel){
//    val gson = Gson()
//    val characterModel: CharacterModel = gson.fromJson(jsonData, CharacterModel::class.java)



    Row (

        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black)
            .height(200.dp)
            .padding(4.dp).border(2.dp, Color.White, RoundedCornerShape(10.dp)),


        horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically




    ){
        Image(
//            modifier=Modifier.background(Color.White),

            painter = rememberImagePainter(data =characterModel.image,

            builder = {
                scale(Scale.FIT)
                placeholder(coil.compose.base.R.drawable.notification_bg)
            }

        ), contentDescription = characterModel.name,
        modifier = Modifier
            .fillMaxHeight()
            .weight(0.2f)
            .background(Color.Black)


        )

        Column(
            modifier = Modifier
                .background(Color.Black)
                .width(200.dp),


            verticalArrangement = Arrangement.Center
        ) {

            Text("Name: ${characterModel.name}",
                color=Color.Black,

                fontWeight = FontWeight.Bold)
            Text("House: ${characterModel.house}", color=Color.White,)
            Text("Species: ${characterModel.species},", color=Color.White,)
            Text("Gender: ${characterModel.gender}", color=Color.White,)
            Text("DoB: ${characterModel.dateOfBirth}", color=Color.White,)
Spacer(modifier = Modifier.height(5.dp))
            Divider()

            OutlinedButton(
                modifier = Modifier.height(35.dp),

                onClick = { }



            ) {

               Row {

                   Text("View More ")
                   Icon(
                   painter = painterResource(id = android.R.drawable.ic_menu_info_details),
                   contentDescription = "Alert Icon"
                   )
               }


            }

        }

    }


}

@Preview(showBackground = true)
@Composable
fun DisplayCharacterInfo() {
    // Parse JSON to CharacterModel
    val gson = Gson()
    val characterModel: CharacterModel = gson.fromJson(jsonData, CharacterModel::class.java)

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        // Display character image
        Image(
            painter = rememberImagePainter(
                data = characterModel.image,
                builder = {
                    scale(coil.size.Scale.FILL)
                    transformations(CircleCropTransformation())
                }
            ),
            contentDescription = "Character Image",
            modifier = Modifier
                .size(100.dp)
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.primary)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Display character information
        Text("Name: ${characterModel.name}", fontWeight = FontWeight.Bold)
        Text("House: ${characterModel.house}")
        Text("Species: ${characterModel.species}")
        Text("Gender: ${characterModel.gender}")
        Text("Date of Birth: ${characterModel.dateOfBirth}")
        Text("Year of Birth: ${characterModel.yearOfBirth}")
        Text("Ancestry: ${characterModel.ancestry}")
        Text("Eye Colour: ${characterModel.eyeColour}")
        Text("Hair Colour: ${characterModel.hairColour}")
        Text("Patronus: ${characterModel.patronus}")
        Text("Hogwarts Student: ${characterModel.hogwartsStudent}")
        Text("Hogwarts Staff: ${characterModel.hogwartsStaff}")
        Text("Actor: ${characterModel.actor}")
        Text("Alive: ${characterModel.alive}")
    }
}
