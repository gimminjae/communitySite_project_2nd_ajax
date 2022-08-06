<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ include file="../common/head.jspf"%>

<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">채팅방</h1>
        <div>
            <div>
                ID : ${chatRoom.id}
            </div>
            <div>
                TITLE : ${chatRoom.title}
            </div>
            <div>
                BODY : ${chatRoom.body}
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">채팅방</h1>

        <div>
            ${room.title}
        </div>

        <div>
            ${room.body}
        </div>

        <script>
            function ChatMessageSave__submitForm(form) {
                form.body.value = form.body.value.trim();
                if ( form.body.value.length == 0 ) {
                    form.body.focus();
                    return false;
                }
                form.submit();
            }
        </script>

        <form onsubmit="ChatMessageSave__submitForm(this); return false;" method="POST" action="/usr/chat/writeMessage/2">
            <input autofocus name="body" type="text" placeholder="메세지를 입력해주세요." class="input input-bordered" />
            <button type="submit" value="" class="btn btn-outline btn-primary">
                작성
            </button>
        </form>
    </div>
</section>

<%@ include file="../common/foot.jspf"%>