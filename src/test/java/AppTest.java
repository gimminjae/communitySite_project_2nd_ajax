import com.ll.exam.article.dto.ArticleDto;
import com.ll.exam.util.Ut;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    void Test_assertThat() {
        int rs = 10 + 30;

        assertThat(rs).isEqualTo(40);
    }
    @Test
    void Test_ObjectMapper() throws Exception {
        ArticleDto articleDto = new ArticleDto(1, "title1", "body1");

        String rs = Ut.json.toJsonStr(articleDto, "");

        assertThat(rs).isEqualTo("""
                {"id":1,"title":"title1","body":"body1"}
                """.trim());
    }
}
