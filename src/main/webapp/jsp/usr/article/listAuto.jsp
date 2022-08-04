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
        fetch(`/usr/article/getArticles/free?fromId=\${Articles_lastId}`)
            .then(data => data.json())
            .then(responseData => {
                const articles = responseData.data;
                for(const index in articles) {
                    const article = articles[index];

                    const html = `
                    <li class="flex">
                    <a class="w-[40px] hover:underline hover:text-[red]" href="/usr/article/detail/free/\${article.id}">\${article.id}</a>
                    <a class="flex-grow hover:underline hover:text-[red]" href="/usr/article/detail/free/\${article.id}">\${article.title}</a>
                    <a onclick="if ( !confirm('정말로 삭제하시겠습니까?') ) return false;" class="hover:underline hover:text-[red] mr-2" href="/usr/article/delete/free/\${article.id}?_method=DELETE">삭제</a>
                    <a class="hover:underline hover:text-[red]" href="/usr/article/modify/free/\${article.id}">수정</a>
                </li>
                    `;

                    $('.articles').append(html);
                }
                if(articles.length > 0) {
                    Articles_lastId = articles[articles.length - 1].id;
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
        <hr class="mt-3 mb-3">
    <button class="btn btn-sm" onclick="Articles_loadMore();">불러오기</button>
    </div>
</section>
<script>
    Articles_loadMore();
</script>

<%@ include file="../common/foot.jspf"%>