INSERT INTO AStore.role (id, name)
VALUES (1, 'admin'),
       (2, 'content_manager'),
       (3, 'user');

INSERT INTO AStore.user (id, username, password, role_id)
VALUES (1, 'Aslan', 'Aslan', 1),
       (2, 'Alex', 'Alex', 2),
       (3, 'Roman', 'Roman', 3),
       (4, 'Ivan', 'Ivan', 3);

INSERT INTO AStore.userinfo (id, name, dateofbirth, user_id)
VALUES (1, 'Aslan', '2000-08-22', 1),
       (2, 'Alex', '1999-05-12', 2),
       (3, 'Roman', '2000-02-04', 3),
       (4, 'Ivan', '1998-11-27', 4);

INSERT INTO AStore.wallet (id, userid, name, description, value)
VALUES (1, 1, 'First', 'First wallet of admin Aslan', 330),
       (2, 1, 'Second', 'Second wallet of admin Aslan', 127),
       (3, 2, 'Wallet', 'First wallet of content manager Alex', 507),
       (4, 3, 'Romha', 'First wallet of user Roman', 400),
       (5, 4, 'Ivanov', 'A wallet of user Ivan', 394.5);
