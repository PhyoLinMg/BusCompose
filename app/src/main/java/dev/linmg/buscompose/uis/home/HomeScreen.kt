package dev.linmg.buscompose.uis.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.linmg.buscompose.R
import dev.linmg.buscompose.ui.theme.cdgDark


@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(onBackPressed = { }, title = "ComfortDelGro Bus")
        }
    ) {
        Text("HELLO WORLD")
    }

}

@Composable
fun TopAppBar(
    onBackPressed: () -> Unit,
    title: String,
) {
    Row(
        modifier = Modifier
            .background(cdgDark),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(
            modifier = Modifier
                .weight(0.6f)
                .padding(top = 15.dp,start = 28.dp)
                .align(CenterVertically),
        ) {
            IconButton(onClick = onBackPressed) {
                Icon(
                    Icons.Default.ArrowBackIos,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
            Text(
                text = title,
                style = MaterialTheme.typography.h6.copy(color = Color.White),
                modifier = Modifier.padding(start = 15.dp, top = 27.dp, bottom = 45.dp)
            )
        }
        Box(
            modifier = Modifier
                .weight(0.4f)
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(start = 10.dp)
                    .size(270.dp,150.dp),
                painter = painterResource(id = R.drawable.end),
                contentDescription = null
            )
        }

    }
}

@Preview
@Composable
fun showTopAppBar() {
    TopAppBar(onBackPressed = {}, title = "Testing")
}