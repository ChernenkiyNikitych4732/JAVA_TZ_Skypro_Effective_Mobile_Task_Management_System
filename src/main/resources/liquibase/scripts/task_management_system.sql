-- Создание таблицы пользователей
CREATE TABLE IF NOT EXISTS Users (
                                     user_id BIGSERIAL PRIMARY KEY,
                                     username VARCHAR(50) UNIQUE,
                                     password VARCHAR(100),
                                     email VARCHAR(100) UNIQUE,
                                     role VARCHAR(20) CHECK (role IN ('администратор/admin', 'пользователь/user')),
                                     name VARCHAR(50),
                                     surname VARCHAR(50)
);

-- Создание таблицы задач
CREATE TABLE IF NOT EXISTS Tasks (
                                     task_id BIGSERIAL PRIMARY KEY,
                                     title VARCHAR(255),
                                     description TEXT,
                                     status VARCHAR(50) CHECK (status IN ('новая/new', 'в ожидании/pending', 'в процесее/in_progress', 'выплолнено/completed')),
                                     priority VARCHAR(50) CHECK (priority IN ('высокий/high', 'средний/medium', 'низкий/low')),
                                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     creator_id BIGINT,
                                     executor_id BIGINT,
                                     FOREIGN KEY (creator_id) REFERENCES users(user_id),
                                     FOREIGN KEY (executor_id) REFERENCES users(user_id)
);

-- Создание таблицы комментариев
CREATE TABLE IF NOT EXISTS Comments (
                                        comment_id BIGSERIAL PRIMARY KEY,
                                        task_id BIGINT,
                                        user_id BIGINT,
                                        comment TEXT,
                                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                        FOREIGN KEY (task_id) REFERENCES tasks(task_id),
                                        FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Создание таблицы ролей
CREATE TABLE IF NOT EXISTS Roles (
                                     role_id BIGSERIAL PRIMARY KEY,
                                     role_name VARCHAR(50) UNIQUE
);

-- Создание таблицы пользователей-ролей
CREATE TABLE IF NOT EXISTS User_roles (
                                          user_id BIGINT,
                                          role_id BIGINT,
                                          PRIMARY KEY (user_id, role_id),
                                          FOREIGN KEY (user_id) REFERENCES users(user_id),
                                          FOREIGN KEY (role_id) REFERENCES roles(role_id)
);