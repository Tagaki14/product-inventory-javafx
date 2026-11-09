package kelas.controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class DaftarController {

    @FXML
    private TableView<Produk> tabel;

    @FXML
    private TableColumn<Produk, String> kodeCol, namaCol, kategoriCol;

    @FXML
    private TableColumn<Produk, Long> hargaCol;

    @FXML
    private TextField cariField;

    @FXML
    private Label pesanLabel;

    private Navigator navigator;
    private DataProduk data;

    private final ObservableList<Produk> dataTampilan =
            FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        kodeCol.setCellValueFactory(
            new PropertyValueFactory<>("kode")
        );

        namaCol.setCellValueFactory(
            new PropertyValueFactory<>("nama")
        );

        kategoriCol.setCellValueFactory(
            new PropertyValueFactory<>("kategori")
        );

        hargaCol.setCellValueFactory(
            new PropertyValueFactory<>("harga")
        );

        hargaCol.setCellFactory(column -> new TableCell<Produk, Long>() {
            @Override
            protected void updateItem(Long harga, boolean empty) {
                super.updateItem(harga, empty);

                if (empty || harga == null) {
                    setText(null);
                } else {
                    setText(NumberFormat.getCurrencyInstance(
                        Locale.forLanguageTag("id-ID")
                    ).format(harga));
                }
            }
        });

        tabel.setItems(dataTampilan);
        tabel.setPlaceholder(new Label("Belum ada produk yang tersimpan."));
    }

    public void setKonteks(Navigator navigator, DataProduk data) {
        this.navigator = navigator;
        this.data = data;
        cari();
    }

    @FXML
    private void cari() {
        if (data == null) {
            return;
        }

        dataTampilan.clear();

        String kata = cariField.getText() == null
                ? ""
                : cariField.getText().trim().toLowerCase(Locale.ROOT);

        for (Produk produk : data.getDaftar()) {
            String nama = produk.getNama().toLowerCase(Locale.ROOT);

            if (nama.contains(kata)) {
                dataTampilan.add(produk);
            }
        }

        tabel.sort();
        pesanLabel.setText(
            "Menampilkan " + dataTampilan.size() + " produk."
        );
    }

    @FXML
    private void tambah() {
        try {
            navigator.bukaForm();
        } catch (IOException e) {
            pesanLabel.setText("Form gagal dibuka.");
            e.printStackTrace();
        }
    }

    @FXML
    private void detail() {
        Produk produk = tabel.getSelectionModel().getSelectedItem();

        if (produk == null) {
            pesanLabel.setText("Pilih produk terlebih dahulu.");
            return;
        }

        try {
            navigator.bukaDetail(produk);
        } catch (IOException e) {
            pesanLabel.setText("Detail produk gagal dibuka.");
            e.printStackTrace();
        }
    }
}
