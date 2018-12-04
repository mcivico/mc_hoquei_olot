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

import mcivico.com.clubhoqueiolot.Calendari_fragment;
import mcivico.com.clubhoqueiolot.Helper.CHOlot_helper;
import mcivico.com.clubhoqueiolot.Model.Event;
import mcivico.com.clubhoqueiolot.R;

public class Calendari_task extends AsyncTask<String, Void, Integer> {

    public InputStream contingut = null;
    public Calendari_response resp_calendari;
    public Calendari_fragment fragment;

    public Calendari_task(Calendari_fragment fragment){this.fragment = fragment;}

    @Override
    protected Integer doInBackground(String... strings) {
        HttpURLConnection c = null;
        int status = -1;
        try{
            URL u = new URL("http://www.ueolot.com/app/webservices/noticias-2.php");
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
                resp_calendari = new Gson().fromJson(json,Calendari_response.class);
                String a = "";
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


        Event jg1 = new Event("0001","PREBENJAMI","H. Banyoles A","","CH Olot A","Banyoles","Dissabte 29 de Setembre","19:00h",R.mipmap.sentmenat, R.drawable.logo_cho);
        Event jg2 = new Event("0002","PREBENJAMI","HC Ripoll","","CH Olot B","Ripoll","Diumenge 30 de Setembre","11:30h",R.mipmap.sentmenat,R.drawable.logo_cho);
        Event jg3 = new Event("0003","BENJAMI","CH Olot","","FD Cassanenc","Olot","Dissabte 29 de Setembre","16:45h",R.drawable.logo_cho,R.mipmap.sentmenat);
        Event jg4 = new Event("0004","ALEVI","H. Banyoles B","","CH Olot A","Banyoles","Dissabte 29 de Setembre","18:00h",R.mipmap.sentmenat,R.drawable.logo_cho);
        Event jg5 = new Event("0005","INFANTIL","CH Olot A","","CH Palafrugell B","Olot","Dissabte 29 de Setembre","10:15h",R.drawable.logo_cho,R.mipmap.sentmenat);
        Event jg6 = new Event("0006","INFANTIL","CH Olot B","","CH Palafrugell A","Olot","Dissabte 29 de Setembre","17:30h",R.drawable.logo_cho,R.mipmap.sentmenat);
        Event jg7 = new Event("0007","INFANTIL","CH Olot C","","CP Jonquerenc","Olot","Dissabte 29 de Setembre","11:30h",R.drawable.logo_cho,R.mipmap.sentmenat);
        Event jg8 = new Event("0008","JUVENIL","CH Sant Feliu","","CH Olot","Sant Feliu de Codines","Dissabte 29 de Setembre","19:45h",R.mipmap.sentmenat,R.drawable.logo_cho);
        Event jg9 = new Event("0009","2a CATALANA","CH Cadí","","CH Olot","La Seu d'Urgell","Diumenge 30 de Setembre","17:00h",R.mipmap.sentmenat,R.drawable.logo_cho);
        Event jg10 = new Event("0010","NACIONAL CATALANA","CH Olot B-Sensible","","CE NOIA B","Olot","Dissabte 29 de Setembre","19:30h",R.drawable.logo_cho,R.mipmap.sentmenat);

        ArrayList<Event> nombreArrayList = new ArrayList<Event>();
        nombreArrayList.add(jg1);
        nombreArrayList.add(jg2);
        nombreArrayList.add(jg3);
        nombreArrayList.add(jg4);
        nombreArrayList.add(jg5);
        nombreArrayList.add(jg6);
        nombreArrayList.add(jg7);
        nombreArrayList.add(jg8);
        nombreArrayList.add(jg9);
        nombreArrayList.add(jg10);

        this.fragment.carregar_dades(nombreArrayList);
        //this.fragment.carregar_dades(resp_calendari.calendari);
    }
}
