package com.cursosandroidant.loginretrofit.retrofit

import com.cursosandroidant.loginretrofit.Constants
import com.google.gson.annotations.SerializedName

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
class UserInfo (
    @SerializedName(Constants.EMAIL_PARAM) val email: String,
    @SerializedName(Constants.PASSWORD_PARAM) val pass: String
)