package mcivico.com.clubhoqueiolot;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Partits_1E_fragment extends Fragment{

    private TextView ppLocal, ppVisitant, ppLloc, ppData, ppHora;
    private TextView upLocal, upResultat, upVisitant, upLloc, upData, upHora;
    private ImageView fotoFCP1, fotoFCP2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater,container,savedInstanceState);
        View v = inflater.inflate(R.layout.partits_primer_equip_fragment,container,false);

        /*
        fotoFCP1 = (ImageView) v.findViewById(R.id.imgFecapa);
        fotoFCP2 = (ImageView) v.findViewById(R.id.imgFecapa2);

        Picasso.with(this.getContext()).load("https://yt3.ggpht.com/a-/AN66SAyAVUTwu-TFJ9S3TMtORdUYrFGK7uTRZTTPqA=s900-mo-c-c0xffffffff-rj-k-no").fit().centerCrop().into(fotoFCP1);
        Picasso.with(this.getContext()).load("https://yt3.ggpht.com/a-/AN66SAyAVUTwu-TFJ9S3TMtORdUYrFGK7uTRZTTPqA=s900-mo-c-c0xffffffff-rj-k-no").fit().centerCrop().into(fotoFCP2);
        */

        /*if(comprovarInternet(getContext())) {

            if (v != null) {
                ppLocal = (TextView)v.findViewById(R.id.ppLocal) ;
                ppVisitant = (TextView)v.findViewById(R.id.ppVisitant);
                ppLloc= (TextView)v.findViewById(R.id.ppLloc);
                ppData = (TextView)v.findViewById(R.id.ppData);
                ppHora = (TextView)v.findViewById(R.id.ppHora);

                upLocal = (TextView)v.findViewById(R.id.upLocal);
                upResultat = (TextView)v.findViewById(R.id.upResultat);
                upVisitant = (TextView)v.findViewById(R.id.upVisitant);
                upLloc = (TextView)v.findViewById(R.id.upLloc);
                upData = (TextView)v.findViewById(R.id.upData);
                upHora = (TextView)v.findViewById(R.id.upHora);
            }

            ppLocal.setText("CH Olot");
            ppVisitant.setText("CE Noia B");
            ppLloc.setText("Pavelló Municipal d'Olot");
            ppData.setText("Dissabte 29 de Setembre");
            ppHora.setText("19:30 h");

            upLocal.setText("HC Sentmenat");
            upResultat.setText("2 - 4");
            upVisitant.setText("CH Olot");
            upLloc.setText("Pavelló Hoquei Sentmenat");
            upData.setText("Diumenge 23 de Setembre");
            upHora.setText("12:30 h");


        }else{
            Snackbar.make(v,"No hi ha connexió a Internet", Snackbar.LENGTH_LONG).show();
        }*/

        return v;

    }

    public static boolean comprovarInternet(Context context){

        boolean connexio = false;

        ConnectivityManager connect = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] xarxes = connect.getAllNetworkInfo();

        for(int i=0; i<xarxes.length; i++){
            if(xarxes[i].getState() == NetworkInfo.State.CONNECTED)
                connexio = true;
        }
        return connexio;
    }


}
