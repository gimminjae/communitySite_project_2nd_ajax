package com.ll.exam.chat;

public class ChatService {
    private ChatRoomRepository chatRoomRepository;

    public ChatService() {
        chatRoomRepository = new ChatRoomRepository();
    }

    public long create(String title, String body) {
        return chatRoomRepository.create(title, body);
    }
}
