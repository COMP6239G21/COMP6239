package com.edu.demo.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CreateStoryScreen(
    onCreateStory: (String, String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var storyName by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("fantasy") }
    var isDropdownExpanded by remember { mutableStateOf(true) }

    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Text(
            text = "Create a New Story",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                letterSpacing = 0.15.sp
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = storyName,
            onValueChange = { storyName = it },
            label = { Text("Story Name") },
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = category,
            onValueChange = {},
            label = { Text("Category") },
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    // Toggle the dropdown when clicking on the text field
                    isDropdownExpanded = true
                    //isDropdownExpanded = !isDropdownExpanded
                }
        )

        DropdownMenu(
            expanded = isDropdownExpanded,
            onDismissRequest = { isDropdownExpanded = true }
        ) {
            DropdownMenuItem(
                onClick = {
                    category = "Option 1"
                    isDropdownExpanded = true
                },
                text = { Text("Option 1") }
            )
            DropdownMenuItem(
                onClick = {
                    category = "Option 2"
                    isDropdownExpanded = true
                },
                text = { Text("Option 2") }
            )
            DropdownMenuItem(
                onClick = {
                    category = "Option 3"
                    isDropdownExpanded = true
                },
                text = { Text("Option 3") }
            )
        }

        // Spacer to push the button to the bottom of the screen
        Spacer(modifier = Modifier.weight(1f))

        // Button aligned to the center horizontally
        Button(
            onClick = { onCreateStory(storyName, description, category) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Create Story")
        }
    }
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