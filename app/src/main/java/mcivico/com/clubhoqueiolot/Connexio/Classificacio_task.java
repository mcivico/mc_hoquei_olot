package mcivico.com.clubhoqueiolot.Connexio;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import mcivico.com.clubhoqueiolot.Classificacio_fragment;
import mcivico.com.clubhoqueiolot.Helper.CHOlot_helper;
import mcivico.com.clubhoqueiolot.Model.Posicio;

public class Classificacio_task extends AsyncTask<String, Void, Integer> {

    public InputStream contingut = null;
    public Classificacio_response resp_classificacio;
    public Classificacio_fragment fragment;

    public Classificacio_task(Classificacio_fragment fragment){
        this.fragment = fragment;
    }

    @Override
    protected Integer doInBackground(String... strings) {
        HttpURLConnection c = null;
        int status = -1;
        try{
            URL u = new URL("http://www.ueolot.com/app/webservices/classificacio2.php");
            c = (HttpURLConnection)u.openConnection();
            c.setRequestMethod("GET");
            c.setRequestProperty("Content-length","0");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.connect();
            status = c.getResponseCode();
            contingut = c.getInputStream();
            if(status == 200){
                String json = CHOlot_helper.getStringFromInputStream(contingut);
                resp_classificacio = new Gson().fromJson(json,Classificacio_response.class);
            }

        }catch (MalformedURLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    protected void onPostExecute(Integer result){
        if(result != 200){
            this.fragment.hideProgressDialog();
            CHOlot_helper.showInternetError(this.fragment.getActivity());
            return;
        }

        ArrayList<Posicio> nombreArrayList = new ArrayList<Posicio>();
        Posicio p1 = new Posicio();
        p1.position = "1";
        p1.equip = "HC Sentmenat";
        p1.partitsJugats = "8";
        p1.punts = "18";
        Posicio p2 = new Posicio();
        p2.position = "2";
        p2.equip = "CH Olot";
        p2.partitsJugats = "8";
        p2.punts = "17";
        Posicio p3 = new Posicio();
        p3.position = "3";
        p3.equip = "HC Piera";
        p3.partitsJugats = "8";
        p3.punts = "15";
        Posicio p4 = new Posicio();
        p4.position = "4";
        p4.equip = "CE Noia B";
        p4.partitsJugats = "8";
        p4.punts = "10";
        Posicio p5 = new Posicio();
        p5.position = "5";
        p5.equip = "CH Juneda-Lleida";
        p5.partitsJugats = "8";
        p5.punts = "9";
        Posicio p6 = new Posicio();
        p6.position = "6";
        p6.equip = "CN Reus Ploms";
        p6.partitsJugats = "8";
        p6.punts = "9";
        Posicio p7 = new Posicio();
        p7.position = "7";
        p7.equip = "CH Ripollet";
        p7.partitsJugats = "8";
        p7.punts = "7";
        Posicio p8 = new Posicio();
        p8.position = "8";
        p8.equip = "CP Folgueroles";
        p8.partitsJugats = "8";
        p8.punts = "6";

        nombreArrayList.add(p1);
        nombreArrayList.add(p2);
        nombreArrayList.add(p3);
        nombreArrayList.add(p4);
        nombreArrayList.add(p5);
        nombreArrayList.add(p6);
        nombreArrayList.add(p7);
        nombreArrayList.add(p8);



        this.fragment.carregar_dades(nombreArrayList);
        //this.fragment.carregar_dades(resp_classificacio.classificacio.positions);
    }
}
