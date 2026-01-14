package main.java.com.upb.agripos;

import main.java.com.upb.agripos.model.*;
import main.java.com.upb.agripos.util.CreditBy;

public class MainInheritance {
    public static void main(String[] args) {
        Benih b = new Benih("BNH-001", "Benih Padi IR64", 20000, 250, "IR64");
        Pupuk p = new Pupuk("PPK-101", "Pupuk Urea", 300000, 50, "Urea");
        AlatPertanian a = new AlatPertanian("ALT-501", "Cangkul Baja", 70000, 20, "Baja");

        System.out.println("------------------------------------------");
        System.out.println(b.deskripsi());

        System.out.println("------------------------------------------");
        System.out.println(p.deskripsi());
        
        System.out.println("------------------------------------------");
        System.out.println(a.deskripsi());

        CreditBy.print("240202848", "Abbi priyoguno");
    }
}