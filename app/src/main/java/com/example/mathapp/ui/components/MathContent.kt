package com.example.mathapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathapp.R

@Composable
fun MathContent(num1: Int, num2: Int, operation: String, answer: String, onAnswerChange: (String) -> Unit, onSubmit: () -> Unit) {
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT

    val (first, second) = if (operation == "-" && num1 < num2) {
        num2 to num1
    } else {
        num1 to num2
    }

    if (isPortrait) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(R.string.math_question, first, operation, second),
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(vertical = 16.dp) .padding(top = 40.dp),
            )
            OutlinedTextField(
                value = answer,
                onValueChange = onAnswerChange,
                label = {
                    Text(
                        text = stringResource(R.string.your_answer),
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Button(
                onClick = onSubmit,
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .width(150.dp)
            ) {
                Text(
                    text = stringResource(R.string.submit),
                    style = MaterialTheme.typography.titleSmall,
                )
            }
        }
    } else {
        Row(
            modifier = Modifier
                .padding(top = 50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "$num1 + $num2 =",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(16.dp),
            )
            OutlinedTextField(
                value = answer,
                onValueChange = onAnswerChange,
                label = {
                    Text(
                        text = stringResource(R.string.your_answer),
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Button(
                onClick = onSubmit,
                modifier = Modifier
                    .padding(16.dp)
                    .width(100.dp)
            ) {
                Text(
                    text = stringResource(R.string.submit),
                    style = MaterialTheme.typography.titleSmall,
                )
            }
        }
    }
}
