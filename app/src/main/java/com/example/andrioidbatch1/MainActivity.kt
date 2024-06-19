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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    @OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            //use scaffold
//            Scaffold(
//                topBar = Top
            ScafflodSample()
//            )
        }
    }

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
 @Composable
        fun ScafflodSample() {
    Scaffold(
        //topBar
        topBar = {
            TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor=MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor =MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                title = { Text(text = "top app bar") }) },
        //BottomBar
        bottomBar = { BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary) { Text(text = "this is my buttom bar") }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
            }
            Icon(Icons.Default.AccountBox, contentDescription = "Add",)
        }
    ) { it ->
        //Inner content view
        Column (modifier = Modifier.padding(it)){ Text(text = "I am inside the body")
        }

    }

}}





