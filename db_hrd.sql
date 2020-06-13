-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 04 Jun 2020 pada 05.49
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_hrd`
--

DELIMITER $$
--
-- Prosedur
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `p_del_pegawai` (IN `p_id` INT(3))  DELETE FROM pegawai WHERE id_pegawai = p_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `p_divisi` ()  READS SQL DATA
SELECT * FROM divisi$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `p_jabatan` ()  READS SQL DATA
SELECT * FROM jabatan$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `p_pegawai` ()  READS SQL DATA
SELECT * FROM pegawai$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `divisi`
--

CREATE TABLE `divisi` (
  `id_divisi` int(3) NOT NULL,
  `divisi` varchar(22) NOT NULL,
  `honor` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `divisi`
--

INSERT INTO `divisi` (`id_divisi`, `divisi`, `honor`) VALUES
(1, 'HRD', 1200000),
(2, 'Security', 1500000),
(3, 'Produksi', 1800000),
(4, 'Logistik', 1600000),
(5, 'Pembelian', 1600000),
(6, 'Penjualan', 1700000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `jabatan`
--

CREATE TABLE `jabatan` (
  `id_jabatan` int(3) NOT NULL,
  `jabatan` varchar(22) NOT NULL,
  `gaji_pokok` bigint(20) NOT NULL,
  `tunj_jabatan` bigint(20) NOT NULL,
  `tunj_anak` bigint(20) NOT NULL,
  `tunj_kesehatan` bigint(20) NOT NULL,
  `perj_dinas` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `jabatan`
--

INSERT INTO `jabatan` (`id_jabatan`, `jabatan`, `gaji_pokok`, `tunj_jabatan`, `tunj_anak`, `tunj_kesehatan`, `perj_dinas`) VALUES
(1, 'Staff', 1200000, 100000, 100000, 210000, 70000),
(2, 'Manajer', 3200000, 1200000, 110000, 210000, 100000),
(3, 'Supervisor', 2850000, 320000, 120000, 250000, 150000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` int(3) NOT NULL,
  `id_divisi` int(3) NOT NULL,
  `id_jabatan` int(3) NOT NULL,
  `nama` varchar(22) NOT NULL,
  `alamat` varchar(22) NOT NULL,
  `usia` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `id_divisi`, `id_jabatan`, `nama`, `alamat`, `usia`) VALUES
(8, 1, 3, 'Suparman', 'Jakarta', 43);

--
-- Trigger `pegawai`
--
DELIMITER $$
CREATE TRIGGER `t_del_pegawai` BEFORE DELETE ON `pegawai` FOR EACH ROW INSERT INTO pegawai_cadangan VALUES( OLD.id_pegawai, OLD.id_divisi, OLD.id_jabatan, OLD.nama, OLD.alamat, OLD.usia )
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai_cadangan`
--

CREATE TABLE `pegawai_cadangan` (
  `id_pegawai` int(3) NOT NULL,
  `id_divisi` int(3) NOT NULL,
  `id_jabatan` int(3) NOT NULL,
  `nama` varchar(22) NOT NULL,
  `alamat` varchar(22) NOT NULL,
  `usia` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pegawai_cadangan`
--

INSERT INTO `pegawai_cadangan` (`id_pegawai`, `id_divisi`, `id_jabatan`, `nama`, `alamat`, `usia`) VALUES
(9, 5, 2, 'Yulianto', 'Bekasi', 43);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `v_detil_pegawai`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `v_detil_pegawai` (
`id_pegawai` int(3)
,`nama` varchar(22)
,`alamat` varchar(22)
,`divisi` varchar(22)
,`jabatan` varchar(22)
,`honor_divisi` bigint(20)
,`gaji_pokok` bigint(20)
,`tunj_jabatan` bigint(20)
,`tunj_anak` bigint(20)
,`tunj_kesehatan` bigint(20)
,`perj_dinas` bigint(20)
,`total` bigint(25)
);

-- --------------------------------------------------------

--
-- Struktur untuk view `v_detil_pegawai`
--
DROP TABLE IF EXISTS `v_detil_pegawai`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_detil_pegawai`  AS  select `pegawai`.`id_pegawai` AS `id_pegawai`,`pegawai`.`nama` AS `nama`,`pegawai`.`alamat` AS `alamat`,`divisi`.`divisi` AS `divisi`,`jabatan`.`jabatan` AS `jabatan`,`divisi`.`honor` AS `honor_divisi`,`jabatan`.`gaji_pokok` AS `gaji_pokok`,`jabatan`.`tunj_jabatan` AS `tunj_jabatan`,`jabatan`.`tunj_anak` AS `tunj_anak`,`jabatan`.`tunj_kesehatan` AS `tunj_kesehatan`,`jabatan`.`perj_dinas` AS `perj_dinas`,`divisi`.`honor` + `jabatan`.`gaji_pokok` + `jabatan`.`tunj_jabatan` + `jabatan`.`tunj_anak` + `jabatan`.`tunj_kesehatan` + `jabatan`.`perj_dinas` AS `total` from ((`pegawai` join `jabatan` on(`pegawai`.`id_jabatan` = `jabatan`.`id_jabatan`)) join `divisi` on(`pegawai`.`id_divisi` = `divisi`.`id_divisi`)) ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `divisi`
--
ALTER TABLE `divisi`
  ADD PRIMARY KEY (`id_divisi`);

--
-- Indeks untuk tabel `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`id_jabatan`);

--
-- Indeks untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`),
  ADD KEY `id_divisi` (`id_divisi`),
  ADD KEY `id_jabatan` (`id_jabatan`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `divisi`
--
ALTER TABLE `divisi`
  MODIFY `id_divisi` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `jabatan`
--
ALTER TABLE `jabatan`
  MODIFY `id_jabatan` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  MODIFY `id_pegawai` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD CONSTRAINT `pegawai_ibfk_1` FOREIGN KEY (`id_jabatan`) REFERENCES `jabatan` (`id_jabatan`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pegawai_ibfk_2` FOREIGN KEY (`id_divisi`) REFERENCES `divisi` (`id_divisi`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
