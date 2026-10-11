/*
SQLyog Community v13.3.1 (64 bit)
MySQL - 10.4.32-MariaDB : Database - bookathon
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookathon` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `bookathon`;

/*Table structure for table `email_zadatak` */

DROP TABLE IF EXISTS `email_zadatak`;

CREATE TABLE `email_zadatak` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime_priloga` varchar(255) DEFAULT NULL,
  `kreirano` datetime DEFAULT NULL,
  `naslov` varchar(100) DEFAULT NULL,
  `poslat` bit(1) DEFAULT NULL,
  `poslatou` datetime DEFAULT NULL,
  `sadrzaj` text DEFAULT NULL,
  `primalac` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `email_zadatak` */

insert  into `email_zadatak`(`id`,`ime_priloga`,`kreirano`,`naslov`,`poslat`,`poslatou`,`sadrzaj`,`primalac`) values 
(8,NULL,'2026-09-09 21:46:56','Bookathon - Potvrda email adrese','','2026-09-09 21:47:06','Dobrodošli na Bookathon!\n\nKliknite na sledeći link da potvrdite svoju email adresu i dovršite registraciju:\n\nhttp://localhost:5173/verifikuj?token=994da15c-1c77-435a-af82-8eb7779f5c82\n\nAko niste vi zatražili registraciju, ignorišite ovaj mejl.','andrija.jelic40@gmail.com'),
(9,NULL,'2026-09-13 23:35:31','Potvrda porudžbine #4','','2026-09-13 23:35:36','Poštovani,\n\nVaša porudžbina #4 je uspešno kreirana\n\nUkupan iznos: 4000.0 RSD\n\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(10,NULL,'2026-09-13 23:39:52','Potvrda porudžbine #5','','2026-09-13 23:39:55','Poštovani,\n\nVaša porudžbina #5 je uspešno kreirana\n\nUkupan iznos: 5800.0 RSD\n\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(11,NULL,'2026-09-13 23:40:14','Potvrda porudžbine #6','','2026-09-13 23:40:25','Poštovani,\n\nVaša porudžbina #6 je uspešno kreirana\n\nUkupan iznos: 2100.0 RSD\n\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(12,NULL,'2026-09-14 00:43:24','Otpremnica OTPREMNICA-2026-002','','2026-09-14 00:43:27','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-002 kreirana ','andrija.jelic40@gmail.com'),
(13,NULL,'2026-09-14 10:21:43','Otpremnica OTPREMNICA-2026-003','','2026-09-14 10:21:48','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-003 kreirana ','andrija.jelic40@gmail.com'),
(14,NULL,'2026-09-14 11:19:19','Potvrda porudžbine #7','','2026-09-14 11:19:21','Poštovani,\n\nVaša porudžbina #7 je uspešno kreirana\n\nUkupan iznos: 7800.0 RSD\n\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(15,NULL,'2026-09-14 11:19:36','Otpremnica OTPREMNICA-2026-004','','2026-09-14 11:19:41','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-004 kreirana \nPregled poslatih knjiga: \nStranac ---- poslato 1 komada\nHobit ---- poslato 1 komada\nGospodar prstenova: Druzina prstena ---- poslato 1 komada\n','andrija.jelic40@gmail.com'),
(16,NULL,'2026-09-14 11:20:56','Otpremnica OTPREMNICA-2026-005','','2026-09-14 11:21:01','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-005 kreirana \nPregled poslatih knjiga: \nHobit ---- poslato 1 komada\nGospodar prstenova: Druzina prstena ---- poslato 2 komada\n','andrija.jelic40@gmail.com'),
(17,NULL,'2026-09-14 11:21:33','Otpremnica OTPREMNICA-2026-006','','2026-09-14 11:21:41','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-006 kreirana \nPregled poslatih knjiga: \n1984 ---- poslato 3 komada\n','andrija.jelic40@gmail.com'),
(19,NULL,'2026-09-14 11:59:18','Potvrda porudžbine #8','','2026-09-14 11:59:30','Poštovani,\n\nVaša porudžbina #8 je uspešno kreirana\n\nUkupan iznos: 16250.0 RSD\n\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(20,NULL,'2026-09-14 12:09:31','Potvrda porudžbine #9','','2026-09-14 12:09:41','Poštovani,\n\nVaša porudžbina #9 je uspešno kreirana\n\nUkupan iznos: 10050.0 RSD\n\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(21,NULL,'2026-09-14 12:24:28','Potvrda porudžbine #10','','2026-09-14 12:24:36','Poštovani,\n\nVaša porudžbina #10 je uspešno kreirana\n\nUkupan iznos: 8400.0 RSD\n\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(22,NULL,'2026-09-14 12:35:11','Otpremnica OTPREMNICA-2026-008','','2026-09-14 12:35:17','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-008 kreirana \nPregled poslatih knjiga: \nDervis i smrt ---- poslato 3 komada\n','andrija.jelic40@gmail.com'),
(23,NULL,'2026-09-14 12:35:43','Otpremnica OTPREMNICA-2026-009','','2026-09-14 12:35:47','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-009 kreirana \nPregled poslatih knjiga: \nBraca Karamazovi ---- poslato 3 komada\n','andrija.jelic40@gmail.com'),
(24,NULL,'2026-09-14 12:36:37','Otpremnica OTPREMNICA-2026-010','','2026-09-14 12:36:47','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-010 kreirana \nPregled poslatih knjiga: \nDervis i smrt ---- poslato 3 komada\n','andrija.jelic40@gmail.com'),
(25,NULL,'2026-09-14 12:37:58','Potvrda porudžbine #11','','2026-09-14 12:38:07','Poštovani,\n\nVaša porudžbina #11 je uspešno kreirana\n\nUkupan iznos: 6750.0 RSD\n\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(26,NULL,'2026-09-14 12:38:34','Otpremnica OTPREMNICA-2026-011','','2026-09-14 12:38:37','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-011 kreirana \nPregled poslatih knjiga: \nDervis i smrt ---- poslato 6 komada\n','andrija.jelic40@gmail.com'),
(27,NULL,'2026-09-14 12:40:06','Potvrda porudžbine #12','','2026-09-14 12:40:07','Poštovani,\n\nVaša porudžbina #12 je uspešno kreirana\n\nUkupan iznos: 6450.0 RSD\n\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(28,NULL,'2026-09-14 12:40:28','Otpremnica OTPREMNICA-2026-012','','2026-09-14 12:40:37','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-012 kreirana \nPregled poslatih knjiga: \nDervis i smrt ---- poslato 8 komada\n','andrija.jelic40@gmail.com'),
(29,NULL,'2026-09-14 12:50:59','Ispravka otpremnice OTPREMNICA-2026-012','','2026-09-14 12:51:07','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-012 koju ste ranije dobili imala grešku u sebi i otkazana je. Uskoro ćete dobiti ispravnu otpremnicu sa tačnim podacima.\n\nIzvinjavamo Vam se na neprijatnosti','andrija.jelic40@gmail.com'),
(30,NULL,'2026-09-14 12:51:19','Ispravka otpremnice OTPREMNICA-2026-011','','2026-09-14 12:51:27','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-011 koju ste ranije dobili imala grešku u sebi i otkazana je. Uskoro ćete dobiti ispravnu otpremnicu sa tačnim podacima.\n\nIzvinjavamo Vam se na neprijatnosti','andrija.jelic40@gmail.com'),
(31,NULL,'2026-09-14 12:56:30','Otpremnica OTPREMNICA-2026-013','','2026-09-14 12:56:32','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-013 kreirana \nPregled poslatih knjiga: \nMali Princ ---- poslato 3 komada\n','andrija.jelic40@gmail.com'),
(32,NULL,'2026-09-14 12:56:49','Ispravka otpremnice OTPREMNICA-2026-013','','2026-09-14 12:56:51','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-013 koju ste ranije dobili imala grešku u sebi i otkazana je. Uskoro ćete dobiti ispravnu otpremnicu sa tačnim podacima.\n\nIzvinjavamo Vam se na neprijatnosti','andrija.jelic40@gmail.com'),
(33,NULL,'2026-09-14 12:59:49','Potvrda porudžbine #13','','2026-09-14 12:59:52','Poštovani,\n\nVaša porudžbina #13 je uspešno kreirana\n\nUkupan iznos: 7050.0 RSD\n\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(34,NULL,'2026-09-14 13:00:11','Potvrda porudžbine #14','','2026-09-14 13:00:22','Poštovani,\n\nVaša porudžbina #14 je uspešno kreirana\n\nUkupan iznos: 4950.0 RSD\n\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(35,NULL,'2026-09-14 13:09:26','Otpremnica OTPREMNICA-2026-001','','2026-09-14 13:09:32','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-001 kreirana \nPregled poslatih knjiga: \nNa Drini cuprija ---- poslato 1 komada\n','andrija.jelic40@gmail.com'),
(36,NULL,'2026-09-14 13:10:01','Otpremnica OTPREMNICA-2026-002','','2026-09-14 13:10:11','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-002 kreirana \nPregled poslatih knjiga: \nNa Drini cuprija ---- poslato 2 komada\n','andrija.jelic40@gmail.com'),
(37,NULL,'2026-09-14 13:19:28','Potvrda porudžbine #15','','2026-09-14 13:19:32','Poštovani,\n\nVaša porudžbina #15 je uspešno kreirana\n\nUkupan iznos: 4350.0 RSD\n\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(38,NULL,'2026-09-14 13:19:41','Potvrda porudžbine #16','','2026-09-14 13:19:52','Poštovani,\n\nVaša porudžbina #16 je uspešno kreirana\n\nUkupan iznos: 6900.0 RSD\n\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(39,NULL,'2026-09-14 13:20:40','Otpremnica OTPREMNICA-2026-001','','2026-09-14 13:20:41','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-001 kreirana \nPregled poslatih knjiga: \nKnjiga o Dzungli ---- poslato 3 komada\n','andrija.jelic40@gmail.com'),
(40,NULL,'2026-09-14 13:21:14','Ispravka otpremnice OTPREMNICA-2026-001','','2026-09-14 13:21:21','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-001 koju ste ranije dobili imala grešku u sebi i otkazana je. Uskoro ćete dobiti ispravnu otpremnicu sa tačnim podacima.\n\nIzvinjavamo Vam se na neprijatnosti','andrija.jelic40@gmail.com'),
(41,NULL,'2026-09-14 13:32:38','Otpremnica OTPREMNICA-2026-002','','2026-09-14 13:32:42','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-002 kreirana \nPregled poslatih knjiga: \nKnjiga o Dzungli ---- poslato 2 komada\nProkleta avlija ---- poslato 3 komada\n','andrija.jelic40@gmail.com'),
(42,NULL,'2026-09-14 14:44:07','Potvrda porudžbine #17','','2026-09-14 14:44:10','Poštovani,\n\nVaša porudžbina #17 je uspešno kreirana\n\nUkupan iznos: 6050.0 RSD\n\nPregled Porudzbine: \nnull --- naruceno 1\nnull --- naruceno 3\nnull --- naruceno 2\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(43,NULL,'2026-09-14 14:56:41','Potvrda porudžbine #18','','2026-09-14 14:56:46','Poštovani,\n\nVaša porudžbina #18 je uspešno kreirana\n\nUkupan iznos: 2650.0 RSD\n\nPregled Porudzbine: \nnull --- naruceno 1\nnull --- naruceno 2\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(44,NULL,'2026-09-14 14:57:57','Potvrda porudžbine #19','','2026-09-14 14:58:08','Poštovani,\n\nVaša porudžbina #19 je uspešno kreirana\n\nUkupan iznos: 2900.0 RSD\n\nPregled Porudzbine: \nnull --- naruceno 1\nnull --- naruceno 2\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(45,NULL,'2026-09-14 14:59:23','Potvrda porudžbine #20','','2026-09-14 14:59:32','Poštovani,\n\nVaša porudžbina #20 je uspešno kreirana\n\nUkupan iznos: 1300.0 RSD\n\nPregled Porudzbine: \nnull --- naruceno 1\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(46,NULL,'2026-09-14 15:02:36','Potvrda porudžbine #21','','2026-09-14 15:02:39','Poštovani,\n\nVaša porudžbina #21 je uspešno kreirana\n\nUkupan iznos: 2900.0 RSD\n\nPregled Porudzbine: \nDervis i smrt --- naruceno 2\nStranac --- naruceno 1\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(47,NULL,'2026-09-14 15:03:41','Otpremnica OTPREMNICA-2026-003','','2026-09-14 15:03:49','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-003 kreirana \nPregled poslatih knjiga: \nDervis i smrt ---- poslato 1 komada\n','andrija.jelic40@gmail.com'),
(48,NULL,'2026-09-14 15:04:12','Otpremnica OTPREMNICA-2026-004','','2026-09-14 15:04:19','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-004 kreirana \nPregled poslatih knjiga: \nStranac ---- poslato 1 komada\n','andrija.jelic40@gmail.com'),
(49,NULL,'2026-09-14 15:07:10','Potvrda porudžbine #22','','2026-09-14 15:07:19','Poštovani,\n\nVaša porudžbina #22 je uspešno kreirana\n\nUkupan iznos: 11300.0 RSD\n\nPregled Porudzbine: \nNa Drini cuprija --- naruceno 4\nZlocin i kazna --- naruceno 5\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(50,NULL,'2026-09-14 15:07:40','Otpremnica OTPREMNICA-2026-001','','2026-09-14 15:07:49','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-001 kreirana \nPregled poslatih knjiga: \nNa Drini cuprija ---- poslato 1 komada\nZlocin i kazna ---- poslato 1 komada\n','andrija.jelic40@gmail.com'),
(51,NULL,'2026-09-14 15:08:11','Otpremnica OTPREMNICA-2026-002','','2026-09-14 15:08:19','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-002 kreirana \nPregled poslatih knjiga: \nNa Drini cuprija ---- poslato 1 komada\nZlocin i kazna ---- poslato 1 komada\n','andrija.jelic40@gmail.com'),
(52,NULL,'2026-09-14 15:08:39','Otpremnica OTPREMNICA-2026-003','','2026-09-14 15:08:49','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-003 kreirana \nPregled poslatih knjiga: \nNa Drini cuprija ---- poslato 2 komada\nZlocin i kazna ---- poslato 3 komada\n','andrija.jelic40@gmail.com'),
(53,NULL,'2026-09-14 15:09:01','Ispravka otpremnice OTPREMNICA-2026-002','','2026-09-14 15:09:09','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-002 koju ste ranije dobili imala grešku u sebi i otkazana je. Uskoro ćete dobiti ispravnu otpremnicu sa tačnim podacima.\n\nIzvinjavamo Vam se na neprijatnosti','andrija.jelic40@gmail.com'),
(54,NULL,'2026-09-14 15:13:59','Potvrda porudžbine #23','','2026-09-14 15:14:09','Poštovani,\n\nVaša porudžbina #23 je uspešno kreirana\n\nUkupan iznos: 8900.0 RSD\n\nPregled Porudzbine: \nProces --- naruceno 1\nGospodar prstenova: Druzina prstena --- naruceno 3\nStranac --- naruceno 4\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(55,NULL,'2026-09-14 15:14:53','Otpremnica OTPREMNICA-2026-001','','2026-09-14 15:14:59','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-001 kreirana \nPregled poslatih knjiga: \nProces ---- poslato 1 komada\nGospodar prstenova: Druzina prstena ---- poslato 1 komada\nStranac ---- poslato 1 komada\n','andrija.jelic40@gmail.com'),
(56,NULL,'2026-09-14 15:15:49','Otpremnica OTPREMNICA-2026-002','','2026-09-14 15:15:59','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-002 kreirana \nPregled poslatih knjiga: \nGospodar prstenova: Druzina prstena ---- poslato 2 komada\n','andrija.jelic40@gmail.com'),
(57,NULL,'2026-09-14 15:16:11','Ispravka otpremnice OTPREMNICA-2026-002','','2026-09-14 15:16:19','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-002 koju ste ranije dobili imala grešku u sebi i otkazana je. Uskoro ćete dobiti ispravnu otpremnicu sa tačnim podacima.\n\nIzvinjavamo Vam se na neprijatnosti','andrija.jelic40@gmail.com'),
(58,NULL,'2026-09-14 15:16:52','Otpremnica OTPREMNICA-2026-003','','2026-09-14 15:16:59','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-003 kreirana \nPregled poslatih knjiga: \nGospodar prstenova: Druzina prstena ---- poslato 2 komada\nStranac ---- poslato 3 komada\n','andrija.jelic40@gmail.com'),
(61,NULL,'2026-09-14 16:01:05','Potvrda porudžbine #26','','2026-09-14 16:01:10','Poštovani,\n\nVaša porudžbina #26 je uspešno kreirana\n\nUkupan iznos: 2150.0 RSD\n\nPregled Porudzbine: \nProkleta avlija --- naruceno 1\nZlocin i kazna --- naruceno 1\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(62,NULL,'2026-09-14 16:01:16','Potvrda porudžbine #27','','2026-09-14 16:01:20','Poštovani,\n\nVaša porudžbina #27 je uspešno kreirana\n\nUkupan iznos: 2300.0 RSD\n\nPregled Porudzbine: \nStranac --- naruceno 1\nGospodar prstenova: Druzina prstena --- naruceno 1\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(63,NULL,'2026-09-14 16:31:16','Potvrda porudžbine #28','','2026-09-14 16:31:23','Poštovani,\n\nVaša porudžbina #28 je uspešno kreirana\n\nUkupan iznos: 2700.0 RSD\n\nPregled Porudzbine: \nKnjiga o Dzungli --- naruceno 3\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(64,NULL,'2026-09-14 17:10:18','Potvrda porudžbine #29','','2026-09-14 17:10:27','Poštovani,\n\nVaša porudžbina #29 je uspešno kreirana\n\nUkupan iznos: 1200.0 RSD\n\nPregled Porudzbine: \nNa Drini cuprija --- naruceno 1\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(65,NULL,'2026-09-14 17:20:58','Potvrda porudžbine #30','','2026-09-14 17:21:07','Poštovani,\n\nVaša porudžbina #30 je uspešno kreirana\n\nUkupan iznos: 4800.0 RSD\n\nPregled Porudzbine: \nKnjiga o Dzungli --- naruceno 1\nZlocin i kazna --- naruceno 3\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(66,NULL,'2026-09-14 17:22:08','Otpremnica OTPREMNICA-2026-001','','2026-09-14 17:22:17','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-001 kreirana \nPregled poslatih knjiga: \nKnjiga o Dzungli ---- poslato 1 komada\nZlocin i kazna ---- poslato 1 komada\n','andrija.jelic40@gmail.com'),
(67,NULL,'2026-09-14 17:24:23','Potvrda porudžbine #31','','2026-09-14 17:24:27','Poštovani,\n\nVaša porudžbina #31 je uspešno kreirana\n\nUkupan iznos: 8400.0 RSD\n\nPregled Porudzbine: \nStranac --- naruceno 3\nGospodar prstenova: Druzina prstena --- naruceno 4\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(68,NULL,'2026-09-14 17:25:05','Otpremnica OTPREMNICA-2026-002','','2026-09-14 17:25:07','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-002 kreirana \nPregled poslatih knjiga: \nStranac ---- poslato 1 komada\nGospodar prstenova: Druzina prstena ---- poslato 1 komada\n','andrija.jelic40@gmail.com'),
(69,NULL,'2026-09-14 17:25:50','Otpremnica OTPREMNICA-2026-003','','2026-09-14 17:25:57','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-003 kreirana \nPregled poslatih knjiga: \nStranac ---- poslato 2 komada\nGospodar prstenova: Druzina prstena ---- poslato 3 komada\n','andrija.jelic40@gmail.com'),
(70,NULL,'2026-09-14 17:28:21','Ispravka otpremnice OTPREMNICA-2026-003','','2026-09-14 17:28:27','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-003 koju ste ranije dobili imala grešku u sebi i otkazana je. Uskoro ćete dobiti ispravnu otpremnicu sa tačnim podacima.\n\nIzvinjavamo Vam se na neprijatnosti','andrija.jelic40@gmail.com'),
(71,NULL,'2026-09-14 17:29:03','Otpremnica OTPREMNICA-2026-004','','2026-09-14 17:29:07','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-004 kreirana \nPregled poslatih knjiga: \nStranac ---- poslato 2 komada\nGospodar prstenova: Druzina prstena ---- poslato 3 komada\n','andrija.jelic40@gmail.com'),
(72,NULL,'2026-09-14 17:29:18','Ispravka otpremnice OTPREMNICA-2026-004','','2026-09-14 17:29:27','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-004 koju ste ranije dobili imala grešku u sebi i otkazana je. Uskoro ćete dobiti ispravnu otpremnicu sa tačnim podacima.\n\nIzvinjavamo Vam se na neprijatnosti','andrija.jelic40@gmail.com'),
(73,NULL,'2026-09-14 18:06:26','Potvrda porudžbine #32','\0',NULL,'Poštovani,\n\nVaša porudžbina #32 je uspešno kreirana\n\nUkupan iznos: 1200.0 RSD\n\nPregled Porudzbine: \nNa Drini cuprija --- naruceno 1\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','a'),
(74,NULL,'2026-09-14 18:15:40','Bookathon - Potvrda email adrese','','2026-09-14 18:15:47','Dobrodošli na Bookathon!\n\nKliknite na sledeći link da potvrdite svoju email adresu i dovršite registraciju:\n\nhttp://localhost:5173/verifikuj?token=5e041841-1e64-4fa3-8af9-6faa73343f11\n\nAko niste vi zatražili registraciju, ignorišite ovaj mejl.','milan.obrenovic987@gmail.com'),
(75,NULL,'2026-09-14 18:19:42','Potvrda porudžbine #33','','2026-09-14 18:19:47','Poštovani,\n\nVaša porudžbina #33 je uspešno kreirana\n\nUkupan iznos: 1200.0 RSD\n\nPregled Porudzbine: \nNa Drini cuprija --- naruceno 1\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','milan.obrenovic987@gmail.com'),
(76,NULL,'2026-09-14 18:22:07','Potvrda porudžbine #34','','2026-09-14 18:22:17','Poštovani,\n\nVaša porudžbina #34 je uspešno kreirana\n\nUkupan iznos: 1200.0 RSD\n\nPregled Porudzbine: \nNa Drini cuprija --- naruceno 1\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','milan.obrenovic987@gmail.com'),
(77,NULL,'2026-09-15 07:44:13','Bookathon - Potvrda email adrese','','2026-09-15 09:56:30','Dobrodošli na Bookathon!\n\nKliknite na sledeći link da potvrdite svoju email adresu i dovršite registraciju:\n\nhttp://localhost:5173/verifikuj?token=dc3c4f89-d72c-4166-a6af-4a39c363ea2b\n\nAko niste vi zatražili registraciju, ignorišite ovaj mejl.','milan.obrenovic987@gmail.com'),
(78,NULL,'2026-09-15 07:46:03','Potvrda porudžbine #35','','2026-09-15 09:56:26','Poštovani,\n\nVaša porudžbina #35 je uspešno kreirana\n\nUkupan iznos: 3600.0 RSD\n\nPregled Porudzbine: \n1984 --- naruceno 2\nNa Drini cuprija --- naruceno 1\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','andrija.jelic40@gmail.com'),
(79,NULL,'2026-09-15 07:46:55','Otpremnica OTPREMNICA-2026-001','','2026-09-15 09:56:27','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-001 kreirana \nPregled poslatih knjiga: \n1984 ---- poslato 1 komada\nNa Drini cuprija ---- poslato 1 komada\n','andrija.jelic40@gmail.com'),
(80,NULL,'2026-09-15 20:45:31','Bookathon - Potvrda email adrese','','2026-09-15 20:45:41','Dobrodošli na Bookathon!\n\nKliknite na sledeći link da potvrdite svoju email adresu i dovršite registraciju:\n\nhttp://localhost:5173/verifikuj?token=6bd5af4b-e5b2-4613-af4d-0fa6274cbae1\n\nAko niste vi zatražili registraciju, ignorišite ovaj mejl.','milan.obrenovic987@gmail.com'),
(81,NULL,'2026-09-15 20:46:54','Potvrda porudžbine #36','','2026-09-15 20:47:01','Poštovani,\n\nVaša porudžbina #36 je uspešno kreirana\n\nUkupan iznos: 3000.0 RSD\n\nPregled Porudzbine: \n1984 --- naruceno 1\nKnjiga o Dzungli --- naruceno 2\nBićete obavešteni kada Vaša porudžbina bude poslata\n\n','milan.obrenovic987@gmail.com'),
(82,NULL,'2026-09-15 20:47:37','Otpremnica OTPREMNICA-2026-002','','2026-09-15 20:47:41','Poštovani,\n\nObaveštavamo vas da je otpremnica OTPREMNICA-2026-002 kreirana \nPregled poslatih knjiga: \n1984 ---- poslato 1 komada\nKnjiga o Dzungli ---- poslato 1 komada\n','milan.obrenovic987@gmail.com');

/*Table structure for table `izdavackakuca` */

DROP TABLE IF EXISTS `izdavackakuca`;

CREATE TABLE `izdavackakuca` (
  `izdavacka_kucaid` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  `adresa` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`izdavacka_kucaid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `izdavackakuca` */

