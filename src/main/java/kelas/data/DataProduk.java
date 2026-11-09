package kelas.data;

import kelas.model.Produk;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataProduk {

    private final ObservableList<Produk> daftar =
            FXCollections.observableArrayList();

    private int urutan = 1;

    public ObservableList<Produk> getDaftar() {
        return FXCollections.unmodifiableObservableList(daftar);
    }

    public Produk tambah(String nama, String kategori, long harga) {
        String kode = String.format("PR%03d", urutan);
        Produk produk = new Produk(kode, nama, kategori, harga);
        daftar.add(produk);
        urutan++;
        return produk;
    }

    public void hapus(Produk produk) {
        daftar.remove(produk);
    }
}
