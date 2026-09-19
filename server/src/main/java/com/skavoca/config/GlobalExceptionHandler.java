package com.skavoca.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage()));

        Map<String, Object> response = body(HttpStatus.BAD_REQUEST, "Validation failed");
        response.put("errors", errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String, Object>> handleAccessDenied(AccessDeniedException ex) {
        return respond(HttpStatus.FORBIDDEN, "권한이 없습니다. (데모 계정은 읽기 전용입니다)");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleAllExceptions(Exception ex) {
        String message = ex.getMessage() != null ? ex.getMessage() : "";

        if (message.contains("not found")) {
            return respond(HttpStatus.NOT_FOUND, message);
        }
        if (message.contains("Invalid email or password") || message.contains("token")
                || message.contains("Account locked")) {
            return respond(HttpStatus.UNAUTHORIZED, message);
        }
        if (message.contains("Email already in use") || message.contains("Invalid auth code")) {
            return respond(HttpStatus.BAD_REQUEST, message);
        }

        // 내부 오류 내용(SQL, 스택 정보 등)은 클라이언트에 노출하지 않고 서버 로그에만 남긴다
        log.error("Unhandled exception", ex);
        return respond(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류가 발생했습니다.");
    }

    private ResponseEntity<Map<String, Object>> respond(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(body(status, message));
    }

    private Map<String, Object> body(HttpStatus status, String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", status.value());
        response.put("error", status.getReasonPhrase());
        response.put("message", message);
        return response;
    }
}
