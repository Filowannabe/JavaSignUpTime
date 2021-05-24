use store;

CREATE TABLE `users` (
`username` char(255) PRIMARY KEY NOT NULL,
`password` char(255) NOT NULL,
`phone` char(255) NOT NULL,
`mail` char(255) NOT NULL
);