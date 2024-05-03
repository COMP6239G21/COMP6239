import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edu.demo.pages.EditPage

@Composable
fun SelectionPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
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
                Button(onClick = { /*TODO*/ }) {
                    Text("Add Choice")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text("Submit Changes")
                }
            }
        }
    }
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