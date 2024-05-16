package com.mohammedalaa.core.base

import android.app.Activity
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.mohammedalaa.core.collectInLaunchedEffect
import com.mohammedalaa.core.useBase
import com.mohammedalaa.designsystem.widget.LoadingView

@Composable
fun BaseRoute(
    baseViewModel: BaseViewModel,
    shimmerView: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    val (baseState, baseEffect, baseEvent) = useBase(viewModel = baseViewModel)
    val context = LocalContext.current
    val activity = context as? Activity

    baseEffect.collectInLaunchedEffect { effect ->
        when (effect) {
            BaseContract.BaseEffect.OnBackPressed -> {
                activity?.onBackPressed()
            }
        }
    }

    BaseScreen(
        baseState = baseState,
        shimmerView = shimmerView,
        content = content,
    )
}

@Composable
private fun BaseScreen(
    baseState: BaseContract.BaseState,
    shimmerView: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        AnimatedContent(
            targetState = baseState,
            transitionSpec = {
                fadeIn(
                    animationSpec = tween(TRANSITION_DURATION),
                ) togetherWith fadeOut(animationSpec = tween(TRANSITION_DURATION))
            },
            label = "Animated Content",
        ) { targetState ->
            when (targetState) {
                BaseContract.BaseState.OnLoading -> {
                    if (shimmerView != null) {
                        shimmerView()
                    } else {
                        LoadingView(modifier = Modifier.fillMaxSize())
                    }
                }

                is BaseContract.BaseState.OnError -> {
                    com.mohammedalaa.designsystem.widget.ErrorView(errorMessage = targetState.errorMessage)
                }

                BaseContract.BaseState.OnSuccess -> content()
            }
        }
    }
}

const val TRANSITION_DURATION = 500
