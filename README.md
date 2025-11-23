# LAPORAN TUGAS KULIAH PEMROGRAMAN BERORIENTASI OBJEK PERTEMUAN KEEMPAT BELAS

Disusun guna memenuhi tugas mata kuliah **Pemrograman Berorientasi Objek**

---

## Dosen Pembimbing
Bayu Adhi Nugroho, Ph.D

## Disusun Oleh
Muhamad Dhauvir Arkan  
(NIM: 09020624044)

## Program Studi
Sistem Informasi, Fakultas Sains dan Teknologi, Universitas Islam Negeri Sunan Ampel, Surabaya  
Tahun 2025

---

## DASAR TEORI

### 1. Keamanan pada Sistem Ubah Password
Pada sistem aplikasi berbasis pengguna, fungsi ubah password merupakan salah satu bagian krusial dalam menjaga keamanan akun. Jika seseorang hanya mengetahui username, dia tidak seharusnya bisa mengganti password secara langsung. Untuk mengatasi potensi penyalahgunaan ini, beberapa konsep penting diterapkan:

- **Autentikasi sebelum ubah password**  
  Sistem harus memverifikasi identitas pengguna sebelum memperbolehkan perubahan password. Metode yang umum digunakan:
  - Memasukkan **password lama** sebelum mengganti ke password baru.
  - Mengirim **kode verifikasi** melalui email atau SMS (two-factor authentication).

- **Hashing dan salting password**  
  Password disimpan dalam bentuk hash + salt, bukan plaintext, sehingga meskipun database bocor, password asli sulit ditebak.
  ```java
  hashedPassword = hash(password + salt);
Fungsi ini memberikan keamanan tambahan saat proses ubah password dilakukan.

**Pembatasan percobaan**
Sistem dapat membatasi jumlah percobaan login atau ubah password dalam periode tertentu untuk mencegah brute force attack.

**Kesimpulan:**
Hanya mengetahui username tidak cukup untuk mengganti password; sistem harus melakukan verifikasi tambahan yang kuat untuk memastikan hanya pemilik akun yang bisa mengubah password.

### 2. Penambahan Button Download (CSV)
Pada aplikasi manajemen data, fitur download/export mempermudah pengguna mengambil data dalam format yang umum, seperti CSV.

**Tujuan:**
- Memudahkan analisis, backup data, dan integrasi dengan aplikasi lain (misal Excel).

**Prinsip:**
- Data yang ditampilkan di JTable diambil dan ditulis ke file CSV dengan format:
- Baris pertama sebagai header (nama kolom)
- Baris berikutnya berisi data setiap record

**Implementasi:**
- Menggunakan JFileChooser untuk menentukan lokasi penyimpanan file.
- Mengambil data dari JTable yang sudah ada di GUI (jTable1 untuk Depo, jTable2 untuk Perawatan).
- Menulis data menggunakan PrintWriter atau BufferedWriter.

**Keuntungan:**
- Mempercepat proses pelaporan.
- Meminimalkan kesalahan input manual.
- Mempermudah integrasi dengan sistem eksternal.

### 3. Normalisasi dan Integrasi Sistem Login
Normalisasi database adalah proses pengaturan struktur tabel untuk menghindari redundansi data dan menjaga konsistensi.

**Tingkat normalisasi:**
- **1NF (First Normal Form):** Setiap kolom hanya mengandung satu nilai, tidak ada duplikasi baris.
- **2NF (Second Normal Form):** Semua kolom non-key bergantung sepenuhnya pada primary key.
- **3NF (Third Normal Form):** Semua kolom non-key tidak bergantung transitif pada primary key.

**Contoh integrasi login dengan modul Depo & Perawatan:**
- Tabel akun_orang berisi username, password_hash, salt, role (admin/pegawai/tamu).
- Role digunakan untuk mengatur akses ke package tugaspert12 yang terdiri dari:
1. Depokeretasbi.java → Entity untuk armada kereta.
2. PerawatanKereta.java → Entity untuk perawatan.
3. GUIMainClass12.java → GUI utama untuk menampilkan tabel Depo & Perawatan.
4. DepoSBI.jrxml & Perawatan.jrxml → Template laporan JasperReports.

**Manfaat integrasi login:**
- Mengontrol hak akses pengguna (misal hanya admin yang bisa insert/delete/update).
- Menjamin keamanan data.
- Mempermudah manajemen data karena semua modul berada dalam satu sistem yang normal dan terhubung dengan database.

**Kesimpulan:**
Normalisasi database yang tepat digabung dengan sistem login berbasis role akan menghasilkan sistem yang aman, efisien, dan terstruktur dengan baik.

## PELAKSANAAN PRAKTIKUM

1. Membuat Java Apps dengan nama TugasPert14.
2. Membuat Entity Class Database untuk mengakses database PostgreSQL di NetBeans.
3. Menekan Next sampai selesai dibuat public agar class bisa diakses dari mana saja.
4. Mengubah Source Persistence agar package dari Java Apps lain bisa diakses.
5. Menambahkan method-method pada setiap pallete agar berfungsi sesuai kebutuhan, misal:
- Class Daftar
- Class Login
- Class Reset

6. Menambahkan JButton Download CSV beserta method-methodnya pada GUIMainClass12.
7. Menambahkan JAR Library sesuai versi NetBeans.
8. Mengetes program:
- Memasukkan username dan password yang ada di PostgreSQL.
- Jika terjadi exception, itu berarti username atau password sudah ada.
- Login hanya bisa dilakukan oleh pengguna yang melengkapi data di Class Daftar (Nama Lengkap, NIK, E-Mail, Role).
9. Mengarahkan pengguna ke tombol Daftar untuk mengisi biodata.
10. Setelah pendaftaran berhasil:
- Pengguna diarahkan untuk login.
- Bisa mengakses GUIMainClass12 yang menampilkan data armada kereta.
11. Uji coba Download CSV:
- Pengguna memilih folder penyimpanan file.
- Tersedia opsi untuk menyimpan salah satu tab atau kedua tab sekaligus.

**CATATAN:**
- Implementasi GUI dilakukan menggunakan Java Swing.
- Database menggunakan PostgreSQL.
- Laporan menggunakan JasperReports (.jrxml files).
- Sistem login terintegrasi dengan role-based access control untuk keamanan data.
