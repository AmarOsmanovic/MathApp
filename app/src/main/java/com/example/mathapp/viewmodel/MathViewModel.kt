package com.example.mathapp.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MathViewModel : ViewModel() {
    private val _num1 = MutableLiveData((0..9).random())
    val num1: LiveData<Int> = _num1

    private val _num2 = MutableLiveData((0..9).random())
    val num2: LiveData<Int> = _num2

    private val _operation = MutableLiveData(if ((0..1).random() == 0) "+" else "-")
    val operation: LiveData<String> = _operation

    private val _score = MutableLiveData(0)
    val score: LiveData<Int> = _score

    private val _message = MutableLiveData("")
    val message: LiveData<String> = _message

    private val _timeLeft = MutableLiveData(10)
    val timeLeft: LiveData<Int> = _timeLeft

    private val _attempts = MutableLiveData(0)
    val attempts: LiveData<Int> = _attempts

    private val _gameOver = MutableLiveData(true)
    val gameOver: LiveData<Boolean> = _gameOver

    private var timerJob: Job? = null

    fun checkAnswer(answer: String) {
        val correctAnswer = when (_operation.value) {
            "+" -> _num1.value!! + _num2.value!!
            "-" -> kotlin.math.abs(_num1.value!! - _num2.value!!)
            else -> throw IllegalStateException("Unsupported operation")
        }

        if (answer.toIntOrNull() == correctAnswer) {
            _score.value = _score.value?.plus(1)
            _message.value = "Correct!"
            _num1.value = (0..9).random()
            _num2.value = (0..9).random()
            _operation.value = if ((0..1).random() == 0) "+" else "-"
            resetTimer()
        } else {
            _message.value = "Try again!"
            _attempts.value = _attempts.value?.plus(1)
            if (_attempts.value!! >= 3) {
                _gameOver.value = false
            }
        }
        viewModelScope.launch {
            delay(2000)
            _message.value = ""
        }
    }

    private fun startTimer() {
        timerJob = viewModelScope.launch {
            while (_timeLeft.value!! > 0) {
                delay(1000)
                _timeLeft.value = _timeLeft.value?.minus(1)
            }
            _message.value = "Time's up!"
            _num1.value = (0..9).random()
            _num2.value = (0..9).random()
            _operation.value = if ((0..1).random() == 0) "+" else "-"
            delay(2000)
            _message.value = ""
            _attempts.value = _attempts.value?.plus(1)
            if (_attempts.value!! >= 3) {
                _gameOver.value = false
            }
            resetTimer()
        }
    }

    private fun resetTimer() {
        timerJob?.cancel()
        _timeLeft.value = 10
        viewModelScope.launch {
            delay(1000)
            startTimer()
        }
    }

    fun restartGame() {
        _score.value = 0
        _message.value = ""
        _num1.value = (0..9).random()
        _num2.value = (0..9).random()
        _operation.value = if ((0..1).random() == 0) "+" else "-"
        _attempts.value = 0
        _gameOver.value = true
        resetTimer()
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }
}
