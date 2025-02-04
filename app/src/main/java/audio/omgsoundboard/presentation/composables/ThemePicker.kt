package audio.omgsoundboard.presentation.composables

import android.os.Build
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import audio.omgsoundboard.R
import audio.omgsoundboard.presentation.theme.ThemeType

@Composable
fun ThemePicker(
    selectedThemeType: ThemeType,
    pickTheme: (ThemeType) -> Unit,
    onDismiss: () -> Unit
) {

    var selected by remember { mutableStateOf(selectedThemeType) }

    Dialog(
        onDismissRequest = onDismiss,
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 15.dp, vertical = 10.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                Radio(text = stringResource(id = R.string.theme_dark), isSelected = selected == ThemeType.DARK) {
                    selected = ThemeType.DARK
                    pickTheme(ThemeType.DARK)
                }
                Radio(text = stringResource(id = R.string.theme_light), isSelected = selected == ThemeType.LIGHT) {
                    selected = ThemeType.LIGHT
                    pickTheme(ThemeType.LIGHT)
                }
                // If android version is >= 12 follow system option will enable material 3 dynamic theming
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    Radio(
                        text = stringResource(id = R.string.theme_follow_system),
                        isSelected = selected == ThemeType.DYNAMIC
                    ) {
                        selected = ThemeType.DYNAMIC
                        pickTheme(ThemeType.DYNAMIC)
                    }
                } else {
                    Radio(
                        text = stringResource(id = R.string.theme_follow_system),
                        isSelected = selected == ThemeType.SYSTEM
                    ) {
                        selected = ThemeType.SYSTEM
                        pickTheme(ThemeType.SYSTEM)
                    }
                }
            }
        }
    }
}


@Composable
fun Radio(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text)
        RadioButton(selected = isSelected, onClick = onClick)
    }

}
