package com.example.sz18_rapidrecall

import java.time.LocalTime
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

class Record @OptIn(ExperimentalTime::class) constructor(
    private val len: Int,
    private val target: Sequence,
    private val input: Sequence,
    private val comparison: IntArray,
    private val correct: Boolean,
    private val time: LocalTime
) {
    fun getLen(): Int {return len}
    fun getTarget(): Sequence {return target}
    fun getInput(): Sequence {return input}
    fun getComparison(): IntArray {return comparison}
    fun getCorrect(): Boolean {return correct}
    @OptIn(ExperimentalTime::class)
    fun getTime(): LocalTime {return time}
}