package dev.linmg.buscompose.uis

data class StepOne(
    val text: String,
    val standard: String,
)

data class StepTwo(
    val busType: String,
    val number: Int
)

data class StepThree(
    val addOnTypes: String?,
    val number: Int?
)

data class StepFour(
    val payment: String,
    val totalPrice: String
)

data class Steps(
    val stepOne: StepOne?,
    val stepTwo: StepTwo?,
    val stepThree: StepThree?,
    val stepFour: StepFour?,
)