package Korcp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseJsonWriter {
    private static final ObjectMapper objMapper = new ObjectMapper();

    public static void writeJSON(HttpServletResponse response, Object obj) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.write(objMapper.writeValueAsString(obj));
        }
    }

    public static String writeJSON(Object obj) throws IOException {
        return objMapper.writeValueAsString(obj);
    }
}
