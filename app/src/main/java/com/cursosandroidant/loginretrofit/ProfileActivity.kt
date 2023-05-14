package com.cursosandroidant.loginretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.cursosandroidant.loginretrofit.databinding.ActivityProfileBinding
import com.cursosandroidant.loginretrofit.retrofit.UserService
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/****
 * Project: Login Retrofit
 * From: com.cursosandroidant.loginretrofit
 * Created by Alain Nicolás Tello on 03/02/23 at 15:26
 * All rights reserved 2023.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * And Frogames formación:
 * https://cursos.frogamesformacion.com/pages/instructor-alain-nicolas
 *
 * Coupons on my Website:
 * www.alainnicolastello.com
 ***/
class ProfileActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        loadUserProfile()
    }

    private fun loadUserProfile() {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(UserService::class.java)
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val result = service.getSigleUser()
                updateUI(result.data, result.support)
            } catch (e: Exception) {
                showMessage(getString(R.string.main_error_server))
            }
        }
    }
    private suspend fun updateUI(user: User, support: Support) = withContext(Dispatchers.Main){
        with(mBinding) {
            tvFullName.text = user.getFullName()
            tvEmail.text = user.email

            Glide.with(this@ProfileActivity)
                .load(user.avatar)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(imgProfile)

            tvSupportMessage.text = support.text
            tvSupportUrl.text = support.url
        }
    }

    private fun showMessage(message: String){
        Snackbar.make(mBinding.root, message, Snackbar.LENGTH_SHORT).show()
    }
}