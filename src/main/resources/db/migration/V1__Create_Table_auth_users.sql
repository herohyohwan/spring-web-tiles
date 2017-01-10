CREATE TABLE IF NOT EXISTS auth_users(
	id VARCHAR(20) NOT NULL,
	name VARCHAR(50) NOT NULL,
	employeeNo VARCHAR(20) NOT NULL,
	email VARCHAR(50) NOT NULL,
	teamName VARCHAR(50) NOT NULL,
	lastLoginTime datetime,
	updatedAt datetime,
	PRIMARY KEY(id)
);


INSERT INTO auth_users (
	id,
	name,
	employeeNo,
	email,
	teamName,
	updatedAt
) VALUES (
	'valentin',
	'lee',
	'',
	'valentin.lee@demo.com',
	'team1',
	now()
),
(
	'eva',
	'kang',
	'',
	'eva.kang@demo.com',
	'team2',
	now()
),
(
	'luigi',
	'yoon',
	'',
	'herohyohwan@gmail.com@demo.com',
	'team3',
	now()
)
;
