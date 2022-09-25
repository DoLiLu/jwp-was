package webserver.http.domain;

import org.checkerframework.checker.units.qual.C;
import org.springframework.util.StringUtils;
import webserver.http.domain.session.HttpSession;
import webserver.http.domain.session.SessionId;
import webserver.http.domain.session.SessionStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static webserver.http.domain.session.SessionId.LOGIN_SESSION_ID;

public class RequestHeader {

    private static final String HEADER_DELIMITER = ": ";

    private final Map<String, String> headers = new HashMap<>();

    public void addRequestHeaders(BufferedReader br) throws IOException {
        String header = br.readLine();
        while (StringUtils.hasText(header)) {
            addHeader(header);
            header = br.readLine();
        }
    }

    public void addHeader(String header) {
        String[] split = header.split(HEADER_DELIMITER);
        this.headers.put(split[0], split[1]);
    }

    public String getValue(String name) {
        String value = headers.get(name);
        if (StringUtils.hasText(value)) {
            return value.trim();
        }
        return "";
    }

    public boolean loginCheck() {
        Cookie cookie = Cookie.getInstance();
        SessionId sessionId = cookie.sessionId("loginKey");
        HttpSession session = SessionStorage.getSession(sessionId);
        return session != null && session.getAttribute(LOGIN_SESSION_ID) != null;
    }

}
