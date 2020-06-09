package ifpr.br.tcc.Login;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import ifpr.br.tcc.R;

public class Cadastro extends AppCompatActivity {
    private void enabledFullScreenMode(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
    public void cadastrarUsuario(View view) throws IOException {

        EditText nomeCadastro = findViewById(R.id.nomeCadastroCachorro);
        String nome = nomeCadastro.getText().toString();

        EditText idadeCadastro = findViewById(R.id.idadeCadastro);
        String idade = idadeCadastro.getText().toString();

        EditText emailCadastro = findViewById(R.id.emailCadastro);
        String email = emailCadastro.getText().toString();

        EditText senhaCadastro = findViewById(R.id.alturaCadastroCachorro);
        String senha = senhaCadastro.getText().toString();

        EditText cepCadastro = findViewById(R.id.racaCadastroCachorro);
        String cep = cepCadastro.getText().toString();


        int resposta = DBHelper.insertIntoDono(nome, idade, email, senha, cep);

        if(resposta ==  1){
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();

            Intent addUsuario = new Intent(this, Login.class);
            startActivity(addUsuario);
        }

        if(resposta == 0){
            Toast.makeText(this, "Cadastro falhou!", Toast.LENGTH_SHORT).show();

            Intent naoAddUsuario = new Intent(this, Login.class);
            startActivity(naoAddUsuario);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        enabledFullScreenMode();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }
}