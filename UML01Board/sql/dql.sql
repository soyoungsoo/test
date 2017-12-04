SELECT * FROM user_info;
SELECT * FROM user_type;
SELECT * FROM user_info_type;
SELECT * FROM board;

SELECT user_info_type.user_info_email, user_type.id, user_type.type
FROM user_info_type, user_type
WHERE user_type.id = user_info_type.user_type_id;

SELECT u.email, u.password, u.name, u.avatar, ut.id, ut.type
FROM user_info u,
	(SELECT user_info_type.user_info_email, user_type.id, user_type.type
	FROM user_info_type, user_type
	WHERE user_type.id = user_info_type.user_type_id) ut
WHERE u.email = ut.user_info_email;

SELECT u.email, u.password, u.name, u.avatar, ut.id, ut.type
FROM user_info u,
	(SELECT user_info_type.user_info_email, user_type.id, user_type.type
	FROM user_info_type, user_type
	WHERE user_type.id = user_info_type.user_type_id) ut
WHERE u.email = ut.user_info_email AND u.email = 'admin@koitt.com';

SELECT * FROM user_type WHERE user_type.id = 1;