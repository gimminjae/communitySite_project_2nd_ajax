package com.ll.exam.chat;

import com.ll.exam.article.dto.ArticleDto;
import com.ll.exam.chat.dto.ChatRoomDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ChatRoomRepository {
    private static List<ChatRoomDto> datum;
    private static long lastId;

    static {
        datum = new ArrayList<>();
        lastId = 0;

        makeTestData();
    }

    private static void makeTestData() { //테스트 데이터 생성
        IntStream.rangeClosed(1, 10).forEach(id -> {
            String title = "이름%d".formatted(id);
            String body = "주제%d".formatted(id);
            create(title, body);
        });
    }
    public static long create(String title, String body) {
        long id = ++lastId;
        ChatRoomDto newChatRoomDto = new ChatRoomDto(id, title, body);

        datum.add(newChatRoomDto);

        return id;
    }

    public List<ChatRoomDto> findAllRooms() {
        return datum;
    }

    public void doDeleteRoom(long id) {
        ChatRoomDto chatRoomDto = findById(id);
        datum.remove(chatRoomDto);
    }

    private ChatRoomDto findById(long id) {
            for(ChatRoomDto ad : datum) {
                if(ad.getId() == id) {
                    return ad;
                }
            }
            return null;
        }
    }
