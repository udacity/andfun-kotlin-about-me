package com.example.android.aboutme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.aboutme.ui.theme.AboutMeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AboutMeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainLayout(
                        stringResource(R.string.name)
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainLayout(name: String) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "About Me") },
                    Modifier.background(
                        Color.Green,
                        shape = MaterialTheme.shapes.medium
                    )
                )
            }
        ) { innerPadding ->
            run {
                Column(
                    Modifier
                        .padding(start = 8.dp,
                            end = 8.dp,
                            top = innerPadding.calculateTopPadding(),
                            bottom = innerPadding.calculateBottomPadding()
                        )
                ) {
                    HeaderUiElement(name)
                    ScrollableContent()
                }
            }
        }
    }

    @Composable
    fun HeaderUiElement(name: String, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .padding(top = 8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_star_border_24),
                contentDescription = "Star",
                modifier = Modifier
                    .size(height = 48.dp, width = 48.dp)
                    .padding(top = 8.dp)
            )
        }
    }

    @Composable
    fun ScrollableContent(modifier: Modifier = Modifier) {
        LazyColumn(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item {
                Text(
                    text = stringResource(R.string.bio),
                    modifier = modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun AboutMePreview() {
        AboutMeTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                MainLayout(
                    "Test Name"
                )
            }
        }
    }
}