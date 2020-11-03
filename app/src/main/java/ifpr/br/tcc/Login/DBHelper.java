package ifpr.br.tcc.Login;

import android.os.Build;
import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DBHelper {

    private static String WEB_SERVICE_URL = "localhost/web_service/";

    private static void checkThreadPolicy(){
            int version = Build.VERSION.SDK_INT;
            if(version > 8){
                StrictMode.ThreadPolicy policy =  new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
    }

    public static Integer insertIntoDono(String nome,String idade, String email, String senha, String cep) throws IOException {
        checkThreadPolicy();

        String values = "nome=" + nome + "&" +"idade=" + idade + "&" +"email=" + email + "&" + "senha=" + senha + "&" +"cep=" + cep;
        URL url = new URL(WEB_SERVICE_URL + "ws_insert/ws_insert_dono.php" + values);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        String resposta = br.readLine();
            if (resposta.equals("true")) {
                return 1;
            } else {
                return 0;
            }
    }

    public static Integer insertIntoCachorro(String nome,String idade, String peso, String altura, String raca) throws IOException {
        checkThreadPolicy();

        String values = "nome=" + nome + "&idade=" + idade + "&peso=" + peso + "&altura=" + altura + "&raca=" + raca;
        URL url = new URL(WEB_SERVICE_URL + "ws_insert/ws_insert_cachorro.php" + values);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        String resposta = br.readLine();
        if (resposta.equals("true")) {
            return 1;
        } else {
            return 0;
        }
    }



    public static JSONArray selectAllFromDono() throws IOException, JSONException {
        checkThreadPolicy();

        URL url = new URL(WEB_SERVICE_URL + "ws_read/ws_read_dono.php");
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String resposta;
        while((resposta = br.readLine())!=null){
            sb.append(resposta);
        }
        JSONArray jsonArray =  new JSONArray(sb.toString().trim());
        return jsonArray;
    }



}