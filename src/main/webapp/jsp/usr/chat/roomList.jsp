<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://cdn.tailwindcss.com"></script>
<!-- 보통 구획은 섹션으로 나눈다. -->
<!-- container(max-width) : 너비가 너무 넓게 퍼지는 것을 막는다 + 반응형은 잃지 않는다. -->
<!-- mx-auto : margin-left:auto; margin-right:auto; -->
<%@ include file="../common/head.jspf"%>
<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">채팅방 리스트</h1>

        <ul class="">
            <c:forEach items="${chatRooms}" var="chatRoom">
                <li class="flex mt-2">
                    <a class="badge badge-primary mr-2" href="/usr/chat/detail/free/${chatRoom.id}">${chatRoom.id}</a>
                    <a class="flex-grow hover:underline hover:text-[red]" href="/usr/chat/detail/free/${chatRoom.id}">${chatRoom.title}</a>
                    <a onclick="if ( !confirm('정말로 삭제하시겠습니까?') ) return false;" class="btn btn-outline btn-error btn btn-sm mr-2" href="/usr/chat/delete/free/${chatRoom.id}?_method=DELETE">삭제</a>
                    <a class="btn btn-outline btn-primary btn btn-sm" href="/usr/chat/modify/free/${chatRoom.id}">수정</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</section>
<%@ include file="../common/foot.jspf"%>