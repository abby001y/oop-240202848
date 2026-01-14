# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Abbi Priyoguno]
- NIM   : [240202848]
- Kelas : [3IKRB]

---

## Tujuan
(
1. Mahasiswa mampu menampilkan data secara terstruktur menggunakan komponen TableView JavaFX.

2. Mahasiswa mampu menerapkan Lambda Expression untuk menyederhanakan penulisan event handling.

3. Mahasiswa mampu menghubungkan secara penuh antarmuka GUI dengan Data Access Object (DAO) melalui Service Layer.

4. Mahasiswa mampu membangun fitur interaktif (Tambah dan Hapus) yang berdampak langsung pada database PostgreSQL.*)

---

## Dasar Teori
(
1. TableView: Komponen JavaFX yang digunakan untuk menampilkan data dalam bentuk baris dan kolom. Menggunakan ObservableList untuk memantau perubahan data secara otomatis pada UI.

2. Lambda Expression: Fitur Java yang memungkinkan penulisan fungsi anonim secara ringkas, sangat efektif digunakan untuk implementasi Functional Interface seperti EventHandler pada JavaFX.

3. Event-Driven Architecture: Model pemrograman di mana tindakan pengguna (klik hapus, klik tambah) memicu urutan proses dari View ke Controller, Service, hingga ke Database.

4. Data Binding: Proses menghubungkan properti objek model (misal: Product) dengan kolom di TableView menggunakan CellValueFactory.)

---

## Langkah Praktikum
(
1. Persiapan: Melanjutkan proyek dari Minggu 12. Memastikan library JDBC PostgreSQL sudah terkonfigurasi.

2. Modifikasi View: Mengganti komponen ListView atau TextArea lama menjadi TableView<Product>.

3. Konfigurasi Kolom: Menentukan kolom (Kode, Nama, Harga, Stok) dan menghubungkannya dengan atribut di kelas Product.

4. Implementasi Lambda: Menambahkan event listener pada tombol Hapus menggunakan sintaks e -> { ... }.

5. Implementasi loadData(): Membuat metode untuk mengambil list produk dari ProductService.findAll() dan memasukkannya ke dalam tabel saat aplikasi dijalankan.

6. Testing: Melakukan operasi tambah dan hapus, kemudian memverifikasi apakah data di database PostgreSQL ikut berubah..)

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
![Screenshot hasil](screenshots/Screenshot%202026-01-14%20180548.png)
![Screenshot hasil](screenshots/Screenshot%202026-01-14%20180805.png)
)

---

## Analisis
(
1. Analisis Kode: Penggunaan TableView memberikan tampilan yang jauh lebih profesional dan terorganisir dibandingkan ListView. Integrasi dengan ProductService memastikan bahwa aplikasi tetap mengikuti prinsip Dependency Inversion (DIP), di mana lapisan UI tidak mengetahui detail teknis query SQL.

2. Perbedaan Pendekatan: Jika sebelumnya pada Minggu 12 tampilan bersifat statis atau sederhana, minggu ini aplikasi sudah mendukung interaksi penuh terhadap database (CRUD). Penggunaan Lambda Expression membuat kode Controller menjadi lebih pendek dan mudah dibaca dibandingkan menggunakan Anonymous Inner Class.

3. Kendala dan Solusi: Kendala yang dihadapi adalah data tidak langsung muncul saat aplikasi dibuka. Solusinya adalah memanggil metode loadData() di dalam blok initialize() agar TableView terisi sesaat setelah komponen UI siap.
)
---

## Kesimpulan
(Praktikum ini berhasil mengintegrasikan seluruh komponen sistem Agri-POS, mulai dari backend (Database & DAO) hingga frontend (JavaFX TableView). Dengan arsitektur MVC dan penggunaan Lambda, kode menjadi lebih modular, bersih, dan siap untuk dikembangkan menjadi aplikasi kasir yang lebih kompleks.*)

---

## Quiz
(
1. Apa keuntungan menggunakan TableView dibandingkan ListView? Jawaban: TableView memungkinkan data ditampilkan dalam format kolom yang terorganisir, mendukung pengurutan (sorting) otomatis per kolom, dan lebih mudah dipetakan langsung ke properti objek model melalui CellValueFactory.

2. Mengapa Lambda Expression sangat disarankan dalam event handling JavaFX? Jawaban: Karena Lambda membuat kode lebih ringkas (boilerplate-free), meningkatkan keterbacaan kode, dan karena sebagian besar event handler JavaFX adalah Functional Interface (hanya memiliki satu metode abstrak).

3. Bagaimana cara memastikan data di TableView sinkron dengan Database? Jawaban: Dengan memanggil metode loadData() yang melakukan query findAll() ke database melalui DAO/Service setiap kali ada aksi yang mengubah data (seperti Tambah atau Hapus). )
