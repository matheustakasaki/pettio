package ifpr.br.tcc;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import java.io.IOError;
import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;

public class Cachorro extends AppCompatActivity {
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
        setContentView(R.layout.activity_cachorro);
    }

    public void irCadastrarCachorro(View view){
    Intent cachorrofds = new Intent(Cachorro.this, AddCachorro.class );
    startActivity(cachorrofds);
}


}
