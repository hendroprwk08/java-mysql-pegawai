-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 22 Jun 2019 pada 10.41
-- Versi Server: 5.6.25
-- PHP Version: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbpegawai`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `divisi`
--

CREATE TABLE IF NOT EXISTS `divisi` (
  `id_divisi` int(3) NOT NULL,
  `divisi` varchar(22) DEFAULT '0',
  `honor_divisi` double DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `divisi`
--

INSERT INTO `divisi` (`id_divisi`, `divisi`, `honor_divisi`) VALUES
(2, 'Marketing', 800000),
(3, 'Produksi', 900000),
(4, 'Security', 1800000),
(5, 'HRD', 2400000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `jabatan`
--

CREATE TABLE IF NOT EXISTS `jabatan` (
  `id_jabatan` int(3) NOT NULL,
  `jabatan` varchar(22) NOT NULL DEFAULT '0',
  `honor_jabatan` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `jabatan`
--

INSERT INTO `jabatan` (`id_jabatan`, `jabatan`, `honor_jabatan`) VALUES
(1, 'Staff', 500000),
(2, 'Supervisor', 800000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE IF NOT EXISTS `karyawan` (
  `id_karyawan` int(2) NOT NULL,
  `nama` varchar(22) NOT NULL DEFAULT '0',
  `alamat` varchar(50) NOT NULL DEFAULT '0',
  `usia` int(2) NOT NULL DEFAULT '0',
  `kelamin` varchar(7) NOT NULL DEFAULT '0',
  `status` varchar(20) NOT NULL DEFAULT '0',
  `id_divisi` int(11) NOT NULL DEFAULT '0',
  `id_jabatan` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `nama`, `alamat`, `usia`, `kelamin`, `status`, `id_divisi`, `id_jabatan`) VALUES
(2, 'dsf', 'dasf', 20, 'Pria', 'Tetap', 3, 2),
(3, 'gdfg', 'sdfg', 23, 'Pria', 'Tetap', 3, 2),
(4, 'gfdfsg', 'dfg', 34, 'Pria', 'Freelance', 3, 1),
(5, 'vzv', 'dfgd', 45, 'Pria', 'Kontrak', 5, 1),
(6, 'Anto', 'jl Mekarsari 12', 23, 'Pria', 'Freelance', 4, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengguna`
--

CREATE TABLE IF NOT EXISTS `pengguna` (
  `username` varchar(6) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama` varchar(22) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengguna`
--

INSERT INTO `pengguna` (`username`, `password`, `nama`, `email`) VALUES
('admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', 'Administrator', 'admin@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `divisi`
--
ALTER TABLE `divisi`
  ADD PRIMARY KEY (`id_divisi`);

--
-- Indexes for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`id_jabatan`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `divisi`
--
ALTER TABLE `divisi`
  MODIFY `id_divisi` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `jabatan`
--
ALTER TABLE `jabatan`
  MODIFY `id_jabatan` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id_karyawan` int(2) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
