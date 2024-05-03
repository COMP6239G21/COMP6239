package com.edu.demo.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edu.demo.ui.theme.Blue1

@Composable
fun CreateStoryScreen(
    onCreateStory: (String, String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var storyName by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("fantasy") }
    var isDropdownExpanded by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
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
                text = "Create a New Story",
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        // 文本 "Create a New Story"
        Column(modifier = Modifier.padding(16.dp)){
            // 剩余部分
            Text(
                text = "Create a New Story",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    letterSpacing = 0.15.sp
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Story Name",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    letterSpacing = 0.15.sp
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = storyName,
                onValueChange = { storyName = it },
                label = { Text("Story Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Description",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    letterSpacing = 0.15.sp
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Take up remaining space
            )
            Spacer(modifier = Modifier.height(16.dp))

            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = category,
                    onValueChange = {},
                    label = { Text("Category") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            // Toggle the dropdown when clicking on the text field
                            isDropdownExpanded = true
                        }
                )

                DropdownMenu(
                    expanded = isDropdownExpanded,
                    onDismissRequest = { isDropdownExpanded = false },
                    scrollState = scrollState,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    listOf("fantasy", "romantic", "horror").forEach { item ->
                        DropdownMenuItem(
                            onClick = {
                                // Update the category text when an item is clicked
                                category = item
                                isDropdownExpanded = false
                            },
                            text = { Text(item) }
                        )
                    }
                }

                IconButton(
                    onClick = { isDropdownExpanded = true },
                    modifier = Modifier.align(Alignment.BottomEnd)
                ) {
                    Icon(Icons.Outlined.Menu, contentDescription = "Menu")
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { onCreateStory(storyName, description, category) },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Blue1)
            ) {
                Text("Create Story")
            }
        }
    }

    // Side Menu
    if (isSideMenuExpanded) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha

                = 0.5f))
                .clickable { isSideMenuExpanded = false }
        ) {
            Column(
                modifier = Modifier
                    .width(200.dp)
                    .fillMaxHeight()
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                SideMenuItem("Create Story") { /* Handle navigation */ }
                SideMenuItem("Edit Page") { /* Handle navigation */ }
                SideMenuItem("Edit Story Page") { /* Handle navigation */ }
                SideMenuItem("Preview Story") { /* Handle navigation */ }
                SideMenuItem("Select Page") { /* Handle navigation */ }
            }
        }
    }
}

@Composable
fun SideMenuItem(
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
fun CreateStoryPreview() {
    CreateStoryScreen(
        onCreateStory = { name, description, category ->
            // Dummy function to handle story creation
            println("Creating story: $name, $description, $category")
        }
    )
}