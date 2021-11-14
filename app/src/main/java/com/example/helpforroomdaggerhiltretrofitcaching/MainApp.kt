package com.example.helpforroomdaggerhiltretrofitcaching

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.SnackbarDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@Composable
fun MainApp(viewModelMainApp: ViewModelMainApp = hiltViewModel()) {

    val connection by connectivityState()
    Log.d("isConnected", connection.toString())

    val isConnected = connection === ConnectionState.Available
    Log.d("isConnected", isConnected.toString())


    var postlist by remember { viewModelMainApp.Mainlist }

    Column() {

        ConnectivityStatusBox(isConnected)

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(postlist.size) {
                PostDesign(post = postlist[it])
            }
        }
    }


}

@Composable
fun ConnectivityStatusBox(isConnected: Boolean) {
    val message = if (isConnected) "Back Online!" else "No Internet Connection!"
    val color = if(isConnected) Color.Green else Color.Red

    Box(
        modifier = Modifier
            .background(color = color)
            .fillMaxWidth()
    ) {
        Text(message, fontSize = 15.sp, textAlign = TextAlign.Center,modifier = Modifier.fillMaxWidth())
    }


}

@Composable
fun PostDesign(post: Post) {
    Box(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxWidth()
    ) {
        Column(
            Modifier
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                .background(color = Color.White)
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Yellow)
                    .padding(10.dp)
            )
            {
                Text(text = "Comment Id: " + post.id.toString())
            }
            Text(text = "Comment User ID: " + post.userId.toString(), Modifier.padding(10.dp))
            Text(text = "Comment Title: " + post.title.toString(), Modifier.padding(10.dp))
            Text(text = "Comment Body", Modifier.padding(10.dp))
            Text(text = post.body.toString(), Modifier.padding(10.dp))
        }
    }
}