package com.example.proyectoprctica

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore


class SigninActivity : AppCompatActivity() {

    private lateinit var editTextEmail : EditText
    private lateinit var editTextName : EditText
    private lateinit var editTextPassword : EditText
    private lateinit var editTextPassword2 : EditText
    private lateinit var btnCrearCuenta : Button
    private lateinit var textViewWarning : TextView
    private lateinit var btnVolver : Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextName = findViewById(R.id.editTextName)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextPassword2 = findViewById(R.id.editTextPassword2)
        btnCrearCuenta = findViewById(R.id.btnCrearCuenta)
        btnVolver = findViewById(R.id.btnVolver)
        textViewWarning = findViewById(R.id.textViewWarning)
        auth = Firebase.auth


        try {
            btnCrearCuenta.setOnClickListener{

                if (editTextEmail.text.isNotEmpty() && editTextPassword.text.isNotEmpty() && editTextPassword.text.isNotEmpty()){

                    if(editTextEmail.text.toString().contains('@') && editTextEmail.text.toString().contains('.')){
                        if(editTextPassword.text.toString()==editTextPassword.text.toString()) {
                            if(editTextPassword.length()>=8) {
                                crearUsuario()
                            } else {
                                textViewWarning.text = "La contraseña debe tener minimo 8 caracteres."
                                textViewWarning.visibility = View.VISIBLE
                                Log.d(TAG, "Contraseña muy corta")
                            }
                        }else{
                            textViewWarning.text = "La contraseña no es igual"
                            textViewWarning.visibility = View.VISIBLE
                            Log.d(TAG, "La contraseña no es igual")
                        }
                    }
                    else{
                        textViewWarning.text = "Formato email incorrecto."
                        textViewWarning.visibility = View.VISIBLE
                        Log.d(TAG, "Formato email incorrecto.")
                    }
                } else{
                    textViewWarning.text = "Debes rellenar todos los campos"
                    textViewWarning.visibility = View.VISIBLE
                    Log.d(TAG, "Debes rellenar todos los campos")
                }
            }

        } catch (e: Exception) {
            Log.d(TAG, "Error no esperado")
        }


        btnVolver.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

    }
    fun crearUsuario(){
        auth.createUserWithEmailAndPassword(editTextEmail.text.toString(), editTextPassword.text.toString()).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {

                val userId = FirebaseAuth.getInstance().currentUser?.uid
                if (userId != null) {
                    GlobalVariables.id = userId

                    // Obtenemos una referencia a la base de datos de Firebase
                    val db = FirebaseFirestore.getInstance()
                    db.collection("Users").document(userId).set(
                        hashMapOf(
                            "Name" to editTextName.text.toString(),
                            "Gmail" to editTextEmail.text.toString(),
                            "Contraseña" to editTextPassword.text.toString()
                            )
                    )




                } else {
                    Log.d(TAG, "El usuario no está autenticado. Manejar el error apropiadamente")
                }


                val intent = Intent(this, PpalActivity::class.java)

                startActivity(intent)
            } else {
                textViewWarning.text = "Usuario No Encontrado"
                textViewWarning.visibility = View.VISIBLE
                Log.d(TAG, "Usuario No Creado Correctamente")
            }
        }
    }
}