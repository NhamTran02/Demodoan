package com.example.demodoan.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    CATEGORY_NOT_FOUND("Không tìm thấy category!"),
    COURSE_NOT_FOUND("Không tìm thấy course!"),
    USER_NOT_FOUND("Không tìm thấy user"),
    CHAPTER_NOT_FOUND("Không tìm thấy chương!"),
    PAYMENT_NOT_FOUND("Không tìm thấy payment !"),
    YOU_MUST_LOGIN("Bạn phải đăng nhập mới có thể sử dụng được chức năng này!"),
    LESSON_NOT_FOUND("Không tìm thấy bài học!"),
    QUIZZE_NOT_FOUND("Không tìm thấy quizze!"),
    ROLE_NOT_FOUND("Không tìm thấy role!"),
    EMAIL_EXISTS("Email đã tồn tại!"),
    USERNAME_EXISTS("Username đã tồn tại!"),
    EMAIL_NOT_FOUND("Không tìm thấy email!"),
    REGISTER_ACCOUNT_ADMIN("Bạn không thể đăng ký tài khoàn admin"),
    INVALID_LOGIN("Email hoặc mật khẩu không đúng!"),
    TOKEN_IS_NOT_BLANK("Token không đc trống"),
    TOKEN_IS_INVALID("Token không hợp lệ"),
    TOKEN_NOT_EXISTS("Token không tồn tại!");

    private String message;
}
