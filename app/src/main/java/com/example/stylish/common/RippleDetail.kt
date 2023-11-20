package com.example.stylish.common

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class RippleDetail {
    // For disabling ripple effect
    class NoRippleInteractionSource : MutableInteractionSource {

        override val interactions: Flow<Interaction> = emptyFlow()
        override suspend fun emit(interaction: Interaction) {}
        override fun tryEmit(interaction: Interaction) = true
    }


    // For changing the color of ripple effect
    object RippleCustomTheme: RippleTheme {
        //Your custom implementation...
        @Composable
        override fun defaultColor() = RippleTheme.defaultRippleColor(
            Color.White,
            lightTheme = true
        )
        @Composable
        override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(
            Color.Black,
            lightTheme = true
        )
    }
}