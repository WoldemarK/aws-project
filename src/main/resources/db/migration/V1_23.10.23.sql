create table Files
(
    id       int primary key generated by default as identity,
    location varchar(255) not null,
    fileName varchar(255) not null,
    status   varchar(50) default 'ACTIVE'

);
create table Users
(
    id         int primary key generated by default as identity,
    username   varchar(64)   not null unique,
    password   varchar(2048) not null,
    first_name varchar(64)   not null,
    last_name  varchar(64)   not null,
    status     varchar(50)            default 'ACTIVE',
    enabled    boolean       not null default false,
    role       varchar(32)   not null,
    create_at  timestamp,
    update_at  timestamp

);
create table Events
(

    id      int primary key generated by default as identity,
    file_id int,
    user_id int,
    status  varchar(50) default 'ACTIVE',
    foreign key (file_id) references files (id),
    foreign key (user_id) references users (id)

);