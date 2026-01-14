# Laporan Praktikum Minggu 4
Topik: Polymorphism (Info Produk)

## Identitas
- Nama  : Abbi priyoguno
- NIM   : 240202848
- Kelas : 3IKRB

---

## Tujuan
- Mahasiswa mampu **menjelaskan konsep polymorphism** dalam OOP.  
- Mahasiswa mampu **membedakan method overloading dan overriding**.  
- Mahasiswa mampu **mengimplementasikan polymorphism (overriding, overloading, dynamic binding)** dalam program.  
- Mahasiswa mampu **menganalisis contoh kasus polymorphism** pada sistem nyata (Agri-POS).
---

## Dasar Teori
Polymorphism berarti “banyak bentuk” dan memungkinkan objek yang berbeda merespons panggilan method yang sama dengan cara yang berbeda.

   1. Overloading → mendefinisikan method dengan nama sama tetapi parameter berbeda.
   2. Overriding → subclass mengganti implementasi method dari superclass.
   3. Dynamic Binding → pemanggilan method ditentukan saat runtime, bukan compile time.
Dalam konteks Agri-POS, misalnya:

   -Method getInfo() pada Produk dioverride oleh Benih, Pupuk, AlatPertanian untuk menampilkan detail spesifik.
   
   -Method tambahStok() bisa dibuat overload dengan parameter berbeda (int, double).

---

## Langkah Praktikum
1. **Overloading**  
   - Tambahkan method `tambahStok(int jumlah)` dan `tambahStok(double jumlah)` pada class `Produk`.  

2. **Overriding**  
   - Tambahkan method `getInfo()` pada superclass `Produk`.  
   - Override method `getInfo()` pada subclass `Benih`, `Pupuk`, dan `AlatPertanian`.  

3. **Dynamic Binding**  
   - Buat array `Produk[] daftarProduk` yang berisi objek `Benih`, `Pupuk`, dan `AlatPertanian`.  
   - Loop array tersebut dan panggil `getInfo()`. Perhatikan bagaimana Java memanggil method sesuai jenis objek aktual.  

4. **Main Class**  
   - Buat `MainPolymorphism.java` untuk mendemonstrasikan overloading, overriding, dan dynamic binding.  

5. **CreditBy**  
   - Tetap panggil `CreditBy.print("<NIM>", "<Nama>")`.  

6. **Commit dan Push**  
   - Commit dengan pesan: `week4-polymorphism`.

---

## Kode Program

### Produk.java (Overloading & getInfo default)  

```java
package main.java.com.upb.agripos.model;
// Produk.java

public class Produk {
    private String kode;
    private String nama;
    private double harga;
    protected int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public void tambahStok(int jumlah) {
        if (jumlah > 0) {
            this.stok += jumlah;
            System.out.println("Stok " + nama + " bertambah " + jumlah + " (int). Stok baru: " + this.stok);
        } else {
            // Mengubah pesan agar lebih sesuai konteks
            System.out.println("Gagal: Jumlah stok yang ditambahkan harus lebih dari nol!");
        }
    }

    public void tambahStok(double jumlah) {
        int jumlahInt = (int) Math.round(jumlah);
        if (jumlahInt > 0) {
            this.stok += jumlahInt;
            System.out.println("Stok " + nama + " bertambah " + jumlah + " (double/dibulatkan jadi " + jumlahInt + "). Stok baru: " + this.stok);
        } else {
            System.out.println("Gagal: Jumlah stok yang ditambahkan (setelah dibulatkan) harus lebih dari nol!");
        }
    }

    public void kurangiStok(int jumlah) {
        if (this.stok >= jumlah) {
            this.stok -= jumlah;
            System.out.println("Stok " + nama + " berkurang " + jumlah + ". Stok baru: " + this.stok);
        } else {
            System.out.println("Stok tidak mencukupi untuk " + nama + "! Tersedia: " + this.stok);
        }
    }

    public void tampilkanData() {
        System.out.println("  Kode Produk: " + kode);
        System.out.println("  Nama Produk: " + nama);
        System.out.println("  Harga (Rp): " + harga);
        System.out.println("  Stok Tersedia: " + stok);
    }

    public void getInfo() {
        System.out.println("--- Detail Produk Umum ---");
        System.out.println(" Kode: " + kode);
        System.out.println(" Nama: " + nama);
        System.out.println(" Harga (Rp): " + harga);
        System.out.println(" Stok Tersedia: " + stok);
    }

}
```
### MainPolymorphism.java

