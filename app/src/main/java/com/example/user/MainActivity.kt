package com.example.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth



class MainActivity : AppCompatActivity() {
    lateinit var maili:EditText
    lateinit var paroli:EditText
    lateinit var sheqmna:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        maili=findViewById(R.id.Email)
        paroli=findViewById(R.id.Password)
        sheqmna=findViewById(R.id.sheqmna)
        sheqmna.setOnClickListener {


            if(maili.text.toString().isEmpty() || paroli.text.toString().isEmpty()){
                Toast.makeText(this, "Empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(maili.text.toString(), paroli.text.toString())
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "წარმატებით შეიქმნა", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
                }
        }



    }
}