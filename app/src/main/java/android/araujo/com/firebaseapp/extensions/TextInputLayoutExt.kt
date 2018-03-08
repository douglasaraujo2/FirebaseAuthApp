package android.araujo.com.firebaseapp.extensions

import android.support.design.widget.TextInputLayout
import android.widget.Toast

fun TextInputLayout.getText() : String{
    return editText?.text.toString()
}
