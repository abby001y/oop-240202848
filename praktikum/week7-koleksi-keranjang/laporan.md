# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Abbi Priyoguno]
- NIM   : [240202848]
- Kelas : [3IKRB]

---

## Tujuan
1. Mahasiswa memahami konsep Java Collections Framework (List, Map, Set).

2. Mahasiswa mampu mengimplementasikan ArrayList untuk menyimpan objek produk secara dinamis.

3. Mahasiswa dapat melakukan operasi CRUD dasar (tambah, hapus, tampilkan) serta perhitungan total pada keranjang belanja.

4. Mahasiswa memahami penggunaan Map untuk mengelola jumlah (quantity) barang.

---

## Dasar Teori
1. Java Collections Framework: Kumpulan antarmuka dan kelas untuk menyimpan dan memanipulasi grup objek secara dinamis.

2. List (ArrayList): Struktur data yang menyimpan elemen secara terurut, memungkinkan duplikasi, dan ukurannya bisa berubah (resizable).

3. Map (HashMap): Struktur data yang menyimpan pasangan kunci (key) dan nilai (value). Sangat efektif untuk pencarian data berdasarkan kunci tertentu.

4. Set (HashSet): Koleksi yang tidak memperbolehkan adanya elemen duplikat dan tidak menjamin urutan elemen.

---

## Langkah Praktikum
1. Persiapan: Membuat struktur folder praktikum di praktikum/week7-collections/.

2. Pembuatan Model: Membuat file Product.java dengan atribut kode, nama, dan harga.

3. Implementasi Logika: - Membuat ShoppingCart.java menggunakan ArrayList.
   Membuat ShoppingCartMap.java menggunakan HashMap untuk fitur kuantitas.

4. Eksekusi: Membuat MainCart.java untuk menguji fungsionalitas tambah dan hapus produk.

5. Dokumentasi: Mengambil screenshot hasil eksekusi dan melakukan commit ke Git dengan format week7-collections: [fitur] [deskripsi].

---

## Kode Program
(Berikut adalah implementasi MainCart.java yang menggabungkan penggunaan keranjang belanja:

```java
package com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {
        // Ganti dengan Nama dan NIM Anda
        System.out.println("Hello, I am [Nama]-[NIM] (Week7)");

        Product p1 = new Product("P01", "Beras", 50000);
        Product p2 = new Product("P02", "Pupuk", 30000);

        // Menggunakan ArrayList
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        System.out.println("--- Keranjang ArrayList ---");
        cart.printCart();

        // Uji Hapus
        cart.removeProduct(p1);
        System.out.println("\n--- Setelah P01 Dihapus ---");
        cart.printCart();
    }
}
```
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/Screenshot%202026-01-14%20195949.png)
![Screenshot hasil](screenshots/Screenshot%202026-01-14%20200014.png)
![Screenshot hasil](screenshots/Screenshot%202026-01-14%20200029.png)
)
---

## Analisis
(
1. Cara Kerja Kode: Program bekerja dengan menyimpan instansiasi dari kelas Product ke dalam sebuah ArrayList di kelas ShoppingCart. Saat metode getTotal() dipanggil, program melakukan looping (perulangan) pada seluruh isi list untuk menjumlahkan harga.

2. Perbedaan Pendekatan: Minggu sebelumnya kita mungkin menggunakan array biasa yang ukurannya tetap (fixed-size). Minggu ini, penggunaan ArrayList mempermudah penambahan data tanpa perlu khawatir tentang batas kapasitas array.

3. Kendala: Salah satu kendala adalah memahami bagaimana ArrayList.remove(Object o) bekerja. Solusinya adalah memastikan objek yang dihapus merujuk pada referensi memori yang sama atau meng-override metode equals().
)
---

## Kesimpulan
Penggunaan Java Collections membuat pengelolaan data dalam aplikasi Agri-POS menjadi jauh lebih fleksibel. ArrayList sangat efektif untuk daftar belanja sederhana, sementara Map memberikan efisiensi lebih saat kita perlu melacak jumlah item yang sama tanpa menduplikasi objek di dalam memori.

---

## Quiz
1. Perbedaan mendasar antara List, Map, dan Set:

List: Terurut dan boleh duplikat (seperti antrean).

Set: Tidak boleh duplikat dan tidak terurut (seperti himpunan matematika).

Map: Pasangan key-value (seperti kamus atau indeks).

2. Mengapa ArrayList cocok untuk keranjang belanja sederhana? Karena mudah digunakan, mendukung penambahan elemen secara dinamis sesuai belanjaan pelanggan, dan kita seringkali hanya perlu menampilkan urutan barang yang dibeli secara berurutan.

3. Bagaimana struktur Set mencegah duplikasi data? Set menggunakan metode hashCode() dan equals(). Sebelum menambah data, Set mengecek apakah kode unik (hash) data tersebut sudah ada. Jika sudah ada dan dianggap sama oleh fungsi equals(), data baru tidak akan dimasukkan.

4. Kapan sebaiknya menggunakan Map dibandingkan List? Gunakan Map saat kita butuh memetakan data atau menghitung jumlah. Contoh: Dalam kasir, jika pelanggan beli 10 bungkus beras yang sama, daripada menyimpan 10 objek beras di List, lebih efisien simpan 1 objek beras sebagai key dan angka 10 sebagai value di Map.