```package main.java.com.upb.agripos;

import main.java.com.upb.agripos.model.AlatPertanian;
import main.java.com.upb.agripos.model.Benih;
import main.java.com.upb.agripos.model.ObatTanaman;
import main.java.com.upb.agripos.model.Produk;
import main.java.com.upb.agripos.model.Pupuk;
import main.java.com.upb.agripos.util.CreditBy; 

public class MainPolymorphism {
    public static void main(String[] args) {
        
        System.out.println("=== WEEK4 POLYMORPHISM ===");
        
        System.out.println("\n--- Overloading (tambahStok) ---");
        Produk produkUmum = new Produk("PRD001", "Jagung", 300000, 150);

        System.out.print("Panggilan INT: ");
        produkUmum.tambahStok(50); 
        
        System.out.print("Panggilan DOUBLE: ");
        produkUmum.tambahStok(14.8); 

        
        System.out.println("\n--- Overriding (getInfo) & Dynamic Binding ---");
        
        Benih b = new Benih("BNH-001", "Benih Padi IR64", 25000, 150, "IR64");
        

        Pupuk p_urea = new Pupuk("PPK-101", "Pupuk Urea", 350000,20, "Anorganik");
        Pupuk p_granul = new Pupuk("PPK-102", "Pupuk Granul", 550000, 50, "Organik"); 

    
        AlatPertanian a_baja = new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 25, "Baja");
        AlatPertanian a_kayu = new AlatPertanian("ALT-502", "Garu", 20000, 25, "Kayu");
        AlatPertanian a_plastik = new AlatPertanian("ALT-503", "Mulsa", 750000, 20, "Plastik");

        ObatTanaman o_tanaman = new ObatTanaman("OBT1", "Gramaxon", 45000, 25, "Cair"); 
        
        Produk[] daftarProduk = {
            b, 
            p_urea, 
            p_granul,
            a_baja,
            a_kayu,
            a_plastik, 
            o_tanaman, 
            produkUmum 
        };
        
        System.out.println("\nHasil getInfo() melalui array Produk[]:");
        for (Produk p : daftarProduk) {
            
            p.getInfo(); 
        }

        
        CreditBy.print("240202848", "Abbi priyoguno"); 
    }
}
```
---

## Hasil Eksekusi  
![alt text](<Screenshot 2025-12-11 110035.png>)
![alt text](<Screenshot 2025-12-11 110231.png>)
![alt text](<Screenshot 2025-12-11 110252.png>)

---
## Analisis
- **Jelaskan bagaimana kode berjalan.**

   Program membuat beberapa objek produk pertanian (Benih, Pupuk, AlatPertanian, dan ObatHama) yang semuanya turunan dari class Produk. Setiap subclass meng-override method getInfo() agar menampilkan informasi berbeda sesuai jenis produk. Array Produk[] digunakan untuk menyimpan semua objek tersebut, lalu saat p.getInfo() dipanggil di dalam perulangan, Java otomatis memanggil versi method yang sesuai dengan objek aslinya (dynamic binding).

- **Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.** 

   Minggu sebelumnya (Inheritance) fokus pada pewarisan atribut dan method dari superclass ke subclass. Sedangkan minggu ini (Polymorphism) fokus pada perbedaan perilaku antar subclass melalui method overriding dan dynamic binding, meskipun dipanggil dengan tipe referensi yang sama (Produk).

