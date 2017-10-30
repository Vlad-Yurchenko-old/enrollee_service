DROP DATABASE IF EXISTS `enrollee`;

CREATE DATABASE `enrollee` DEFAULT CHARACTER SET utf8;
USE `enrollee`;

CREATE TABLE `subject` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `univers` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `specialty` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `set` INTEGER NOT NULL,
  `univers_id` INTEGER NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (univers_id) REFERENCES univers(id)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `enrollee` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `sur_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `city` VARCHAR(255) NOT NULL,
  `gender` VARCHAR(255) NOT NULL,
  `specialty_id` INTEGER NOT NULL,
  `score` INTEGER NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (specialty_id) REFERENCES specialty(id)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `exam_scope` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `scope` INTEGER NOT NULL,
  `enrollee_id` INTEGER NOT NULL,
  `subject_id` INTEGER NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (enrollee_id) REFERENCES enrollee(id),
  FOREIGN KEY (subject_id) REFERENCES subject(id)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;



INSERT INTO `subject`
(`id`, `name`)
VALUES
  (1,    "ПЧМИ"),
  (2,    "АиСД"),
  (3,    "СОА");

INSERT INTO `univers`
(`id`, `city`, `name`)
VALUES
  (1, "Витебск", "ВГУ"),
  (2, "Витебск", "ВГТУ"),
  (3, "Витебск", "МЕД");


INSERT INTO `specialty`
(`id`, `name`, `set`, `univers_id`)
VALUES
  (1, "ПОКС", 33, 1),
  (2, "ПОИТ", 33, 1),
  (3, "Дебильная", 133, 2);

INSERT INTO `enrollee`
(`id`, `name`, `sur_name`, `last_name`,`city`, `gender`, `specialty_id`, `score`)
VALUES
  (1, "Юрченко", "Владислав", "Анатольевич", "Витебск", "м", 1, 326),
  (2, "Мысин", "Олег", "Юрьевич", "Боровка", "м", 1, 280),
  (3, "Маруневская", "Марина", "ХЗКТОТАКАЯ", "Витебск", "ж", 1, 326);

INSERT INTO `exam_scope`
(`id`, `scope`, `enrollee_id`, `subject_id`)
VALUES
  (1, 30, 1 ,3),
  (2, 31, 2 ,2),
  (3, 28, 3 ,1);

