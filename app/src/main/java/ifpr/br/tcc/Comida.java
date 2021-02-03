package ifpr.br.tcc;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.Locale;

public class Comida extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final long START_TIME_IN_MILLIS = 28800000; //Oito em Oito Horas

    private ImageButton mButtonInformacoes;

    private CountDownTimer mContagem;

    private long mTempoRestanteEmMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida);

        startTimer();
        Spinner spinner1 = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.horarios1, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.horarios2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        Spinner spinner3 = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,R.array.horarios3, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemClickListener((AdapterView.OnItemClickListener) this);
    }


    public void startTimer() {
        mContagem = new CountDownTimer(mTempoRestanteEmMillis, 1000 ) { //1 min
            @Override
            public void onTick(long  millisAteTerminar) {
                mTempoRestanteEmMillis = millisAteTerminar;
            }

            @Override
            public void onFinish() {
                resetTimer();
                startTimer();
                Notificação();
                Toast.makeText(getApplicationContext(),"zap", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

    private void resetTimer() {
        mContagem.cancel();
        mTempoRestanteEmMillis = START_TIME_IN_MILLIS;
    }

    private void Notificação(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            NotificationChannel channel =
                    new NotificationChannel("LembreteComida" ,"lembreteComida" ,
                            NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager nm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            nm.createNotificationChannel(channel);}


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"Lembrete");
        builder.setSmallIcon(R.drawable.comida);
        builder.setContentTitle("Não vá deixa-lo com fome em!");
        builder.setContentText("Não esqueça de dar comida ao seu pet :)");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager nm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(3566, builder.build());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
