package com.example.login12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private EditText eEmail;
    private EditText epass ;
    private Button elogin;
    private Button eregister;

    private String username="admin";
    private String password="12345";

    DBConnections db = new DBConnections(this);

    userandpass use2 =new userandpass();

    ArrayList <String> arrayUser= db.getuser();
    ArrayList <String> arrayPass= db.getpass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        use2.setUser("admin");
        use2.setPass("246761");
        use2.setUser("ad");
        use2.setPass("24");
        eEmail=findViewById(R.id.etname);
        epass =findViewById(R.id.etpassword);
        elogin=findViewById(R.id.btnlogin);
        eregister=findViewById(R.id.btnregester);







        if(eEmail.getText().toString().isEmpty() || epass.getText().toString().isEmpty())
            Toast.makeText(MainActivity.this, "inter all the field", Toast.LENGTH_SHORT).show();
        elogin.setEnabled(true);

        eregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, registeravtivity.class);
                startActivity(intent2);
            }
        });


        elogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputmail = eEmail.getText().toString();
                String inputpass = epass.getText().toString();

                if (inputmail.isEmpty() || inputpass.isEmpty())
                    Toast.makeText(MainActivity.this, "inter all the field", Toast.LENGTH_SHORT).show();
                else
                    if (validate(inputmail, inputpass)){
                    Toast.makeText(MainActivity.this, "welcame admin", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, homebageactivity.class);
                     startActivity(intent);
                    }
                System.out.println(use2.getUser().get(0));
                System.out.println(use2.getPass().get(0));
                System.out.println(use2.getPass().get(1));
            }
        });
}

    private boolean validate ( String User, String Pass){

        for (int i=0 ;i< arrayUser.size();i++) {
            System.out.println(use2.getUser().get(i));

            if (arrayUser.get(i).toString().equals(User) && arrayPass.get(i).toString().equals(Pass)) {
                System.out.println(arrayPass.get(0));
                return true;
            }
        }
            return false;
    }


}