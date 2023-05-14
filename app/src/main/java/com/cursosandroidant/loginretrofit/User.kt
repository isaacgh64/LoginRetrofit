package com.cursosandroidant.loginretrofit

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
data class User(
    val id: Long,
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String){

    fun getFullName(): String = "$first_name $last_name"

}
