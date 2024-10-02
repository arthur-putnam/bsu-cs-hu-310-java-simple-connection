use examples;


DROP TABLE java_users;

CREATE TABLE java_users(
	id int auto_increment,
    first_name varchar(80),
    last_name  varchar(80),
    date_joined DATE DEFAULT (CURRENT_DATE),
    primary key (id)
);

INSERT INTO java_users (first_name, last_name) VALUES ('Arthur', 'Putnam'), ('Katrina', 'Fuller'), ('Reb', 'Revals');


SELECT * FROM java_users;