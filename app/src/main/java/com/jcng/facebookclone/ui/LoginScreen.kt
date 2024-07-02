package com.jcng.facebookclone.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.jcng.facebookclone.R
import com.jcng.facebookclone.ui.theme.AppTypography
import com.jcng.facebookclone.ui.theme.FacebookCloneTheme
import com.jcng.facebookclone.ui.theme.bodyFontFamily
import com.jcng.facebookclone.ui.theme.provider
import java.util.regex.Pattern

@Composable
fun LoginScreen(navController: NavHostController?) {

    var email by rememberSaveable { mutableStateOf("") }
    var validEmail by rememberSaveable { mutableStateOf(true) }
    var password by rememberSaveable { mutableStateOf("") }
    var validPassword by rememberSaveable { mutableStateOf(true) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    fun validateEmail(email: String): Boolean {
        val pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\$")
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun validatePassword(password: String): Boolean {
        return password.length >= 8
    }

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.primary,
    ) {
        innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(id = R.drawable.facebooklogo),
                contentDescription = null,
                modifier = Modifier.width(100.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "FACEBOOK",
                color = Color.White,
                style = AppTypography.headlineLarge,
            )
            Text(
                text = "INICIAR SESIÓN",
                color = Color.White,
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = email,
                onValueChange = {
                    text ->
                    validEmail = true
                    email = text
                },
                label = { Text(text = "Correo:", color = MaterialTheme.colorScheme.secondary) },
                singleLine = true,
                isError = !validEmail,
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                modifier = Modifier.shadow(8.dp).fillMaxWidth(0.8f),
                trailingIcon = {
                    val image = Icons.Filled.Email

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                },
            )
            if (!validEmail){
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Email vacío o incorrecto",
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = password,
                onValueChange = {
                    validPassword = true
                    password = it
                },
                label = { Text(text = "Contraseña:", color = MaterialTheme.colorScheme.secondary) },
                singleLine = true,
                isError = !validPassword,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible && password != "") Icons.Filled.Visibility else if (password != "") Icons.Filled.VisibilityOff else {
                        passwordVisible = false
                        Icons.Filled.Lock
                    }

                    IconButton(onClick = {
                        passwordVisible = !passwordVisible
                    }) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.shadow(8.dp).fillMaxWidth(0.8f)
            )
            if (!validPassword){
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "La contraseña debe tener al menos 8 caracteres",
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    validEmail = validateEmail(email)
                    validPassword = validatePassword(password)
                    if (validEmail && validPassword) {
                        navController?.navigate("main")
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0866FF)),
                shape = RoundedCornerShape(8.dp),
                enabled = ((password.isNotEmpty() && email.isNotEmpty()))
            ) {
                Text(
                    text = "Iniciar sesión",
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            TextButton(
                onClick = {
                    navController?.navigate("register")
                }
            ) {
                Text(
                    text = "¿No tienes una cuenta?",
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    FacebookCloneTheme {
        LoginScreen(navController = null)
    }
}