select * from my_app.user;

CREATE TABLE `audio` (
  `id` int(11) NOT NULL,
  `title` varchar(225) DEFAULT NULL,
  `author` varchar(225) DEFAULT NULL,
  `featuring` varchar(225) DEFAULT NULL,
  `genre` enum('PROG','ROCK','HEAVY','NEW_AGE','REGGAE','FOLK','SEGA','COUNTRY','CLASSIC','FLAMENCO') DEFAULT NULL,
  `audiotype` enum('CD','TAPE','VINYL') DEFAULT NULL,
  `duration` varchar(225) DEFAULT NULL,
  `audio_url` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(225) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SELECT * FROM my_app.user;


INSERT INTO audio (id,title,author,featuring,genre,audiotype,duration, audio_url) VALUES(1,"Tresspass","Genesis","Peter Gabriel",'PROG','CD',"80", "https://m.media-amazon.com/images/I/91ujObhVbDL._SS500_.jpg");
INSERT INTO audio (id,title,author,featuring,genre,audiotype,duration, audio_url) VALUES(2,"In the Court of Crimson King","King Crimson","Lake, Bruford,Fripp ", 'PROG','CD',"75", "https://m.media-amazon.com/images/I/81qqI9mMFnL._SS500_.jpg");
INSERT INTO audio (id,title,author,featuring,genre,audiotype,duration, audio_url) VALUES(3,"Black Sabbath","Black Sabbath","Osbourne",'HEAVY','VINYL',"65","https://m.media-amazon.com/images/I/81ZymMX0lcL._SS500_.jpg" );
INSERT INTO audio (id,title,author,featuring,genre,audiotype,duration, audio_url) VALUES(4,"Bad Motor Scotter","Montrose","Sammy Haggar, Montrose", 'HEAVY','CD',"80", "https://m.media-amazon.com/images/I/91xd9iNK+cL._SS500_.jpg");
INSERT INTO audio (id,title,author,featuring,genre,audiotype,duration, audio_url) VALUES(5,"Queen II","Queen","Mercury",'HEAVY','VINYL',"60", "https://m.media-amazon.com/images/I/71TQO-PbCgL._SS500_.jpg");
INSERT INTO audio (id,title,author,featuring,genre,audiotype,duration, audio_url) VALUES(6,"Night at the Opera","Queen","Mercury",'HEAVY','VINYL',"80", "https://m.media-amazon.com/images/I/713I8qLULWL._SS500_.jpg");
INSERT INTO audio (id,title,author,featuring,genre,audiotype,duration, audio_url) VALUES(7,"News of the world","Queen","Mercury",'HEAVY','VINYL',"75", "https://m.media-amazon.com/images/I/91+8gsRB3FL._SS500_.jpg");
INSERT INTO audio (id,title,author,featuring,genre,audiotype,duration, audio_url) VALUES(8,"Nursery Cryme","Genesis","Peter Gabriel",'PROG','TAPE',"80","https://m.media-amazon.com/images/I/81Gfpg4F4PL._SS500_.jpg");
INSERT INTO audio (id,title,author,featuring,genre,audiotype,duration, audio_url) VALUES(9,"Red","King Crimson","Lake, Bruford,Fripp",'PROG','CD',"80","https://m.media-amazon.com/images/I/61X+V1cnfhL._SS500_.jpg");
INSERT INTO audio (id,title,author,featuring,genre,audiotype,duration, audio_url) VALUES(10,"Lizard","King Crimson","Lake, Bruford,Fripp",'PROG','CD',"80", "https://m.media-amazon.com/images/I/81k5ig-1axL._SS500_.jpg");