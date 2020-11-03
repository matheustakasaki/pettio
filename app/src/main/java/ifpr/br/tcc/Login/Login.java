package ifpr.br.tcc.Login;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import ifpr.br.tcc.MainActivity;
import ifpr.br.tcc.R;

public class Login extends AppCompatActivity {
    private void enabledFullScreenMode(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        enabledFullScreenMode();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void irParaTelaCadastro(View view) {
    Intent cadastro = new Intent(this, Cadastro.class);
    startActivity(cadastro);

    }
    public void teste(View view) {
        Intent teste = new Intent(this, MainActivity.class);
        startActivity(teste);
    }

    public void login(View view) throws IOException, JSONException {
        EditText emailLogin = findViewById(R.id.emailLogin);
        EditText senhaLogin = findViewById(R.id.senhaLogin);

        String emailDigitado = emailLogin.getText().toString();
        String senhaDigitada = senhaLogin.getText().toString();


        JSONArray todosOsUsuarios = DBHelper.selectAllFromDono();
        boolean encontrou = false;
        for (int i = 0; i < todosOsUsuarios.length(); i++) {
            JSONObject usuario = todosOsUsuarios.getJSONObject(i);

            String email = usuario.getString("email");
            String senha = usuario.getString("senha");
            if (email.equals(emailDigitado) && senha.equals(senhaDigitada)) {
                encontrou = true;
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }
        if (encontrou == false) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Erro no Login!");
            builder.setMessage("Usuário não encontrado!");
            builder.setPositiveButton("Ok", null);
            builder.create().show();
        }
    }
}


