CREATE TABLE `kategorien` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`bezeichnung` VARCHAR(200),
	PRIMARY KEY (`id`)
);

CREATE TABLE `produkte` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`bezeichnung` VARCHAR(200) NOT NULL UNIQUE,
	`kategorie_id` INT(10) UNSIGNED NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`kategorie_id`) REFERENCES `kategorien`(`id`) ON DELETE CASCADE
);

CREATE TABLE `benutzer` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`benutzername` VARCHAR(50) NOT NULL UNIQUE,
	`vorname` VARCHAR(100) NOT NULL,
	`nachname` VARCHAR(100) NOT NULL,
	`passwort` TEXT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `einkaufslisten` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`benutzer_id` INT(10) UNSIGNED NOT NULL,
	`titel` VARCHAR(100),
	PRIMARY KEY (`id`),
	FOREIGN KEY (`benutzer_id`) REFERENCES `benutzer`(`id`) ON DELETE CASCADE
);

CREATE TABLE `listeneintraege` (
	`listen_id` INT(10) UNSIGNED NOT NULL,
	`produkt_id` INT(10) UNSIGNED NOT NULL,
	`menge` INT(3) UNSIGNED NOT NULL DEFAULT 1,
	FOREIGN KEY (`listen_id`) REFERENCES `einkaufslisten`(`id`) ON DELETE CASCADE,
	FOREIGN KEY (`produkt_id`) REFERENCES `produkte`(`id`) ON DELETE CASCADE
);