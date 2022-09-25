package webserver.http.domain.session;

import java.util.concurrent.ConcurrentHashMap;

public class SessionStorage {
    private static final ConcurrentHashMap<SessionId, HttpSession> storage = new ConcurrentHashMap<>();

    public static HttpSession getSession(SessionId sessionId) {
        if (sessionId == null || !storage.containsKey(sessionId)) {
            return null;
        }
        return storage.get(sessionId);
    }

    public static void add(HttpSession httpSession) {
        storage.put(httpSession.sessionId(), httpSession);
    }

    public static void remove(SessionId sessionId) {
        storage.remove(sessionId);
    }

    public static void invalidate() {
        storage.clear();
    }
}