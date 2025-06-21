package com.anshu.fruithubapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    Column(modifier=Modifier.fillMaxSize(),
        verticalArrangement= Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally
    ){
        Image(painter=painterResource(R.drawable.logo),contentDescription=null,
            modifier=modifier.size(184.dp,206.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun SplashScreenPrev(modifier: Modifier = Modifier) {
    SplashScreen()

    
}