create table temperature (
        id bigint generated by default as identity (start with 1),
        timestamp timestamp not null,
        value double not null,
        primary key (id)
    )