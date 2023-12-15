package com.sam.compose.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sam.compose.R
import com.sam.compose.ui.theme.Blue05

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {

    Box(
        modifier = modifier
            .height(50.dp)
            .background(Blue05, shape = RoundedCornerShape(12.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = null)
            BasicTextField(
                value = "Text", onValueChange = onValueChange,
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(start = 20.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically),
            )
        }
    }

}

@Preview
@Composable
fun SearchFieldPreview() {
    SearchField(value = "", onValueChange = {})
}

//
//package com.transfergalaxy.transfergalaxyandroid.compose.components
//import androidx.annotation.DrawableRes
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.BasicTextField
//import androidx.compose.foundation.text.KeyboardActions
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.focus.onFocusChanged
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.transfergalaxy.transfergalaxyandroid.R
//import com.transfergalaxy.transfergalaxyandroid.compose.theme.Black54
//import com.transfergalaxy.transfergalaxyandroid.compose.theme.Black87
//import com.transfergalaxy.transfergalaxyandroid.compose.theme.BrandRed
//import com.transfergalaxy.transfergalaxyandroid.compose.theme.Error
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SearchField(
//    value: String,
//    onValueChange: (String) -> Unit,
//    modifier: Modifier = Modifier,
//    isPasswordField: Boolean = false,
//    isPasswordVisible: Boolean = false,
//    onVisibilityChanged: (Boolean) -> Unit = {},
//    onFocusChanged: (Boolean) -> Unit = {},
//    @DrawableRes leadingIcon: Int = -1,
//    label: String = "",
//    placeholder: String = "",
//    prefix: String = "",
//    singleLine: Boolean = true,
//    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
//    keyboardActions: KeyboardActions = KeyboardActions.Default,
//    showError: Boolean = false,
//    errorMessage: String = "",
//) {
//
//    var focusState by remember { mutableStateOf(false) }
//    var focusedByOS by remember { mutableStateOf(false) }
//
//    Column(modifier = modifier) {
//        Text(
//            text = label,
//            color = if (showError) Error else if (focusState) BrandRed else Black87,
//            style = MaterialTheme.typography.labelMedium
//        )
//        Box(
//            modifier = Modifier
//                .border(
//                    width = (.5).dp,
//                    color = if (showError) Error else if (focusState) BrandRed else Black54,
//                    shape = RoundedCornerShape(5.dp)
//                )
//                .height(58.dp)
//        ) {
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.padding(horizontal = 10.dp)
//            ) {
//
//                if (leadingIcon != -1) {
//                    Icon(
//                        modifier = Modifier
//                            .size(25.dp),
//                        painter = painterResource(id = leadingIcon),
//                        contentDescription = errorMessage
//                    )
//                }
//
//                if (prefix.isNotEmpty())
//                    Text(
//                        text = prefix,
//                        color = Black87,
//                        modifier = Modifier.padding(horizontal = 5.dp),
//                        style = MaterialTheme.typography.titleLarge
//                    )
//
//
////                TextField(
////                    value = value,
////                    onValueChange = { onValueChange(it) },
////                    modifier = Modifier
////                        .weight(1f)
////                        .onFocusChanged { focusState = it.hasFocus },
////                    textStyle = MaterialTheme.typography.titleLarge,
////                    placeholder = {
////                        Text(
////                            text = placeholder,
////                            color = Black54,
////                            style = MaterialTheme.typography.titleLarge
////                        )
////                    },
////                    visualTransformation = if (isPasswordField && !isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
////                    colors = TextFieldDefaults.colors(
////                        cursorColor = BrandRed,
////                        focusedContainerColor = Color.Transparent,
////                        unfocusedContainerColor = Color.Transparent,
////                        focusedIndicatorColor = Color.Transparent,
////                        unfocusedIndicatorColor = Color.Transparent,
////                    ),
////                    isError = showError,
////                    singleLine = singleLine,
////                    keyboardOptions = keyboardOptions,
////                    keyboardActions = keyboardActions,
////                )
//
//                BasicTextField(
//                    value = value,
//                    onValueChange = { onValueChange(it) },
//                    singleLine = singleLine,
//                    visualTransformation = if (isPasswordField && !isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
//                    modifier = Modifier
//                        .onFocusChanged {
//                            if (it.isFocused) {
//                                focusedByOS = true
//                            } else {
//                                if (focusedByOS) {
//                                    onFocusChanged(it.hasFocus)
//                                    focusState = it.hasFocus
//                                }
//                                focusedByOS = false
//                            }
//
//
//                        }
//                        .fillMaxSize()
//                        .weight(1f),
//                    textStyle = MaterialTheme.typography.titleLarge.copy(
//                        color = Black87
//                    ),
//                    keyboardOptions = keyboardOptions,
//                    keyboardActions = keyboardActions,
//
//                    ) { innerTextField ->
//
//                    Box(
//                        contentAlignment = Alignment.CenterStart
//                    ) {
//                        if (value.isEmpty() && placeholder.isNotEmpty())
//                            Text(
//                                text = placeholder,
//                                style = MaterialTheme.typography.titleLarge.copy(
//                                    color = Black54
//                                ),
//                            )
//
//                        innerTextField()
//                    }
//                }
//
//                if (showError && !isPasswordField)
//                    Icon(
//                        modifier = Modifier
//                            .size(25.dp),
//                        painter = painterResource(id = R.drawable.ic_text_field_error_logo),
//                        tint = Error,
//                        contentDescription = errorMessage,
//                    )
//
//                if (isPasswordField)
//                    IconButton(
//                        modifier = Modifier
//                            .padding(end = 10.dp)
//                            .size(25.dp),
//                        onClick = { onVisibilityChanged(!isPasswordVisible) }) {
//                        Icon(
//                            painter = painterResource(id = if (isPasswordVisible) R.drawable.ic_show_password_on else R.drawable.ic_show_password_off),
//                            contentDescription = "Toggle Password Icon",
//                        )
//                    }
//
//
//            }
//        }
//
//        if (showError)
//            Text(
//                text = errorMessage,
//                color = Error,
//                modifier = Modifier
//                    .padding(start = 5.dp)
//                    .fillMaxWidth(.9f)
//            )
//    }
//
//}
//
//
//@Preview(showBackground = true, widthDp = 300, heightDp = 100)
//@Composable
//fun TGInputFieldPreview() {
//    TGInputField(
//        value = "",
//        onValueChange = {},
//        prefix = "+49",
//        label = "Label",
//        placeholder = "Placeholder",
//        showError = false,
//        errorMessage = "Test error"
//    )
//}
//
//
//@Preview(showBackground = true)
//@Composable
//fun TGInputFieldErrorPreview() {
//    TGInputField(
//        value = "Test",
//        onValueChange = {},
//        label = "Label",
//        placeholder = "Placeholder",
//        showError = true,
//        errorMessage = "Test error"
//    )
//}
