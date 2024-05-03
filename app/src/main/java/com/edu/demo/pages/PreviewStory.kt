package com.edu.demo.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StoryPreview() {
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
            modifier = Modifier.fillMaxWidth()
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
        Button(onClick = { /* Read Story */ }) {
            Text("Read Story")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StoryPPreview() {
    // Set the background color of the preview to white
    StoryPreview()
}