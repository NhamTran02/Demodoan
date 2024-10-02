package com.example.demodoan.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    CATEGORY_NOT_FOUND("Không tìm thấy category!"),
    COURSE_NOT_FOUND("Không tìm thấy course!"),
    CHAPTER_NOT_FOUND("Không tìm thấy chương!"),
    PAYMENT_NOT_FOUND("Không tìm thấy payment !"),
    YOU_MUST_LOGIN("Bạn phải đăng nhập mới có thể sử dụng được chức năng này!"),
    LESSON_NOT_FOUND("Không tìm thấy bài học!"),
    QUIZZE_NOT_FOUND("Không tìm thấy quizze!"),
    ROLE_NOT_FOUND("Không tìm thấy role!"),
    EMAIL_EXISTS("Email đã tồn tại!"),
    EMAIL_NOT_FOUND("Không tìm thấy email!"),
    REGISTER_ACCOUNT_ADMIN("Bạn không thể đăng ký tài khoàn admin"),
    INVALID_LOGIN("Số điện thoại hoặc mật khẩu không đúng!");

    private String message;
}
