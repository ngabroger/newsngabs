package com.ngabroger.newsngabs.presentation.component

import android.R.attr.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MyCustomTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,

) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        placeholder= { Text(placeholder, color = Color.Gray) },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),



        singleLine = true,
        shape = MaterialTheme.shapes.medium

    )
}
