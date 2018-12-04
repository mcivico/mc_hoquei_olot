package mcivico.com.clubhoqueiolot;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import mcivico.com.clubhoqueiolot.Adapters.Classificacio_adapter;
import mcivico.com.clubhoqueiolot.Connexio.Classificacio_task;
import mcivico.com.clubhoqueiolot.Model.Posicio;


public class Classificacio_fragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    private TextView posicio, equip, partits_jugats, punts;
    private ListView llista;
    private SwipeRefreshLayout swipeLayout;
    private ProgressDialog dialog;
    private Classificacio_fragment fragment = this;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater,container,savedInstanceState);
        View v = inflater.inflate(R.layout.clasificacio_fragment,container,false);

        if(comprovarInternet(getContext())) {

            if (v != null) {
                llista = (ListView) v.findViewById(R.id.listViewClassificacio);
                posicio = (TextView)v.findViewById(R.id.txtPos) ;
                equip = (TextView)v.findViewById(R.id.txtEqu);
                partits_jugats = (TextView)v.findViewById(R.id.txtPartitsJugats);
                punts = (TextView)v.findViewById(R.id.txtPunts);
            }

            //dialog = ProgressDialog.show(getActivity(),"","Carregant dades...",true);
            new Classificacio_task(this).execute();


            swipeLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_container_classificacio);
            swipeLayout.setOnRefreshListener(this);

            llista.setOnScrollListener(new ListView.OnScrollListener() {

                @Override
                public void onScrollStateChanged(AbsListView absListView, int i) {

                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    int filaSuperior = (
                            llista == null//Si la lista esta vacía ó
                                    || llista.getChildCount() == 0) ? 0 : llista.getChildAt(0).getTop();//Estamos en el elemento superior
                    swipeLayout.setEnabled(filaSuperior >= 0); //Activamos o desactivamos el swipe layout segun corresponda
                }

            });
        }else{
            Snackbar.make(v,"No hi ha connexió a Internet", Snackbar.LENGTH_LONG).show();
        }

        return v;

    }

    public void carregar_dades(ArrayList<Posicio> dades) {
        Classificacio_adapter adapter_classificacio = new Classificacio_adapter(this.getActivity(), dades);
        llista.setAdapter(adapter_classificacio);
        //hideProgressDialog();
    }

    public void hideProgressDialog(){
        if(dialog != null)
            dialog.hide();
    }


    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                new Classificacio_task(fragment).execute();
                swipeLayout.setRefreshing(false);
            }
        },2500);
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
