DROP DATABASE IF EXISTS blog;

CREATE DATABASE blog;

use blog;

-- 创建users表存储管理员用户信息
CREATE TABLE user
(
    id    INT PRIMARY KEY AUTO_INCREMENT,                                         -- 用户ID，主键，自增
    username   VARCHAR(50)  NOT NULL UNIQUE COMMENT '用户名，唯一，不为空',              -- 用户名
    email      VARCHAR(100) NOT NULL UNIQUE COMMENT '邮箱，唯一，不为空',                -- 邮箱
    password   VARCHAR(100) NOT NULL COMMENT '密码，不为空',                            -- 密码
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间，自动记录当前时间' -- 创建时间
);

-- 创建categories表存储文章分类信息
CREATE TABLE categories
(
    id INT PRIMARY KEY AUTO_INCREMENT,                -- 分类ID，主键，自增
    name        VARCHAR(50) NOT NULL COMMENT '分类名称，不为空' -- 分类名称
);

-- 创建articles表存储文章信息
CREATE TABLE articles
(
    id     INT PRIMARY KEY AUTO_INCREMENT,                                                              -- 文章ID，主键，自增
    user_id     INT                  NOT NULL COMMENT '作者ID，不为空',                                       -- 作者ID
    title       VARCHAR(255)         NOT NULL COMMENT '文章标题，不为空',                                     -- 文章标题
    category_id INT                  NOT NULL COMMENT '文章分类，不为空',                                     -- 文章分类ID，不为空，表示文章应属于一个分类
    tag_id      INT COMMENT '文章标签，可为空，表示文章可以没有标签',                                          -- 文章标签ID，可为空，表示文章可以没有标签
    content     TEXT                 NOT NULL COMMENT '文章内容，不为空',                                     -- 文章内容
    status      ENUM ('0', '1', '2') NOT NULL DEFAULT '0' COMMENT '文章状态：草稿、已发布、回收站，默认为草稿',  -- 文章状态
    created_time  TIMESTAMP                     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间，自动记录当前时间', -- 创建时间
    updated_time  TIMESTAMP                     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间, 自动记录当前时间',
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,                                      -- 外键，关联到users表的user_id字段，级联删除
    FOREIGN KEY (category_id) REFERENCES categories (id)                                            -- 外键，关联到categories表的category_id字段，级联设置为空
);

-- 创建tags表存储文章标签信息
CREATE TABLE tags
(
    tag_id INT PRIMARY KEY AUTO_INCREMENT,                -- 标签ID，主键，自增
    name   VARCHAR(50) NOT NULL COMMENT '标签名称，不为空' -- 标签名称
);

-- 创建comments表存储文章评论信息
CREATE TABLE comments
(
    id INT PRIMARY KEY AUTO_INCREMENT,                                          -- 评论ID，主键，自增
    user_id    INT  NOT NULL COMMENT '评论者ID，不为空',                                 -- 评论者ID
    article_id    INT  NOT NULL COMMENT '文章ID，不为空',                                   -- 文章ID
    content    TEXT NOT NULL COMMENT '评论内容，不为空',                                 -- 评论内容
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间，自动记录当前时间', -- 创建时间
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,                 -- 外键，关联到users表的user_id字段，级联删除
    FOREIGN KEY (article_id) REFERENCES articles (id) ON DELETE CASCADE               -- 外键，关联到posts表的post_id字段，级联删除
);
