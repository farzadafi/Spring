create table public.student
(
    id             serial primary key,
    name           varchar(50) not null,
    student_number varchar(10) not null
);