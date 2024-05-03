import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
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
fun EditStoryPage() {
    var isSideMenuExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Custom navigation bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(color = Blue1),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { isSideMenuExpanded = true },
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Icon(Icons.Outlined.Menu, contentDescription = "Menu", tint = Color.White)
            }

            Text(
                text = "Edit Story Page",
                color = Color.White,
                //style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        // Rest of the content
        Column(
            modifier = Modifier.padding(16.dp)
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
                modifier = Modifier.fillMaxWidth().weight(1f)
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
                    Button(onClick = { /* Edit Page */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Blue1))
                    {
                        Text("Edit")
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = { /* Add Page */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Blue1))
                {
                    Text("Add Page")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { /* Submit Changes */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Blue1))
                {
                    Text("Submit Changes")
                }
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
                EditPageSideMenuItem("Create Story") { /* Handle navigation */ }
                EditPageSideMenuItem("Edit Page") { /* Handle navigation */ }
                EditPageSideMenuItem("Edit Story Page") { /* Handle navigation */ }
                EditPageSideMenuItem("Preview Story") { /* Handle navigation */ }
                EditPageSideMenuItem("Select Page") { /* Handle navigation */ }
            }
        }
    }
}


@Composable
fun EditPageSideMenuItem(
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
fun EditStoryPagePreview() {
    // Set the background color of the preview to white
    EditStoryPage()
}
