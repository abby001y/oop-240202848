# Laporan Praktikum Minggu 1
Topik: "Pengenalan Paradigma dan Setup Proyek"

## Identitas
- Nama  : Abbi priyoguno
- NIM   : 240202848
- Kelas : 3IKRB

---

## Tujuan
- Mahasiswa mampu mendefinisikan paradigma prosedural, OOP, dan fungsional.
- Mahasiswa mampu membandingkan kelebihan dan keterbatasan tiap paradigma.
- Mahasiswa mampu memberikan contoh program sederhana untuk masing-masing paradigma.
- Mahasiswa aktif dalam diskusi kelas (bertanya, menjawab, memberi opini).

---

## Dasar Teori
Paradigma pemrograman adalah cara pandang dalam menyusun program:  
- **Prosedural**: program dibangun sebagai rangkaian perintah (fungsi/prosedur).  
- **OOP (Object-Oriented Programming)**: program dibangun dari objek yang memiliki data (atribut) dan perilaku (method).  
- **Fungsional**: program dipandang sebagai pemetaan fungsi matematika, lebih menekankan ekspresi dan transformasi data. 

---

## Langkah Praktikum
1. Menginstall JDK versi terbaru dan cek instalasinya menggunakan perintah `java -version`  
2. Membuat file program `HelloProcedural.java`, `HelloOOP.java`, dan `HelloFunctional.java`.
3. Menulis kode sesuai paradigma yang diminta.
4. Melakukan eksekusi program
5. Mengecek hasil eksekusi di terminal.
6. Membuat commit ke repository GitHub dengan pesan commit `"week1-setup-hello-pos"`

---

## Kode Program
- Prosedural
```java
// HelloProcedural
public class HelloProcedural {
    public static void main(String[] args) {
        String nim = "240202848";
        String name = "abbi priyoguno";

        System.out.println("Hello World, I am " + name + " - " + nim);
    }
}
```

- OOP (Object-Oriented Programming)
```java
// HelloOOP
class Student {
    String nim;
    String name;
    Student(String nim, String name) {
        this.nim = nim;
        this.name = name;
    }

    void introduce() {
        System.out.println("Hello World, I am " + name + " - " + nim);
    }
}

public class HelloOOP {
    public static void main(String[] args) {
        Student s = new Student("240202848", "abbi priyoguno");
        s.introduce();
    }
}
```
- Fungsional
```java
// HelloFunctional
import java.util.function.BiConsumer;

public class HelloFunctional {
    public static void main(String[] args) {
        BiConsumer<String, String> introduce =
            (nim, name) -> System.out.println("Hello World, I am " + name + " - " + nim);

        introduce.accept("240202848","abbi priyoguno");
    }
}
```

---

## Hasil Eksekusi
- HelloProcedural
<img width="1017" height="582" alt="Screenshot 2025-10-10 221828" src="https://github.com/user-attachments/assets/f5b1f016-7b5d-4773-b14f-0461cf09cc1f" />


- HelloOOP
<img width="1019" height="596" alt="Screenshot 2025-10-10 212510" src="https://github.com/user-attachments/assets/0b8245c4-bb6e-44f1-ad63-99d4a7e6face" />

- HelloFunctional
<img width="1027" height="658" alt="Screenshot 2025-10-10 212711" src="https://github.com/user-attachments/assets/19965d28-cc77-47ec-9908-49a2a9a2f1b9" />


---

## Analisis
- Cara kerja kode:
   - Pada paradigma prosedural, kode hanya berupa urutan instruksi tanpa class.
   - Pada paradigma OOP, kode dibungkus dalam class Student sehingga data (nim, name) dan perilaku (introduce()) disatukan.
   - Pada paradigma fungsional, digunakan lambda expression dan functional interface (BiConsumer) untuk mencetak pesan.
   
- Perbedaan dengan minggu sebelumnya:
   - Minggu ini mulai diperkenalkan perbedaan paradigma, tidak hanya menulis instruksi sederhana.
   - Pendekatan OOP membuat program lebih terstruktur, sedangkan functional membuat kode lebih ringkas.
