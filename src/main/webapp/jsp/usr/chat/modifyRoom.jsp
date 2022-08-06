<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ page import="com.ll.exam.article.dto.ArticleDto" %>--%>

<%--<%--%>
<%--    ArticleDto article = (ArticleDto)request.getAttribute("article");--%>
<%--%>--%>

<%@ include file="../common/head.jspf"%>


<script>
    function ArticleSave__submitForm(form) {
        form.title.value = form.title.value.trim();
        if ( form.title.value.length == 0 ) {
            alert('이름을 입력해주세요.');
            form.title.focus();
            return;
        }
        form.body.value = form.body.value.trim();
        if ( form.body.value.length == 0 ) {
            alert('주제를 입력해주세요.');
            form.body.focus();
            return;
        }
        form.submit();
    }
</script>

<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">채팅방 수정</h1>
        <form method="POST" onsubmit="ArticleSave__submitForm(this); return false;">
            <div class="gap-3">
                <span>이름</span>
                <div>
                    <input name="title" type="text" maxlength="50" placeholder="이름을 입력해주세요." class="input input-bordered w-full max-w-xs" />

                </div>
            </div>

            <div class="gap-3">
                <span>주제</span>
                <div>
                    <input name="body" type="text" maxlength="200" placeholder="주제를 입력해주세요." class="input input-bordered w-full max-w-xs" />

                </div>
            </div>

            <div>
                <div>
                    <input type="submit" class="btn btn-outline btn-primary" value="수정"></input>
                </div>
            </div>
        </form>
    </div>
</section>

<%@ include file="../common/foot.jspf"%>