package com.ll.exam.chat;

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
}
