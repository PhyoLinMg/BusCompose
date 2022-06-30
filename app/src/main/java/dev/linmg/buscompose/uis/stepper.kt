import android.graphics.Paint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import dev.linmg.buscompose.ui.theme.cdgDark
import dev.linmg.buscompose.ui.theme.cdgLightGrey
import dev.linmg.buscompose.ui.theme.secondaryDisabledColor

@Composable
fun Stepper(modifier: Modifier = Modifier, numberOfSteps: Int, currentStep: Int) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            color = cdgDark,
            modifier = Modifier.width(20.dp),
            thickness = 4.dp
        )
        for (step in 1..numberOfSteps) {
            Step(
                step = step,
                modifier = if (step > 1) Modifier.weight(1f) else Modifier,
                isComplete = step < (currentStep + 1),
                isCurrent = step == (currentStep + 1)
            )
        }
        Divider(
            color = cdgLightGrey,
            thickness = 4.dp,
            modifier = Modifier.width(20.dp),
        )
    }
}

@Composable
fun Step(step: Int, modifier: Modifier = Modifier, isComplete: Boolean, isCurrent: Boolean) {
    val selectedColor = if (isComplete || isCurrent) cdgDark else cdgLightGrey
    val canvasBackgroundColor by animateColorAsState(
        if (isComplete) selectedColor else cdgLightGrey,
        animationSpec = tween(500),
    )
    val dividerBackgroundColor by animateColorAsState(
        if (isComplete) cdgDark else cdgLightGrey,
        animationSpec = tween(500),
    )
    val circularBackgroundColor by animateColorAsState(
        if (isComplete) selectedColor else Color.White,
        animationSpec = tween(500),
    )
    val stepPaint = Paint().apply {
        textAlign = Paint.Align.CENTER
        textSize = 40f
        color = if (isComplete) Color.White.toArgb() else secondaryDisabledColor.toArgb()
    }
    val titlePaint = Paint().apply {
        textAlign = Paint.Align.CENTER
        textSize = 20f
        color = secondaryDisabledColor.toArgb()
    }



    Box(modifier = modifier) {
        // Line
        if (step > 1) {
            Divider(
                modifier = Modifier.align(Alignment.CenterStart),
                color = dividerBackgroundColor,
                thickness = 4.dp
            )
        }
        // Circle
        Canvas(
            modifier = Modifier
                .size(25.dp)
                .align(CenterEnd)
                .border(
                    shape = CircleShape,
                    width = 4.dp,
                    color = canvasBackgroundColor
                ),
            onDraw = {
                drawCircle(
                    color = circularBackgroundColor,
                )
                drawContext.canvas.nativeCanvas.drawText(
                    "$step",
                    center.x,
                    center.y + 13,
                    stepPaint
                )
                drawContext.canvas.nativeCanvas.drawText(
                    "Booking Process",
                    center.x + 20,
                    center.y + 60,
                    titlePaint
                )
            }
        )

//
    }
}



