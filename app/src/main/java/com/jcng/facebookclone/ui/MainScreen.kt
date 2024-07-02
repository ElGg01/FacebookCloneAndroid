package com.jcng.facebookclone.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Sell
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.jcng.facebookclone.R

@Composable
fun MainScreen(navController: NavHostController?){

    val scrollStateHistorys = rememberScrollState()
    val scrollStateFeed = rememberScrollState()

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.onPrimaryContainer
    ) {
        innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(scrollStateFeed)
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterHorizontally),
            ) {
                Image(
                    painterResource(id = R.drawable.facebooklogo),
                    contentDescription = null,
                    modifier = Modifier.width(32.dp)
                )
                Spacer(modifier = Modifier.height(32.dp))
                Icon(Icons.Filled.Home, contentDescription = null, tint = Color.White, modifier = Modifier.size(32.dp))
                Icon(Icons.Filled.People, contentDescription = null, tint = Color.White, modifier = Modifier.size(32.dp))
                Icon(Icons.Filled.Sell, contentDescription = null, tint = Color.White, modifier = Modifier.size(32.dp))
                Icon(Icons.Filled.Notifications, contentDescription = null, tint = Color.White, modifier = Modifier.size(32.dp))
                Icon(Icons.Filled.Person, contentDescription = null, tint = Color.White, modifier = Modifier.size(32.dp))
            }
            Text(
                text = "Historias:",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                modifier = Modifier.padding(horizontal = 16.dp),
            )
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 1.dp)
                    .horizontalScroll(scrollStateHistorys)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterHorizontally),
            ) {
                Box (
                    modifier = Modifier
                        .height(160.dp)
                        .width(128.dp)
                        .background(color = MaterialTheme.colorScheme.tertiary, shape = RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Historia",
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
                Box (
                    modifier = Modifier
                        .height(160.dp)
                        .width(128.dp)
                        .background(color = MaterialTheme.colorScheme.tertiary, shape = RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Historia",
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
                Box (
                    modifier = Modifier
                        .height(160.dp)
                        .width(128.dp)
                        .background(color = MaterialTheme.colorScheme.tertiary, shape = RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Historia",
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
                Box (
                    modifier = Modifier
                        .height(160.dp)
                        .width(128.dp)
                        .background(color = MaterialTheme.colorScheme.tertiary, shape = RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Historia",
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
            }
        }
    }
}