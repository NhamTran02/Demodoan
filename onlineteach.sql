CREATE DATABASE onlineteach;
USE onlineteach;

-- Bảng Users
CREATE TABLE tbl_users (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           username VARCHAR(100) NOT NULL,
                           email VARCHAR(50) NOT NULL,
                           password VARCHAR(50) NOT NULL,
                           phone_number VARCHAR(11) NOT NULL,
                           role_id INT,
                           create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                           update_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                           FOREIGN KEY (role_id) REFERENCES tbl_roles(id)
);

-- Bảng Roles
CREATE TABLE tbl_roles (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           name VARCHAR(20) NOT NULL,
                           description TEXT
);

-- Bảng Categories
CREATE TABLE tbl_categories (
                                id INT PRIMARY KEY AUTO_INCREMENT,
                                name VARCHAR(100) NOT NULL
);

-- Bảng Courses
CREATE TABLE tbl_courses (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             title VARCHAR(100) NOT NULL,
                             description TEXT,
                             image VARCHAR(255),
                             category_id INT,
                             create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                             update_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             FOREIGN KEY (category_id) REFERENCES tbl_categories(id) ON DELETE CASCADE
);

-- Bảng Chapters
CREATE TABLE tbl_chapters (
                              id INT PRIMARY KEY AUTO_INCREMENT,
                              course_id INT,
                              name VARCHAR(100) NOT NULL,
                              quantity INT,
                              FOREIGN KEY (course_id) REFERENCES tbl_courses(id) ON DELETE CASCADE
);

-- Bảng Lessons
CREATE TABLE tbl_lessons (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             chapter_id INT,
                             title VARCHAR(100) NOT NULL,
                             video_url VARCHAR(255) NOT NULL,
                             create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                             update_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             FOREIGN KEY (chapter_id) REFERENCES tbl_chapters(id) ON DELETE CASCADE
);

-- Bảng Enrollments (Đăng ký khóa học)
CREATE TABLE tbl_enrollments (
                                 id INT PRIMARY KEY AUTO_INCREMENT,
                                 user_id INT,
                                 course_id INT,
                                 create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                                 FOREIGN KEY (user_id) REFERENCES tbl_users(id),
                                 FOREIGN KEY (course_id) REFERENCES tbl_courses(id)
);

-- Bảng Course Reviews (Đánh giá khóa học)
CREATE TABLE tbl_course_reviews (
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    course_id INT,
                                    user_id INT,
                                    rating INT CHECK (rating >= 1 AND rating <= 5),
                                    comment TEXT,
                                    create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                                    FOREIGN KEY (course_id) REFERENCES tbl_courses(id),
                                    FOREIGN KEY (user_id) REFERENCES tbl_users(id)
);

-- Bảng Quizzes (Bài kiểm tra)
CREATE TABLE tbl_quizzes (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             course_id INT,
                             title VARCHAR(100) NOT NULL,
                             questions TEXT, -- Có thể lưu câu hỏi dưới dạng JSON hoặc văn bản
                             create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                             update_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             FOREIGN KEY (course_id) REFERENCES tbl_courses(id) ON DELETE CASCADE
);

-- Bảng Progress (Tiến độ học viên)
CREATE TABLE tbl_progress (
                              id INT PRIMARY KEY AUTO_INCREMENT,
                              user_id INT,
                              course_id INT,
                              lesson_id INT,
                              status ENUM('COMPLETED', 'IN-PROGRESS') NOT NULL,
                              create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                              update_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                              FOREIGN KEY (user_id) REFERENCES tbl_users(id),
                              FOREIGN KEY (course_id) REFERENCES tbl_courses(id),
                              FOREIGN KEY (lesson_id) REFERENCES tbl_lessons(id)
);

-- Bảng Payments (Thanh toán)
CREATE TABLE tbl_payments (
                              id INT PRIMARY KEY AUTO_INCREMENT,
                              user_id INT,
                              course_id INT,
                              amount DECIMAL(10, 2) NOT NULL,
                              status ENUM('PENDING', 'COMPLETED', 'FAILED') NOT NULL,
                              method_payment ENUM('CREDIT_CARD', 'CASH') NOT NULL,
                              create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                              FOREIGN KEY (user_id) REFERENCES tbl_users(id),
                              FOREIGN KEY (course_id) REFERENCES tbl_courses(id)
);

-- Bảng Forums (Diễn đàn)
CREATE TABLE tbl_forums (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            user_id INT,
                            title VARCHAR(255) NOT NULL,
                            content TEXT,
                            create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                            update_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                            FOREIGN KEY (user_id) REFERENCES tbl_users(id)
);

-- Bảng Notifications (Thông báo)
CREATE TABLE tbl_notifications (
                                   id INT PRIMARY KEY AUTO_INCREMENT,
                                   user_id INT,
                                   title TEXT,
                                   message TEXT,
                                   is_read BOOLEAN DEFAULT FALSE,
                                   create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                                   FOREIGN KEY (user_id) REFERENCES tbl_users(id)
);

-- Bảng Tokens
CREATE TABLE tbl_tokens (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            email VARCHAR(255),
                            create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                            update_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                            access_token VARCHAR(255),
                            refresh_token VARCHAR(255)
);

-- Các câu lệnh SELECT
SELECT * FROM tbl_users;
SELECT * FROM tbl_tokens;
SELECT * FROM tbl_roles;
SELECT * FROM tbl_notifications;
SELECT * FROM tbl_forums;
SELECT * FROM tbl_payments;
