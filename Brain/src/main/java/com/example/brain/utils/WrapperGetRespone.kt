package com.example.brain.utils

import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuthEmailException
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun <T> firebaseResponse(
    call: suspend () -> ApiResponse<T>
): Flow<ApiResponse<T>> = flow{
    try{
        /*Success*/
        emit(call())
    }
    catch (e:FirebaseAuthEmailException){
        /*(Specific Auth) Invalid Email Exception*/
        emit(ApiResponse.Error(e.message ?: "Email not found. Try again later"))
    }
    catch (e:FirebaseAuthInvalidUserException){
        /*(Specific Auth) Invalid User Exception*/
        emit(ApiResponse.Error(e.message ?: "Invalid User"))
    }
    catch (e:FirebaseAuthException){
        /*Auth Exception*/
        emit(ApiResponse.Error(e.message ?: "Authentication failed. Try again later"))
    }
    catch (e:FirebaseFirestoreException){
        /*Firestore Exception*/
        emit(ApiResponse.Error(e.message ?: "Something went wrong with Firestore Database. Try again later"))
    }
    catch (e: FirebaseNetworkException){
        /*Network Exception*/
        emit(ApiResponse.Error(e.message ?: "Network error. Try again later"))
    }
    catch (e: FirebaseException){
        /*Global Firebase Exception*/
        emit(ApiResponse.Error(e.message ?: "Error on Server Side"))
    }
    catch (e: Exception){
        /*Global Kotlin Exception*/
        emit(ApiResponse.Error(e.message ?: "Something went wrong. Try again later"))
    }
}