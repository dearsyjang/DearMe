INSERT INTO USER(created_at, updated_at, id, pw, nick_name, gender, type, birth, email, real_file_name, file_name, points, refresh_token)
VALUES (now(), now(), 'test1', 'test1', 'test1', 'FEMALE' ,'USER', '2021-01-01', 'test1@test', 'test', 'test', 0, 'refreshToken');

INSERT INTO USER(created_at, updated_at, id, pw, nick_name, gender, type, birth, email, real_file_name, file_name, points, refresh_token)
VALUES (now(), now(), 'test2', 'test2', 'test2', 'MALE' ,'USER', '2021-01-01', 'test2@test', 'test', 'test', 0, 'refreshToken');

INSERT INTO USER(created_at, updated_at, id, pw, nick_name, gender, type, birth, email, real_file_name, file_name, points, refresh_token)
VALUES (now(), now(), 'test3', 'test3', 'test3', 'FEMALE' ,'USER', '2021-01-01', 'test3@test', 'test', 'test', 0, 'refreshToken');

INSERT INTO USER(created_at, updated_at, id, pw, nick_name, gender, type, birth, email, real_file_name, file_name, points, refresh_token)
VALUES (now(), now(), 'test4', 'test4', 'test4', 'MALE' ,'USER', '2021-01-01', 'test4@test', 'test', 'test', 0, 'refreshToken');

INSERT INTO USER(created_at, updated_at, id, pw, nick_name, gender, type, birth, email, real_file_name, file_name, points, refresh_token)
VALUES (now(), now(), 'test5', 'test5', 'test5', 'MALE' ,'USER', '2021-01-01', 'test5@test', 'test', 'test', 0, 'refreshToken');

INSERT INTO USER(created_at, updated_at, id, pw, nick_name, gender, type, birth, email, real_file_name, file_name, points, refresh_token)
VALUES (now(), now(), 'test6', 'test6', 'test6', 'MALE' ,'COUNSELOR', '2021-01-01', 'test6@test', 'test', 'test', 0, 'refreshToken');

INSERT INTO USER(created_at, updated_at, id, pw, nick_name, gender, type, birth, email, real_file_name, file_name, points, refresh_token)
VALUES (now(), now(), 'test7', 'test7', 'test7', 'MALE' ,'COUNSELOR', '2021-01-01', 'test7@test', 'test', 'test', 0, 'refreshToken');

INSERT INTO USER(created_at, updated_at, id, pw, nick_name, gender, type, birth, email, real_file_name, file_name, points, refresh_token)
VALUES (now(), now(), 'test8', 'test8', 'test8', 'MALE' ,'COUNSELOR', '2021-01-01', 'test8@test', 'test', 'test', 0, 'refreshToken');

INSERT INTO USER(created_at, updated_at, id, pw, nick_name, gender, type, birth, email, real_file_name, file_name, points, refresh_token)
VALUES (now(), now(), 'test9', 'test9', 'test9', 'MALE' ,'COUNSELOR', '2021-01-01', 'test9@test', 'test', 'test', 0, 'refreshToken');

INSERT INTO USER(created_at, updated_at, id, pw, nick_name, gender, type, birth, email, real_file_name, file_name, points, refresh_token)
VALUES (now(), now(), 'test10', 'test10', 'test10', 'MALE' ,'COUNSELOR', '2021-01-01', 'test10@test', 'test', 'test', 0, 'refreshToken');

INSERT INTO COUNSELOR_PROFILE(counselor_id, created_at, updated_at, introduce, price, reviewcnt, reviewvalue)
VALUES(6, now(), now(), 'hello6', 1000, 0, 0);

INSERT INTO COUNSELOR_PROFILE(counselor_id, created_at, updated_at, introduce, price, reviewcnt, reviewvalue)
VALUES(7, now(), now(), 'hello7', 5000, 0, 0);

INSERT INTO COUNSELOR_PROFILE(counselor_id, created_at, updated_at, introduce, price, reviewcnt, reviewvalue)
VALUES(8, now(), now(), 'hello8', 10000, 0, 0);

INSERT INTO COUNSELOR_PROFILE(counselor_id, created_at, updated_at, introduce, price, reviewcnt, reviewvalue)
VALUES(9, now(), now(), 'hello9', 15000, 0, 0);

