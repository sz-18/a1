package com.example.sz18_rapidrecall

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun UserScreen(
    user: User,
    modifier: Modifier
) {
    var selectedLength: Int by remember { mutableIntStateOf(0) }
    var selectedSequence: Sequence? by remember { mutableStateOf(null) }
    var currentRecord: Record? by remember { mutableStateOf(null) }
    var currentRoundIndex: Int by remember { mutableIntStateOf(0) }
    var targetSeq: Sequence? by remember { mutableStateOf(null) }

    val buttons = arrayOf(
        arrayOf("1", "2", "3"),
        arrayOf("4", "5", "6"),
        arrayOf("7", "8", "9"),
        arrayOf("0", "Enter", "<-")
    )

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // title of the game
        Text(
            text = "Rapid Recall",
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )

        // select the length of the sequence to be generated
        if (selectedLength == 0) {

            // TODO: update selectedLength
            // TODO: update targetSeq
        }
        // start the round get the sequence
        else if (selectedSequence == null) {
            user.startRound(selectedLength)
            selectSequence()
            // TODO: update selectedSequence
        }
        // do the round, check the answer, and display the feedback
        else {
            displayTargetSeq()
            //TODO:  wait after the display target seq after it is done. display the input box, please enter your answer here
            user.doRound(selectedSequence!!)
            viewFeedback()
            // TODO: initialize the variables
        }
    }
}



fun viewFeedback() {
    // TODO: display the feedback (current record) in a nice way
}

fun viewSummary() {
    // TODO: display the summary (records) in a nice way
}

fun selectLength() {
    // TODO: select the length of the sequence to be generated
}

fun selectSequence() {
    // TODO: select the sequence to be generated
}

fun displayTargetSeq() {
    // TODO: display target_seq in a nice way

}

@Composable
fun NumPad(
    buttons: Array<Array<String>>,
    ,
) {
    Column {
        for (row in buttons) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (button in row) {
                    Button(
                        onClick = {
                            when (button) {
                                "Enter" -> {}
                                "<-" -> {selectedSequence?.pop()}
                                else -> {selectedSequence.add(button.toInt())}
                            }
                        },
                        modifier = Modifier.size(72.dp).padding(4.dp),
                        enabled = button.isNotEmpty()
                    ) {
                        Text(
                            text = button,
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
                    }
                }
        }
    }

}