# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Abbi Priyoguno]
- NIM   : [240202848]
- Kelas : [3IKRB]

---

## Tujuan
1. Mahasiswa mampu mengidentifikasi kebutuhan sistem ke dalam diagram UML.

2. Mahasiswa mampu membuat Use Case, Activity, Sequence, dan Class Diagram yang konsisten.

3. Mahasiswa mampu menerapkan dan menjelaskan prinsip desain SOLID dalam arsitektur perangkat lunak.
---

## Dasar Teori
1. UML (Unified Modeling Language): Bahasa standar untuk memvisualisasikan, menspesifikasikan, 2. 2. membangun, dan mendokumentasikan artefak dari sistem perangkat lunak.

2. SOLID Principles: Lima prinsip desain kelas dalam OOP (Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, dan Dependency Inversion) untuk meningkatkan maintainability dan scalability.

3. Agri-POS: Sistem kasir khusus produk pertanian yang membutuhkan fleksibilitas dalam metode pembayaran dan pengelolaan stok.

---

## Langkah Praktikum
1. Analisis Kebutuhan: Memetakan Functional Requirements (FR) seperti manajemen produk dan transaksi ke dalam Use Case.

2. Perancangan Alur: Membuat Activity Diagram untuk proses Checkout dan Sequence Diagram untuk interaksi objek saat pembayaran.

3. Perancangan Struktur: Menyusun Class Diagram dengan memperhatikan relasi (asosiasi, komposisi) dan enkapsulasi.

4. Penerapan SOLID: Mengintegrasikan interface PaymentMethod dan pola Repository untuk memenuhi prinsip OCP dan DIP.

5. Dokumentasi: Mengekspor diagram ke format .png dan menyusun tabel traceability.

---

## Kode Program
(Berikut adalah cuplikan kode Java yang merepresentasikan penerapan prinsip Open/Closed dan Dependency Inversion pada bagian pembayaran:

```java
// Antarmuka untuk abstraksi (DIP)
interface PaymentMethod {
    void processPayment(double amount);
}

// Implementasi konkrit yang bisa ditambah tanpa mengubah kode lama (OCP)
class CashPayment implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Pembayaran tunai sebesar: " + amount);
    }
}

class EWalletPayment implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Pembayaran E-Wallet sebesar: " + amount);
    }
}

// Service yang bergantung pada abstraksi
class PaymentService {
    private PaymentMethod method;

    public PaymentService(PaymentMethod method) { // Constructor Injection
        this.method = method;
    }

    public void checkout(double total) {
        method.processPayment(total);
    }
}
```
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.)  
![Screenshot hasil](docs/class%20diagram.drawio.png)
![Screenshot hasil](docs/activiti%20Diagram.drawio.png)
![Screenshot hasil](docs/sequence%20Diagram.drawio.png)
![Screenshot hasil](docs/usecase%20Diagram.drawio.png
)
---

## Analisis
(
FR,Use Case,Activity/Sequence,Class/Interface
Manajemen Produk,UC-Kelola Produk,Activity Produk,"ProductService, ProductRepository"
Pembayaran,UC-Checkout,Seq Pembayaran,"PaymentMethod, CashPayment, EWalletPayment"
)
---

## Kesimpulan
Dengan menerapkan UML dan prinsip SOLID pada sistem Agri-POS, arsitektur menjadi lebih modular. Hal ini memudahkan pengembang untuk melakukan pengujian (testability) dan menambahkan fitur baru di masa depan tanpa merusak fitur yang sudah ada (extensibility).
---

## Quiz
1. Jelaskan perbedaan aggregation dan composition serta berikan contohnya.

Aggregation (Agregasi): Hubungan "has-a" yang lemah. Objek bagian dapat berdiri sendiri tanpa objek induk. Contoh: Gudang dan Produk. Jika Gudang dihapus, Produk tetap ada.

Composition (Komposisi): Hubungan "has-a" yang kuat. Objek bagian tidak bisa hidup tanpa induknya. Contoh: Transaksi dan ItemTransaksi. Jika data Transaksi dihapus, maka Item didalamnya otomatis ikut terhapus.

2. Bagaimana prinsip Open/Closed dapat memastikan sistem mudah dikembangkan? Prinsip ini memungkinkan kita menambah fungsionalitas baru hanya dengan menambah kode baru (extension), bukan mengubah kode yang sudah berjalan (modification). Ini meminimalisir risiko munculnya bug pada fitur lama yang sudah stabil.

3. Mengapa Dependency Inversion Principle (DIP) meningkatkan testability? DIP memungkinkan kita melakukan Injection. Saat pengujian, kita bisa memasukkan "Mock Object" (objek tiruan) ke dalam service alih-alih menggunakan database atau payment gateway asli, sehingga unit testing dapat berjalan lebih cepat dan terisolasi.