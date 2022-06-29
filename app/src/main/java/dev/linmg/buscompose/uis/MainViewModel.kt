package dev.linmg.buscompose.uis

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*

// ktlint-disable no-wildcard-imports

private data class MainViewModelState(
    val stepperState: StepperState = StepperState.StepOneState(
        stepOne = null
    )
) {
    fun toState(): StepperState = stepperState
}

class MainViewModel : ViewModel() {
    private val _stepState = MutableStateFlow(1)
    private val mainViewModelStateFlow = MutableStateFlow(MainViewModelState())

    private val _steps = MutableStateFlow(Steps(null, null, null, null))
    val stepsState: StateFlow<Int> = _stepState

    val stepperState = mainViewModelStateFlow.map { it.toState() }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        mainViewModelStateFlow.value.toState()
    )

    fun handleEvent(event: StepperEvent) {
        when (event) {
            is StepperEvent.Next ->
                if (_stepState.value < 4) {
                    _stepState.value =
                        _stepState.value + 1
                    mapStepsToState(_stepState.value, event.any)
                }
            is StepperEvent.Previous -> {
                if (_stepState.value > 1) _stepState.value =
                    _stepState.value - 1

                mapStepsToState(_stepState.value, event.any, isPrevious = true)
            }
        }
    }

    private fun mapStepsToState(value: Int, step: Any?, isPrevious: Boolean = false) {
        when (value) {
            1 -> {
                mainViewModelStateFlow.update {
                    it.copy(
                        stepperState = StepperState.StepOneState(stepOne = _steps.value.stepOne)
                    )
                }
            }
            2 -> {
                if (step != null) {
                    val stepOne = step as StepOne
                    _steps.update {
                        it.copy(stepOne = stepOne)
                    }
                }
                mainViewModelStateFlow.update {
                    it.copy(
                        stepperState = StepperState.StepTwoState(stepTwo = _steps.value.stepTwo)
                    )
                }
            }
            3 -> {
                if (step != null && !isPrevious) {
                    val stepTwo = step as StepTwo
                    _steps.update {
                        it.copy(stepTwo = stepTwo)
                    }
                }
                if (step != null && isPrevious) {
                    val stepFour = step as StepFour
                    _steps.update {
                        it.copy(stepFour = stepFour)
                    }
                }
                mainViewModelStateFlow.update {
                    it.copy(
                        stepperState = StepperState.StepThreeState(stepThree = _steps.value.stepThree)
                    )
                }
            }
            4 -> {
                if (step != null) {
                    val stepThree = step as StepThree
                    _steps.update {
                        it.copy(stepThree = stepThree)
                    }
                }
                mainViewModelStateFlow.update {
                    it.copy(
                        stepperState = StepperState.StepFourState(stepFour = _steps.value.stepFour)
                    )
                }
            }
        }
    }
}
