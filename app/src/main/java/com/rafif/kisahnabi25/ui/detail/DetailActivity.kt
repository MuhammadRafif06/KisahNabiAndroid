package com.rafif.kisahnabi25.ui.detail

import android.nfc.NfcAdapter.EXTRA_DATA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.rafif.kisahnabi25.R
import com.rafif.kisahnabi25.data.KisahResponse
import com.rafif.kisahnabi25.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private var _binding : ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<KisahResponse>(EXTRA_DATA)
        data?.let {
            binding.apply {
                Glide.with(this@DetailActivity).load(data.imageUrl).into(detailImage)
                detailNama.text = data.name
                detailTempat.text = data.tmp
                val usia = "Usia: " + data.usia + " tahun"
                detailUsia.text = data.usia
                detailDesk.text = data.description
        }

        }

    }
    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}