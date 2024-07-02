package com.jcng.facebookclone.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jcng.facebookclone.R
import com.jcng.facebookclone.ui.theme.AppTypography
import com.jcng.facebookclone.ui.theme.FacebookCloneTheme
import java.util.regex.Pattern

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController?) {

    var email by rememberSaveable { mutableStateOf("") }
    var validEmail by rememberSaveable { mutableStateOf(true) }
    var password by rememberSaveable { mutableStateOf("") }
    var validPassword by rememberSaveable { mutableStateOf(true) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    var name by rememberSaveable { mutableStateOf("") }
    var validName by rememberSaveable { mutableStateOf( true) }
    var age by rememberSaveable { mutableStateOf("") }
    var validAge by rememberSaveable { mutableStateOf( true) }
    var repeatedPassword by rememberSaveable { mutableStateOf("") }

    var expanded by rememberSaveable { mutableStateOf(false) }
    val genderList = listOf("Hombre", "Mujer", "Otro")
    var selectedText by rememberSaveable {
        mutableStateOf(genderList[0])
    }

    var termsAndConditions = rememberSaveable { mutableStateOf(false) }

    val scrollState= rememberScrollState()

    val context = LocalContext.current

    fun validateEmail(email: String): Boolean {
        val pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\$")
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun validatePassword(password: String): Boolean {
        return password.length >= 8
    }

    fun validateName(name: String): Boolean {
        return name.isNotEmpty()
    }

    fun validateAge(age: String): Boolean {
        return if (age.length <= 2) {
            try {
                age.toInt() >= 16
            } catch (error: Throwable) {
                false
            }
        } else {
            false
        }
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
                .padding(vertical = 1.dp)
                .verticalScroll(scrollState)
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
                text = "REGISTRARSE",
                color = Color.White,
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = name,
                onValueChange = {
                        text ->
                    name = text
                },
                label = { Text(text = "Nombre:", color = MaterialTheme.colorScheme.secondary) },
                singleLine = true,
                isError = !validName,
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                modifier = Modifier
                    .shadow(8.dp)
                    .fillMaxWidth(0.8f),
                trailingIcon = {
                    val image = Icons.Filled.TextFields

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                },
            )
            if (!validName){
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "El nombre no debe estar vacío",
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = age,
                onValueChange = {
                        text ->
                    age = text
                },
                label = { Text(text = "Edad:", color = MaterialTheme.colorScheme.secondary) },
                singleLine = true,
                isError = !validAge,
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                modifier = Modifier
                    .shadow(8.dp)
                    .fillMaxWidth(0.8f),
                trailingIcon = {
                    val image = Icons.Filled.Numbers

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                },
            )
            if (!validAge){
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "La edad esta vacía o es incorrecta, recuerda que debes tener al menos 16 años para usar la app",
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
                modifier = Modifier.shadow(8.dp).fillMaxWidth(0.8f)
            ) {
                TextField(
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(),
                    value = selectedText,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    onValueChange = {},
                    shape = RoundedCornerShape(8.dp),
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) }
                )
                ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    genderList.forEachIndexed {
                        index, text ->
                        DropdownMenuItem(
                            text = { Text(text = text) },
                            onClick = {
                                selectedText = genderList[index]
                                expanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }
            }
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
                modifier = Modifier
                    .shadow(8.dp)
                    .fillMaxWidth(0.8f),
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
                modifier = Modifier
                    .shadow(8.dp)
                    .fillMaxWidth(0.8f)
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
            TextField(
                value = repeatedPassword,
                onValueChange = {
                    repeatedPassword = it
                },
                label = { Text(text = "Repite la contraseña:", color = MaterialTheme.colorScheme.secondary) },
                singleLine = true,
                isError = password != repeatedPassword,
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
                modifier = Modifier
                    .shadow(8.dp)
                    .fillMaxWidth(0.8f)
            )
            if (password != repeatedPassword){
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Las contraseñas no coinciden",
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row (
                modifier = Modifier.fillMaxWidth(0.8f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Acepto terminos y condiciones")
                Spacer(modifier = Modifier.width(4.dp))
                Checkbox(
                    checked = termsAndConditions.value,
                    onCheckedChange = {
                        termsAndConditions.value = it
                    }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    validEmail = validateEmail(email)
                    validPassword = validatePassword(password)
                    validName = validateName(name)
                    validAge = validateAge(age)
                    if (validEmail && validPassword && validName && validAge) {
                        navController?.navigate("main")
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0866FF)),
                shape = RoundedCornerShape(8.dp),
                enabled = (password.isNotEmpty() && email.isNotEmpty() && age.isNotEmpty() && name.isNotEmpty() && repeatedPassword.isNotEmpty() && termsAndConditions.value)
            ) {
                Text(
                    text = "Registrarse",
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            TextButton(
                onClick = {
                    navController?.navigate("login")
                }
            ) {
                Text(
                    text = "¿Ya tienes una cuenta?",
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview(){
    FacebookCloneTheme {
        RegisterScreen(navController = null)
    }
}