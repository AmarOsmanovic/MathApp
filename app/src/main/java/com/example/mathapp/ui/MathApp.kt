package com.example.mathapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mathapp.R
import com.example.mathapp.ui.components.MathContent
import com.example.mathapp.ui.components.ScoreContent
import com.example.mathapp.ui.components.ShareButton
import com.example.mathapp.viewmodel.MathViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MathApp() {
    val viewModel: MathViewModel = viewModel()
    val num1 by viewModel.num1.observeAsState(0)
    val num2 by viewModel.num2.observeAsState(0)
    val operation by viewModel.operation.observeAsState("+")
    val score by viewModel.score.observeAsState(0)
    val message by viewModel.message.observeAsState("")
    val timeLeft by viewModel.timeLeft.observeAsState(10)
    val attempts by viewModel.attempts.observeAsState(0)
    val gameOver by viewModel.gameOver.observeAsState(true)
    var answer by rememberSaveable { mutableStateOf("") }
    var gameStarted by rememberSaveable { mutableStateOf(false) }

    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Math Practice", color = Color.White)},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                ),
                actions = {
                    ShareButton(score)
                }
            )
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
                    .alpha(0.3f),
                contentScale = ContentScale.Crop
            )
            if (isPortrait) {
                PortraitLayout(
                    gameStarted = gameStarted,
                    gameOver = gameOver,
                    num1 = num1,
                    num2 = num2,
                    operation = operation,
                    answer = answer,
                    onAnswerChange = { answer = it },
                    onSubmit = { viewModel.checkAnswer(answer); answer = "" },
                    onStartGame = {
                        gameStarted = true
                        viewModel.restartGame()
                    },
                    onRestartGame = { viewModel.restartGame() },
                    score = score,
                    message = message,
                    timeLeft = timeLeft,
                    attempts = attempts
                )
            } else {
                LandscapeLayout(
                    gameStarted = gameStarted,
                    gameOver = gameOver,
                    num1 = num1,
                    num2 = num2,
                    operation = operation,
                    answer = answer,
                    onAnswerChange = { answer = it },
                    onSubmit = { viewModel.checkAnswer(answer); answer = "" },
                    onStartGame = {
                        gameStarted = true
                        viewModel.restartGame()
                    },
                    onRestartGame = { viewModel.restartGame() },
                    score = score,
                    message = message,
                    timeLeft = timeLeft,
                    attempts = attempts
                )
            }
        }
    }
}

@Composable
fun PortraitLayout(
    gameStarted: Boolean,
    gameOver: Boolean,
    num1: Int,
    num2: Int,
    operation: String,
    answer: String,
    onAnswerChange: (String) -> Unit,
    onSubmit: () -> Unit,
    onStartGame: () -> Unit,
    onRestartGame: () -> Unit,
    score: Int,
    message: String,
    timeLeft: Int,
    attempts: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!gameStarted) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 40.dp)
                    .padding(bottom = 30.dp),
                text = stringResource(R.string.welcome_message),
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Button(
                onClick = onStartGame,
                modifier = Modifier
                    .width(250.dp)
                    .padding(bottom = 20.dp)
            ) {
                Text(stringResource(R.string.start_game))
            }
            Button(
                onClick = {},
                modifier = Modifier
                    .width(250.dp)
            ) {
                Text(stringResource(R.string.about))
            }
        } else {
            if (gameOver) {
                MathContent(num1, num2, operation, answer, onAnswerChange, onSubmit)
                Text(
                    text = stringResource(R.string.tries_left, 3 - attempts),
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Red,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                ScoreContent(score, message, timeLeft)
                Spacer(modifier = Modifier.height(180.dp))
            } else {
                Text(
                    text = stringResource(R.string.game_over),
                    modifier = Modifier.padding(bottom = 20.dp),
                    fontSize = 35.sp,
                )
                Text(
                    text = stringResource(R.string.you_scored, score),
                    modifier = Modifier.padding(bottom = 20.dp),
                    fontSize = 15.sp,
                )
            }
            Button(onClick = onRestartGame, modifier = Modifier.width(250.dp)) {
                Text(stringResource(R.string.restart_game))
            }
        }
    }
}

@Composable
fun LandscapeLayout(
    gameStarted: Boolean,
    gameOver: Boolean,
    num1: Int,
    num2: Int,
    operation: String,
    answer: String,
    onAnswerChange: (String) -> Unit,
    onSubmit: () -> Unit,
    onStartGame: () -> Unit,
    onRestartGame: () -> Unit,
    score: Int,
    message: String,
    timeLeft: Int,
    attempts: Int
) {
    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (!gameStarted) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.welcome_message),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 25.dp)
                )
                Button(
                    onClick = onStartGame,
                    modifier = Modifier
                        .width(250.dp)
                        .padding(bottom = 20.dp)
                ) {
                    Text(stringResource(R.string.start_game))
                }
                Button(
                    onClick = { },
                    modifier = Modifier
                        .width(250.dp)
                ) {
                    Text(stringResource(R.string.about))
                }
            }
        } else {
            if (gameOver) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    MathContent(num1, num2, operation, answer, onAnswerChange, onSubmit)
                    Text(
                        text = stringResource(R.string.tries_left, 3 - attempts),
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Red,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                    ScoreContent(score, message, timeLeft)
                    Button(
                        onClick = onRestartGame,
                        modifier = Modifier
                            .width(250.dp)
                            .padding(top = 10.dp)

                    ) {
                        Text(
                            stringResource(R.string.restart_game),
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 100.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 100.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.game_over),
                            modifier = Modifier.padding(bottom = 8.dp),
                            fontSize = 35.sp,
                        )
                        Text(
                            text = stringResource(R.string.you_scored, score),
                            modifier = Modifier.padding(bottom = 8.dp),
                            fontSize = 15.sp,
                        )
                    }
                    Button(
                        onClick = onRestartGame,
                        modifier = Modifier.width(250.dp)
                    ) {
                        Text(
                            stringResource(R.string.restart_game),
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MathApp()
}
