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

CREATE TABLE `AStore`.`category`
(
  `id`   INT(11)     NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `AStore`.`product`
(
  `id`          INT(11)        NOT NULL AUTO_INCREMENT,
  `category_id` INT(11)        NOT NULL,
  `wallet_id`   INT(11)        NOT NULL,
  `name`        VARCHAR(45)    NOT NULL,
  `description` TEXT           NOT NULL,
  `cost`        DECIMAL(11, 5) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `category_id_product_fk_idx` (`category_id` ASC) VISIBLE,
  INDEX `wallet_id_product_fk_idx` (`wallet_id` ASC) VISIBLE,
  CONSTRAINT `category_id_product_fk`
    FOREIGN KEY (`category_id`)
      REFERENCES `AStore`.`category` (`id`)
      ON DELETE CASCADE
      ON UPDATE NO ACTION,
  CONSTRAINT `wallet_id_product_fk`
    FOREIGN KEY (`wallet_id`)
      REFERENCES `AStore`.`wallet` (`id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);

CREATE TABLE `AStore`.`subscription`
(
  `id`             INT(11)    NOT NULL AUTO_INCREMENT,
  `prod_id`        INT(11)    NOT NULL,
  `user_wallet_id` INT(11)    NOT NULL,
  `start`          DATE       NOT NULL,
  `end`            DATE       NOT NULL,
  `is_active`      TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `prod_id_sub_fk_idx` (`prod_id` ASC) VISIBLE,
  INDEX `user_wallet_id_sub_fk_idx` (`user_wallet_id` ASC) VISIBLE,
  CONSTRAINT `prod_id_sub_fk`
    FOREIGN KEY (`prod_id`)
      REFERENCES `AStore`.`product` (`id`)
      ON DELETE CASCADE
      ON UPDATE NO ACTION,
  CONSTRAINT `user_wallet_id_sub_fk`
    FOREIGN KEY (`user_wallet_id`)
      REFERENCES `AStore`.`wallet` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);
