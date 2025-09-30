package com.app.estudos

import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

object FirestoreHelper {
    val db: FirebaseFirestore by lazy {
        Firebase.firestore
    }
}
