package com.aldemir.jetpackcompose.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aldemir.jetpackcompose.R
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay

@Composable
fun SwipeRefreshCompose() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        var refreshing by remember { mutableStateOf(false)}
        LaunchedEffect(refreshing ) {
            if (refreshing) {
                delay(2000)
                refreshing = false
            }
        }

        SwipeRefresh(state = rememberSwipeRefreshState(isRefreshing = refreshing),
            onRefresh = {
                refreshing = true
            }
        ) {
          LazyColumn {
              items(count = 10) {
                  Card(
                      modifier = Modifier
                          .fillMaxWidth()
                          .height(100.dp)
                          .padding(10.dp, 5.dp, 10.dp, 5.dp)
                          .clip(RoundedCornerShape(10.dp))
                          .background(Color.White)
                  ) {
                      Column(
                          modifier = Modifier.padding(10.dp)
                      ) {
                          Row(
                              verticalAlignment = Alignment.CenterVertically
                          ) {
                              Image(painter = painterResource(id = R.drawable.ic_user_circle),
                                  contentDescription = "Profile Image",
                                  contentScale = ContentScale.Crop,
                                  modifier = Modifier
                                      .size(60.dp)
                                      .clip(CircleShape)
                              )

                              Spacer(modifier = Modifier.padding(5.dp))

                              Column {
                                  Text(
                                      text = "Sample Test",
                                      color = Color.Black,
                                      fontSize = 16.sp,
                                      fontWeight = FontWeight.Bold
                                  )

                                  Spacer(modifier = Modifier.padding(2.dp))

                                  Text(
                                      text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has.",
                                      color = Color.Gray,
                                      fontSize = 12.sp
                                  )
                              }
                          }
                      }
                  }
              }
          }
        }
    }
}