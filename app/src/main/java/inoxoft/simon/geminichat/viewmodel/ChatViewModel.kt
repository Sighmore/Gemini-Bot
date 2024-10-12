package inoxoft.simon.geminichat.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import inoxoft.simon.geminichat.model.Constants
import inoxoft.simon.geminichat.model.MessageModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel(){

    //creating the list that will store the questions and responses for displaying in the UI
    val messageList by lazy {
        mutableStateListOf<MessageModel>()
    }


//creating the instance of generative ai Gemini: pass two arguments: model name and api key
val generativeModel : GenerativeModel = GenerativeModel(
    modelName = "gemini-pro",
    apiKey = Constants.apiKey
)

    fun sendMessage(question: String){

        //calling inside a coroutine since it takes more time and may block the main thread
        viewModelScope.launch {
            try {

                //variables that store the sent message
                val chat = generativeModel.startChat(
                    history = messageList.map {
                        content(it.role){
                            text(it.message)
                        }
                    }.toList()
                )
                messageList.add(MessageModel(question,"user"))//adding the quiz to the list
                messageList.add(MessageModel("Typing...","model"))
                //variables that store the received outcome from the ai
                val response =chat.sendMessage(question)
                messageList.removeLast()
                messageList.add(MessageModel(response.text.toString(),"model"))//adding response to the list
            }catch (e: Exception){
                delay(2000L)
                messageList.removeLast()
                messageList.add(MessageModel("Check your connection \n"+e.message.toString(),"model"))
            }
 }

    }

}