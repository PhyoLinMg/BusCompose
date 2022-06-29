package dev.linmg.buscompose.uis

sealed class StepperEvent {
    data class Next(val any:Any?) : StepperEvent()

    data class Previous(val any:Any?): StepperEvent()
}
