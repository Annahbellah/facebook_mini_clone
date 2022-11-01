create table user(
                     user_id int AUTO_INCREMENT PRIMARY KEY not null,
                     name varchar(50) NOT NULL,
                     email varchar(50) NOT NULL UNIQUE,
                     gender varchar (10) not null
)ENGINE=INNODB;

create table post(
                     post_id int AUTO_INCREMENT PRIMARY KEY not null,
                     text_body varchar(250) NOT NULL,
                     user_id int NOT NULL,
                     likes int,
                     foreign key (user_id),
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
)ENGINE=INNODB
/Users/mac/IdeaProjects/facebook-clone-app/src/main/java/dev/decagon/facebookcloneapp/model/User.java