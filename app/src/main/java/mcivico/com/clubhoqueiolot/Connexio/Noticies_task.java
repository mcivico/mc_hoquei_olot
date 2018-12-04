package mcivico.com.clubhoqueiolot.Connexio;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import mcivico.com.clubhoqueiolot.Helper.CHOlot_helper;
import mcivico.com.clubhoqueiolot.Noticies_fragment;

public class Noticies_task extends AsyncTask<String, Void, Integer>{

    public InputStream contingut = null;
    public Noticies_response resp_noticies;
    public Noticies_fragment fragment;

    public Noticies_task(Noticies_fragment fragment){this.fragment = fragment;}

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
                resp_noticies = new Gson().fromJson(json,Noticies_response.class);
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
        this.fragment.carregar_dades(resp_noticies.noticies);
    }
}
