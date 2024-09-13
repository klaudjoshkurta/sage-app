@file:OptIn(ExperimentalMaterial3Api::class)

package com.klaudjoshkurta.sage.ui.components

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.klaudjoshkurta.sage.ui.theme.Geist

@Composable
fun MenuSheet(
    sheetState: SheetState,
    onDismiss: () -> Unit,
    sharedPreferences: SharedPreferences
) {

    var darkMode by remember { mutableStateOf(false) }

    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = onDismiss,
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp).navigationBarsPadding()
        ) {
            ListItem(
                headlineContent = {
                    Text(
                        text = "Dark mode",
                        color = MaterialTheme.colorScheme.onBackground,
                        fontFamily = Geist,
                        fontSize = 16.sp
                    )
                },
                trailingContent = {
                    Switch(
                        checked = darkMode,
                        onCheckedChange = {
                            darkMode = it
                            sharedPreferences.edit().putBoolean("dark_mode", it).apply()
                        },
                        colors = SwitchDefaults.colors(
                            uncheckedBorderColor = MaterialTheme.colorScheme.primary,
                            uncheckedThumbColor = MaterialTheme.colorScheme.primary,
                            uncheckedTrackColor = MaterialTheme.colorScheme.background
                        )
                    )
                },
                modifier = Modifier.padding(horizontal = 16.dp),
                colors = ListItemDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.background,
                    headlineColor = MaterialTheme.colorScheme.onBackground
                )
            )
            ListItem(
                headlineContent = {
                    Text(
                        text = "About",
                        color = MaterialTheme.colorScheme.onBackground,
                        fontFamily = Geist,
                        fontSize = 16.sp
                    )
                },
                modifier = Modifier.padding(horizontal = 16.dp),
                colors = ListItemDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.background,
                    headlineColor = MaterialTheme.colorScheme.onBackground
                )
            )
        }
    }
}