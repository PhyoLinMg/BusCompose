package dev.linmg.buscompose.uis

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.linmg.buscompose.R
import dev.linmg.buscompose.ui.theme.cdgDark

@Composable
fun CartItemUi(cartModel: CartModel, onPlusClick: () -> Unit, onMinusClick: () -> Unit) {
    println("count in ui: ${cartModel.count}")
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            modifier = Modifier.size(100.dp, 80.dp),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Image",
        )
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(start = 40.dp)
        ) {
            Text(
                text = cartModel.title,
                style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "S$ ${cartModel.price}", style = MaterialTheme.typography.subtitle2)
            Spacer(modifier = Modifier.height(5.dp))
            CartItemCountUi(
                count = cartModel.count,
                onPlusClick = onPlusClick,
                onMinusClick = onMinusClick
            )
        }
    }
}


@Composable
private fun CartItemCountUi(count: Int, onPlusClick: () -> Unit, onMinusClick: () -> Unit) {
    println("count in count ui: $count")
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(100))
            .background(color = Color.Cyan)
            .padding(horizontal = 11.dp)
    ) {
        IconButton(
            onClick = onMinusClick,
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(22.dp)
                .background(color = cdgDark)
        ) {
            Icon(Icons.Filled.Remove, tint = Color.White, contentDescription = "Remove")
        }
        Text(
            text = "$count",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)
        )
        IconButton(
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(22.dp)
                .background(color = cdgDark),
            onClick = onPlusClick
        ) {
            Icon(
                Icons.Filled.Add, tint = Color.White,
                contentDescription = "Add"
            )
        }
    }
}
