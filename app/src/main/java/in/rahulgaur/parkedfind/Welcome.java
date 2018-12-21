package in.rahulgaur.parkedfind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Welcome extends AppCompatActivity {

    @BindView(R.id.login_emailLayout)
    TextInputLayout emailLayout;
    @BindView(R.id.login_passLayout)
    TextInputLayout passLayout;
    @BindView(R.id.login_login_btn)
    Button loginBtn;
    @BindView(R.id.login_reg_btn)
    Button regBtn;

    private String email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        loginBtn.setOnClickListener(v -> {
            email = emailLayout.getEditText().getText().toString();
            pass = passLayout.getEditText().getText().toString();

            if (!email.isEmpty() && !pass.isEmpty()){
                Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please Fill both fields", Toast.LENGTH_SHORT).show();
            }
        });

        regBtn.setOnClickListener(v ->{
            startActivity(new Intent(Welcome.this, Register.class));
        });
    }
}
