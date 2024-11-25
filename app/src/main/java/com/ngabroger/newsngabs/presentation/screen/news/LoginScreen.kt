package com.ngabroger.newsngabs.presentation.screen.news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import com.ngabroger.newsngabs.presentation.component.MyCustomTextField
import com.ngabroger.newsngabs.presentation.viewmodel.AuthViewModel
import com.ngabroger.newsngabs.presentation.viewmodel.AuthViewModelImpl
import org.koin.androidx.compose.koinViewModel

@Preview(showBackground = true)
@Composable
fun LoginScreen (
    onLogin: (email : String , password: String ) -> Unit={_,_->}
){
    val authViewModel: AuthViewModelImpl = koinViewModel()

    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    Column (
        modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 12.dp))
    {
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            text = "Masuk",
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Masuk dengan email dan password",
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 12.dp)

        )
        MyCustomTextField(
            label = "Email",
            value = email,
            onValueChange = {
                email = it
            },
            placeholder = "Masukkan email",

        )
        Spacer(modifier = Modifier.height(12.dp))
        MyCustomTextField(
            label = "Password",
            value = password,
            onValueChange = {
                password = it
            },
            placeholder = "Masukkan email"
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                onLogin(email, password)
                authViewModel.login(email,password)
                      },
            modifier = Modifier.fillMaxWidth()
            ) {
            Text("Masuk")
        }
    }


}