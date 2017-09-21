package startactivityforresult.shawnerlsala.packagecom.mcregistration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class First extends AppCompatActivity {
    private Button login;
    private EditText consumerCodeTxt;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        findViews();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("customer_code");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String checkAlphaNumeric = "[a-zA-Z0-9]+";
                if (consumerCodeTxt.getText().toString().matches(checkAlphaNumeric)) {
                    Intent intent = new Intent(First.this, LoginActivity.class);
                    intent.putExtra("customerCode", consumerCodeTxt.getText().toString());
                    startActivity(intent);
                }else{
                    Toast.makeText(First.this, "Invalid Input!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void findViews(){
        login = findViewById(R.id.loginbtn);
        consumerCodeTxt = findViewById(R.id.consumerCodeTxt);
    }

}

