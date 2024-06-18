package com.example.andrioidbatch1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
            //for column layout
          Column{
              Text(text = "HelloWorld ",
                  fontSize = 20.sp,
                  color = Color.Blue
              )
              Text(text = "Subhashree ",
                  fontSize = 20.sp,
                  color = Color.Red)
              Text(text = "Subhashree",
                  fontSize = 20.sp,
                  color = Color.Green)
              Text(text = "Subhashree",
                  fontSize = 20.sp, color = Color.Magenta)

          }


        }
    }
}

