package kelas.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class FormController {

    @FXML
    private TextField namaField, hargaField;

    @FXML
    private ComboBox<String> kategoriBox;

    @FXML
    private Label pesanLabel;

    private Navigator navigator;
    private DataProduk data;

    @FXML
    private void initialize() {
        kategoriBox.getItems().addAll("Makanan", "Minuman");
        kategoriBox.setPromptText("Pilih kategori");
    }

    public void setKonteks(Navigator navigator, DataProduk data) {
        this.navigator = navigator;
        this.data = data;
    }

    @FXML
    private void simpan() {
        if (namaField.getText() == null || namaField.getText().isBlank()) {
            pesanLabel.setText("Nama produk tidak boleh kosong.");
            namaField.requestFocus();
            return;
        }

        if (kategoriBox.getValue() == null) {
            pesanLabel.setText("Silakan pilih kategori produk.");
            kategoriBox.requestFocus();
            return;
        }

        String inputHarga = hargaField.getText().trim().replace(".", "").replace(" ", "");

        if (inputHarga.isEmpty()) {
            pesanLabel.setText("Harga produk tidak boleh kosong.");
            hargaField.requestFocus();
            return;
        }

        long harga;

        try {
            harga = Long.parseLong(inputHarga);
        } catch (NumberFormatException e) {
            pesanLabel.setText("Harga harus berupa angka yang valid.");
            hargaField.requestFocus();
            return;
        }

        Produk produk;

        try {
            produk = data.tambah(
                namaField.getText(),
                kategoriBox.getValue(),
                harga
            );
        } catch (IllegalArgumentException e) {
            pesanLabel.setText(e.getMessage());
            return;
        }

        try {
            navigator.bukaDetail(produk);
        } catch (IOException e) {
            data.hapus(produk);
            pesanLabel.setText("Detail gagal dibuka. Data dibatalkan.");
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
