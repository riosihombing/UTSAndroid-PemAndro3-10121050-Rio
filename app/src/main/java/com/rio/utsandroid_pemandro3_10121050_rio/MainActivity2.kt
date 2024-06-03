//10121050-Rio Christian Cesar Sihombing-PemAndro3-IF2-3 Juni 2024
package com.rio.utsandroid_pemandro3_10121050_rio

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cek_data)

        // Mengambil data yang dikirimkan oleh MainActivity
        val tanggalDikonfirmasi = intent.getStringExtra("tanggal_dikonfirmasi")
        val nama = intent.getStringExtra("nama")
        val tanggalLahir = intent.getStringExtra("tanggal_lahir")
        val nik = intent.getStringExtra("nik")
        val jenisKelamin = intent.getStringExtra("jenis_kelamin")
        val jenisTes = intent.getStringExtra("jenis_tes")
        val hubunganKeluarga = intent.getStringExtra("hubungan_keluarga")

        // Menampilkan data
        findViewById<TextView>(R.id.View12).text = nama
        findViewById<TextView>(R.id.View10).text = tanggalDikonfirmasi
        findViewById<TextView>(R.id.View13).text = tanggalLahir
        findViewById<TextView>(R.id.View11).text = nik
        findViewById<TextView>(R.id.View14).text = jenisKelamin
        findViewById<TextView>(R.id.View9).text = jenisTes
        findViewById<TextView>(R.id.View16).text = hubunganKeluarga

        // Inisialisasi Button
        val btnBack = findViewById<Button>(R.id.button2)

        // Set onClickListener
        btnBack.setOnClickListener {
            // Buat Intent untuk kembali ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Menutup Activity saat ini agar tidak bisa kembali menggunakan tombol back
        }
        //Tambahkan fungsi
        val btnCekHasil: Button = findViewById(R.id.button4)
        btnCekHasil.setOnClickListener {
            // Menampilkan popup
            showSuccessPopup()
        }
    }

    private fun showSuccessPopup() {
        val inflater: LayoutInflater = LayoutInflater.from(this)
        val view: View = inflater.inflate(R.layout.activity_berhasil_simpan, null)

        val builder = AlertDialog.Builder(this)
        builder.setView(view)

        val dialog: AlertDialog = builder.create()

        val btnOk: Button = view.findViewById(R.id.btn_ok)
        btnOk.setOnClickListener {
            // Menutup popup
            dialog.dismiss()
        }
        // Menampilkan popup
        dialog.show()
    }
}

