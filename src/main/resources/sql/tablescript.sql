create table user(
                     user_id int AUTO_INCREMENT PRIMARY KEY not null,
                     name varchar(50) NOT NULL,
                     email varchar(50) NOT NULL UNIQUE,
                     gender varchar (10) not null
)ENGINE=INNODB;

create table post(
                     post_id int AUTO_INCREMENT PRIMARY KEY not null,
                     text_body varchar(250) NOT NULL,
                     username varchar(50) not null,
                     user_id int NOT NULL,
                     likes int,
                     foreign key (user_id)
                     constraint fk_userPost

                             references user(user_id)
                             on update cascade
                             on delete cascade
)ENGINE=INNODB;

create table comment(
                        comment_id int AUTO_INCREMENT not null,
                        text_body varchar(250) NOT NULL,
                        post_id int not null,
                        user_id int NOT NULL,
                        likes int not null ,
                        primary key (comment_id)
                        constraint fk_postComment
                            foreign key (post_id)
                                references post(post_id)
                                on update cascade
                                on delete cascade
)ENGINE=INNODB;


CREATE TABLE login(
                      email varchar(50) not null,
                      password varchar(50),
                      user_id int not null unique,
                      primary key(email),
                      foreign key(user_id)references user(user_id)
                          on delete cascade
                          on update cascade
)ENGINE=INNODB;



DELIMITER @
DROP PROCEDURE IF EXISTS getLoginByEmail
@
CREATE PROCEDURE getLoginByEmail(IN emailid VARCHAR(50))
BEGIN
    SELECT * FROM login WHERE email=emailid;
END
@
DELIMITER ;


DELIMITER @
DROP PROCEDURE IF EXISTS getUserByEmail
@
CREATE PROCEDURE getUserByEmail(IN emailid VARCHAR(50))
BEGIN
    SELECT * FROM user WHERE email=emailid;
END
@
DELIMITER ;