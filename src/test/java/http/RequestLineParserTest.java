package http;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestLineParserTest {
    @Test
    void parse() {
        RequestLine requestLine = RequestLineParser.parse("GET /users HTTP/1.1");
        assertThat(requestLine.getMethod()).isEqualTo("GET");
        assertThat(requestLine.getPath()).isEqualTo("/users");
        assertThat(requestLine.getProtocol()).isEqualTo("HTTP");
        assertThat(requestLine.getVersion()).isEqualTo("1.1");
    }

    @Test
    void parse_post() {
        RequestLine requestLine = RequestLineParser.parse("POST /users HTTP/1.1");
        assertThat(requestLine.getMethod()).isEqualTo("POST");
        assertThat(requestLine.getPath()).isEqualTo("/usert");
        assertThat(requestLine.getProtocol()).isEqualTo("HTTP");
        assertThat(requestLine.getVersion()).isEqualTo("1.1");
    }
}