package dev.linmg.buscompose.uis

sealed class StepperState {

    data class StepOneState(
        val stepOne: StepOne?
    ) : StepperState()

    data class StepTwoState(
        val stepTwo: StepTwo?
    ) : StepperState()

    data class StepThreeState(
        val stepThree:StepThree?
    ) : StepperState()

    data class StepFourState(
        val stepFour: StepFour?
    ) : StepperState()
}