- Kendala:
   - Awalnya bingung membedakan kapan harus pakai class vs lambda.
   - Solusi: membaca dokumentasi Java tentang java.util.function dan contoh penggunaan OOP sederhana. 

---

## Kesimpulan
- Paradigma prosedural cocok untuk program sederhana dan cepat dibuat.
- Paradigma OOP memberikan struktur yang jelas dengan memanfaatkan class dan object, sehingga program lebih mudah dikembangkan.
- Paradigma fungsional membuat kode lebih ringkas dan mengurangi boilerplate dengan memanfaatkan lambda expression.
- Dengan memahami ketiga paradigma, mahasiswa dapat memilih pendekatan yang tepat sesuai kebutuhan aplikasi.

---

## Quiz
1. Apakah OOP selalu lebih baik dari prosedural?  
   **Jawaban:**
   Tidak selalu. OOP (Object-Oriented Programming) lebih baik untuk proyek besar dan kompleks yang memerlukan struktur data yang saling berhubungan, karena OOP memudahkan pengelolaan dan pemeliharaan kode melalui konsep class, inheritance, dan encapsulation.
   Namun, untuk proyek kecil atau tugas sederhana yang bersifat linear dan tidak membutuhkan banyak objek, paradigma prosedural bisa lebih efisien karena lebih ringan dan mudah dipahami.

2. Kapan functional programming lebih cocok digunakan dibanding OOP  atau prosedural?    
   **Jawaban:**
   Functional programming lebih cocok digunakan ketika program membutuhkan perhitungan matematis yang kompleks, pengolahan data yang bersifat paralel, atau manipulasi data dalam jumlah besar (misalnya pada data analysis atau machine learning).
   Paradigma ini unggul karena menghindari side effect dan mendorong immutability, sehingga mudah diuji dan lebih aman untuk pemrosesan paralel.

3. Bagaimana paradigma (prosedural, OOP, fungsional) memengaruhi maintainability dan scalability aplikasi?  
   **Jawaban:**
   - **Prosedural:** Kode lebih mudah ditulis tetapi sulit di-maintain jika program berkembang besar karena logika tersebar di banyak fungsi.  
   - **OOP:** Lebih mudah di-maintain dan scalable karena struktur kelas dan objek memudahkan penambahan fitur baru tanpa mengubah kode lama. 
   - **Functional:** Memiliki maintainability tinggi karena fungsi bersifat independen dan tidak memiliki efek samping, sehingga perubahan di satu fungsi jarang memengaruhi yang lain.

4. Mengapa OOP lebih cocok untuk mengembangkan aplikasi POS dibanding prosedural?  
**Jawaban:**
   Karena aplikasi POS (Point of Sale) memiliki banyak entitas berbeda yang saling berhubungan seperti `Produk`, `Transaksi`, `Kasir`, `Pelanggan`, dan `Pembayaran`. Dengan OOP:
   - Data dan perilaku bisa disatukan dalam class (misalnya `Transaksi` punya method `hitungTotal()`).
   - Relasi antar-objek jelas (misalnya `Transaksi` berisi daftar `Produk`).
   - Kode lebih terstruktur, mudah dikembangkan, dan di-*maintain* seiring bertambahnya fitur.

5. Bagaimana paradigma fungsional dapat membantu mengurangi kode berulang (boilerplate code)?  
**Jawaban:**
   Paradigma fungsional mengurangi boilerplate dengan:
   - **Higher-order function** → kita bisa membuat fungsi umum (misalnya `map`, `filter`, `reduce`) yang bisa dipakai ulang untuk berbagai kebutuhan tanpa menulis loop berulang.  
   - **Immutability & pure function** → memisahkan logika dari state, sehingga fungsi bisa dipakai ulang tanpa bergantung pada konteks.  
   - **Function composition** → membangun fungsi kompleks dari fungsi kecil tanpa duplikasi kode.  

   - **Function composition** → membangun fungsi kompleks dari fungsi kecil tanpa duplikasi kode.  
