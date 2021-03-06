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

import java.util.ArrayList;

import mcivico.com.clubhoqueiolot.Adapters.Calendari_1e_adapter;
import mcivico.com.clubhoqueiolot.Adapters.Calendari_adapter;
import mcivico.com.clubhoqueiolot.Connexio.Calendari_1e_task;
import mcivico.com.clubhoqueiolot.Connexio.Calendari_task;
import mcivico.com.clubhoqueiolot.Model.Event;


public class Calendari_1e_fragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    private ListView llista;
    private SwipeRefreshLayout swipeLayout;
    private ProgressDialog dialog;
    private Calendari_1e_fragment fragment = this;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View v = inflater.inflate(R.layout.calendari_fragment,container,false);

        if(comprovarInternet(getContext())){
            if(v != null){
                llista = (ListView) v.findViewById(R.id.listViewCalendari);
            }
            //dialog = ProgressDialog.show(getActivity(),"","Carregant dades...",true);

            new Calendari_1e_task(this).execute();

            swipeLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_container_calendari);
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


    public void carregar_dades(ArrayList<Event> dades) {
        Calendari_1e_adapter adapter_calendari = new Calendari_1e_adapter(this.getActivity(), dades);
        llista.setAdapter(adapter_calendari);
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
                new Calendari_1e_task(fragment).execute();
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
