package dev.katiebarnett.wearexperiments.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.ListHeader
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.ScalingLazyListState
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.rememberScalingLazyListState
import dev.katiebarnett.wearexperiments.R

@Composable
fun HomeScreen(
    listState: ScalingLazyListState,
    onUserInputClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ScalingLazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .selectableGroup(),
        state = listState,
    ) {
        item {
            ListHeader(Modifier) {
                Text(stringResource(R.string.experiment_heading))
            }
        }
        item {
            Chip(
                label = { Text(text = stringResource(id = R.string.user_input)) },
                onClick = onUserInputClick,
                colors = ChipDefaults.chipColors(),
                border = ChipDefaults.chipBorder(),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        HomeScreen(rememberScalingLazyListState(), {})
    }
}