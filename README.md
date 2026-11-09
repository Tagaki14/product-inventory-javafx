# Aplikasi Manajemen Inventaris Produk

Aplikasi desktop berbasis JavaFX yang dikembangkan untuk melakukan pencatatan dan pengelolaan data inventaris produk. Aplikasi ini menyediakan fitur penambahan produk, pengelompokan kategori, pencarian produk, serta penampilan detail informasi produk.

## Tampilan Aplikasi

![Uploading gambar.png…]()


## Fitur Aplikasi

- **Tambah Produk:** Memasukkan nama, kategori, dan harga produk.
- **Kode Produk Otomatis:** Menghasilkan kode unik secara berurutan, seperti PR001, PR002, dan seterusnya.
- **Kategori Produk:** Mengelompokkan produk ke dalam kategori Makanan dan Minuman.
- **Daftar Produk:** Menampilkan data produk dalam tabel.
- **Pencarian Produk:** Mencari produk berdasarkan nama.
- **Detail Produk:** Menampilkan informasi produk yang dipilih.
- **Validasi Data:** Memastikan nama produk tidak kosong dan harga lebih dari nol.

## Struktur Program

```text
src/
├── main/
│   ├── java/
│   │   └── kelas/
│   │       ├── MainApp.java
│   │       ├── Navigator.java
│   │       ├── controller/
│   │       │   ├── FormController.java
│   │       │   ├── DaftarController.java
│   │       │   └── DetailController.java
│   │       ├── data/
│   │       │   └── DataProduk.java
│   │       └── model/
│   │           └── Produk.java
│   └── resources/
│       └── kelas/
│           ├── form.fxml
│           ├── daftar.fxml
│           ├── detail.fxml
│           └── styles/
│               └── app.css
└── pom.xml
```

## Teknologi yang Digunakan

- Java
- JavaFX
- FXML
- CSS
- Maven

## Cara Menjalankan Aplikasi

### Persyaratan

- JDK 17 atau versi lebih baru.
- Apache Maven.

### Langkah Menjalankan

1. Clone repository:

   ```bash
   git clone https://github.com/Tagaki14/product-inventory-javafx.git
   ```

2. Masuk ke direktori proyek:

   ```bash
   cd product-inventory-javafx
   ```

3. Jalankan aplikasi:

   ```bash
   mvn clean javafx:run
   ```

## Pengelolaan Data

Aplikasi menggunakan penyimpanan sementara di dalam memori (*in-memory storage*) melalui `ObservableList`. Data produk hanya tersedia selama aplikasi berjalan dan tidak disimpan secara permanen ke database.

## Catatan

Proyek ini dikembangkan sebagai tugas praktikum pemrograman GUI menggunakan JavaFX.
