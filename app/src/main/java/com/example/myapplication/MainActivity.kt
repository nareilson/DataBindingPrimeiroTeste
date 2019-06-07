package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var dog:DogList?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDOG()
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner
        var user = User("TESTE", 12)



        binding.user = user

        binding.executePendingBindings()

    }

    fun getDOG() {

        var call: Call<JsonObject> = RetrofitClass().acessar().create(APIClient::class.java).getListDod()
        call.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

                var urlW:String =(response.body()?.get("message").toString().replace("\"", ""))
                if(response.isSuccessful){
                    Log.e("DOG", response.body()?.get("message").toString())
                    Glide.with(applicationContext).load(urlW).into(imageView)
                }

            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

    }
}
