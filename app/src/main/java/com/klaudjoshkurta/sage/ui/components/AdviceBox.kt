package com.klaudjoshkurta.sage.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.klaudjoshkurta.sage.model.Advice
import com.klaudjoshkurta.sage.ui.theme.Geist

@Composable
fun AdviceBox(
    modifier: Modifier = Modifier,
    advice: Advice
) {
    Column(
        modifier = modifier.fillMaxWidth().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = advice.slip.advice,
            fontFamily = Geist,
            color = Color.Black,
            fontSize = 22.sp,
            lineHeight = 30.sp
        )
        Surface(
            color = Color.Black.copy(0.05f),
            shape = RoundedCornerShape(4.dp)
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 3.dp),
                text = "No.${advice.slip.id}",
                color = Color.Black,
                fontSize = 14.sp,
                lineHeight = 14.sp
            )
        }
    }
}