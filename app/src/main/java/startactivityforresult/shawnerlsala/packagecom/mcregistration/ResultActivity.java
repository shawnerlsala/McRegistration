package startactivityforresult.shawnerlsala.packagecom.mcregistration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView email, phoneNum, TelephoneNum;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        email=findViewById(R.id.email);
//        phoneNum=findViewById(R.id.phoneNum);
//        TelephoneNum=findViewById(R.id.TelephoneNum);


    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
