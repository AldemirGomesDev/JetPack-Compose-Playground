package com.aldemir.jetpackcompose.ui.pages

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aldemir.jetpackcompose.R
import com.aldemir.jetpackcompose.ui.components.otp.OTPTextFields
import com.aldemir.jetpackcompose.ui.theme.Purple500

@ExperimentalComposeUiApi
@Composable
fun OTPScreen() {
    val context = LocalContext.current
    var otpVal: String? = null

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(75.dp))
        Image(
            painter = painterResource(id = R.drawable.otp),
            contentDescription = "Otp Image",
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
        )

        Spacer(modifier = Modifier.height(75.dp))

        Text(
            text = "Enter the OTP",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        OTPTextFields(
            length = 4
        ) { getOpt ->
            otpVal = getOpt
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                Toast.makeText(context, "Please Enter Otp: " + otpVal, Toast.LENGTH_SHORT).show()
                if (otpVal == null || otpVal == "") {
                    print("")
                }
            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(45.dp)
                .background(Purple500),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Get Otp",
                fontSize = 15.sp,
                color = Color.White
            )
        }
    }


}