package com.cursosandroidant.loginretrofit.retrofit

import com.cursosandroidant.loginretrofit.Constants
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/****
 * Project: Login Retrofit
 * From: com.cursosandroidant.loginretrofit.retrofit
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
interface LoginService {
    @Headers("Content-Type: application/json")
    @POST(Constants.API_PATH + Constants.LOGIN_PATH)
    fun login(@Body data: UserInfo): Call<LoginResponse>

    @POST(Constants.API_PATH + Constants.LOGIN_PATH)
    suspend fun loginUser(@Body data: UserInfo): LoginResponse

    @POST(Constants.API_PATH + Constants.REGISTER_PATH)
    suspend fun registerUser(@Body data: UserInfo) : RegisterResponse
}