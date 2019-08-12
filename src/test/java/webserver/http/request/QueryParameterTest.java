package webserver.http.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueryParameterTest {

    @DisplayName("query string parse test")
    @Test
    void querystring_parse_test() {
        QueryParameter queryParameter = new QueryParameter("userId=javajigi&password=password&name=JaeSung");

        assertThat(queryParameter.getParameter("userId")).isEqualTo("javajigi");
        assertThat(queryParameter.getParameter("password")).isEqualTo("password");
        assertThat(queryParameter.getParameter("name")).isEqualTo("JaeSung");
    }

    @DisplayName("query string parse test query string의 value 값이 없는 경우 null 반환")
    @Test
    void querystring_parse_test_without_value() {
        QueryParameter queryParameter = new QueryParameter("userId=");

        assertThat(queryParameter.getParameter("userId")).isEqualTo(null);
    }
}