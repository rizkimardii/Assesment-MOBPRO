package org.d3if3145.assesment1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.d3if3145.assesment1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
            private lateinit var binding: ActivityMainBinding
            private lateinit var usdInput: EditText
            private lateinit var idrResult: TextView

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
                binding = ActivityMainBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)


                usdInput = findViewById(R.id.USDInput)
                idrResult = findViewById(R.id.IDRView)

                val convertButton = findViewById<Button>(R.id.button)
                convertButton.setOnClickListener {
                    val usdString = usdInput.text.toString()
                    val usd = usdString.toDoubleOrNull() ?: return@setOnClickListener
                    val idr = convertUsdToIdr(usd)
                    val idrString = String.format("%.2f", idr)
                    idrResult.text = idrString
                }

            }

            private fun convertUsdToIdr(usd: Double): Double {
                // call API to get USD to IDR exchange rate
                val exchangeRate = 14000.0
                val idr = usd * exchangeRate
                return idr
            }
        }


