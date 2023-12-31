package com.example.samplecomposearchitecture.ui.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.samplecomposearchitecture.ui.navigation.LocalNavController
import com.example.samplecomposearchitecture.ui.screen.detail.navigateToDetail
import com.example.samplecomposearchitecture.ui.screen.home.model.HomeEvent
import com.example.samplecomposearchitecture.ui.widget.EventFlowEffect

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController = LocalNavController.current,
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    EventFlowEffect(flow = viewModel.event) { event ->
        when (event) {
            is HomeEvent.ToDetail -> {
                navController.navigateToDetail(event.dog.url)
            }
        }
    }
}

@Composable
private fun HomeScreen() {
}
