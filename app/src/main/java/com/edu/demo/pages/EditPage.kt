package com.edu.demo.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EditPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
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
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Choices:", modifier = Modifier.padding(bottom = 8.dp))

        // Displaying sample choices
        val choices = listOf("Choice 1", "Choice 2", "Choice 3")

        for (choice in choices) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(choice, modifier = Modifier.weight(1f))
                Button(onClick = { /* Edit Choice */ }) {
                    Text("Edit Choice")
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { /* Add Choice */ }) {
                Text("Add Choice")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { /* Submit Changes */ }) {
                Text("Submit Changes")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditPagePreview() {
    // Set the background color of the preview to white
    EditPage()
}
