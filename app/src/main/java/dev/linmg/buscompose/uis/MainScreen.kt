package dev.linmg.buscompose.uis

import Stepper
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    val currentStep = viewModel.stepsState.collectAsState()
    val stepsState by viewModel.stepperState.collectAsState()
    val stepFour = remember {
        mutableStateOf(StepFour("", ""))
    }

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = {
                if (currentStep.value > 1) viewModel.handleEvent(
                    StepperEvent.Previous(if (currentStep.value == 4) stepFour.value else null)
                )
                else print(
                    "dismissed the screen"
                )
            },
            content = {
                if (currentStep.value > 1) Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Back"
                )
                else Icon(Icons.Default.Cancel, contentDescription = "Cancel")
            }
        )
        Stepper(
            modifier = Modifier.fillMaxWidth(),
            numberOfSteps = 4,
            currentStep = currentStep.value
        )
        when (stepsState) {
            is StepperState.StepOneState -> {
                Step1(viewModel = viewModel, state = stepsState as StepperState.StepOneState)
            }
            is StepperState.StepTwoState -> {
                Step2(viewModel = viewModel, state = stepsState as StepperState.StepTwoState)
            }
            is StepperState.StepThreeState -> {
                Step3(viewModel = viewModel, state = stepsState as StepperState.StepThreeState)
            }
            is StepperState.StepFourState -> {
                Step4(viewModel = viewModel, state = stepsState as StepperState.StepFourState) {
                    stepFour.value = it
                }
            }
        }
    }
}

@Composable
fun Step1(viewModel: MainViewModel, state: StepperState.StepOneState) {
    val stepOneData = state.stepOne ?: StepOne("", "")
    var text by remember { mutableStateOf(TextFieldValue(stepOneData.text)) }
    var standard by remember { mutableStateOf(TextFieldValue(stepOneData.standard)) }
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        CartItemUi(CartModel(1, "name", price = 1.0), onPlusClick = {}, onMinusClick = {})
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            }
        )
        TextField(
            value = standard,
            onValueChange = { newText ->
                standard = newText
            }
        )
        Button(
            onClick = {
                viewModel.handleEvent(
                    StepperEvent.Next(
                        StepOne(text.text, standard.text)
                    )
                )
            },
            content = {
                Text("Step 2")
            }
        )
    }
}

@Composable
fun Step2(viewModel: MainViewModel, state: StepperState.StepTwoState) {
    val stepOneData = state.stepTwo ?: StepTwo("", -1)
    var busType by remember { mutableStateOf(TextFieldValue(stepOneData.busType)) }
    var number by remember { mutableStateOf(TextFieldValue(stepOneData.number.toString())) }
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = busType,
            onValueChange = { newText ->
                busType = newText
            }
        )
        TextField(
            value = number,
            onValueChange = { newText ->
                number = newText
            }
        )
        Button(
            onClick = {
                viewModel.handleEvent(
                    StepperEvent.Next(
                        StepTwo(busType.text, number.text.toInt())
                    )
                )
            },
            content = {
                Text("Step 3")
            }
        )
    }
}

@Composable
fun Step3(viewModel: MainViewModel, state: StepperState.StepThreeState) {
    val stepOneData = state.stepThree ?: StepThree("", -1)
    var addOnTypes by remember { mutableStateOf(TextFieldValue(stepOneData.addOnTypes ?: "")) }
    var number by remember { mutableStateOf(TextFieldValue(stepOneData.number.toString())) }
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = addOnTypes,
            onValueChange = { newText ->
                addOnTypes = newText
            }
        )
        TextField(
            value = number,
            onValueChange = { newText ->
                number = newText
            }
        )
        Button(
            onClick = {
                viewModel.handleEvent(
                    StepperEvent.Next(
                        StepThree(addOnTypes.text, number.text.toInt())
                    )
                )
            },
            content = {
                Text("Step 4")
            }
        )
    }
}

@Composable
fun Step4(
    viewModel: MainViewModel,
    state: StepperState.StepFourState,
    onStepBack: (StepFour) -> Unit
) {
    val stepOneData = state.stepFour ?: StepFour("", "")
    var text by remember { mutableStateOf(TextFieldValue(stepOneData.payment)) }
    var standard by remember { mutableStateOf(TextFieldValue(stepOneData.totalPrice)) }
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            }
        )
        TextField(
            value = standard,
            onValueChange = { newText ->
                standard = newText
            }
        )
        onStepBack(StepFour(text.text, standard.text))
        Button(
            onClick = {
                viewModel.handleEvent(
                    StepperEvent.Next(
                        StepFour(text.text, standard.text)
                    )
                )
            },
            content = {
                Text("Done....")
            }
        )
    }
}
