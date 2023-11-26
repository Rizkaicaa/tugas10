import java.util.ArrayList;

public class Faktur {
    private String noFaktur;
    private String namaPelanggan;
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private double totalBayar;

    public Faktur(String noFaktur, String namaPelanggan) throws MinimarketException {
        if (noFaktur == null || noFaktur.isEmpty() || namaPelanggan == null || namaPelanggan.isEmpty()) {
            throw new MinimarketException("Input tidak valid");
        }

        this.noFaktur = noFaktur;
        this.namaPelanggan = namaPelanggan;
    }

    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void displayFaktur() {
        System.out.println("No. Faktur: " + noFaktur);
        System.out.println("Nama Pelanggan: " + namaPelanggan);

        System.out.println("Daftar Barang:");
        for (Barang barang : daftarBarang) {
            System.out.println("- " + barang.getNamaBarang() + " | Harga: " + barang.getHarga() +
                    " | Jumlah: " + barang.getJumlah());
        }

        System.out.println("Total Bayar: " + totalBayar);
    }
}
