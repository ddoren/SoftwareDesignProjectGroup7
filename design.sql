-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema system_dev_exam_app
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `system_dev_exam_app` ;

-- -----------------------------------------------------
-- Schema system_dev_exam_app
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `system_dev_exam_app` DEFAULT CHARACTER SET utf8 ;
USE `system_dev_exam_app` ;

-- -----------------------------------------------------
-- Table `system_dev_exam_app`.`articles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `system_dev_exam_app`.`articles` (
  `article_id` INT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(15) NOT NULL,
  `title` VARCHAR(200) NOT NULL,
  `body` VARCHAR(10000) NOT NULL,
  PRIMARY KEY (`article_id`),
  UNIQUE INDEX `article_id` (`article_id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `system_dev_exam_app`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `system_dev_exam_app`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(70) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `permission` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id` (`user_id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `system_dev_exam_app`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `system_dev_exam_app`.`comments` (
  `comment_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `comment` VARCHAR(150) NOT NULL,
  `article_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`comment_id`),
  UNIQUE INDEX `comment_id` (`comment_id` ASC) VISIBLE,
  INDEX `fk_comments_articles_idx` (`article_id` ASC) INVISIBLE,
  INDEX `fk_comments_users1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_comments_articles`
    FOREIGN KEY (`article_id`)
    REFERENCES `system_dev_exam_app`.`articles` (`article_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `system_dev_exam_app`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `system_dev_exam_app`.`articles`
-- -----------------------------------------------------
START TRANSACTION;
USE `system_dev_exam_app`;
INSERT INTO `system_dev_exam_app`.`articles` (`article_id`, `category`, `title`, `body`) VALUES (1, 'Tech', 'Procastrination and it\'s advantages', 'So today I was talking with Dorin and did not do anything for the rest of the day.');
INSERT INTO `system_dev_exam_app`.`articles` (`article_id`, `category`, `title`, `body`) VALUES (2, 'Modelling', 'COVID-19 has been smoldering in rural America for months. Here’s why we missed it.', 'A dangerous combination of limited \nresources, stigma, and politics made the coronavirus difficult to track in rural areas, allowing its spread to go largely unnoticed all summer.\nTHE HOUSES IN Chevak spring from an open sweep of tundra and lakes. The small community in western Alaska, near the mouth of the Yukon River, \nis accessible only by plane. Yet in the last several weeks, almost a quarter of its roughly 1,000 residents have tested positive for coronavirus.\nFor months, health officials had hoped Alaska’s rural villages would be protected by their isolation. But the state now ranks among the worst 15 \nin the country in per capita case rate. So many Alaskans are sick that officials are falling behind with logging data, so the state may only\n be accounting for half the true cases, according to Alaska Public Media.');
INSERT INTO `system_dev_exam_app`.`articles` (`article_id`, `category`, `title`, `body`) VALUES (3, 'Modelling', '\'Echo Mapping\' in Faraway Galaxies Could Measure Vast Cosmic Distances', 'Measuring the luminosity of a celestial object is\n challenging, especially with black holes, which don\'t emit light. But the supermassive black holes that lie at the center of most galaxies\n provide a loophole: They often pull lots of matter around them, forming hot disks that can radiate brightly. Measuring the luminosity of a bright\n disk would allow astronomers to gauge the distance to the black hole and the galaxy it lives in. Distance measurements not only help scientists \n create a better, three-dimensional map of the universe, they can also provide information about how and when objects formed.\n\nIn a new study, astronomers used a technique that some have nicknamed \"echo mapping\" to measure the luminosity of black hole disks \nin over 500 galaxies. Published last month in the Astrophysical Journal, the study adds support to the idea that this approach could be used to\nmeasure the distances between Earth and these faraway galaxies.');
INSERT INTO `system_dev_exam_app`.`articles` (`article_id`, `category`, `title`, `body`) VALUES (4, 'Tech', 'Mirror Quadrants for XRISM', 'The X-ray Imaging and Spectroscopy Mission (XRISM, pronounced “crism”) is a collaboration between \nthe Japan Aerospace Exploration Agency (JAXA) and NASA, along with ESA participation, to investigate the X-ray universe using high-resolution\nimaging and spectroscopy. XRISM features two instruments: Resolve, an X-ray calorimeter spectrometer, and Xtend, an X-ray imager.\n\nThese images, taken in June 2019, show completed elements of one XRISM flight X-ray Mirror Assembly (XMA). Each XMA includes both a primary\n and a secondary mirror. Each mirror has four quadrants with 203 nested foil mirror segments apiece, for a total of 1,624 mirror segments in one XMA.\n\nNASA’s Goddard Space Flight Center developed the X-ray Mirror Assemblies, as well as the Resolve detector and many of its subsystems. \nXRISM is expected to launch in early 2022.');
INSERT INTO `system_dev_exam_app`.`articles` (`article_id`, `category`, `title`, `body`) VALUES (5, 'Modelling', 'Black Hole Fails to Do Its Job', 'Astronomers have discovered what can happen when a giant black hole does not intervene in the\n life of a galaxy cluster. Using NASA’s Chandra X-ray Observatory and other telescopes they have shown that passive black hole behavior may explain\n a remarkable torrent of star formation occurring in a distant cluster of galaxies.\n\nGalaxy clusters contain hundreds or thousands of galaxies pervaded by hot, X-ray emitting gas that outweighs the combined mass of all the galaxies. \nEjections of material powered by a supermassive black hole in the cluster’s central galaxy usually prevent this hot gas from cooling to form vast\n numbers of stars. This heating allows supermassive black holes to influence or control the activity and evolution of their host cluster.\n\nBut what happens if that black hole stops being active? The galaxy cluster SpARCS104922.6+564032.5 (SpARCS1049 for short) located 9.9 billion light\n years away from Earth is supplying one answer.\n\nBased on observations from NASA’s Hubble Space Telescope and Spitzer Space Telescope, astronomers had previously discovered stars were forming at \nan extraordinary rate of about 900 new Suns worth of mass per year in SpARCS1049. This is over 300 times faster than the rate at which our galaxy, \nthe Milky Way, is forming its stars.  (At the rate seen in SpARCS1049, all of the stars in the Milky Way could form in just 100 million years,\n which is a short period of time compared to our Galaxy’s age of more than ten billion years.)');
INSERT INTO `system_dev_exam_app`.`articles` (`article_id`, `category`, `title`, `body`) VALUES (6, 'Tech', 'Runaway Star Might Explain Black Hole\'s Disappearing Act', 'At the center of a far-off galaxy, a black hole is slowly consuming\n a disk of gas that swirls around it like water circling a drain. As a steady trickle of gas is pulled into the gaping maw, ultrahot particles\n gather close to the black hole, above and below the disk, generating a brilliant X-ray glow that can be seen 300 million light-years away on Earth. \n These collections of ultrahot gas, called black hole coronas, have been known to exhibit noticeable changes in their luminosity,\n brightening or dimming by up to 100 times as a black hole feeds.\n\nBut two years ago, astronomers watched in awe as X-rays from the black hole corona in a galaxy known as 1ES 1927+654 disappeared completely,\n fading by a factor of 10,000 in about 40 days. Almost immediately it began to rebound, and about 100 days later had become almost\n 20 times brighter than before the event.\n\nThe X-ray light from a black hole corona is a direct byproduct of the black hole\'s feeding, so the disappearance of that light from\n 1ES 1927+654 likely means that its food supply had been cut off. In a new study in the Astrophysical Journal Letters, scientists hypothesize\n that a runaway star might have come too close to the black hole and been torn apart. If this was the case, fast-moving debris from the star\n could have crashed through part of the disk, briefly dispersing the gas.');
INSERT INTO `system_dev_exam_app`.`articles` (`article_id`, `category`, `title`, `body`) VALUES (7, 'Modelling', 'How SpaceX became NASA\'s go-to ride into orbit', 'In 2006, during SpaceX’s first launch attempt on Omelek, a Falcon 1 rocket\n carrying a U.S. Air Force Academy satellite experienced an engine failure about 30 seconds after liftoff, sending the rocket careening into\n the ocean and the satellite crashing into a storage shed on the island.\n\nA year later, a Falcon 1 carrying a dummy payload spun out of control just before reaching orbit. The third attempt in August 2008, with\n a Falcon 1 carrying two small satellites for NASA and one for the Department of Defense (as well as cremated remains of astronaut \n Gordon Cooper and Star Trek actor James Doohan), ended in a fiery failure when two parts of the rocket, known as the first and second stage,\n crashed into each other after they separated.\n\nThe fourth time was finally the charm: Just eight weeks after their third failure and once again carrying a dummy payload, the successful launch\n of a Falcon 1 from Omelek Island made SpaceX the first company to send a privately funded liquid-fueled rocket into orbit.');
INSERT INTO `system_dev_exam_app`.`articles` (`article_id`, `category`, `title`, `body`) VALUES (9, 'Modelling', 'TESTS3GIGA', 'GIGA');

COMMIT;


-- -----------------------------------------------------
-- Data for table `system_dev_exam_app`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `system_dev_exam_app`;
INSERT INTO `system_dev_exam_app`.`users` (`user_id`, `email`, `password`, `permission`) VALUES (1, 'admin@gmail.com', 'admin', 'ADMIN');
INSERT INTO `system_dev_exam_app`.`users` (`user_id`, `email`, `password`, `permission`) VALUES (2, 'owner@gmail.com', 'owner', 'OWNER');
INSERT INTO `system_dev_exam_app`.`users` (`user_id`, `email`, `password`, `permission`) VALUES (3, 'rob.williams@yahoo.com', 'robbingyou', 'USER');
INSERT INTO `system_dev_exam_app`.`users` (`user_id`, `email`, `password`, `permission`) VALUES (4, 'bob.fischer@gmail.com', 'fishnchips', 'USER');
INSERT INTO `system_dev_exam_app`.`users` (`user_id`, `email`, `password`, `permission`) VALUES (5, 'test@gmail.com', 'test', 'test');

COMMIT;


-- -----------------------------------------------------
-- Data for table `system_dev_exam_app`.`comments`
-- -----------------------------------------------------
START TRANSACTION;
USE `system_dev_exam_app`;
INSERT INTO `system_dev_exam_app`.`comments` (`comment_id`, `comment`, `article_id`, `user_id`) VALUES (1, 'I think that this is false because I have experienced something different', 1, 1);
INSERT INTO `system_dev_exam_app`.`comments` (`comment_id`, `comment`, `article_id`, `user_id`) VALUES (2, 'Love it <3', 1, 2);
INSERT INTO `system_dev_exam_app`.`comments` (`comment_id`, `comment`, `article_id`, `user_id`) VALUES (3, 'Good luck next!', 1, 2);
INSERT INTO `system_dev_exam_app`.`comments` (`comment_id`, `comment`, `article_id`, `user_id`) VALUES (4, 'You are so cute ;)', 2, 2);

COMMIT;

