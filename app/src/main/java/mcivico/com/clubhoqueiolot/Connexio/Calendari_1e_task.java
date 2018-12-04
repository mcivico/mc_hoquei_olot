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

import mcivico.com.clubhoqueiolot.Calendari_1e_fragment;
import mcivico.com.clubhoqueiolot.Helper.CHOlot_helper;
import mcivico.com.clubhoqueiolot.Model.Event;
import mcivico.com.clubhoqueiolot.R;

public class Calendari_1e_task extends AsyncTask<String, Void, Integer> {

    public InputStream contingut = null;
    public Calendari_response resp_calendari;
    public Calendari_1e_fragment fragment;

    public Calendari_1e_task(Calendari_1e_fragment fragment){this.fragment = fragment;}

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


        Event jg1 = new Event("0001","NACIONAL CATALANA","CH Olot B-Sensible","1 - 4","CH Juneda Lleida","Olot","Dissabte 15 de Setembre","16:00h", R.drawable.logo_cho,R.mipmap.juneda);
        Event jg2 = new Event("0002","NACIONAL CATALANA","HC Sentmenat","2 - 4","CH Olot B-Sensible","Sentmenat","Dissabte 29 de Setembre","19:30h",R.mipmap.sentmenat,R.drawable.logo_cho);
        Event jg3 = new Event("0003","NACIONAL CATALANA","CH Olot B-Sensible","2 - 6","CE NOIA B","Olot","Dissabte 29 de Setembre","19:30h",R.drawable.logo_cho,R.mipmap.escut_noia);
        Event jg4 = new Event("0004","NACIONAL CATALANA","Ripollet","1 - 4","CH Olot B-Sensible","Ripollet","Dissabte 6 d'Octubre","19:30h",R.mipmap.ripollet,R.drawable.logo_cho);
        Event jg5 = new Event("0005","NACIONAL CATALANA","CH Olot B-Sensible","3 - 2","CN Reus Ploms","Olot","Dissabte 13 d'Octubre","19:45h",R.drawable.logo_cho,R.mipmap.reusploms);
        Event jg6 = new Event("0006","NACIONAL CATALANA","CH Olot B-Sensible","3 - 3","HC Piera","Olot","Dissabte 20 d'Octubre","19:45h",R.drawable.logo_cho,R.mipmap.piera_hc);
        Event jg7 = new Event("0007","NACIONAL CATALANA","CP Folgueroles","1 - 1","CH Olot B-Sensible","Folgueroles","Dissabte 27 d'Octubre","18:00h",R.mipmap.folgueroles,R.drawable.logo_cho);
        Event jg8 = new Event("0008","NACIONAL CATALANA","CH Juneda Lleida","3 - 7","CH Olot B-Sensible","Juneda","Diumenge 4 de Novembre","16:05h",R.mipmap.juneda,R.drawable.logo_cho);
        Event jg9 = new Event("0009","NACIONAL CATALANA","CH Olot B-Sensible","","HC Sentmenat","Olot","Diumenge 11 de Novembre","12:00h",R.drawable.logo_cho,R.mipmap.sentmenat);
        Event jg10 = new Event("0010","NACIONAL CATALANA","CE Noia B","","CH Olot B-Sensible","Sant Sadurní d'Anoia","Diumenge 18 de Novembre","12:30h",R.mipmap.escut_noia,R.drawable.logo_cho);
        Event jg11 = new Event("0010","NACIONAL CATALANA","CH Olot B-Sensible","","Ripollet","Olot","Diumenge 25 de Novembre","16:05h",R.drawable.logo_cho,R.mipmap.ripollet);
        Event jg12 = new Event("0010","NACIONAL CATALANA","CN Reus Ploms","","CH Olot B-Sensible","Reus","Divendres 30 de Novembre","21:45h",R.mipmap.reusploms,R.drawable.logo_cho);
        Event jg13 = new Event("0010","NACIONAL CATALANA","HC Piera","","CH Olot B-Sensible","Piera","Diumenge 9 de Desembre","22:30h",R.mipmap.piera_hc,R.drawable.logo_cho);
        Event jg14 = new Event("0010","NACIONAL CATALANA","CH Olot B-Sensible","","CP Folgueroles","Olot","Dissabte 15 de Desembre","19:45h",R.drawable.logo_cho,R.mipmap.folgueroles);


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
        nombreArrayList.add(jg11);
        nombreArrayList.add(jg12);
        nombreArrayList.add(jg13);
        nombreArrayList.add(jg14);


        this.fragment.carregar_dades(nombreArrayList);
        //this.fragment.carregar_dades(resp_calendari.calendari);
    }
}
