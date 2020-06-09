package ifpr.br.tcc;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.Locale;

public class Comida extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 28800000; //Oito em Oito Horas

    private ImageButton mButtonInformacoes;

    private CountDownTimer mContagem;

    private long mTempoRestanteEmMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida);

        startTimer();

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

}
