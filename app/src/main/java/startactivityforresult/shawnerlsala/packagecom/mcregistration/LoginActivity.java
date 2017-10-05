package startactivityforresult.shawnerlsala.packagecom.mcregistration;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    private EditText inputEmail, inputPhone, inputTelPhone;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Button btnSignup, btnLogin, btnReset;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String customerCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Get String Extra which is customer/consumer code
        if (getIntent().getStringExtra("customerCode") != null) {
            customerCode = getIntent().getStringExtra("customerCode");
        }

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("customers");


//        if (auth.getCurrentUser() != null) {
//            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//            finish();
//        }

        // set the view now
        setContentView(R.layout.activity_login);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inputEmail = (EditText) findViewById(R.id.email);
        inputPhone = (EditText) findViewById(R.id.phoneNumTxt);
        inputTelPhone = (EditText) findViewById(R.id.telephoneNumTxt);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnLogin = (Button) findViewById(R.id.btn_login);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String check1 = "";
                String check2 = " ";
                String checkAlphaNumeric = "[a-zA-Z0-9]+";
                if(!inputEmail.getText().toString().matches(check1)
                        || !inputEmail.getText().toString().matches(check2)
                        && inputPhone.getText().toString().matches(checkAlphaNumeric)){
                    if(!inputPhone.getText().toString().matches(check1)
                        || !inputPhone.getText().toString().matches(check2))
                    //if check
                    databaseReference.child(customerCode).child("email").setValue(inputEmail.getText().toString());
                    databaseReference.child(customerCode).child("phoneNum").setValue(inputPhone.getText().toString());
                    databaseReference.child(customerCode).child("telephoneNum").setValue(inputTelPhone.getText().toString());
                    showSuccessDialog();
                }else{
                    Toast.makeText(LoginActivity.this, "Invalid Input!", Toast.LENGTH_SHORT).show();
                }

            }
        });

//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = inputEmail.getText().toString();
//            final String password = inputPhone.getText().toString();
//
//                if (TextUtils.isEmpty(email)) {
//                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                if (TextUtils.isEmpty(password)) {
//                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                progressBar.setVisibility(View.VISIBLE);
//
//                //authenticate user
//                auth.signInWithEmailAndPassword(email, password)
//                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                // If sign in fails, display a message to the user. If sign in succeeds
//                                // the auth state listener will be notified and logic to handle the
//                                // signed in user can be handled in the listener.
//                                progressBar.setVisibility(View.GONE);
//                                if (!task.isSuccessful()) {
//                                    // there was an error
//                                    if (password.length() < 6) {
//                                        inputPhone.setError(getString(R.string.minimum_password));
//                                    } else {
//                                        Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
//                                    }
//                                } else {
//                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                            }
//                        });
//            }
//        });
    }

    private void showSuccessDialog(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mView = inflater.inflate(R.layout.popup_register_success, null);

        Button finishBtn = mView.findViewById(R.id.finishBtn);
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, First.class));
                finish();
            }
        });

        mBuilder.setView(mView);
        Dialog dialog = mBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}
