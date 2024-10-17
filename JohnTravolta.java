import java.util.Scanner;

public class HitungGaji {

    // Method untuk menghitung gaji
    public static double hitungGaji(double jamKerja, double tarifPerJam) {
        double jamNormal = 40;
        double lemburRate = 1.5;
        double gajiNormal, gajiLembur, totalGaji;

        if (jamKerja <= jamNormal) {
            gajiNormal = jamKerja * tarifPerJam;
            gajiLembur = 0;
        } else {
            gajiNormal = jamNormal * tarifPerJam;
            double jamLembur = jamKerja - jamNormal;
            gajiLembur = jamLembur * tarifPerJam * lemburRate;
        }

        totalGaji = gajiNormal + gajiLembur;
        return totalGaji;
    }

    // Method untuk menghitung tabungan
    public static String[] hitungTabungan(double gaji, double pengeluaran) {
        String status;
        double tabungan;

        if (gaji > pengeluaran) {
            status = "Bisa menabung";
            tabungan = gaji - pengeluaran;
        } else if (gaji == pengeluaran) {
            status = "Tidak bisa menabung";
            tabungan = 0;
        } else {
            status = "Cari tambahan";
            tabungan = gaji - pengeluaran; // Nilai negatif jika pengeluaran lebih besar dari gaji
        }

        return new String[]{Double.toString(tabungan), status};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input dari pengguna
        System.out.print("Masukkan jam kerja Mr. John Travolta: ");
        double jamKerja = input.nextDouble();

        double tarifPerJam = 15000; // Tarif per jam tetap

        System.out.print("Masukkan pengeluaran Mr. John Travolta minggu ini: ");
        double pengeluaran = input.nextDouble();

        // Hitung gaji dan tabungan
        double gaji = hitungGaji(jamKerja, tarifPerJam);
        String[] hasilTabungan = hitungTabungan(gaji, pengeluaran);
        double tabungan = Double.parseDouble(hasilTabungan[0]);
        String status = hasilTabungan[1];

        // Output
        System.out.println("Gaji Mr. John Travolta: Rp " + gaji);
        System.out.println("Tabungan minggu ini: Rp " + tabungan);
        System.out.println(status);
    }
}
