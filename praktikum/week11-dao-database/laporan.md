# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Abbi Priyoguno]
- NIM   : [240202848]
- Kelas : [3IKRB]

---

## Tujuan
(
1. Mahasiswa memahami dan mampu mengimplementasikan pola desain Data Access Object (DAO).

2. Mahasiswa mampu mengonfigurasi koneksi basis data PostgreSQL melalui JDBC di aplikasi Java.

3. Mahasiswa mampu membuat fitur CRUD (Create, Read, Update, Delete) yang terintegrasi dengan database.

4. Mahasiswa memahami pentingnya pemisahan logika akses data dengan logika bisnis aplikasi.*)

---

## Dasar Teori
(
1. DAO (Data Access Object): Pola desain yang berfungsi sebagai perantara antara aplikasi dan database. Tujuannya adalah menyembunyikan detail teknis penyimpanan data dari pengguna (logika bisnis).

2. JDBC (Java Database Connectivity): API standar Java untuk menghubungkan aplikasi dengan database relasional (RDBMS) seperti PostgreSQL.

3. PreparedStatement: Komponen JDBC yang digunakan untuk menjalankan query SQL secara aman, mencegah SQL Injection, dan meningkatkan performa melalui pra-kompilasi query.

4. Separation of Concerns: Prinsip desain yang memisahkan kode program berdasarkan fungsinya agar lebih mudah diuji, dipelihara, dan dikembangkan secara modular..)

---

## Langkah Praktikum
(
1. Setup Database: Membuat database agripos di PostgreSQL dan menjalankan script SQL untuk membuat tabel products.

2. Pembuatan Model: Membuat class Product.java sebagai representasi data di memori.

3. bstraksi DAO: Membuat Interface ProductDAO.java untuk mendefinisikan kontrak operasi CRUD.

4. Implementasi JDBC: Membuat class ProductDAOImpl.java yang berisi logika SQL (INSERT, SELECT, UPDATE, DELETE) menggunakan JDBC.

5. Pengujian: Menjalankan class MainDAOTest.java untuk melakukan serangkaian operasi CRUD dan menutup koneksi database secara benar.)

---

## Kode Program
(Tuliskan kode utama yang dibuat, contoh:  

```java
// Contoh
Produk p1 = new Produk("BNH-001", "Benih Padi", 25000, 100);
System.out.println(p1.getNama());
```
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/Screenshot%202026-01-14%20205941.png)
)
---

## Analisis
(
Analisis Kode: Penggunaan PreparedStatement sangat krusial untuk keamanan. Dengan menggunakan blok try-with-resources, koneksi dan statement akan otomatis ditutup, mencegah kebocoran memori (resource leak).

Perbedaan Pendekatan: Sebelumnya, data hanya disimpan di dalam memori (ArrayList atau Map) yang akan hilang saat aplikasi dimatikan. Minggu ini, data bersifat persistent karena disimpan di database PostgreSQL.

Kendala dan Solusi: Kendala yang sering ditemui adalah error No suitable driver found. Solusinya adalah menambahkan file .jar driver JDBC PostgreSQL ke dalam Library atau Classpath proyek.
---
)
## Kesimpulan
(Penerapan pola DAO menggunakan JDBC membuat aplikasi Agri-POS menjadi lebih profesional. Kode program lebih bersih karena tidak ada perintah SQL yang bercampur dengan logika utama di Main(). Hal ini mempermudah transisi jika di masa depan database diganti dari PostgreSQL ke MySQL atau database lainnya.)

---

## Quiz
(
1. Apa fungsi utama interface pada pola DAO? Jawaban: Interface berfungsi sebagai kontrak atau standar yang harus diikuti. Hal ini memungkinkan kita memiliki beberapa implementasi (misal: implementasi untuk database asli dan implementasi untuk pengujian/mock) tanpa mengubah kode pada sisi aplikasi.

2. Apa kegunaan ResultSet dalam JDBC? Jawaban: ResultSet adalah objek yang menampung hasil query SELECT dari database. Kita dapat melakukan iterasi pada ResultSet untuk mengambil data baris demi baris menggunakan method seperti getString() atau getInt().

3. Mengapa PreparedStatement lebih disarankan daripada Statement biasa? Jawaban: Karena PreparedStatement mendukung parameterisasi (tanda tanya ?), yang secara otomatis menangani escaping karakter berbahaya, sehingga mencegah serangan SQL Injection. Selain itu, ia lebih cepat untuk query yang dijalankan berulang kali. )
