package dev.linmg.buscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.linmg.buscompose.ui.theme.BusComposeTheme
import dev.linmg.buscompose.uis.MainScreen
import dev.linmg.buscompose.uis.home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusComposeTheme {
                // A surface container using the 'background' color from the theme
//                MainScreen()
                HomeScreen()
            }
        }
    }
}



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusComposeTheme {
        Greeting("Android")
    }
}
