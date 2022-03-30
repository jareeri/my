package com.example.login12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;

public class registeravtivity extends AppCompatActivity {
    public userandpass use = new userandpass();
    private EditText rEmail;
    private EditText rpass ;
    private Button rregister;

    DBConnections db = new DBConnections(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeravtivity);



        rEmail=findViewById(R.id.rename);
        rpass =findViewById(R.id.repassword);
        rregister=findViewById(R.id.btnredisterd);

        rregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String x=rEmail.getText().toString();
                //add the user to the array

                if (rEmail.getText().toString().isEmpty() || rpass.getText().toString().isEmpty())
                    Toast.makeText(registeravtivity.this, "inter all fields", Toast.LENGTH_SHORT).show();
                else {
                    use.setUser(rEmail.getText().toString());
                    use.setPass(rpass.getText().toString());
                    if (use.getUser().isEmpty())
                        Toast.makeText(registeravtivity.this, "it is empty", Toast.LENGTH_SHORT).show();
                    else {
                        Toast.makeText(registeravtivity.this, "it is not impty", Toast.LENGTH_SHORT).show();
                        db.InsertRowAdmin(rEmail.getText().toString(),rpass.getText().toString());
                        System.out.println(x);
                        System.out.println(use.getUser().get(0));
                        System.out.println(use.getPass().get(0));
                        Intent intent = new Intent(registeravtivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                }
            }
        });
    }
}