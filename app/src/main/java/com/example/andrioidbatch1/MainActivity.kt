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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.AssistChip
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Horizontal
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andrioidbatch1.ui.theme.AndrioidBatch1Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import androidx.compose.ui.Alignment.Companion as Alignment

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            Text(text = "Switch", fontSize = 40.sp)
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){

                    SwitchExample()
                }
        }
    }
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SwitchExample(){
    var isChecked by remember {
        mutableStateOf(value = false)
    }
    var  icons= if (isChecked) Icons.Filled.Check  else Icons.Filled.Close
    Switch(checked = isChecked, onCheckedChange ={ isChecked=it },
        thumbContent = {
            Icon(
                imageVector =icons,
                contentDescription = null,
                modifier = Modifier.size(SwitchDefaults.IconSize)
            )
        })
}
@Composable
fun SliderExample()
{
    var  sliderPosition by remember {
        mutableStateOf(value= 0f)
    }
    Column(modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = sliderPosition.toString())
        Slider(value = sliderPosition, onValueChange ={sliderPosition=it} )
    }

}
    @Composable
    fun ProgressIndExample() {
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        modifier= Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(20.dp))
        {
        LinearProgressIndicator(progress = 0.8f,
            modifier = Modifier
                .padding(50.dp)
                .height(15.dp)
                .fillMaxWidth()
                .background(Color.Gray), color = Color.Blue,
            )
            CircularProgressIndicator(modifier = Modifier.size(150.dp),
                color = Color.Blue,
                strokeWidth = 10.dp,
                progress = 0.6f)
        }

    }

    }