- **Kendala yang dihadapi dan cara mengatasinya.**

  Kebingungan antara Overloading dan Overriding: Terdapat dua jenis utama polimorfisme (statis/waktu kompilasi dan dinamis/waktu proses), yang masing-masing dicapai melalui method overloading dan method overriding. Pemula sering kali bingung membedakan kedua mekanisme ini dan kapan harus menggunakannya. 
---

## Kesimpulan
Melalui rangkaian praktikum ini, kita dapat melihat bagaimana prinsip Polymorphism bekerja sebagai jembatan yang menyatukan berbagai jenis objek di bawah satu identitas. Dengan memanfaatkan method overloading dan overriding, kita telah membangun sistem yang cerdas: sistem yang mampu mengenali bahwa meskipun Benih, Pupuk, dan AlatPertanian adalah barang yang berbeda secara karakteristik, mereka semua tetaplah sebuah Produk.
Fleksibilitas ini terlihat jelas saat kita memanggil method getInfo(). Tanpa perlu menulis kode yang berulang-ulang untuk setiap jenis barang, Java secara otomatis memberikan informasi yang paling relevan sesuai dengan wujud asli objeknya. Hal ini membuktikan bahwa polimorfisme bukan sekadar teknik pemograman, melainkan strategi untuk menciptakan kode yang "rapi di luar, namun spesifik di dalam", sehingga memudahkan pengembang dalam memperluas sistem di masa depan tanpa merombak struktur yang sudah ada.

---

## Quiz
1. Mengenai perbedaan Overloading dan Overriding: Jika diibaratkan, overloading adalah seperti satu orang yang memiliki banyak keahlian berbeda namun menggunakan satu nama yang sama (misalnya, seorang "Koki" yang bisa memasak nasi goreng atau memanggang roti tergantung bahan yang diberikan). Sebaliknya, overriding adalah seperti sebuah tradisi yang diwariskan dari orang tua ke anak, namun si anak memutuskan untuk melakukan tradisi tersebut dengan caranya sendiri yang lebih modern tanpa mengubah nama tradisinya. Secara teknis, overloading dibedakan dari parameter metodenya di satu kelas, sementara overriding mengubah perilaku metode milik induk di dalam kelas anak.

2. Mekanisme Penentuan Method dalam Dynamic Binding: Proses ini terjadi di balik layar saat program sedang berjalan (runtime). Java tidak terburu-buru menentukan metode mana yang akan dipakai saat kode dikompilasi. Sebaliknya, Java menunggu hingga detik terakhir saat objek benar-benar digunakan. JVM (Java Virtual Machine) akan memeriksa "identitas asli" dari objek yang disimpan dalam memori. Meskipun variabelnya bertipe induk, jika objek di dalamnya adalah milik kelas anak, maka Java akan "setia" pada implementasi yang ada di kelas anak tersebut. Inilah yang membuat program kita bisa berperilaku dinamis.

3. Contoh Polymorphism pada Sistem POS (Point of Sale) Ritel: Mari kita bayangkan sistem pada kasir supermarket saat memproses "Pajak". Setiap barang mungkin memiliki skema pajak yang berbeda:
Produk Sembako mungkin memiliki metode hitungPajak() yang mengembalikan nilai 0% (bebas pajak).
Produk Mewah (seperti parfum atau elektronik) memiliki metode hitungPajak() yang mengenakan tarif 20%.
Produk Impor memiliki logika pajak tambahan bea cukai di dalam metode yang sama.
Meskipun logika di dalamnya sangat berbeda, mesin kasir cukup memanggil satu perintah: barang.hitungPajak(). Polimorfisme memastikan bahwa setiap barang menghitung pajaknya sendiri sesuai dengan aturan yang berlaku bagi dirinya, tanpa kasir perlu mengecek satu per satu jenis barangnya secara manual.