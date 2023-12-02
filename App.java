import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class App {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean ulangTransaksi = true;
        while (ulangTransaksi) {
            // Input Data Transaksi
            System.out.println("----Input Data Transaksi----");
            try {
                System.out.print("No. Faktur: ");
                String noFaktur = scanner.nextLine();

                System.out.print("Nama Pelanggan: ");
                String namaPelanggan = scanner.nextLine();

                System.out.print("No. HP: ");
                String noHpPelanggan = scanner.nextLine();

                System.out.print("Alamat: ");
                String alamatPelanggan = scanner.nextLine();

                Faktur faktur = new Faktur(noFaktur, namaPelanggan);

                // Input Nama Kasir
                System.out.print("Nama Kasir: ");
                String namaKasir = scanner.nextLine();
                faktur.setNamaKasir(namaKasir);

            // Input Barang
            boolean tambahBarang = true;
            while (tambahBarang) {
                System.out.print("Kode Barang: ");
                String kodeBarang = scanner.nextLine();

                System.out.print("Nama Barang: ");
                String namaBarang = scanner.nextLine();

                System.out.print("Harga Barang: ");
                double hargaBarang = scanner.nextDouble();

                System.out.print("Jumlah Barang: ");
                int jumlahBarang = scanner.nextInt();
                scanner.nextLine();  // Membersihkan buffer newline

                Barang barang = new Barang(kodeBarang, namaBarang, hargaBarang, jumlahBarang);
                HitungTotalBayar hitungTotalBayar = new HitungTotalBayar();

                faktur.tambahBarang(barang);
                faktur.setTotalBayar(faktur.getTotalBayar() + hitungTotalBayar.calculateTotal(barang));

                // Apabila terdapat lebih dari satu barang
                System.out.print("Tambah barang lagi? (y/n): ");
                String tambahLagi = scanner.nextLine().toLowerCase();
                tambahBarang = tambahLagi.equals("y");
                }

                // Menampilkan faktur belanja
                System.out.println("\n====== R3 SUPERMARKET ======");
                System.out.println("Tanggal : " + getFormattedTanggal());
                System.out.println("Waktu   : " + getFormattedWaktu());
                System.out.println("No. Faktur: " + noFaktur);
                System.out.println("==============================");
                System.out.println("         DATA PELANGGAN");
                System.out.println("------------------------------");
                System.out.println("Nama Pelanggan : " + namaPelanggan.toUpperCase());
                System.out.println("No. HP         : " + noHpPelanggan);  // Tambahkan informasi No. HP
                System.out.println("Alamat         : " + alamatPelanggan);  // Tambahkan informasi Alamat
                System.out.println("++++++++++++++++++++++++++++++");
                System.out.println("      DATA PEMBELIAN BARANG");
                System.out.println("------------------------------");
                faktur.displayFaktur();
                // Tampilkan nama kasir
                System.out.println("++++++++++++++++++++++++++++++");
                System.out.println("Kasir: " + namaKasir.toUpperCase());
                System.out.println("Terima kasih! Silahkan datang kembali.");
            } catch (Exception e) {
                System.out.println("Terjadi Kesalahan Pada Input: " + e.getMessage());
                System.out.println("\n");
            }

            // untuk lanjut ke transaksi pembelian berikutnya
            System.out.print("\nLakukan transaksi pembeli berikutnya? (y/n): ");
            String ulangiTransaksi = scanner.nextLine().toLowerCase();
            ulangTransaksi = ulangiTransaksi.equals("y");

        }
        scanner.close();
    }

    // Metode untuk mendapatkan tanggal dan waktu saat ini dengan format "EEE, dd/MM/yyyy"
    private static String getFormattedTanggal() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEEEEEE, dd/MM/yyyy");
        return dateFormat.format(date);
    }

    // Metode untuk mendapatkan waktu saat ini dengan format "hh:mm:ss z"
    private static String getFormattedWaktu() {
        Date date = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss z");
        return timeFormat.format(date);
    }
}
