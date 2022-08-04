<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://cdn.tailwindcss.com"></script>
<!-- 보통 구획은 섹션으로 나눈다. -->
<!-- container(max-width) : 너비가 너무 넓게 퍼지는 것을 막는다 + 반응형은 잃지 않는다. -->
<!-- mx-auto : margin-left:auto; margin-right:auto; -->
<%@ include file="../common/head.jspf"%>
<script>
    let Articles_lastId = 0;
    function Articles_loadMore() {
        fetch('/usr/article/getArticles/free?fromId=${Articles_lastId}')
            .then(data => data.json())
            .then(responseData => {
                console.log(responseData);
                for(const key in responseData.data) {
                    const article = responseData.data[key];

                    const html = `
                    <li> \${article.id} </li>
                    `;

                    $('.articles').append(html);
                }
            });
    }
</script>
<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">게시물 리스트</h1>

        <ul class="articles mt-5">
            <!-- 이 부분을 자바스크립트를 이용해 채운다. -->
        </ul>
        <hr>
    <button class="btn btn-sm" onclick="Articles_loadMore();">불러오기</button>
    </div>
</section>

<%@ include file="../common/foot.jspf"%>