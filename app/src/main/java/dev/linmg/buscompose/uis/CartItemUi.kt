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
import androidx.compose.ui.unit.dp
import dev.linmg.buscompose.R
import dev.linmg.buscompose.ui.theme.cdgDark

@Composable
fun CartItemUi(cartModel: CartModel, onPlusClick: () -> Unit, onMinusClick: () -> Unit) {

    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            modifier = Modifier.size(48.dp),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Image",
        )
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(start = 40.dp)
        ) {
            Text(text = cartModel.title, style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "S$ ${cartModel.price}", style = MaterialTheme.typography.subtitle2)
            Spacer(modifier = Modifier.width(5.dp))
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
            Icon(Icons.Filled.Remove, contentDescription = "Remove")
        }
        Text(
            text = "$count",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)
        )
        IconButton(
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(22.dp)
                .background(color = cdgDark),
            onClick = onPlusClick
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add")
        }
    }
}
