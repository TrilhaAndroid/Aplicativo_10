package br.com.leonardobarral.application_10.components

import android.graphics.drawable.Icon
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TextFieldComponent(
    value:String,
    onValueChage: (String) -> Unit,
    label:String,
    placeholder: String,
    modifier: Modifier
) {
    TextField(
        value = value,
        onValueChange = {onValueChage(it)},
        label = {
            Text(text = label)
        },
        placeholder={
            Text(text = placeholder)
        },
        modifier = modifier
    )
}