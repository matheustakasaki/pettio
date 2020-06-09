package ifpr.br.tcc;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import ifpr.br.tcc.Login.Cadastro;

public class Vacina extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacina);
    }

public void addVacina (View view){
        Intent irAddVacina = new Intent(Vacina.this, AddVacina.class);
        startActivity(irAddVacina);
}
}
