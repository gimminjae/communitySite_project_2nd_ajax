package com.ll.exam.chat;

import com.ll.exam.article.dto.ArticleDto;
import com.ll.exam.chat.dto.ChatRoomDto;

import java.util.List;

public class ChatService {
    private ChatRoomRepository chatRoomRepository;

    public ChatService() {
        chatRoomRepository = new ChatRoomRepository();
    }

    public long create(String title, String body) {
        return chatRoomRepository.create(title, body);
    }

    public List<ChatRoomDto> findAllRooms() {
        return chatRoomRepository.findAllRooms();
    }

    public void doDeleteRoom(long id) {
        chatRoomRepository.doDeleteRoom(id);
    }
    public ChatRoomDto findById(long id) {
        return chatRoomRepository.findById(id);
    }

    public void modify(long id, String title, String body) {
        chatRoomRepository.modify(id, title, body);
    }

}
