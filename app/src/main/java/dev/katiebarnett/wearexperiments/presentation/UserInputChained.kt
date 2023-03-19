package dev.katiebarnett.wearexperiments.presentation

import android.app.RemoteInput
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.CompactButton
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.input.RemoteInputIntentHelper
import androidx.wear.input.wearableExtender
import dev.katiebarnett.wearexperiments.R


@Composable
fun UserInputChainedScreen(
    modifier: Modifier = Modifier
) {
    val defaultText = stringResource(id = R.string.edit_user_input)
    var userInput by remember { mutableStateOf(defaultText) }
    val inputTextKey1 = "input_text_1"
    val inputTextKey2 = "input_text_2"
    val inputTextKey3 = "input_text_3"

    val remoteInputs: List<RemoteInput> = listOf(
        RemoteInput.Builder(inputTextKey1)
            .setLabel(stringResource(R.string.edit_user_input_1))
            .wearableExtender {
                setEmojisAllowed(true)
                setInputActionType(EditorInfo.IME_ACTION_NEXT)
            }.build(),
        RemoteInput.Builder(inputTextKey2)
            .setLabel(stringResource(R.string.edit_user_input_2))
            .wearableExtender {
                setEmojisAllowed(true)
                setInputActionType(EditorInfo.IME_ACTION_NEXT)
            }.build(),
        RemoteInput.Builder(inputTextKey3)
            .setLabel(stringResource(R.string.edit_user_input_2))
            .wearableExtender {
                setEmojisAllowed(true)
                setInputActionType(EditorInfo.IME_ACTION_DONE)
            }.build(),
    )

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        it.data?.let { data ->
            val results: Bundle = RemoteInput.getResultsFromIntent(data)
            val newInputText1: CharSequence = results.getCharSequence(inputTextKey1) ?: ""
            val newInputText2: CharSequence = results.getCharSequence(inputTextKey2) ?: ""
            val newInputText3: CharSequence = results.getCharSequence(inputTextKey3) ?: ""
            userInput = "$newInputText1 $newInputText2 and $newInputText3"
        }
    }

    val intent: Intent = RemoteInputIntentHelper.createActionRemoteInputIntent()
    RemoteInputIntentHelper.putRemoteInputsExtra(intent, remoteInputs)

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Row(modifier = Modifier.fillMaxWidth(0.75f)) {
            Text(text = userInput, Modifier.weight(1f))
            CompactButton(
                onClick = { launcher.launch(intent) },
                colors = ButtonDefaults.secondaryButtonColors()
            ) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = stringResource(id = R.string.edit_user_input)
                )
            }
        }
    }
}