INSERT INTO COUNSELOR_PROFILE(counselor_id, created_at, updated_at, introduce, price, reviewcnt, reviewvalue)
VALUES(10, now(), now(), 'hello10', 20000, 0, 0);

INSERT INTO CAREER(created_at, updated_at, contents, counselor_id)
VALUES(now(), now(), 'contents1', 6);

INSERT INTO CAREER(created_at, updated_at, contents, counselor_id)
VALUES(now(), now(), 'contents2', 6);

INSERT INTO CAREER(created_at, updated_at, contents, counselor_id)
VALUES(now(), now(), 'contents3', 6);

INSERT INTO CAREER(created_at, updated_at, contents, counselor_id)
VALUES(now(), now(), 'contents4', 6);

INSERT INTO CAREER(created_at, updated_at, contents, counselor_id)
VALUES(now(), now(), 'contents5', 6);

INSERT INTO CERTIFICATE(created_at, updated_at, contents, counselor_id)
VALUES(now(), now(), 'contents1', 6);

INSERT INTO CERTIFICATE(created_at, updated_at, contents, counselor_id)
VALUES(now(), now(), 'contents2', 6);

INSERT INTO CERTIFICATE(created_at, updated_at, contents, counselor_id)
VALUES(now(), now(), 'contents3', 6);

INSERT INTO CERTIFICATE(created_at, updated_at, contents, counselor_id)
VALUES(now(), now(), 'contents4', 6);

INSERT INTO CERTIFICATE(created_at, updated_at, contents, counselor_id)
VALUES(now(), now(), 'contents5', 6);

INSERT INTO CATEGORY(created_at, updated_at, contents, counselor_id)
VALUES(now(), now(), 'contents1', 6);

INSERT INTO CATEGORY(created_at, updated_at, contents, counselor_id)
VALUES(now(), now(), 'contents2', 6);

INSERT INTO CATEGORY(created_at, updated_at, contents, counselor_id)
VALUES(now(), now(), 'contents3', 6);

INSERT INTO CATEGORY(created_at, updated_at, contents, counselor_id)
VALUES(now(), now(), 'contents4', 6);

INSERT INTO CATEGORY(created_at, updated_at, contents, counselor_id)
VALUES(now(), now(), 'contents5', 6);

INSERT INTO GROUP(contents, price, title, counselor_id)
VALUES('contents1', 0, 'title1', 6);

INSERT INTO GROUP(contents, price, title, counselor_id)
VALUES('contents2', 0, 'title2', 6);

INSERT INTO GROUP(contents, price, title, counselor_id)
VALUES('contents3', 0, 'title3', 7);

INSERT INTO GROUP(contents, price, title, counselor_id)
VALUES('contents4', 0, 'title4', 7);

INSERT INTO GROUP(contents, price, title, counselor_id)
VALUES('contents5', 0, 'title5', 7);

INSERT INTO GROUP_USER(group_id, user_id)
VALUES(1, 1);

INSERT INTO GROUP_USER(group_id, user_id)
VALUES(2, 1);

INSERT INTO GROUP_USER(group_id, user_id)
VALUES(3, 1);

INSERT INTO GROUP_USER(group_id, user_id)
VALUES(4, 1);

INSERT INTO GROUP_USER(group_id, user_id)
VALUES(5, 1);

INSERT INTO GROUP_USER(group_id, user_id)
VALUES(1, 2);

INSERT INTO GROUP_USER(group_id, user_id)
VALUES(2, 2);

INSERT INTO GROUP_USER(group_id, user_id)
VALUES(3, 2);

INSERT INTO TEXT_DIARY(created_at, updated_at, contents, day, month, title, year, user_id)
VALUES(now(), now(), 'contents1', 1, 8, 'title1', 2022, 1);

INSERT INTO TEXT_DIARY(created_at, updated_at, contents, day, month, title, year, user_id)
VALUES(now(), now(), 'contents2', 2, 8, 'title2', 2022, 1);

INSERT INTO TEXT_DIARY(created_at, updated_at, contents, day, month, title, year, user_id)
VALUES(now(), now(), 'contents3', 3, 8, 'title3', 2022, 1);

