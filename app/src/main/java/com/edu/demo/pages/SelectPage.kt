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
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.edu.demo.pages.EditPage
import com.edu.demo.pages.PreviewSideMenuItem
import com.edu.demo.ui.theme.Blue1

@Composable
fun SelectionPage() {

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
                value = "Chapter 1",
                onValueChange = { },
                label = { Text("Page Title") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = "Once upon a time...",
                onValueChange = { },
                label = { Text("Content") },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                maxLines = Int.MAX_VALUE,
                textStyle = TextStyle(fontSize = 18.sp)
            )
            Text(
                text = "Choices",
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top = 8.dp)
            )
            Column(
                modifier = Modifier.background(Color.LightGray),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ChoiceItem("Go to Page 2")
                ChoiceItem("Go to Page 3")
                ChoiceItem("Go to Page 4")
                ChoiceItem("Go to Page 5")
                // Add more choices here if needed
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Blue1)
                    )
                    {
                        Text("Add Choice")
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Blue1)
                    )
                    {
                        Text("Submit Changes")
                    }
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
                SelectSideMenuItem("Create Story") { /* Handle navigation */ }
                SelectSideMenuItem("Edit Page") { /* Handle navigation */ }
                SelectSideMenuItem("Edit Story Page") { /* Handle navigation */ }
                SelectSideMenuItem("Preview Story") { /* Handle navigation */ }
                SelectSideMenuItem("Select Page") { /* Handle navigation */ }
            }
        }
    }
}


@Composable
fun SelectSideMenuItem(
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

@Composable
fun ChoiceItem(choiceTitle: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /*TODO*/ },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = choiceTitle)
        // You can add an icon here if needed
    }
}

@Preview(showBackground = true)
@Composable
fun SelectPagePreview() {
    // Set the background color of the preview to white
    SelectionPage()
}