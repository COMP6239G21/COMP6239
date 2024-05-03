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
fun EditStoryPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Edit Story Page",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = "Fantasy Story",
            onValueChange = {},
            label = { Text("Story Name:") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = "A magical adventure...",
            onValueChange = {},
            label = { Text("Description:") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = "Fantasy",
            onValueChange = {},
            label = { Text("Category:") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Pages:", modifier = Modifier.padding(bottom = 8.dp))

        // Displaying sample pages
        val pages = listOf("Page 1", "Page 2", "Page 3")

        for (page in pages) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(page, modifier = Modifier.weight(1f))
                Button(onClick = { /* Edit Page */ }) {
                    Text("Edit")
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { /* Add Page */ }) {
                Text("Add Page")
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
fun EditStoryPagePreview() {
    // Set the background color of the preview to white
    EditStoryPage()
}