insert  into `izdavackakuca`(`izdavacka_kucaid`,`naziv`,`adresa`) values 
(1,'Eduka','sss'),
(2,'Agora','t'),
(3,'Beli put',NULL);

/*Table structure for table `knjiga` */

DROP TABLE IF EXISTS `knjiga`;

CREATE TABLE `knjiga` (
  `KnjigaID` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) DEFAULT NULL,
  `godina_izdanja` date DEFAULT NULL,
  `cena` double DEFAULT NULL,
  `stanje` bigint(20) DEFAULT NULL,
  `opis` varchar(500) DEFAULT NULL,
  `autor` varchar(50) DEFAULT NULL,
  `izdavacka_kucafk` bigint(20) DEFAULT NULL,
  `slika` varchar(255) DEFAULT NULL,
  `rezervisano_stanje` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`KnjigaID`),
  KEY `izdavackaKucaFK` (`izdavacka_kucafk`),
  CONSTRAINT `knjiga_ibfk_1` FOREIGN KEY (`izdavacka_kucafk`) REFERENCES `izdavackakuca` (`izdavacka_kucaid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `knjiga` */

insert  into `knjiga`(`KnjigaID`,`naziv`,`godina_izdanja`,`cena`,`stanje`,`opis`,`autor`,`izdavacka_kucafk`,`slika`,`rezervisano_stanje`) values 
(1,'Knjiga o Dzungli','2026-09-06',900,19,' U dubinama misteriozne i neistražene indijske džungle, skriven od ljudskih očiju, jedan dečak nalazi svoj dom među životinjama. ','Radjard Kipling',2,'https://laguna.oozmi-cdn.com/images/f785cae0-c4a7-4309-8789-20cdd66f6486/Knjiga-o-dzungli-h800.avif',0),
(2,'1984','1969-02-05',1200,5,'Rat je mir, Sloboda je ropstvo, Neznanje je moć. „Onaj ko kontroliše prošlost“, glasio je partijski slogan, „kontroliše budućnost: onaj ko kontroliše sadašnjost kontroliše prošlost.“','Dzorz Orvel',2,'https://sajsa.ir/wp-content/uploads/2024/05/1984.jpg',0),
(4,'Na Drini cuprija','1945-03-10',1200,16,'Epska priča o viševekovnoj istoriji višegradskog mosta i sudbinama ljudi sa tog podneblja.','Ivo Andric',2,'https://www.knjizare-vulkan.rs/files/images/slike_proizvoda/389701.jpg',0),
(5,'Prokleta avlija','1954-05-15',850,35,'Mračna priča o carigradskom zatvoru i ljudskim sudbinama unutar njega.','Ivo Andric',2,'https://www.korisnaknjiga.com/photo/books0059/p058202c0.jpg',0),
(6,'Seobe','1929-11-20',1100,10,'Istorijski roman o učešću Srba u austrijskim ratovima tokom 18. veka.','Milos Crnjanski',2,'https://www.knjizare-vulkan.rs/files/images/slike_proizvoda/289203.jpg',0),
(7,'Dervis i smrt','1966-09-01',1050,27,'Duboka filozofska i psihološka drama o borbi pojedinca protiv nepravde i vlasti.','Mesa Selimovic',2,'https://lektire.elektronskaknjiga.com/slike/dervis_i_smrt.jpg',0),
(8,'Zlocin i kazna','1866-01-01',1300,9,'Psihološki roman o Raskoljnikovu i njegovoj unutrašnjoj borbi nakon ubistva.','Fjodor Dostojevski',2,'https://edicija.rs/wp-content/uploads/2025/03/zlocin-i-kazna.jpg',0),
(9,'Braca Karamazovi','1880-11-01',1600,25,'Kutno delo o moralu, veri, porodici i ubistvu starog Karamazova.','Fjodor Dostojevski',2,'https://gradknjige.ba/wp-content/uploads/2025/08/braca_karamazovi_i-fjodor_mihailovic_dostojevski_v.jpg',0),
(10,'Mali Princ','1943-04-06',750,42,'Bezvremenska alegorijska priča o ljubavi, prijateljstvu i ljudskoj prirodi.','Antoan de Sent Egziperi',2,'https://eknjizara.hr/wp-content/uploads/2023/11/Mali-princ-NOVO.png',0),
(11,'Gospodar prstenova: Druzina prstena','1954-07-29',1500,19,'Početak epske fantastike o uništavanju Jedinstvenog Prstena.','Dž.R.R. Tolkin',2,'https://narodna-knjiga.com/wp-content/uploads/2024/03/KNJIGA-DRUZINA-PRSTENA.jpg',0),
(12,'Hobit','1937-09-21',1250,11,'Avantura Bilba Baginsa koji kreće u potragu za blagom koje čuva zmaj Šmaug.','Dž.R.R. Tolkin',2,'https://www.njuskalo.hr/image-w920x690/beletristika/knjiga-hobit-j-r-r-tolkien-algoritam-slika-51397888.jpg',0),
(13,'Stranac','1942-05-19',800,23,'Eksistencijalistički roman o Mersou i njegovoj ravnodušnosti prema svetu.','Alber Kami',2,'https://www.knjizara.zavod.co.rs/image/cache/catalog/knjige/32072-500x700.jpg',0),
(16,'Proces','1936-02-05',1200,41,'Remek-delo svetske književnosti koje prati Jozefa K.','Franc Kafka',2,'https://www.knjizare-vulkan.rs/files/images/slike_proizvoda/382383.jpg',0);

/*Table structure for table `otpremnica` */

DROP TABLE IF EXISTS `otpremnica`;

CREATE TABLE `otpremnica` (
  `OtpremnicaID` bigint(20) NOT NULL AUTO_INCREMENT,
  `datum` date DEFAULT NULL,
  `iznos` double DEFAULT NULL,
  `broj_otpremnice` varchar(50) DEFAULT NULL,
  `status_otpremnice` enum('IZDATA','STORNIRANA') DEFAULT NULL,
  `porudzbinaFK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`OtpremnicaID`),
  KEY `porudzbinaFK` (`porudzbinaFK`),
  CONSTRAINT `otpremnica_ibfk_1` FOREIGN KEY (`porudzbinaFK`) REFERENCES `porudzbina` (`PorudzbinaID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `otpremnica` */

/*Table structure for table `porudzbina` */

DROP TABLE IF EXISTS `porudzbina`;

CREATE TABLE `porudzbina` (
  `PorudzbinaID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ukupan_iznos` double DEFAULT NULL,
  `datum` date DEFAULT NULL,
  `status_porudzbine` enum('KREIRANA','PARCIJALNO_ISPORUCENA','ISPORUCENA','OTKAZANA') DEFAULT NULL,
  `userFK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`PorudzbinaID`),
  KEY `userFK` (`userFK`),
  CONSTRAINT `porudzbina_ibfk_1` FOREIGN KEY (`userFK`) REFERENCES `user` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `porudzbina` */

