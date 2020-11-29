SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

DROP DATABASE IF EXISTS `system_dev_exam_app`;
CREATE SCHEMA IF NOT EXISTS `system_dev_exam_app` DEFAULT CHARACTER SET utf8 ;
USE `system_dev_exam_app` ;

CREATE TABLE IF NOT EXISTS `system_dev_exam_app`.`articles`(
`article_id` INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
`category` VARCHAR(15) NOT NULL,
`title` VARCHAR(200) NOT NULL,
`body` VARCHAR(10000) NOT NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `system_dev_exam_app`.`comments`(
`comment_id` INT UNSIGNED PRIMARY KEY UNIQUE AUTO_INCREMENT,
`comment` VARCHAR(150) NOT NULL,
`article_id` INT,
	CONSTRAINT `article_id_fk` FOREIGN KEY (`article_id`)
	REFERENCES `system_dev_exam_app`.`articles` (`article_id`) ON DELETE SET NULL ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `system_dev_exam_app`.`users`(
`user_id` INT UNSIGNED PRIMARY KEY UNIQUE AUTO_INCREMENT,
`email` VARCHAR(70),
`password` VARCHAR(20),
`permission` VARCHAR(15))
ENGINE = InnoDB;

INSERT INTO `system_dev_exam_app`.`articles` VALUES
(1, 'Tech', 'Procastrination and it''s advantages', 'So today I was talking with Dorin and did not do anything for the rest of the day.'),
(2, 'Tech', '400 years ago, visitors to this painted cave took hallucinogens', 'In a study published today in Proceedings of the National
 Academy of Sciences, an international research team reports that 400-year-old chewed-up wads of datura, a plant with powerful psychoactive 
 properties, have been found stuffed into the cracks of the ceiling of a sacred cave. Located near the edge of the traditional territory of
 the Chumash people, the cavern had been dubbed Pinwheel Cave after the swirling red painting on its curved ceiling. Researchers think this
 artwork might represent a datura flower, which unfurls in a pinwheel shape at dusk, and that the site
 may have been a place for group ceremonies where datura was consumed.'),
(3, 'Modelling', 'COVID-19 has been smoldering in rural America for months. Here’s why we missed it.', 'A dangerous combination of limited 
resources, stigma, and politics made the coronavirus difficult to track in rural areas, allowing its spread to go largely unnoticed all summer.
THE HOUSES IN Chevak spring from an open sweep of tundra and lakes. The small community in western Alaska, near the mouth of the Yukon River, 
is accessible only by plane. Yet in the last several weeks, almost a quarter of its roughly 1,000 residents have tested positive for coronavirus.
For months, health officials had hoped Alaska’s rural villages would be protected by their isolation. But the state now ranks among the worst 15 
in the country in per capita case rate. So many Alaskans are sick that officials are falling behind with logging data, so the state may only
 be accounting for half the true cases, according to Alaska Public Media.'),
(4, 'Modelling', '''Echo Mapping'' in Faraway Galaxies Could Measure Vast Cosmic Distances', 'Measuring the luminosity of a celestial object is
 challenging, especially with black holes, which don''t emit light. But the supermassive black holes that lie at the center of most galaxies
 provide a loophole: They often pull lots of matter around them, forming hot disks that can radiate brightly. Measuring the luminosity of a bright
 disk would allow astronomers to gauge the distance to the black hole and the galaxy it lives in. Distance measurements not only help scientists 
 create a better, three-dimensional map of the universe, they can also provide information about how and when objects formed.

In a new study, astronomers used a technique that some have nicknamed "echo mapping" to measure the luminosity of black hole disks 
in over 500 galaxies. Published last month in the Astrophysical Journal, the study adds support to the idea that this approach could be used to
measure the distances between Earth and these faraway galaxies.'),
(5, 'Tech', 'Mirror Quadrants for XRISM', 'The X-ray Imaging and Spectroscopy Mission (XRISM, pronounced “crism”) is a collaboration between 
the Japan Aerospace Exploration Agency (JAXA) and NASA, along with ESA participation, to investigate the X-ray universe using high-resolution
imaging and spectroscopy. XRISM features two instruments: Resolve, an X-ray calorimeter spectrometer, and Xtend, an X-ray imager.

These images, taken in June 2019, show completed elements of one XRISM flight X-ray Mirror Assembly (XMA). Each XMA includes both a primary
 and a secondary mirror. Each mirror has four quadrants with 203 nested foil mirror segments apiece, for a total of 1,624 mirror segments in one XMA.

NASA’s Goddard Space Flight Center developed the X-ray Mirror Assemblies, as well as the Resolve detector and many of its subsystems. 
XRISM is expected to launch in early 2022.'),
(6, 'Modelling', 'Black Hole Fails to Do Its Job', 'Astronomers have discovered what can happen when a giant black hole does not intervene in the
 life of a galaxy cluster. Using NASA’s Chandra X-ray Observatory and other telescopes they have shown that passive black hole behavior may explain
 a remarkable torrent of star formation occurring in a distant cluster of galaxies.

Galaxy clusters contain hundreds or thousands of galaxies pervaded by hot, X-ray emitting gas that outweighs the combined mass of all the galaxies. 
Ejections of material powered by a supermassive black hole in the cluster’s central galaxy usually prevent this hot gas from cooling to form vast
 numbers of stars. This heating allows supermassive black holes to influence or control the activity and evolution of their host cluster.

But what happens if that black hole stops being active? The galaxy cluster SpARCS104922.6+564032.5 (SpARCS1049 for short) located 9.9 billion light
 years away from Earth is supplying one answer.

Based on observations from NASA’s Hubble Space Telescope and Spitzer Space Telescope, astronomers had previously discovered stars were forming at 
an extraordinary rate of about 900 new Suns worth of mass per year in SpARCS1049. This is over 300 times faster than the rate at which our galaxy, 
the Milky Way, is forming its stars.  (At the rate seen in SpARCS1049, all of the stars in the Milky Way could form in just 100 million years,
 which is a short period of time compared to our Galaxy’s age of more than ten billion years.)'),
(7, 'Tech', 'Runaway Star Might Explain Black Hole''s Disappearing Act', 'At the center of a far-off galaxy, a black hole is slowly consuming
 a disk of gas that swirls around it like water circling a drain. As a steady trickle of gas is pulled into the gaping maw, ultrahot particles
 gather close to the black hole, above and below the disk, generating a brilliant X-ray glow that can be seen 300 million light-years away on Earth. 
 These collections of ultrahot gas, called black hole coronas, have been known to exhibit noticeable changes in their luminosity,
 brightening or dimming by up to 100 times as a black hole feeds.

But two years ago, astronomers watched in awe as X-rays from the black hole corona in a galaxy known as 1ES 1927+654 disappeared completely,
 fading by a factor of 10,000 in about 40 days. Almost immediately it began to rebound, and about 100 days later had become almost
 20 times brighter than before the event.

The X-ray light from a black hole corona is a direct byproduct of the black hole''s feeding, so the disappearance of that light from
 1ES 1927+654 likely means that its food supply had been cut off. In a new study in the Astrophysical Journal Letters, scientists hypothesize
 that a runaway star might have come too close to the black hole and been torn apart. If this was the case, fast-moving debris from the star
 could have crashed through part of the disk, briefly dispersing the gas.'),
(8, 'Modelling', 'How SpaceX became NASA''s go-to ride into orbit', 'In 2006, during SpaceX’s first launch attempt on Omelek, a Falcon 1 rocket
 carrying a U.S. Air Force Academy satellite experienced an engine failure about 30 seconds after liftoff, sending the rocket careening into
 the ocean and the satellite crashing into a storage shed on the island.

A year later, a Falcon 1 carrying a dummy payload spun out of control just before reaching orbit. The third attempt in August 2008, with
 a Falcon 1 carrying two small satellites for NASA and one for the Department of Defense (as well as cremated remains of astronaut 
 Gordon Cooper and Star Trek actor James Doohan), ended in a fiery failure when two parts of the rocket, known as the first and second stage,
 crashed into each other after they separated.

The fourth time was finally the charm: Just eight weeks after their third failure and once again carrying a dummy payload, the successful launch
 of a Falcon 1 from Omelek Island made SpaceX the first company to send a privately funded liquid-fueled rocket into orbit.');

INSERT INTO `system_dev_exam_app`.`comments` VALUES
(1, 'I think that this is false because I have experienced something different', 1),
(2, 'Love it <3', 1),
(3, 'Good luck next!', 1),
(4, 'You are so cute ;)', 1);

INSERT INTO `system_dev_exam_app`.`users` VALUES
(1, 'admin@gmail.com', 'admin', 'ADMIN'),
(2, 'owner@gmail.com', 'owner', 'OWNER'),
(3, 'rob.williams@yahoo.com', 'robbingyou', 'USER'),
(4, 'bob.fischer@gmail.com', 'fishnchips', 'USER');

