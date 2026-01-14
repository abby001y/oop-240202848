# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Abbi Priyoguno]
- NIM   : [240202848]
- Kelas : [3IKRB]

---

## Tujuan
(
1. Mengintegrasikan seluruh konsep OOP, Collections, dan Exception Handling ke dalam satu aplikasi utuh.

2. Mengimplementasikan rancangan UML dan prinsip SOLID (Bab 6) ke dalam kode nyata.

3. Menghubungkan antarmuka grafis JavaFX dengan database PostgreSQL melalui arsitektur Layered (DAO & Service).

4. Melakukan pengujian logika bisnis menggunakan JUnit Testing untuk memastikan kualitas perangkat lunak.*)

---

## Dasar Teori
(
1. Arsitektur Layered (MVC + Service + DAO): Pemisahan tanggung jawab kode di mana View menangani UI, Controller mengatur alur, Service mengelola logika bisnis, dan DAO berurusan dengan persistensi data.

2. Dependency Inversion Principle (DIP): Prinsip yang menyatakan bahwa modul tingkat tinggi tidak boleh bergantung pada modul tingkat rendah, melainkan pada abstraksi. Dalam Agri-POS, GUI bergantung pada Service, bukan langsung ke DAO.

3. Java Collections dalam Bisnis: Penggunaan List dan Map untuk mengelola data sementara seperti item di keranjang belanja sebelum diproses lebih lanjut.

4. Design Pattern (Singleton): Menjamin bahwa koneksi database hanya memiliki satu instansi di seluruh siklus hidup aplikasi..)

---

## Langkah Praktikum
(
1. Integrasi Backend: Menyatukan kelas ProductDAO dan JdbcProductDAO untuk akses database PostgreSQL.

2. Logika Keranjang: Mengimplementasikan kelas Cart dan CartItem menggunakan ArrayList untuk menyimpan belanjaan sementara.

3. Pembuatan Service: Membuat ProductService dan CartService sebagai pusat logika aplikasi dan validasi.

4. Pengembangan GUI: Menggunakan JavaFX TableView untuk menampilkan produk dan area ringkasan untuk total belanja keranjang.

5. Exception Handling: Menambahkan blok try-catch dengan custom exception untuk menangani stok kosong atau input harga tidak valid.

6. Unit Testing: Menulis kode tes di src/test/java untuk memvalidasi perhitungan total harga di keranjang belanja.)

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
![Screenshot hasil](screenshots/Screenshot%202026-01-14%20190245.png)
![Screenshot hasil](screenshots/Screenshot%202026-01-14%20190323.png)
![Screenshot hasil](screenshots/Screenshot%202026-01-14%20190417.png)
![Screenshot hasil](screenshots/Screenshot%202026-01-14%20190703.png)
)
---

## Analisis
(
1. Alur Kerja Aplikasi: Saat aplikasi dijalankan, DatabaseConnection (Singleton) diinisialisasi. PosController memanggil ProductService untuk memuat data ke TableView. Ketika tombol "Tambah ke Keranjang" diklik, sistem mengecek stok melalui CartService, jika stok tidak cukup, custom exception akan dilempar dan ditampilkan sebagai pesan Alert di GUI.

2. Penerapan SOLID: Aplikasi ini menerapkan Dependency Inversion dengan ketat. GUI tidak mengetahui adanya SQL; ia hanya berinteraksi dengan interface Service. Hal ini mempermudah pemeliharaan jika suatu saat database diganti.

3. Kendala & Solusi:

Kendala: Sinkronisasi stok antara database dan keranjang belanja saat item dihapus.

Solusi: Menambahkan logika reload data produk dari database setiap kali ada aksi pada keranjang belanja untuk memastikan data stok tetap akurat.
)
---

## Kesimpulan
(Aplikasi Agri-POS telah berhasil mengintegrasikan seluruh materi praktikum dari awal semester. Dengan penggunaan arsitektur berlapis (Service & DAO) serta pengujian otomatis melalui JUnit, aplikasi menjadi lebih stabil, terstruktur, dan mudah untuk dikembangkan lebih lanjut.*)

---

## Quiz
(
1. Apa manfaat utama penggunaan Service Layer di antara Controller dan DAO? Jawaban: Untuk memisahkan logika bisnis (seperti perhitungan diskon atau validasi stok) dari logika akses data. Ini membuat kode lebih bersih dan memungkinkan penggunaan kembali logika bisnis di berbagai View yang berbeda.

2. Mengapa unit testing sangat penting dalam tahap integrasi ini? Jawaban: Untuk memastikan bahwa penggabungan berbagai modul (DB, Keranjang, UI) tidak merusak logika dasar yang sudah dibuat sebelumnya (regression testing).

3. Sebutkan satu Design Pattern yang Anda gunakan dan alasannya. Jawaban: Singleton Pattern pada kelas koneksi database. Alasannya adalah untuk mengefisiensi penggunaan sumber daya dengan memastikan hanya ada satu koneksi aktif ke PostgreSQL selama aplikasi berjalan. )
