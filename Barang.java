public class Barang {
    private String namaBarang;
    private double harga;
    private int jumlah;

    public Barang(String namaBarang, double harga, int jumlah) {
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public double getHarga() {
        return harga;
    }

    public int getJumlah() {
        return jumlah;
    }
}
