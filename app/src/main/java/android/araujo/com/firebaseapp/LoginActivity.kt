package android.araujo.com.firebaseapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import android.widget.Toast
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.Task
import android.support.annotation.NonNull
import com.google.android.gms.tasks.OnCompleteListener
import android.R.attr.password
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.R.attr.password
import kotlinx.android.synthetic.main.activity_login.*
import android.R.attr.password
import android.araujo.com.firebaseapp.extensions.getText


class LoginActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
        mAuth = FirebaseAuth.getInstance();

        btnCriar.setOnClickListener {
            mAuth?.createUserWithEmailAndPassword(tilEmail.getText(), tilPass.getText())?.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = mAuth?.getCurrentUser()
                    // updateUI(user)
                } else {
                    Toast.makeText(this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    Log.w("LoginAcitivity", "signInWithEmail:failure", task.exception)
                    // updateUI(null)
                }
            }
        }
        btnLogin.setOnClickListener {
            mAuth?.signInWithEmailAndPassword(tilEmail.getText(), tilPass.getText())?.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = mAuth?.getCurrentUser()
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("LoginAcitivity", "signInWithEmail:failure", task.exception)
                    Toast.makeText(this@LoginActivity, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        var currentUser = mAuth?.getCurrentUser()
        updateUI(currentUser)
    }
    fun updateUI(currentUser: FirebaseUser?){
        Toast.makeText(this,currentUser?.email,Toast.LENGTH_SHORT).show()
    }



}
