package mcivico.com.clubhoqueiolot;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import mcivico.com.clubhoqueiolot.Adapters.Plantilla_adapter;
import mcivico.com.clubhoqueiolot.Connexio.Plantilla_task;
import mcivico.com.clubhoqueiolot.Model.Jugador;


public class Plantilla_fragment extends Fragment {

    private GridView gridView;
    private SwipeRefreshLayout swipeLayout;
    private ProgressDialog dialog;
    private Plantilla_fragment fragment = this;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View v = inflater.inflate(R.layout.plantilla_fragment,container,false);

        if(comprovarInternet(getContext())){
            if(v != null){
                gridView = (GridView) v.findViewById(R.id.gwPlantilla);
            }

            //dialog = ProgressDialog.show(getActivity(),"","Carregant dades...",true);
            new Plantilla_task(this).execute();


        }else{
            Snackbar.make(v,"No hi ha connexió a Internet", Snackbar.LENGTH_LONG).show();
        }



        return v;
    }

    public void carregar_dades(ArrayList<Jugador> dades) {
        Plantilla_adapter adapter_plantilla = new Plantilla_adapter(this.getActivity(), dades);
        gridView.setAdapter(adapter_plantilla);
        //hideProgressDialog();
    }

    public void hideProgressDialog(){
        if(dialog != null)
            dialog.hide();
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
