package com.ll.exam.article;

import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleRepository {
    private static List<ArticleDto> datum;
    private static long lastId;

    static {
        datum = new ArrayList<>();
        lastId = 0;

        makeTestData();
    }

    private static void makeTestData() { //테스트 데이터 생성
        IntStream.rangeClosed(1, 10).forEach(id -> {
            String title = "제목%d".formatted(id);
            String body = "내용%d".formatted(id);
            write(title, body);
        });
    }

    public static long write(String title, String body) {
        long id = ++lastId;
        ArticleDto newArticleDto = new ArticleDto(id, title, body);

        datum.add(newArticleDto);

        return id;
    }

    public List<ArticleDto> findAll() {
        return datum;
    }

    public ArticleDto findById(long id) {
        for(ArticleDto ad : datum) {
            if(ad.getId() == id) {
                return ad;
            }
        }
        return null;
    }


    public long delete(long id) {
                ArticleDto ad = findById(id);
                datum.remove(ad);
                return id;
    }

    public void modify(long id, String title, String body) {
        ArticleDto articleDto = findById(id);

        if(articleDto == null) return;

        articleDto.setTitle(title);
        articleDto.setBody(body);
    }

    public List<ArticleDto> findAllGreaterThan(int fromId) {
        return datum.stream().filter(o -> o.getId() > fromId).toList();
    }
}