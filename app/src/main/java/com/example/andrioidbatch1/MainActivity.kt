package com.example.andrioidbatch1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andrioidbatch1.ui.theme.AndrioidBatch1Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
//use alignment
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically)
            {

                Text(text = "Hello World",
                    fontSize = 50.sp,
                    modifier = Modifier
                        .padding(20.dp)
                        .background(Color.Green)
                        .clickable {
                            println("I am clicked")
                        }
//                        .border(4.dp, Color.Red)
//                        .padding(7.dp)


                )

            }

        }
    }
}




