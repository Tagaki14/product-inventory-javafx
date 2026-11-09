package kelas.controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import kelas.Navigator;
import kelas.model.Produk;

public class DetailController {

    @FXML
    private Label kodeLabel, namaLabel, kategoriLabel, hargaLabel, pesanLabel;

    private Navigator navigator;

    public void setData(Navigator navigator, Produk produk) {
        this.navigator = navigator;

        kodeLabel.setText(produk.getKode());
        namaLabel.setText(produk.getNama());
        kategoriLabel.setText(produk.getKategori());

        hargaLabel.setText(
            NumberFormat.getCurrencyInstance(
                Locale.forLanguageTag("id-ID")
            ).format(produk.getHarga())
        );

        pesanLabel.setText("Informasi produk berhasil ditampilkan.");
    }

    @FXML
    private void tambahLagi() {
        try {
            navigator.bukaForm();
        } catch (IOException e) {
            pesanLabel.setText("Gagal membuka form produk.");
            e.printStackTrace();
        }
    }

    @FXML
    private void bukaDaftar() {
        try {
            navigator.bukaDaftar();
        } catch (IOException e) {
            pesanLabel.setText("Gagal membuka daftar produk.");
            e.printStackTrace();
        }
    }
}
