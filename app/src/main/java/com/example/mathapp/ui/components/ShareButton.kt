package com.example.mathapp.ui.components

import android.content.Intent
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.mathapp.R

@Composable
fun ShareButton(score: Int) {
    val context = LocalContext.current
    val shareText = stringResource(R.string.share_text, score)
    val shareDescription = stringResource(R.string.share)

    IconButton(onClick = {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        context.startActivity(shareIntent)
    }) {
        Icon(Icons.Filled.Share, contentDescription = shareDescription, tint = Color.White)
    }
}
