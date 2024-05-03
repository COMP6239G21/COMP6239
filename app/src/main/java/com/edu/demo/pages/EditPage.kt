package com.edu.demo.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.*
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
fun EditPage() {
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
                text = "Edit Page",
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Edit Page",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = "Chapter 1",
                onValueChange = {},
                label = { Text("Page Title:") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = "Once upon a time...",
                onValueChange = {},
                label = { Text("Content:") },
                modifier = Modifier.fillMaxWidth().weight(1f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Chapters:", modifier = Modifier.padding(bottom = 8.dp))

            // Displaying sample choices
            val choices = listOf("Chapter 1", "Chapter 2", "Chapter 3")

            for (choice in choices) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(choice, modifier = Modifier.weight(1f))
                    Button(onClick = { /* Edit Choice */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Blue1))
                    {
                        Text("Edit Chapter")
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = { /* Add Choice */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Blue1)) {
                    Text("Add Choice")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { /* Submit Changes */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Blue1)) {
                    Text("Submit Changes")
                }
            }
        }
    }

    // Side Menu
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
                EditStorySideMenuItem("Create Story") { /* Handle navigation */ }
                EditStorySideMenuItem("Edit Page") { /* Handle navigation */ }
                EditStorySideMenuItem("Edit Story Page") { /* Handle navigation */ }
                EditStorySideMenuItem("Preview Story") { /* Handle navigation */ }
                EditStorySideMenuItem("Select Page") { /* Handle navigation */ }
            }
        }
    }
}

@Composable
fun EditStorySideMenuItem(
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
fun EditPagePreview() {
    // Set the background color of the preview to white
    EditPage()
}
