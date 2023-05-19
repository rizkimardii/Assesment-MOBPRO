package org.d3if3145.assesment1.ui

import android.os.Bundle
import android.provider.Telephony.Mms.Rate
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if3145.assesment1.R
import org.d3if3145.assesment1.databinding.FragmentUsdBinding
import org.d3if3145.assesment1.model.HasilRupiah


class fragmentUsd : Fragment() {
    private lateinit var binding: FragmentUsdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View {

        binding = FragmentUsdBinding.inflate(layoutInflater, container, false)

        binding.button.setOnClickListener { convertUsdToIdr() }
        return binding.root
    }


    private fun convertUsdToIdr() {

        val usd = binding.USDInput.text.toString()
        val result = HasilRupiah(usd.toFloat())

        showResult(result)
    }

    private fun convertUsdToIdr(exchangeRate: Float, usd: Float) : HasilRupiah{

        val exchange = exchangeRate * 14000
        val idr = usd * exchange

        return HasilRupiah(idr)
    }

    private fun showResult(result : HasilRupiah){

        binding.IDRView.text = getString(R.string.usd_x, result.idr)
    }
}