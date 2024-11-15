package com.example.flashchat.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flashchat.ui.theme.FlashChatTheme
import com.example.flashchat.view.CustomTitle
import com.example.flashchat.view.CustomButtons




/**
 * The authentication view which gives the user an option to choose between
 * login and register.
 */

@Composable
fun AuthenticationView(register: () -> Unit, login: () -> Unit) {
    FlashChatTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(16.dp), // Corrected padding usage
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center // Centered vertically
            ) {
                CustomTitle(title = "⚡️ Chat Connect")
                Spacer(modifier = Modifier.height(32.dp)) // Adjusted spacing for better UI
                CustomButtons(title = "Register", onClick = register, backgroundColor = Color.Blue)
                Spacer(modifier = Modifier.height(16.dp)) // Adjusted spacing
                Buttons(title = "Login", onClick = login, backgroundColor = Color.Magenta)
            }
        }
    }
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineLarge,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(bottom = 16.dp) // Adjusted bottom padding
    )
}

@Composable
fun Buttons(title: String, onClick: () -> Unit, backgroundColor: Color) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp), // Fixed dp usage
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor), // Corrected usage
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp) // Fixed dp usage
            .padding(vertical = 8.dp) // Added vertical padding to separate buttons
    ) {
        Text(text = title, style = MaterialTheme.typography.bodyLarge, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAuthenticationView() {
    AuthenticationView(register = {}, login = {})
}
