import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    void Test_assertThat() {
        int rs = 10 + 30;

        assertThat(rs).isEqualTo(40);
    }
}
