create table feriado
(
    feriado_id     int auto_increment primary key,
    title       varchar(100) not null,
    type       varchar(20) not null,
    inalienable      int           null,
    extra       varchar(20) not null,
   
);
create table users
(
    user_id    binary(16)   not null primary key,
    bio        varchar(500)  null,
    created_at datetime(6)  not null,
    email      varchar(30)  not null,
    image      varchar(100) null,
    password   varchar(200) not null,
    username   varchar(30)  not null,
    constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email),
    constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username)
);



