package com.edu.demo.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edu.demo.ui.theme.Blue1

@Composable
fun StoryPreview() {
    var isSideMenuExpanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize())
    {
        // 导航栏
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Blue1) // 淡蓝色
                .height(56.dp), // 设置导航栏的高度
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { isSideMenuExpanded = true },
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Icon(Icons.Outlined.Menu, contentDescription = "Menu", tint = Color.White)
            }

            Text(
                text = "Preview Story",
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = "Fantasy Story",
                onValueChange = { },
                label = { Text("Story Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = "A magical adventure...",
                onValueChange = { },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth().weight(1f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = "Fantasy",
                onValueChange = { },
                label = { Text("Category") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Pages",
                modifier = Modifier.padding(bottom = 16.dp)
            )
            repeat(5) {
                Text(
                    text = "Page ${it + 1}: Chapter ${it + 1}",
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { /* Read Story */ },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Blue1))
            {
                Text("Read Story")
            }
        }
    }

    if (isSideMenuExpanded) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
                .clickable { isSideMenuExpanded = false }
        ) {
            Column(
                modifier = Modifier
                    .width(200.dp)
                    .fillMaxHeight()
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                PreviewSideMenuItem("Create Story") { /* Handle navigation */ }
                PreviewSideMenuItem("Edit Page") { /* Handle navigation */ }
                PreviewSideMenuItem("Edit Story Page") { /* Handle navigation */ }
                PreviewSideMenuItem("Preview Story") { /* Handle navigation */ }
                PreviewSideMenuItem("Select Page") { /* Handle navigation */ }
            }
        }
    }

}

@Composable
fun PreviewSideMenuItem(
    text: String,
    onClick: () -> Unit
) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun StoryPrePreview() {
    // Set the background color of the preview to white
    StoryPreview()
}