package com.example.sz18_rapidrecall

import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class Round(
    private val _targetSeq: Sequence,
    private val _targetLen: Int
) {
    @OptIn(ExperimentalTime::class)
    fun check(inputSeq: Sequence, records: MutableList<Record>): Boolean {
        val compare = IntArray(_targetLen)

        for (i in 0 until _targetLen) {
            if (inputSeq.seq[i] == _targetSeq.seq[i]) {     // it already calls the getter
                compare[i] = 1
            }
        }
        if (compare.count { it == 1}  == _targetLen) {
            records.add(Record(_targetLen, _targetSeq, inputSeq, compare, true, Clock.System.now()))
        }
        else {
            records.add(Record(_targetLen, _targetSeq, inputSeq, compare, false, Clock.System.now()))
        }
        return (compare.count { it == 1}  == _targetLen)
    }

}