/*Table structure for table `recenzija` */

DROP TABLE IF EXISTS `recenzija`;

CREATE TABLE `recenzija` (
  `userFK` bigint(20) NOT NULL,
  `knjigaFK` bigint(20) DEFAULT NULL,
  `ocena` double DEFAULT NULL,
  `poruka` varchar(300) DEFAULT NULL,
  `recenzija_id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`recenzija_id`),
  UNIQUE KEY `userFK` (`userFK`,`knjigaFK`),
  KEY `knjigaFK` (`knjigaFK`),
  CONSTRAINT `recenzija_ibfk_1` FOREIGN KEY (`userFK`) REFERENCES `user` (`UserID`),
  CONSTRAINT `recenzija_ibfk_2` FOREIGN KEY (`knjigaFK`) REFERENCES `knjiga` (`KnjigaID`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `recenzija` */

insert  into `recenzija`(`userFK`,`knjigaFK`,`ocena`,`poruka`,`recenzija_id`) values 
(1,1,5,'ddsdsd',4),
(1,2,5,'sdsd',5),
(2,2,5,'55554',8),
(2,1,3,'efffffffffffffffffffff',9),
(1,4,5,'Fenomenlano',10),
(1,5,5,'super',12),
(3,1,5,'komentar c',14),
(3,2,5,'hh',33),
(3,13,5,'Nova recenzija',34),
(2,4,5,'admin',42);

/*Table structure for table `stavkaotpremnice` */

DROP TABLE IF EXISTS `stavkaotpremnice`;

CREATE TABLE `stavkaotpremnice` (
  `redni_broj` bigint(20) NOT NULL AUTO_INCREMENT,
  `otpremnicaFK` bigint(20) NOT NULL,
  `jedinicna_cena` double DEFAULT NULL,
  `iznos` double DEFAULT NULL,
  `kolicina` bigint(20) DEFAULT NULL,
  `KnjigaFK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`redni_broj`,`otpremnicaFK`),
  KEY `otpremnicaFK` (`otpremnicaFK`),
  KEY `KnjigaFK` (`KnjigaFK`),
  CONSTRAINT `stavkaotpremnice_ibfk_1` FOREIGN KEY (`otpremnicaFK`) REFERENCES `otpremnica` (`OtpremnicaID`),
  CONSTRAINT `stavkaotpremnice_ibfk_2` FOREIGN KEY (`KnjigaFK`) REFERENCES `knjiga` (`KnjigaID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `stavkaotpremnice` */

/*Table structure for table `stavkaporudzbine` */

DROP TABLE IF EXISTS `stavkaporudzbine`;

CREATE TABLE `stavkaporudzbine` (
  `redni_broj` bigint(20) NOT NULL AUTO_INCREMENT,
  `porudzbinaFK` bigint(20) NOT NULL,
  `kolicina` bigint(20) DEFAULT NULL,
  `jedinicna_cena` double DEFAULT NULL,
  `iznos` double DEFAULT NULL,
  `KnjigaFK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`redni_broj`,`porudzbinaFK`),
  KEY `porudzbinaFK` (`porudzbinaFK`),
  KEY `KnjigaFK` (`KnjigaFK`),
  CONSTRAINT `stavkaporudzbine_ibfk_1` FOREIGN KEY (`porudzbinaFK`) REFERENCES `porudzbina` (`PorudzbinaID`),
  CONSTRAINT `stavkaporudzbine_ibfk_2` FOREIGN KEY (`KnjigaFK`) REFERENCES `knjiga` (`KnjigaID`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `stavkaporudzbine` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `UserID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(35) DEFAULT NULL,
  `prezime` varchar(35) DEFAULT NULL,
  `password` varchar(35) DEFAULT NULL,
  `username` varchar(35) DEFAULT NULL,
  `email` varchar(35) DEFAULT NULL,
  `adresa` varchar(35) DEFAULT NULL,
  `uloga` enum('ADMIN','KUPAC') NOT NULL,
  `verifikacioni_token` varchar(255) DEFAULT NULL,
  `email_potvrdjen` bit(1) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `user` */

insert  into `user`(`UserID`,`ime`,`prezime`,`password`,`username`,`email`,`adresa`,`uloga`,`verifikacioni_token`,`email_potvrdjen`) values 
(1,'a','a','a','a','a','a','KUPAC',NULL,NULL),
(2,'b','b','b','b','b','b','ADMIN',NULL,NULL),
(3,'c','a','c','c','c@c','c','KUPAC',NULL,NULL),
(4,'d','d','d','d','d@d','d','KUPAC',NULL,NULL),
(5,'v','v','v','z','v@c','v','KUPAC',NULL,NULL),
(6,'n','n','n','n','n@g','n','KUPAC',NULL,NULL),
(14,'Andrija','Jelic','lozinka','Andrija','andrija.jelic40@gmail.com','B s 10','KUPAC','994da15c-1c77-435a-af82-8eb7779f5c82',''),
(17,'Milan','Obrenovic','lozinka','milan','milan.obrenovic987@gmail.com','bgd','KUPAC','6bd5af4b-e5b2-4613-af4d-0fa6274cbae1','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
