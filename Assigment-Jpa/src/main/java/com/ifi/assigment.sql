-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 06 Février 2018 à 19:37
-- Version du serveur :  10.1.19-MariaDB
-- Version de PHP :  5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `assigment`
--

-- --------------------------------------------------------

--
-- Structure de la table `activities`
--

CREATE TABLE `activities` (
  `activity_id` int(11) NOT NULL,
  `activity_code` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `other_details` varchar(225) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `activity_codes`
--

CREATE TABLE `activity_codes` (
  `activity_code` int(11) NOT NULL,
  `activity_description` varchar(225) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `cost_centers`
--

CREATE TABLE `cost_centers` (
  `cost_center_id` int(11) NOT NULL,
  `cost_center_name` varchar(125) COLLATE utf8_unicode_ci NOT NULL,
  `cost_center_decription` varchar(225) COLLATE utf8_unicode_ci NOT NULL,
  `other_details` varchar(225) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `employees`
--

CREATE TABLE `employees` (
  `employee_id` int(11) NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `other_details` varchar(225) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `employees`
--

INSERT INTO `employees` (`employee_id`, `start_date`, `end_date`, `other_details`) VALUES
(1, '3914-03-06 00:00:00', '3916-11-12 00:00:00', 'other details 1 is first'),
(2, '3914-03-06 00:00:00', '3916-11-12 00:00:00', 'other details 1 is first'),
(3, '3914-03-06 00:00:00', '3916-11-12 00:00:00', 'other details 1 is first'),
(4, '3914-03-06 00:00:00', '3916-11-12 00:00:00', 'other details 1 is first'),
(7, '3914-03-06 00:00:00', '3916-11-12 00:00:00', 'other details 1 is first'),
(8, '3914-03-06 00:00:00', '3916-11-12 00:00:00', 'other details 1 is first'),
(9, '2017-11-09 00:00:00', '2017-12-10 00:00:00', 'other details 1 is first'),
(10, '2017-11-09 00:00:00', '2017-12-10 00:00:00', 'other details 1 is first'),
(11, '2017-11-09 00:00:00', '2017-12-10 00:00:00', 'other details 1 is first');

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

CREATE TABLE `location` (
  `location_code` int(11) NOT NULL,
  `location_decription` varchar(225) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `location`
--

INSERT INTO `location` (`location_code`, `location_decription`) VALUES
(1, 'Airport'),
(2, 'Airport'),
(3, 'Airport'),
(4, 'Airport'),
(7, 'Airport'),
(8, 'Airport'),
(9, 'Airport'),
(10, 'Airport'),
(11, 'Airport');

-- --------------------------------------------------------

--
-- Structure de la table `projects`
--

CREATE TABLE `projects` (
  `project_id` int(11) NOT NULL,
  `location_code` int(11) NOT NULL,
  `project_mgr_employee_id` int(11) NOT NULL,
  `start_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `end_date` datetime NOT NULL,
  `other_details` varchar(225) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `timesheets`
--

CREATE TABLE `timesheets` (
  `timesheet_id` int(11) NOT NULL,
  `activity_id` int(11) NOT NULL,
  `authorised_by_employee_id` int(11) NOT NULL,
  `cost_center_id` int(11) NOT NULL,
  `timesheet_for_employee_id` int(11) NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `submitted_date` datetime NOT NULL,
  `other_details` varchar(225) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `activities`
--
ALTER TABLE `activities`
  ADD PRIMARY KEY (`activity_id`),
  ADD KEY `activity_code` (`activity_code`,`project_id`),
  ADD KEY `project_id` (`project_id`);

--
-- Index pour la table `activity_codes`
--
ALTER TABLE `activity_codes`
  ADD PRIMARY KEY (`activity_code`);

--
-- Index pour la table `cost_centers`
--
ALTER TABLE `cost_centers`
  ADD PRIMARY KEY (`cost_center_id`);

--
-- Index pour la table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`employee_id`);

--
-- Index pour la table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`location_code`);

--
-- Index pour la table `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`project_id`),
  ADD KEY `location_code` (`location_code`,`project_mgr_employee_id`),
  ADD KEY `project_mgr_employee_id` (`project_mgr_employee_id`);

--
-- Index pour la table `timesheets`
--
ALTER TABLE `timesheets`
  ADD PRIMARY KEY (`timesheet_id`),
  ADD KEY `activity_id` (`activity_id`,`authorised_by_employee_id`,`cost_center_id`,`timesheet_for_employee_id`),
  ADD KEY `authorised_by_employee_id` (`authorised_by_employee_id`),
  ADD KEY `cost_center_id` (`cost_center_id`),
  ADD KEY `timesheet_for_employee_id` (`timesheet_for_employee_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `activities`
--
ALTER TABLE `activities`
  MODIFY `activity_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `activity_codes`
--
ALTER TABLE `activity_codes`
  MODIFY `activity_code` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `cost_centers`
--
ALTER TABLE `cost_centers`
  MODIFY `cost_center_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `employees`
--
ALTER TABLE `employees`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT pour la table `location`
--
ALTER TABLE `location`
  MODIFY `location_code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT pour la table `projects`
--
ALTER TABLE `projects`
  MODIFY `project_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `timesheets`
--
ALTER TABLE `timesheets`
  MODIFY `timesheet_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `activities`
--
ALTER TABLE `activities`
  ADD CONSTRAINT `activities_ibfk_1` FOREIGN KEY (`activity_code`) REFERENCES `activity_codes` (`activity_code`),
  ADD CONSTRAINT `activities_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`);

--
-- Contraintes pour la table `projects`
--
ALTER TABLE `projects`
  ADD CONSTRAINT `projects_ibfk_1` FOREIGN KEY (`location_code`) REFERENCES `location` (`location_code`),
  ADD CONSTRAINT `projects_ibfk_2` FOREIGN KEY (`project_mgr_employee_id`) REFERENCES `employees` (`employee_id`);

--
-- Contraintes pour la table `timesheets`
--
ALTER TABLE `timesheets`
  ADD CONSTRAINT `timesheets_ibfk_1` FOREIGN KEY (`activity_id`) REFERENCES `activities` (`activity_id`),
  ADD CONSTRAINT `timesheets_ibfk_2` FOREIGN KEY (`authorised_by_employee_id`) REFERENCES `employees` (`employee_id`),
  ADD CONSTRAINT `timesheets_ibfk_3` FOREIGN KEY (`cost_center_id`) REFERENCES `cost_centers` (`cost_center_id`),
  ADD CONSTRAINT `timesheets_ibfk_4` FOREIGN KEY (`timesheet_for_employee_id`) REFERENCES `employees` (`employee_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
