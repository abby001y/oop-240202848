# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Abbi Priyoguno]
- NIM   : [240202848]
- Kelas : [3IKRB]

---

## Tujuan
1. Memahami perbedaan antara Error dan Exception dalam Java.

2. Mengimplementasikan blok try–catch–finally untuk menangani kesalahan program.

3. Mampu membuat Custom Exception untuk validasi logika bisnis yang spesifik.

4. Menerapkan penanganan eksepsi pada studi kasus keranjang belanja Agri-POS.

---

## Dasar Teori
1. Error vs Exception: Error adalah masalah fatal yang tidak dapat ditangani program (seperti OutOfMemory), sedangkan Exception adalah kondisi tidak normal yang masih dapat ditangani menggunakan kode program.

2. try–catch–finally: Mekanisme penanganan kesalahan di mana kode berisiko diletakkan di dalam try, penanganan di catch, dan kode yang wajib dieksekusi diletakkan di finally.

3. Custom Exception: Kelas pengecualian buatan sendiri yang diturunkan dari kelas Exception untuk menangani validasi khusus (misalnya stok kurang atau input negatif).

4. Throw & Throws: throw digunakan untuk melempar eksepsi secara manual, sedangkan throws digunakan pada method signature untuk mendeklarasikan bahwa metode tersebut berpotensi menghasilkan eksepsi.
---

## Langkah Praktikum
1. Pembuatan Custom Exception: Membuat tiga kelas pengecualian baru: InvalidQuantityException, ProductNotFoundException, dan InsufficientStockException.

2. Pengembangan Model: Menambahkan atribut stock pada kelas Product dan metode untuk mengurangi stok.

3. Logika Bisnis: Mengintegrasikan pengecekan validasi pada kelas ShoppingCart. Jika validasi gagal, program akan memicu throw new [CustomException].

4. Uji Coba (Demo): Membuat kelas MainExceptionDemo yang menjalankan skenario kesalahan (input negatif, produk tidak ditemukan, stok habis) di dalam blok try-catch.

5. Commit & Push: Mengunggah hasil pekerjaan ke repositori dengan pesan commit sesuai format.
---

## Kode Program
(Berikut adalah bagian inti dari penanganan eksepsi pada kelas ShoppingCart:

```java
public void checkout() throws InsufficientStockException {
    for (Map.Entry<Product, Integer> entry : items.entrySet()) {
        Product product = entry.getKey();
        int qty = entry.getValue();
        
        // Validasi stok sebelum proses checkout
        if (product.getStock() < qty) {
            throw new InsufficientStockException(
                "Stok tidak cukup untuk: " + product.getName()
            );
        }
    }
    
    // Pengurangan stok dieksekusi hanya jika semua stok mencukupi
    for (Map.Entry<Product, Integer> entry : items.entrySet()) {
        entry.getKey().reduceStock(entry.getValue());
    }
    System.out.println("Checkout berhasil!");
}
```
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/Screenshot%202026-01-14%20200906.png)
![Screenshot hasil](screenshots/Screenshot%202026-01-14%20200956.png)
![Screenshot hasil](screenshots/Screenshot%202026-01-14%20201019.png)
![Screenshot hasil](screenshots/Screenshot%202026-01-14%20201043.png)
)
---

## Analisis
(
1. Alur Kode: Saat cart.addProduct(p1, -1) dipanggil, metode tersebut mendeteksi angka negatif dan langsung melempar InvalidQuantityException. Program kemudian langsung melompat ke blok catch tanpa mengeksekusi baris di bawahnya.

2. Perbedaan Pendekatan: Dibandingkan minggu sebelumnya, program sekarang tidak langsung "crash" atau mati saat terjadi kesalahan input. Program memberikan pesan kesalahan yang informatif kepada pengguna.

3. Kendala dan Solusi: Kendala utama adalah memastikan semua pengecekan dilakukan sebelum stok benar-benar dikurangi. Solusinya adalah menggunakan loop pengecekan terpisah sebelum melakukan eksekusi pengurangan stok (reduceStock). 
)
---

## Kesimpulan
(Dengan menggunakan Exception Handling, aplikasi Agri-POS menjadi lebih robust (tangguh) terhadap kesalahan input pengguna. Penggunaan Custom Exception memungkinkan pengembang memberikan diagnosa kesalahan yang lebih spesifik sesuai dengan logika bisnis pertanian (stok pupuk habis, dsb).)

---

## Quiz
(
1. Jelaskan perbedaan error dan exception. Jawaban: Error bersifat fatal dan disebabkan oleh lingkungan eksekusi (seperti kegagalan sistem/hardware), sedangkan Exception disebabkan oleh kesalahan logika program atau input yang masih bisa diantisipasi.

2. Apa fungsi finally dalam blok try–catch–finally? Jawaban: Blok finally berisi kode yang akan selalu dijalankan, baik saat terjadi pengecualian maupun tidak. Biasanya digunakan untuk cleanup seperti menutup koneksi database atau file.

3. Mengapa custom exception diperlukan? Jawaban: Agar pesan kesalahan lebih spesifik dan relevan dengan domain aplikasi. Exception bawaan Java (seperti IllegalArgumentException) terlalu umum, sedangkan InsufficientStockException langsung memberitahu apa masalahnya dalam konteks POS.

4. Berikan contoh kasus bisnis dalam POS yang membutuhkan custom exception. Jawaban:

ExpiredProductException: Terjadi jika produk yang di-scan sudah melewati tanggal kedaluwarsa.

NegativePaymentException: Terjadi jika kasir menginput jumlah uang pembayaran yang lebih kecil dari total tagihan.
 )
