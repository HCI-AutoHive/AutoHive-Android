package com.example.chian.viewmodel

import android.util.Log
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bumpercar.data.AuthorData
import com.example.bumpercar.data.ChatMessageData
import com.example.bumpercar.data.ChatMessageWithAuthor
import com.example.bumpercar.data.MessageData
import com.example.chian.network.RetrofitClient
import com.example.chian.ui.theme.chatBoxAccentTextColor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val _chatMessageData = MutableStateFlow(ChatMessageData(emptyList(), AuthorData("","")))
    val chatMessageData = _chatMessageData.asStateFlow()

    private val _chatMessageDataWithAuthor = MutableStateFlow<List<ChatMessageWithAuthor>>(emptyList())
    val chatMessageDataWithAuthor = _chatMessageDataWithAuthor.asStateFlow()

    private val _textField = MutableStateFlow("")
    val textField = _textField.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    fun getTextField(text: String) {
        _textField.update {
            text
        }
    }

    init {
        setInitialChatMessage()
    }

    private fun setInitialChatMessage() {
        val initialMessage = ChatMessageWithAuthor(
            messageData = MessageData(
                query = buildAnnotatedString {
                    append("AI 기반의 ")
                    withStyle(SpanStyle(color = chatBoxAccentTextColor)) { append("챗봇") }
                    append("에게 자동차에 대해 물어보세요!\n")
                    withStyle(SpanStyle(color = chatBoxAccentTextColor)) { append("차종(ex:아반떼)") }
                    append("만 작성해 주시면 됩니다! ")
                }.toString()
            ),
            authorData = AuthorData.chatBotAssistant
        )
        _chatMessageDataWithAuthor.value = listOf(initialMessage)
    }

    // 대화 초기화 메서드
    fun resetChatMessages() {
        setInitialChatMessage() // 초기 메시지로 리셋
    }

    fun sendUserMessage(text: String) {
        // 새로운 메시지 데이터를 작성자와 함께 생성
        val newMessageWithAuthor = ChatMessageWithAuthor(MessageData(text), AuthorData.localUser)

        // 기존 데이터에 새 메시지를 추가
        _chatMessageDataWithAuthor.update { it + newMessageWithAuthor }

        // 기존 _chatMessageData도 업데이트 (필요할 경우)
        _chatMessageData.update {
            it.copy(
                messages = it.messages + MessageData(text),
                interlocutor = AuthorData.localUser
            )
        }

        // API 호출
        getChatbotResponse(text)
    }

    private fun getChatbotResponse(query: String) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = RetrofitClient.getChatApi().postDriveJudge(MessageData(query))
                val botMessageWithAuthor = ChatMessageWithAuthor(
                    MessageData(response.body()?.answer?.trimEnd('\n') ?: ""),
                    AuthorData.chatBotAssistant
                )

                // 챗봇 메시지를 리스트에 추가
                _chatMessageDataWithAuthor.update { it + botMessageWithAuthor }

                // 기존 _chatMessageData도 업데이트 (필요할 경우)
                _chatMessageData.update {
                    it.copy(
                        messages = it.messages + MessageData(response.body()?.answer ?: ""),
                        interlocutor = AuthorData.chatBotAssistant
                    )
                }

            } catch (e: Exception) {
                Log.e("ChatViewModel", e.toString())
            } finally {
                _isLoading.value = false
            }
        }
    }
}