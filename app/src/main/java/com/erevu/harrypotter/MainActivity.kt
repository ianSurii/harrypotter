package com.erevu.harrypotter

import CharacterBaseInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.erevu.harryporter.models.CharacterModel
import com.erevu.harrypotter.ui.theme.HarrypotterTheme
import com.erevu.harrypotter.view.CharacterViewModel
import com.google.gson.Gson
import jsonData

class MainActivity : ComponentActivity() {
    val characterViewModel by viewModels<CharacterViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarrypotterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    CharacterLIst(characterList = characterViewModel.characterListResponse)
                    characterViewModel.getMovieList()

                }
            }
        }
    }
}

@Composable
fun CharacterLIst(characterList: List<CharacterModel>) {
    LazyColumn {
        itemsIndexed(items = characterList) { index, item ->
            CharacterBaseInfo(characterModel = characterList[index])
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    HarrypotterTheme {
//        val jsonData = """
//{
//    "id": "9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8",
//    "name": "Harry Potter",
//    "alternateNames": ["The Boy Who Lived", "The Chosen One"],
//    "species": "human",
//    "gender": "male",
//    "house": "Gryffindor",
//    "dateOfBirth": "31-07-1980",
//    "yearOfBirth": 1980,
//    "wizard": true,
//    "ancestry": "half-blood",
//    "eyeColour": "green",
//    "hairColour": "black",
//    "wand": {
//        "wood": "holly",
//        "core": "phoenix feather",
//        "length": 11
//    },
//    "patronus": "stag",
//    "hogwartsStudent": true,
//    "hogwartsStaff": false,
//    "actor": "Daniel Radcliffe",
//    "alternateActors": [],
//    "alive": true,
//    "image": "https://ik.imagekit.io/hpapi/harry.jpg"
//}
//"""
//        val gson = Gson()
//        val characterModel: CharacterModel = gson.fromJson(jsonData, CharacterModel::class.java)
//
//
//        CharacterBaseInfo(characterModel = characterModel)
//
//    }
//}