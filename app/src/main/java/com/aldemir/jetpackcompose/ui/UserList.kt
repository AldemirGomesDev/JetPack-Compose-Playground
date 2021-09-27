package com.aldemir.jetpackcompose.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.aldemir.jetpackcompose.ui.pages.EmployeeItem
import com.aldemir.jetpackcompose.model.User
import com.aldemir.jetpackcompose.ui.state.ErrorItem
import com.aldemir.jetpackcompose.ui.state.LoadingItem
import com.aldemir.jetpackcompose.ui.state.LoadingView
import kotlinx.coroutines.flow.Flow

@Composable
fun UserList(modifier: Modifier = Modifier, viewModel: EmployeeViewModel, context: Context) {
    UserInfoList(modifier, userList = viewModel.user, context)
}

@Composable
fun UserInfoList(modifier: Modifier, userList: Flow<PagingData<User>>, context: Context) {
    val userListItems: LazyPagingItems<User> = userList.collectAsLazyPagingItems()
    Log.d("loadingState", "count items: ${userListItems.itemCount}")

    Surface(modifier.padding(bottom = 56.dp)) {
        LazyColumn {
            itemsIndexed(userListItems) {index, item ->
                item?.let {
                    EmployeeItem(empData = it, onClick = {
                        Toast.makeText(context, item.id.toString(),   Toast.LENGTH_SHORT).show()
                    })
                }
            }
            userListItems.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        Log.d("loadingState", "loading")
                        item { LoadingView(modifier = Modifier.fillParentMaxSize()) }
                    }
                    loadState.append is LoadState.Loading -> {
                        Log.d("loadingState", "loading append")
                        item { LoadingItem() }
                    }
                    loadState.refresh is LoadState.Error -> {
                        Log.d("loadingState", "Error")
                        val e = userListItems.loadState.refresh as LoadState.Error
                        item {
                            ErrorItem(
                                message = e.error.localizedMessage!!,
                                modifier = Modifier.fillParentMaxSize(),
                                onClickRetry = { retry() }
                            )
                        }
                    }
                    loadState.append is LoadState.Error -> {
                        Log.d("loadingState", "Error")
                        val e = userListItems.loadState.refresh as LoadState.Error
                        item {
                            ErrorItem(
                                message = e.error.localizedMessage!!,
                                modifier = Modifier.fillParentMaxSize(),
                                onClickRetry = { retry() }
                            )
                        }
                    }
                }
            }
        }
    }
}
