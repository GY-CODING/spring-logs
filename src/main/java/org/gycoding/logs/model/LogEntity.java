package org.gycoding.logs.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class LogEntity {
    private String id;
    private String message;
    private LogLevel level;
    private String origin;
    private String timestamp;

    @Override
    public String toString() {
        return String.format(
                "[%s] - Log ID: %s\nMessage: %s\nLevel: %s\nOrigin: %s",
                timestamp, id, message, level, origin
        );
    }

    /**
     * Convert the log entity to a JSON string.
     * @return JSON string representation of the log entity.
     */
    public String toJSON() {
        return String.format(
                "{\"id\":\"%s\", \"message\":\"%s\", \"level\":\"%s\", \"origin\":\"%s\", \"timestamp\":\"%s\"}",
                id, message, level, origin, timestamp
        );
    }
}
