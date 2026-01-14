# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Abbi Priyoguno]
- NIM   : [240202848]
- Kelas : [3IKRB]

---

## Tujuan
(
1. Mahasiswa memahami konsep event-driven programming menggunakan JavaFX.

2. Mahasiswa mampu membangun antarmuka grafis (GUI) untuk form input data produk.

3. Mahasiswa mampu mengintegrasikan GUI dengan modul backend (DAO dan Service) yang telah dibuat sebelumnya.

4. Mahasiswa mampu merealisasikan desain desain UML (Bab 6) ke dalam implementasi kode yang nyata.*)

---

## Dasar Teori
(
1. Event-Driven Programming: Paradigma pemrograman di mana alur program ditentukan oleh peristiwa (event) seperti klik tombol, input keyboard, atau pesan dari sistem.

2. JavaFX: Framework modern untuk membangun aplikasi desktop di Java yang menggunakan hierarki Scene Graph.

3. MVC dalam GUI: Memisahkan komponen antara data (Model), tampilan (View), dan logika kontrol (Controller) untuk menjaga kode tetap bersih dan maintainable.

4. Dependency Inversion Principle (DIP): Sesuai prinsip SOLID, komponen View tidak boleh memanggil DAO secara langsung, melainkan melalui lapisan Service.)

---

## Langkah Praktikum
(
1. Setup Library: Menyiapkan library JavaFX dalam proyek dan memastikan koneksi JDBC PostgreSQL tetap aktif.

2. Implementasi Service: Memastikan ProductService sudah tersedia untuk menjembatani antara Controller GUI dan ProductDAO.

3. Desain Layout: Membuat kelas ProductFormView yang berisi komponen TextField (Kode, Nama, Harga, Stok) dan Button.

4. Event Handling: Menambahkan listener setOnAction pada tombol tambah untuk menangkap input data.

5. Integrasi & Running: Menjalankan aplikasi melalui kelas AppJavaFX dan melakukan pengujian input data ke database..)

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
![Screenshot hasil](screenshots/Screenshot%202026-01-12%20031020.png)

)

---

## Analisis
(
1. Analisis Kode: Program berjalan secara asinkron dalam konteks event loop JavaFX. Saat tombol diklik, program memvalidasi input, mengirimkannya ke ProductService, yang kemudian memerintahkan ProductDAO untuk menjalankan query INSERT ke PostgreSQL.

2. Traceability Bab 6: Pendekatan minggu ini merupakan implementasi fisik dari Sequence Diagram yang dirancang di Bab 6. Urutan panggilan View -> Controller -> Service -> DAO diterapkan secara ketat tanpa melompati lapisan (DIP).

3. Kendala dan Solusi: Kendala utama adalah error Not on FX application thread saat mencoba update UI. Solusinya adalah memastikan semua manipulasi komponen GUI dilakukan di dalam thread utama JavaFX.
)
---

## Kesimpulan
(Dengan mengintegrasikan JavaFX dan JDBC menggunakan pola MVC, aplikasi Agri-POS kini memiliki antarmuka pengguna yang fungsional. Penerapan prinsip SOLID dari Bab 6 memastikan bahwa perubahan pada database atau UI tidak akan merusak logika bisnis utama di lapisan Service.*)

---

## Quiz
(J
1. elaskan konsep event-driven programming. Jawaban: Konsep di mana alur eksekusi program sangat bergantung pada interaksi pengguna (seperti klik mouse, ketikan keyboard) yang menghasilkan sinyal/event untuk kemudian ditangani oleh fungsi tertentu (event handler).

2. Mengapa View tidak boleh memanggil DAO langsung? Jawaban: Hal ini melanggar prinsip Single Responsibility dan Dependency Inversion. Jika UI terikat langsung ke database (DAO), maka perubahan struktur tabel akan memaksa kita mengubah kode UI, yang membuat sistem sulit dikelola (tight coupling).

3. Apa fungsi dari ProductService dalam arsitektur ini? Jawaban: Sebagai lapisan abstraksi yang menampung logika bisnis (seperti validasi atau perhitungan pajak) sebelum data dikirim ke DAO untuk disimpan secara permanen. )
