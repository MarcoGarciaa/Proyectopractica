package com.example.proyectoprctica

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SigninActivity : AppCompatActivity() {

    private lateinit var editTextEmail : EditText
    private lateinit var editTextName : EditText
    private lateinit var editTextPassword : EditText
    private lateinit var editTextPassword2 : EditText
    private lateinit var btnIniciarSesion : Button
    private lateinit var btnVolver : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextName = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextEmail)
        editTextPassword2 = findViewById(R.id.editTextEmail)
        btnIniciarSesion = findViewById(R.id.editTextEmail)
        btnVolver = findViewById(R.id.editTextEmail)


        try {
            btnCrearCuenta.setOnClickListener{

                if (Email.text.isNotEmpty() && Password.text.isNotEmpty() && RepeatPassword.text.isNotEmpty()){

                    if(Email.text.toString().contains('@') && Email.text.toString().contains('.')){
                        if(Password.text.toString()==RepeatPassword.text.toString()) {
                            if(Password.length()>=8) {
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

        btnIniciarSesion.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

        btnVolver.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

    }
    fun crearUsuario(){
        auth.createUserWithEmailAndPassword(Email.text.toString(), Password.text.toString()).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {

                val userId = FirebaseAuth.getInstance().currentUser?.uid
                if (userId != null) {

                    val globalInstance = variableGlobal.getInstance()
                    globalInstance.initPersonaje(userId)
                    Log.d(TAG, "El usuario creado correctamente")

                } else {
                    Log.d(TAG, "El usuario no está autenticado. Manejar el error apropiadamente")
                }


                val intent = Intent(this, CrearPersonajeActivity::class.java)
                intent.putExtra("email", Email.text.toString())
                intent.putExtra("password", Password.text.toString())
                startActivity(intent)
            } else {
                textViewWarning.text = "Usuario No Encontrado"
                textViewWarning.visibility = View.VISIBLE
                Log.d(TAG, "Usuario No Creado Correctamente")
            }
        }
    }
}