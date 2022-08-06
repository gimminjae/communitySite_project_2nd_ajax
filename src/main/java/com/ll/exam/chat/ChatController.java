package com.ll.exam.chat;

import com.ll.exam.Rq;
import com.ll.exam.article.dto.ArticleDto;
import com.ll.exam.chat.dto.ChatRoomDto;

import java.util.List;

public class ChatController {
    private ChatService chatService;

    public ChatController() {
        chatService = new ChatService();
    }
    public void showCreateRoom(Rq rq) {
        rq.view("usr/chat/createRoom");
    }

    public void doCreateRoom(Rq rq) {
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

        if (title.length() == 0) {
            rq.historyBack("이름을 입력해주세요.");
            return;
        }

        if (body.length() == 0) {
            rq.historyBack("주제을 입력해주세요.");
            return;
        }

        long id = chatService.create(title, body);

        rq.replace("/usr/chat/room/%d".formatted(id), "%d번 채팅방이 생성되었습니다.".formatted(id));

    }

    public void showRoomList(Rq rq) {
        List<ChatRoomDto> chatRoomDtos = chatService.findAllRooms();

        rq.setAttr("chatRooms", chatRoomDtos);
        rq.view("usr/chat/roomList");
    }

    public void doDelete(Rq rq) {
        long id = rq.getPostId();


        chatService.doDeleteRoom(id);

        rq.println("<div class=\"alert('정말로 삭제하시겠습니까?')\"></div>".formatted(id));

        rq.replace("/usr/chat/roomList/free", "채팅방이 삭제되었습니다.");
    }

    public void showModifyRoom(Rq rq) {
        long id = rq.getPostId();

        if (id == 0) {
            rq.replace("/usr/chat/roomList/free", "번호를 입력해주세요.");
            return;
        }
        ChatRoomDto chatRoomDto = chatService.findById(id);

        if (chatRoomDto == null) {
            rq.replace("/usr/chat/roomList/free", "해당 채팅방은 존재하지 않습니다.");
            return;
        }
        rq.setAttr("chatRoom", chatRoomDto);
        rq.view("usr/chat/modifyRoom");
    }

    public void doModifyRoom(Rq rq) {
        long id = rq.getPostId();

        if (id == 0) {
            rq.replace("/usr/chat/chatList/free", "번호를 입력해주세요.");
            return;
        }
        ChatRoomDto chatRoomDto = chatService.findById(id);

        if (chatRoomDto == null) {
            rq.replace("/usr/chat/roomList/free", "해당 채팅방은 존재하지 않습니다.");
            return;
        }

        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

        chatService.modify(id, title, body);

        rq.replace("/usr/chat/room/free/%d".formatted(id), "%d번 채팅방이 수정되었습니다.".formatted(id));
    }

    public void showRoom(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.replace("/usr/chat/room/free", "번호를 입력해주세요.");
            return;
        }
        ChatRoomDto chatRoomDto = chatService.findById(id);

        if (chatRoomDto == null) {
            rq.replace("/usr/chat/roomList/free", "해당 글은 존재하지 않습니다.");
            return;
        }

        rq.setAttr("chatRoom", chatRoomDto);
        rq.view("usr/chat/room");
    }

    public void doWriteMessage(Rq rq) {
        long roomId = rq.getLongPathValueByIndex(0, -1);
        String body = rq.getParam("body", "");

        rq.println("채팅방 번호 : %d<br />".formatted(roomId));
        rq.println("채팅메세지 : %s<br />".formatted(body));
    }
}