INSERT INTO TEXT_DIARY(created_at, updated_at, contents, day, month, title, year, user_id)
VALUES(now(), now(), 'contents4', 4, 8, 'title4', 2022, 1);

INSERT INTO TEXT_DIARY(created_at, updated_at, contents, day, month, title, year, user_id)
VALUES(now(), now(), 'contents5', 5, 8, 'title5', 2022, 1);

INSERT INTO TEXT_DIARY(created_at, updated_at, contents, day, month, title, year, user_id)
VALUES(now(), now(), 'contents6', 6, 8, 'title6', 2022, 1);

INSERT INTO TEXT_DIARY(created_at, updated_at, contents, day, month, title, year, user_id)
VALUES(now(), now(), 'contents7', 7, 8, 'title7', 2022, 1);

INSERT INTO TEXT_DIARY(created_at, updated_at, contents, day, month, title, year, user_id)
VALUES(now(), now(), 'contents8', 8, 8, 'title8', 2022, 1);

INSERT INTO TEXT_DIARY(created_at, updated_at, contents, day, month, title, year, user_id)
VALUES(now(), now(), 'contents9', 8, 7, 'title9', 2022, 1);

INSERT INTO TEXT_DIARY(created_at, updated_at, contents, day, month, title, year, user_id)
VALUES(now(), now(), 'contents10', 9, 7, 'title10', 2022, 1);

INSERT INTO TEXT_DIARY(created_at, updated_at, contents, day, month, title, year, user_id)
VALUES(now(), now(), 'contents11', 10, 7, 'title11', 2022, 1);

INSERT INTO TEXT_DIARY(created_at, updated_at, contents, day, month, title, year, user_id)
VALUES(now(), now(), 'contents12', 11, 7, 'title12', 2022, 1);

INSERT INTO TEXT_DIARY(created_at, updated_at, contents, day, month, title, year, user_id)
VALUES(now(), now(), 'contents13', 12, 7, 'title13', 2022, 1);

INSERT INTO COUNSELING(day, month, type, year, counselor_id, user_id)
VALUES(1, 8, 'ACCEPTED', 2022, 6, 1);

INSERT INTO COUNSELING(day, month, type, year, counselor_id, user_id)
VALUES(2, 8, 'ACCEPTED', 2022, 6, 1);

INSERT INTO COUNSELING(day, month, type, year, counselor_id, user_id)
VALUES(3, 8, 'ACCEPTED', 2022, 6, 1);

INSERT INTO COUNSELING(day, month, type, year, counselor_id, user_id)
VALUES(4, 8, 'ACCEPTED', 2022, 6, 1);

INSERT INTO COUNSELING(day, month, type, year, counselor_id, user_id)
VALUES(5, 8, 'ACCEPTED', 2022, 6, 1);

INSERT INTO COUNSELING(day, month, type, year, counselor_id, user_id)
VALUES(6, 8, 'ACCEPTED', 2022, 6, 1);

INSERT INTO COUNSELING_DOCUMENT(contents, day, is_open, month, year, counseling_id, counselor_id, user_id)
VALUES('contents1', 1, 'FALSE', 8, 2022, 1, 6, 1);

INSERT INTO COUNSELING_DOCUMENT(contents, day, is_open, month, year, counseling_id, counselor_id, user_id)
VALUES('contents1', 2, 'FALSE', 8, 2022, 2, 6, 1);

INSERT INTO COUNSELING_DOCUMENT(contents, day, is_open, month, year, counseling_id, counselor_id, user_id)
VALUES('contents1', 3, 'FALSE', 8, 2022, 3, 6, 1);

INSERT INTO COUNSELING_DOCUMENT(contents, day, is_open, month, year, counseling_id, counselor_id, user_id)
VALUES('contents1', 4, 'FALSE', 8, 2022, 4, 6, 1);

INSERT INTO COUNSELING_DOCUMENT(contents, day, is_open, month, year, counseling_id, counselor_id, user_id)
VALUES('contents1', 5, 'FALSE', 8, 2022, 5, 6, 1);

INSERT INTO COUNSELING_DOCUMENT(contents, day, is_open, month, year, counseling_id, counselor_id, user_id)
VALUES('contents1', 6, 'FALSE', 8, 2022, 6, 6, 1);