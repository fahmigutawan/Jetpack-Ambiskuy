package com.example.ambiskuy.helper

import com.google.firebase.auth.FirebaseAuth

fun isLoggedIn():Boolean = FirebaseAuth.getInstance().currentUser != null