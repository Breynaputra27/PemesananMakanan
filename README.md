# Aplikasi Pemesanan Makanan

Ini adalah project Ujian Tengah Semester (UTS) untuk mata kuliah Pengembangan Aplikasi Mobile. Aplikasi ini dibuat menggunakan **Kotlin** 

Aplikasi ini mensimulasikan alur pemesanan makanan, mulai dari *login/register*, melihat menu, memesan, mengisi alamat, hingga konfirmasi.

---

## Penjelasan Singkat & Fitur Utama

* **Pindah Halaman:** Saya menggunakan `Compose Navigation` untuk mengatur alur pindah-pindah layar. Jadi, aplikasi ini sebenarnya hanya punya satu "Activity" utama.
* **Mengingat Data:** Supaya aplikasi bisa ingat nama *user* yang login, saya pakai `ViewModel`. `ViewModel` ini seperti "otak" kecil yang menyimpan nama *user*, jadi `HomeScreen`, `OrderScreen`, dan layar lainnya bisa mengambil nama itu dan menampilkannya ("Halo, Budi").
* **Tab Bawah (Bottom Nav):** Bagian *Home, Order, Profile* punya navigasinya sendiri. Ini seperti "aplikasi di dalam aplikasi" yang diatur oleh `MainScreen`.
* **Menu yang Rapi:** Halaman *Home* menampilkan 10 menu makanan dalam bentuk *Grid* (2 kolom) agar tidak monoton dan lebih menarik secara visual.
* **Fitur Keren (Pesan Cepat):** Kalau *user* mengklik gambar "Nasi Goreng" di *Home*, aplikasi akan langsung pindah ke tab "Order" dan otomatis mengisi *field* "Detail Pesanan" dengan "Nasi Goreng". Ini juga pakai `ViewModel`.
* **Tampilan Penuh:** Aplikasi ini dirancang agar tampilannya penuh sampai ke tepi layar (atas dan bawah), dan saya pakai `Scaffold` untuk memastikan tombol atau konten tidak tertimpa.

---

## angkapan Layar Screenshot

<img width="370" height="903" alt="image" src="https://github.com/user-attachments/assets/c374466c-9d4b-4d55-a1ca-514f32d84aff" />

<img width="369" height="897" alt="image" src="https://github.com/user-attachments/assets/d504388f-4716-42aa-92a2-075cf777577c" />

<img width="347" height="908" alt="image" src="https://github.com/user-attachments/assets/60120190-2476-4162-8404-55a9a33a688d" />

<img width="369" height="931" alt="image" src="https://github.com/user-attachments/assets/b230ddb8-1707-48af-a806-a65bc27e542c" />

<img width="347" height="857" alt="image" src="https://github.com/user-attachments/assets/7a2bd782-3461-4b1d-a83b-7ddba2db5d1d" />

<img width="367" height="790" alt="image" src="https://github.com/user-attachments/assets/239e40e3-5122-4358-b011-6f1c0224523e" />

<img width="340" height="796" alt="image" src="https://github.com/user-attachments/assets/f8081ddf-62ca-45ce-989c-bddd5ce78e18" />

<img width="368" height="793" alt="image" src="https://github.com/user-attachments/assets/a02ee314-158c-4bf1-8334-e01cf7b0b877" />





