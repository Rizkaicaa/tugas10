import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean ulangTransaksi = true;
        while (ulangTransaksi) {
            // Input Data Transaksi
            System.out.println("------Input Data Transaksi------");
            try {
                System.out.print("No. Faktur: ");
                String noFaktur = scanner.nextLine();

                System.out.print("Nama Pelanggan: ");
                String namaPelanggan = scanner.nextLine();

                Faktur faktur = new Faktur(noFaktur, namaPelanggan);

                // Input Barang
                boolean tambahBarang = true;
                while (tambahBarang) {
                    System.out.print("Nama Barang: ");
                    String namaBarang = scanner.nextLine();

                    System.out.print("Harga Barang: ");
                    double hargaBarang = scanner.nextDouble();

                    System.out.print("Jumlah Barang: ");
                    int jumlahBarang = scanner.nextInt();
                    scanner.nextLine();

                    Barang barang = new Barang(namaBarang, hargaBarang, jumlahBarang);
                    HitungTotalBayar hitungTotalBayar = new HitungTotalBayar();

                    faktur.tambahBarang(barang);
                    faktur.setTotalBayar(faktur.getTotalBayar() + hitungTotalBayar.calculateTotal(barang));

                    // Apabila terdapat lebih dari satu barang
                    System.out.print("Tambah barang lagi? (y/n): ");
                    String tambahLagi = scanner.nextLine().toLowerCase();
                    tambahBarang = tambahLagi.equals("y");
                }

                // Faktur Belanja
                System.out.println("\n------Faktur Belanja------");
                faktur.displayFaktur();
                System.out.println("Terima kasih! Silahkan datang kembali.");

            }

            catch (Exception e) {
                System.out.println("Terjadi Kesalahan Pada Input: " + e.getMessage());
                System.out.println("\n");
            }

            // untuk lanjut ke transaksi pembeli berikutnya
            System.out.print("\nLakukan transaksi pembeli berikutnya? (y/n): ");
            String ulangiTransaksi = scanner.nextLine().toLowerCase();
            ulangTransaksi = ulangiTransaksi.equals("y");
        }

        scanner.close();
    }
}
