import com.fasterxml.jackson.core.type.TypeReference;
import com.ll.exam.article.dto.ArticleDto;
import com.ll.exam.util.Ut;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    void Test_assertThat() {
        int rs = 10 + 30;

        assertThat(rs).isEqualTo(40);
    }
    @Test
    void Test_ObjectMapper_toJsonStr() throws Exception {
        ArticleDto articleDto = new ArticleDto(1, "title1", "body1");

        String rs = Ut.json.toJsonStr(articleDto, "");

        assertThat(rs).isEqualTo("""
                {"id":1,"title":"title1","body":"body1"}
                """.trim());
    }
    @Test
    void Test_ObjectMapper_toObj() {
        ArticleDto articleDto = new ArticleDto(1, "title1", "body1");

        String jsonStr = Ut.json.toJsonStr(articleDto, "");

        ArticleDto resultArticleDto = Ut.json.toObj(jsonStr, ArticleDto.class, null);

        assertThat(resultArticleDto).isEqualTo(articleDto);
    }
    @Test
    void Test_ObjectMapper_mapToJsonStr() {
        Map<String, ArticleDto> articleDtoMap = new HashMap<>();
        articleDtoMap.put("가장 오래된", new ArticleDto(1, "title1", "body1"));
        articleDtoMap.put("최신의", new ArticleDto(2, "title2", "body2"));

        String jsonStr = Ut.json.toJsonStr(articleDtoMap, "");

        assertThat(jsonStr).isEqualTo("""
                {"가장 오래된":{"id":1,"title":"title1","body":"body1"},"최신의":{"id":2,"title":"title2","body":"body2"}}
                """.trim());
    }
    @Test
    void Test_ObjectMapper_listToJsonStr() {
        List<ArticleDto> articleDtoList = new LinkedList<>();
        articleDtoList.add(new ArticleDto(1, "title1", "body1"));
        articleDtoList.add(new ArticleDto(2, "title2", "body2"));

        String jsonStr = Ut.json.toJsonStr(articleDtoList, "");

        assertThat(jsonStr).isEqualTo("""
                [{"id":1,"title":"title1","body":"body1"},{"id":2,"title":"title2","body":"body2"}]
                """.trim());
    }
    @Test
    void Test_ObjectMapper_jsonStrToList() {
        List<ArticleDto> articleDtoList = new LinkedList<>();
        articleDtoList.add(new ArticleDto(1, "title1", "body1"));
        articleDtoList.add(new ArticleDto(2, "title2", "body2"));

        String jsonStr = Ut.json.toJsonStr(articleDtoList, "");

        List<ArticleDto> articleDtoList2 = Ut.json.toObj(jsonStr, new TypeReference<>() {}, null);
        assertThat(articleDtoList2).isEqualTo(articleDtoList);
    }
    @Test
    void Test_ObjectMapper_jsonStrToMap() {
        Map<String, ArticleDto> articleDtoMap = new HashMap<>();
        articleDtoMap.put("가장 오래된", new ArticleDto(1, "title1", "body1"));
        articleDtoMap.put("최신의", new ArticleDto(2, "title2", "body2"));

        String jsonStr = Ut.json.toJsonStr(articleDtoMap, "");

        Map<String, ArticleDto> articleDtoMap2 = Ut.json.toObj(jsonStr, new TypeReference<>() {}, null);

        assertThat(articleDtoMap2).isEqualTo(articleDtoMap);
    }
}
