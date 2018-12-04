package mcivico.com.clubhoqueiolot.Connexio;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import mcivico.com.clubhoqueiolot.Helper.CHOlot_helper;
import mcivico.com.clubhoqueiolot.Model.Jugador;
import mcivico.com.clubhoqueiolot.Plantilla_fragment;
import mcivico.com.clubhoqueiolot.R;

public class Plantilla_task extends AsyncTask<String, Void, Integer> {

    public InputStream contingut = null;
    public Plantilla_response resp_plantilla;
    public Plantilla_fragment fragment;

    public Plantilla_task(Plantilla_fragment fragment){this.fragment = fragment;}

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
            /*if(status == 200){
                String json = CHOlot_helper.getStringFromInputStream(contingut);
                resp_plantilla = new Gson().fromJson(json,Plantilla_response.class);
                String a = "";
            }*/
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

        Jugador jg1 = new Jugador("0001","Pau","Flores","10", R.mipmap.pau);
        Jugador jg2 = new Jugador("0002","Blass","Taramasso","91",R.mipmap.pau);
        Jugador jg3 = new Jugador("0003","Adrià","Piera","21",R.mipmap.piera);
        Jugador jg4 = new Jugador("0004","Marc","Prat","43",R.mipmap.ferran);
        Jugador jg5 = new Jugador("0005","Ferran","Sacrest","6",R.mipmap.ferran);
        Jugador jg6 = new Jugador("0006","Lluc","Jiménez","15",R.mipmap.lluc);
        Jugador jg7 = new Jugador("0007","Tomàs","Marcé","2",R.mipmap.toumas);
        Jugador jg8 = new Jugador("0008","Joan","Mangas","17",R.mipmap.roger);
        Jugador jg9 = new Jugador("0009","Nil","Rodriguez","20",R.mipmap.toumas);
        Jugador jg10 = new Jugador("0010","Roger","Saladrigues","7", R.mipmap.roger);

        ArrayList<Jugador> nombreArrayList = new ArrayList<Jugador>();
        nombreArrayList.add(jg7);
        nombreArrayList.add(jg5);
        nombreArrayList.add(jg10);
        nombreArrayList.add(jg1);
        nombreArrayList.add(jg6);
        nombreArrayList.add(jg8);
        nombreArrayList.add(jg9);
        nombreArrayList.add(jg3);
        nombreArrayList.add(jg4);
        nombreArrayList.add(jg2);

        this.fragment.carregar_dades(nombreArrayList);
        //this.fragment.carregar_dades(resp_plantilla.plantilla);
    }

}
