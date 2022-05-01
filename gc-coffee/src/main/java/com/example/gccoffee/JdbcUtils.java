package com.example.gccoffee;

import java.nio.ByteBuffer;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public class JdbcUtils {
    public static LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }

    public static UUID toUUID(byte[] bytes) {
        var bytesBuffer = ByteBuffer.wrap(bytes);
        return new UUID(bytesBuffer.getLong(), bytesBuffer.getLong());
    }

}
