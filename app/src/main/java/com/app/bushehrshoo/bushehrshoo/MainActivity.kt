package com.app.bushehrshoo.bushehrshoo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import com.google.i18n.phonenumbers.*;
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


import retrofit2.converter.gson.GsonConverterFactory;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin.setOnClickListener {
            val phoneNumber = txtPhone_number.text.toString()
            if (phoneNumber.isNullOrBlank() || phoneNumber.isNullOrEmpty()) {
                Toast.makeText(this, "Your Phone Number is not correct", Toast.LENGTH_LONG).show();
            } else {
                val phoneUtil = PhoneNumberUtil.getInstance()
                try {
                    val swissNumberProto = phoneUtil.parse(phoneNumber, "IR")

                    Toast.makeText(this, phoneUtil.isValidNumber(swissNumberProto).toString(), Toast.LENGTH_LONG).show();

                    val retrofit = Retrofit.Builder()
                            .baseUrl("http://79.175.168.229")
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build()


                   val apiMovies = retrofit.create(ApiMovies::class.java)



                    apiMovies.getMovies().subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.computation())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe({
                                var movieRespones : MovieResponse = it
                            },{

                            })
                } catch (e: Exception) {
                    Toast.makeText(this, e.message, Toast.LENGTH_LONG).show();
                }
            }

        }


        //region my region


        //endregion


    }
}
