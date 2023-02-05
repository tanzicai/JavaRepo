CREATE TABLE user
    (
        id VARCHAR(32) NOT NULL
            PRIMARY KEY COMMENT '用户ID',
        username VARCHAR(64) NOT NULL COMMENT '用户名',
        nickname VARCHAR(64) NULL COMMENT '用户昵称',
        password VARCHAR(64) NOT NULL COMMENT '加密后的密码',
        gender VARCHAR(255) NULL COMMENT '性别',
        locked tinyint(1) DEFAULT 0 NOT NULL COMMENT '是否锁定，1-是，0-否',
        enabled tinyint(1) DEFAULT 1 NOT NULL COMMENT '是否可用，1-是，0-否',
        last_login_ip VARCHAR(64) NULL COMMENT '最后登录IP',
        last_login_time datetime(6) NULL COMMENT '最后登录IP',
        created_time datetime(6) NOT NULL COMMENT '创建时间',
        updated_time datetime(6) NOT NULL COMMENT '更新时间',
        CONSTRAINT uk_user_username
            UNIQUE (username)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '用户表';

CREATE TABLE role
(
    id VARCHAR(32) NOT NULL
        PRIMARY KEY COMMENT '角色ID',
    name VARCHAR(128) NULL COMMENT '角色名称',
    title VARCHAR(128) NULL COMMENT '角色标识',
    created_time datetime(6) NOT NULL COMMENT '创建时间',
    updated_time datetime(6) NOT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '角色表';

CREATE TABLE user_role
(
    user_id VARCHAR(32) NOT NULL COMMENT '用户ID',
    role_id VARCHAR(32) NOT NULL COMMENT '角色ID',
    CONSTRAINT c_user_id
        FOREIGN KEY (user_id) REFERENCES user (id),
    CONSTRAINT c_role_id
        FOREIGN KEY (role_id) REFERENCES role (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '用户角色表';

INSERT INTO `user` (id, username, nickname, password, created_time, updated_time)
VALUES ('1', 'admin', '谭自财', '$2a$10$t/9Fu1/5zDt/0XUbxoFYP.bzaLNOz5Apr8J6QIFDh9IDsaKSGB7xa',
        '2021-07-21 09:27:12.260000',
        '2021-07-21 09:27:12.260000');
INSERT INTO `role` (id, name, title, created_time, updated_time)
VALUES ('1', 'ROLE_USER', '普通用户', '2021-07-21 09:27:12.260000', '2021-07-21 09:27:12.260000');
INSERT INTO `role` (id, name, title, created_time, updated_time)
VALUES ('2', 'ROLE_ADMIN', '超级管理员', '2021-07-21 09:27:12.260000', '2021-07-21 09:27:12.260000');
INSERT INTO `user_role` (user_id, role_id)
VALUES ('1', '1');
INSERT INTO `user_role` (user_id, role_id)
VALUES ('1', '2');

CREATE TABLE music
(
    id VARCHAR(32) NOT NULL
        PRIMARY KEY COMMENT '歌曲ID',
    name VARCHAR(64) NOT NULL COMMENT '歌曲名',
    description TEXT NULL COMMENT '歌曲简介',
    status VARCHAR(32) DEFAULT 'DRAFT' NOT NULL COMMENT '歌曲上架状态，DRAFT-草稿，PUBLISHED-已上架，CLOSED-已下架',
    created_time datetime(6) NOT NULL COMMENT '创建时间',
    updated_time datetime(6) NOT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '歌曲表';

CREATE TABLE file
(
    `id` VARCHAR(32) NOT NULL
        PRIMARY KEY COMMENT '文件ID',
    `name` VARCHAR(64) NOT NULL COMMENT '文件名',
    `file_key` VARCHAR(64) NOT NULL COMMENT '文件hash值，即ObjectKey',
    `ext` VARCHAR(12) NOT NULL COMMENT '文件后缀名',
    `size` INT DEFAULT 0 NOT NULL COMMENT '文件大小；单位byte',
    `type` VARCHAR(32) DEFAULT 'OTHER' NOT NULL COMMENT '文件类型，AUDIO-音频，IMAGE-图片，VIDEO-视频，OTHER-其他',
    `storage` VARCHAR(16) DEFAULT 'COS' NOT NULL COMMENT '存储供应商，COS-腾讯云存储，OSS-阿里云存储',
    `status` VARCHAR(32) DEFAULT 'UPLOADING' NOT NULL COMMENT '文件状态，UPLOADING-上传中，UPLOADED-已上传，CANCEL-已取消',
    `created_time` datetime(6) NOT NULL COMMENT '创建时间',
    `updated_time` datetime(6) NOT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '文件表';

ALTER TABLE `music`
    ADD COLUMN `file_id` VARCHAR(32) NULL COMMENT '音乐文件ID' AFTER `description` ,
        ADD CONSTRAINT `c_music_file_id`
        FOREIGN KEY (`file_id`) REFERENCES `file`(`id`);

CREATE TABLE playlist
(
    `id` VARCHAR(32) NOT NULL
        PRIMARY KEY COMMENT '歌单ID',
    `name` VARCHAR(64) NOT NULL COMMENT '歌单名字',
    `description` TEXT NULL COMMENT '歌单简介',
    `cover_id` VARCHAR(32) NULL COMMENT '歌单封面ID',
    `status` VARCHAR(32) DEFAULT 'DRAFT' NOT NULL COMMENT '歌单上架状态，DRAFT-草稿，PUBLISHED-已上架，CLOSED-已下架',
    `created_time` datetime(6) NOT NULL COMMENT '创建时间',
    `updated_time` datetime(6) NOT NULL COMMENT '更新时间',
    CONSTRAINT c_cover_id
        FOREIGN KEY (cover_id) REFERENCES `file` (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '歌单表';

CREATE TABLE playlist_music
(
    `playlist_id` VARCHAR(32) NOT NULL COMMENT '歌单ID',
    `music_id` VARCHAR(32) NOT NULL COMMENT '歌曲ID',
    CONSTRAINT c_playlist_id
        FOREIGN KEY (playlist_id) REFERENCES `playlist` (id),
    CONSTRAINT c_music_id
        FOREIGN KEY (music_id) REFERENCES `music` (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '歌单歌曲表';

ALTER TABLE `file`
    ADD COLUMN `created_by_user_id` VARCHAR(32) NOT NULL DEFAULT '1'  COMMENT '创建者用户ID' AFTER `status` ,
        ADD CONSTRAINT `c_created_by_user_id`
        FOREIGN KEY (`created_by_user_id`) REFERENCES `user`(`id`);

ALTER TABLE `file`
    ADD COLUMN `updated_by_user_id` VARCHAR(32) NOT NULL DEFAULT '1' COMMENT '更新者用户ID' AFTER `created_by_user_id` ,
        ADD CONSTRAINT `c_updated_by_user_id`
        FOREIGN KEY (`updated_by_user_id`) REFERENCES `user`(`id`);

CREATE TABLE artist
(
    `id` VARCHAR(32) NOT NULL
        PRIMARY KEY COMMENT '歌手ID',
    `name` VARCHAR(64) NOT NULL COMMENT '歌手名字',
    `remark` VARCHAR(128) NULL COMMENT '歌手备注',
    `photo_id` VARCHAR(32) NULL COMMENT '歌手照片ID',
    `status` VARCHAR(32) DEFAULT 'DRAFT' NOT NULL COMMENT '歌手上架状态，DRAFT-草稿，PUBLISHED-已上架，BLOCKED-已封禁',
    `created_by_user_id` VARCHAR(32) NOT NULL COMMENT '创建人ID',
    `updated_by_user_id` VARCHAR(32) NOT NULL COMMENT '最后更新人ID',
    `created_time` datetime(6) NOT NULL COMMENT '创建时间',
    `updated_time` datetime(6) NOT NULL COMMENT '更新时间',
    CONSTRAINT artist_photo_id
        FOREIGN KEY (photo_id) REFERENCES `file` (id),
    CONSTRAINT artist_created_by_user_id
        FOREIGN KEY (created_by_user_id) REFERENCES `user` (id),
    CONSTRAINT artist_updated_by_user_id
        FOREIGN KEY (updated_by_user_id) REFERENCES `user` (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '歌手表';

CREATE TABLE artist_music
(
    `artist_id` VARCHAR(32) NOT NULL COMMENT '歌手ID',
    `music_id` VARCHAR(32) NOT NULL COMMENT '歌曲ID',
    CONSTRAINT artist_music_artist_id
        FOREIGN KEY (artist_id) REFERENCES `artist` (id),
    CONSTRAINT artist_music_music_id
        FOREIGN KEY (music_id) REFERENCES `music` (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '歌手歌曲关联表';

ALTER TABLE `artist`
    ADD COLUMN `recommended` TINYINT(1) NOT NULL DEFAULT 0  COMMENT '是否推荐：推荐：1； 不推荐：0；默认：0'  AFTER `status`;
ALTER TABLE `artist`
    ADD COLUMN `recommend_factor` INT NOT NULL DEFAULT 0  COMMENT '推荐因数：越高越在上面' AFTER `recommended`;

ALTER TABLE `playlist`
    ADD COLUMN `recommended` TINYINT(1) NOT NULL DEFAULT 0  COMMENT '是否推荐：推荐：1； 不推荐：0；默认：0'  AFTER `status`,
    ADD COLUMN `recommend_factor` INT NOT NULL DEFAULT 0  COMMENT '推荐因数：越高越在上面' AFTER `recommended`;

ALTER TABLE `playlist`
    ADD COLUMN `created_by_user_id` VARCHAR(32) NOT NULL DEFAULT '1'  COMMENT '创建者用户ID' AFTER `status` ,
        ADD CONSTRAINT `playlist_created_by_user_id`
        FOREIGN KEY (`created_by_user_id`) REFERENCES `user`(`id`);

ALTER TABLE `playlist`
    ADD COLUMN `updated_by_user_id` VARCHAR(32) NOT NULL DEFAULT '1' COMMENT '更新者用户ID' AFTER `created_by_user_id` ,
        ADD CONSTRAINT `playlist_updated_by_user_id`
        FOREIGN KEY (`updated_by_user_id`) REFERENCES `user`(`id`);

ALTER TABLE `playlist`
    ADD COLUMN `special` TINYINT(1) NOT NULL DEFAULT 0  COMMENT '是否特色歌单：特色歌单：1； 否则：0；默认：0'  AFTER `recommended`;

CREATE TABLE `album`
(
    `id` VARCHAR(32) NOT NULL
        PRIMARY KEY COMMENT '专辑ID',
    `name` VARCHAR(64) NOT NULL COMMENT '专辑名字',
    `description` TEXT NULL COMMENT '专辑简介',
    `cover_id` VARCHAR(32) NULL COMMENT '专辑封面ID',
    `status` VARCHAR(32) DEFAULT 'DRAFT' NOT NULL COMMENT '专辑上架状态，DRAFT-草稿，PUBLISHED-已上架，BLOCKED-已封禁',
    `created_by_user_id` VARCHAR(32) NOT NULL COMMENT '创建人ID',
    `updated_by_user_id` VARCHAR(32) NOT NULL COMMENT '最后更新人ID',
    `created_time` datetime(6) NOT NULL COMMENT '创建时间',
    `updated_time` datetime(6) NOT NULL COMMENT '更新时间',
    CONSTRAINT album_cover_id
        FOREIGN KEY (cover_id) REFERENCES `file` (id),
    CONSTRAINT album_created_by_user_id
        FOREIGN KEY (created_by_user_id) REFERENCES `user` (id),
    CONSTRAINT album_updated_by_user_id
        FOREIGN KEY (updated_by_user_id) REFERENCES `user` (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '专辑表';

CREATE TABLE `album_music`
(
    `album_id` VARCHAR(32) NOT NULL COMMENT '专辑ID',
    `music_id` VARCHAR(32) NOT NULL COMMENT '歌曲ID',
    CONSTRAINT album_music_album_id
        FOREIGN KEY (album_id) REFERENCES `album` (id),
    CONSTRAINT album_music_music_id
        FOREIGN KEY (music_id) REFERENCES `music` (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '专辑歌曲表';


CREATE TABLE `album_artist`
(
    `album_id` VARCHAR(32) NOT NULL COMMENT '专辑ID',
    `artist_id` VARCHAR(32) NOT NULL COMMENT '歌手ID',
    CONSTRAINT album_artist_album_id
        FOREIGN KEY (album_id) REFERENCES `album` (id),
    CONSTRAINT album_artist_artist_id
        FOREIGN KEY (artist_id) REFERENCES `artist` (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '专辑歌手';

ALTER TABLE `album`
    ADD COLUMN `recommended` TINYINT(1) NOT NULL DEFAULT 0  COMMENT '是否推荐：推荐：1； 不推荐：0；默认：0'  AFTER `status`;
ALTER TABLE `album`
    ADD COLUMN `recommend_factor` INT NOT NULL DEFAULT 0  COMMENT '推荐因数：越高越在上面' AFTER `recommended`;