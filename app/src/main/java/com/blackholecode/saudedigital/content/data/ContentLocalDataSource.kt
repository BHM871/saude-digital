package com.blackholecode.saudedigital.content.data

import com.blackholecode.saudedigital.common.model.User
import com.blackholecode.saudedigital.common.util.UserSession

class ContentLocalDataSource() : ContentDataSource {

    override fun fetchSession() : User {
//        FirebaseFirestore.getInstance()
//            .collection("/users")
//            .document("uuid", FirebaseAuth.getInstance().uid)
//            .get()
        return UserSession.get() ?: User("jbckjabc", password = "jbcasbjchas", condition = listOf(
            Pair("Obesidade", "Tipo 1")
        ))
    }

}