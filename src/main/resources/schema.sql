DROP TABLE IF EXISTS notes;
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;


create table users(
                      id int auto_increment primary key,
                      username varchar_ignorecase(50) not null,
                      password varchar_ignorecase(50) not null,
                      enabled boolean not null
);
create table authorities (
                             user_id int not null,
                             authority varchar_ignorecase(50) not null,
                             constraint fk_authorities_users foreign key(user_id) references users(id)
);
create unique index ix_auth_username on authorities (user_id,authority);
