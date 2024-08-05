-- liquibase formatted sql
-- changeset han,kim:20230131032602_added_column_StdAdmin_isActivated_changelog


ALTER TABLE tbl_std_admin
    MODIFY is_activated bit DEFAULT false not null COMMENT '활성화여부';


alter table tbl_std_admin_authority
    add if not exists admin_id bigint not null comment '어드민ID' after id;

alter table tbl_std_admin_authority
    modify if exists admin_id bigint not null comment '어드민ID';


alter table tbl_std_admin_authority
    add constraint tbl_std_admin_authority_tbl_std_admin_id_fk
        foreign key (admin_id) references tbl_std_admin (id);






alter table tbl_std_admin_authority
    alter column is_deleted set default false;

alter table tbl_std_admin_authority
    alter column created_by set default SYSTEM_USER();

alter table tbl_std_admin_authority
    alter column created_date set default NOW();

alter table tbl_std_admin_authority
    alter column last_modified_by set default SYSTEM_USER();

alter table tbl_std_admin_authority
    alter column last_modified_date set default NOW();

alter table tbl_std_admin_authority
    modify id bigint auto_increment;

alter table tbl_std_admin_authority
    auto_increment = 1;


alter table tbl_std_admin
    alter column is_activated set default true;

--     default insert
INSERT INTO tbl_std_admin (id, admin_login_id, admin_password, admin_user_name, admin_phone_num, admin_email,
                           is_activated, is_deleted, created_by, created_date, last_modified_by,
                           last_modified_date)
VALUES (1, 'admin', '$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC', 'SYSTEM', '02-3452-3242',
        'admin@weedscomm.com', true, false, 'SYSTEM', now(), 'SYSTEM', now()),
       (2, 'user', '$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC', 'SYSTEM', '02-3452-3242',
        'user@weedscomm.com', true, false, 'SYSTEM', now(), 'SYSTEM', now());


INSERT INTO tbl_std_authority (id, authority_code, authority_name, authority_desc, is_activated, is_deleted, created_by,
                               created_date, last_modified_by, last_modified_date)
VALUES (1, 'ROLE_ADMIN', '어드민', null, true, false, 'SYSTEM', NOW(), 'SYSTEM', NOW()),
       (2, 'ROLE_USER', '사용자', null, true, false, 'SYSTEM', NOW(), 'SYSTEM', NOW());


INSERT INTO tbl_std_admin_authority (id, is_deleted, created_by, created_date, last_modified_by, last_modified_date,
                                     admin_id, authority_code_id)
VALUES (1, false, 'SYSTEM', NOW(), 'SYSTEM', NOW(), 1, 1),
       (2, false, 'SYSTEM', NOW(), 'SYSTEM', NOW(), 2, 2);
