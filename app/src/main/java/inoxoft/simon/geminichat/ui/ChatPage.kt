package inoxoft.simon.geminichat.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import inoxoft.simon.geminichat.model.MessageModel
import inoxoft.simon.geminichat.ui.theme.modelColor
import inoxoft.simon.geminichat.ui.theme.userColor
import inoxoft.simon.geminichat.viewmodel.ChatViewModel

@Composable
fun ChatPage(modifier: Modifier = Modifier,viewModel: ChatViewModel){
    Column(modifier = Modifier) {
        AppHeader()
        MessageList(modifier=Modifier.weight(1F), messageList = viewModel.messageList)
        MessageInput(
            onMessageSend = {
                //calling the chatViewmodel instance to send the message to gemini generative ai
                //binding the viewmodel with the lambda message function
                viewModel.sendMessage(it)
            }
        )
    }
}

@Composable
fun AppHeader(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center){
        Text(modifier = Modifier
            .padding(16.dp),
            text = "Gemini",
            color = Color.White,
            fontSize = 22.sp

        )
    }
}

@Composable
//creating a lambda function onmessagesend
fun MessageInput(onMessageSend: (String)-> Unit){

    var message by remember {
        mutableStateOf("")
    }
    Row (
        modifier=Modifier
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){

        OutlinedTextField(modifier = Modifier
            .weight(1F),
            value = message,
            onValueChange = { message = it }
        )
        IconButton(onClick = {
            onMessageSend(message)
            message=""
        }) {

            Icon(imageVector = Icons.Default.Send, contentDescription = "Send prompt")

        }

    }
}

@Composable
fun MessageList(modifier: Modifier=Modifier,messageList: List<MessageModel>){

    LazyColumn (
        modifier = Modifier,
        reverseLayout = true
    ){
        items(messageList.reversed()){
            MessageRow(messageModel = it)
        }
    }
}

@Composable
fun MessageRow(messageModel: MessageModel){
    val isModel = messageModel.role=="model"

    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.fillMaxSize()){
            Box(
                modifier = Modifier
                    .align(
                        if (isModel) Alignment.BottomStart else Alignment.BottomEnd
                    )
                    .padding(
                        start = if (isModel) 8.dp else 70.dp,
                        end = if (isModel) 70.dp else 8.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    )
                    .clip(RoundedCornerShape(48f))
                    .background(if (isModel) modelColor else userColor)
                    .padding(16.dp)
            ){
                Text(text = messageModel.message, fontWeight = FontWeight.W500, color = Color.White)
            }
        }
    }

}














