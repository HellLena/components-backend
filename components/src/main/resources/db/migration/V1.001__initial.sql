create table unit_type (
    id bigserial primary key,
    "name" varchar(100) unique not null
);

create table unit (
    id bigserial primary key,
    unit_type_id int not null,
    decimal_name varchar(100) unique not null,
    created_at timestamp not null default current_timestamp(),
    updated_at timestamp,
    bomFileData varchar(255),
    bomFileName varchar(100),
    bomStatus varchar(25),
    foreign key (unit_type_id) references unit_type(id)
);

create table element_type (
    id bigserial primary key,
    "name" varchar(100) unique not null,
    status varchar(100) not null default "MODERATION"
);

create table manufacturer (
    id bigserial primary key,
    "name" varchar(100) unique not null,
    status varchar(100) not null default "MODERATION"
);

create table footprint (
    id bigserial primary key,
    "name" varchar(100) unique not null,
    status varchar(100) not null default "MODERATION"
);

create table "element" (
    id bigserial primary key,
    element_type_id int not null,
    manufacturer_id int,
    manufacturer_number varchar(100),
    description text not null,
    status varchar(100) not null default "MODERATION",
    unique (manufacturer_number, description),
    foreign key (element_type_id) references element_type(id),
    foreign key (manufacturer_id) references manufacturer(id)
);

create index idx_gin_description
    on "element" using gin(to_tsvector('russian', description));

create table "bom" (
    id bigserial primary key,
    unit_id int not null,
    designator varchar(10) not null,
    element_id int not null,
    footprint_id int,
    quantity int not null,
    fitted boolean not null,
    can_be_replaced boolean not null,
    status varchar(100) not null,
    unique (unit_id, designator),
    foreign key (unit_id) references unit(id),
    foreign key (element_id) references "element"(id),
    foreign key (footprint_id) references "footprint"(id)
);
