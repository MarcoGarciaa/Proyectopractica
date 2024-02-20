package com.example.proyectoprctica
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
class loginActivity  : AppCompatActivity() {
    //VARIABLES
    private lateinit var Email : EditText
    private lateinit var Password : EditText
    private lateinit var btnIniciarSesion: Button
    private lateinit var btnCrearCuenta: Button
    private lateinit var btnVolver: Button
    private lateinit var textViewWarning: TextView
    private lateinit var auth: FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Email = findViewById(R.id.editTextEmail)
        Password = findViewById(R.id.editTextPassword)
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion)
        btnCrearCuenta = findViewById(R.id.btnIniciarSesion)
        btnVolver = findViewById(R.id.btnVolver)
        auth = Firebase.auth

        try {
            btnIniciarSesion.setOnClickListener{
                    if (Email.text.isNotEmpty() && Password.text.isNotEmpty()){
                        auth.signInWithEmailAndPassword(Email.text.toString(), Password.text.toString()).addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                Log.d(TAG, "Autenticacion del ususario Correcta")
                                val userId = FirebaseAuth.getInstance().currentUser?.uid
                            if (userId != null) {
                                GlobalVariables.id = userId
                            }

                            val intent = Intent(this, PpalActivity::class.java)
                            startActivity(intent)

                        }
                        else {
                            val builder = AlertDialog.Builder(this)
                            builder.setTitle("Error")
                            builder.setMessage("Usuario o Contraseña Incorrecta")
                            builder.setPositiveButton("Aceptar",null)
                            val dialog: AlertDialog = builder.create()
                            dialog.show()
                        }
                    }
                }else{ Log.d(TAG, "Debes rellenar los campos") }
            }
        } catch (e: Exception) {
            Log.d(TAG, "Error en la autentificacion del usuario")
        }
        btnVolver.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }

}