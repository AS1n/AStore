CREATE SCHEMA `AStore`;

CREATE TABLE `AStore`.`role`
(
  `id`   INT         NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `AStore`.`user`
(
  `id`       INT         NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role_id`  INT         NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `roleid_fk_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `roleid_fk`
    FOREIGN KEY (`role_id`)
      REFERENCES `AStore`.`role` (`id`)
      ON DELETE CASCADE
      ON UPDATE NO ACTION
);

CREATE TABLE `AStore`.`userinfo`
(
  `id`          INT         NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(45) NOT NULL,
  `dateofbirth` DATE        NOT NULL,
  `user_id`     INT         NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_userinfo_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_userinfo_fk`
    FOREIGN KEY (`user_id`)
      REFERENCES `AStore`.`user` (`id`)
      ON DELETE CASCADE
      ON UPDATE NO ACTION
);

CREATE TABLE `AStore`.`wallet`
(
  `id`          INT            NOT NULL AUTO_INCREMENT,
  `userid`      INT            NOT NULL,
  `name`        VARCHAR(45)    NOT NULL,
  `description` TEXT           NOT NULL,
  `value`       DECIMAL(11, 5) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `userid_fk_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `userid_wallet_fk`
    FOREIGN KEY (`userid`)
      REFERENCES `AStore`.`user` (`id`)
      ON DELETE CASCADE
      ON UPDATE NO ACTION
);
