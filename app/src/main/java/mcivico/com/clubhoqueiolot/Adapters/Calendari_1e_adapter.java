package mcivico.com.clubhoqueiolot.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mcivico.com.clubhoqueiolot.Model.Event;
import mcivico.com.clubhoqueiolot.R;

public class Calendari_1e_adapter extends BaseAdapter{

    private Activity context;
    private ArrayList<Event> dades;

    class Vista{
        private ImageView foto1,foto2;
        private TextView categoria,equipL,equipV,resultat,lloc,hora,data;
    }

    public Calendari_1e_adapter(Activity context, ArrayList<Event> dades){
        this.context = context;
        this.dades = dades;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Vista holder;
        if(view == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            view = layoutInflater.inflate(R.layout.partits_adapter, null);

            holder = new Vista();
            holder.foto1 = (ImageView) view.findViewById(R.id.imgLocalPartit);
            holder.foto2 = (ImageView) view.findViewById(R.id.imgVisitantPartit);
            holder.categoria = (TextView) view.findViewById(R.id.txtEquipPartit);
            holder.equipL = (TextView) view.findViewById(R.id.txtLocalPartit);
            holder.equipV = (TextView) view.findViewById(R.id.txtVisitantPartit);
            holder.resultat = (TextView) view.findViewById(R.id.txtResultatPartit);
            holder.hora = (TextView) view.findViewById(R.id.txtHoraPartit);
            holder.data = (TextView) view.findViewById(R.id.txtDataPartit);
            holder.lloc = (TextView) view.findViewById(R.id.txtLlocPartit);
            view.setTag(holder);
        }else{
            holder = (Vista)view.getTag();
        }

        String categoria,equipL,equipV,resultat,lloc,hora,data;
        categoria = dades.get(i).categoria;
        equipL = dades.get(i).equipL;
        equipV = dades.get(i).equipV;
        resultat = dades.get(i).resultat;
        lloc = dades.get(i).lloc;
        hora = dades.get(i).hora;
        data = dades.get(i).data;

        holder.categoria.setText(categoria);
        holder.equipL.setText(equipL);
        holder.equipV.setText(equipV);
        holder.resultat.setText(resultat);
        holder.lloc.setText(lloc);
        holder.hora.setText(hora);
        holder.data.setText(data);
        holder.foto1.setImageResource(dades.get(i).local);
        holder.foto2.setImageResource(dades.get(i).visitant);


        //Picasso.with(this.getContext()).load("http://www.radiolot.cat/media/2016/03/LHoquei-Olot-celebra-un-gol-David-Planella-1024x683.jpg").fit().centerCrop().into(holder.foto);

        return view;
    }

    @Override
    public int getCount() {
        return this.dades.size();
    }

    @Override
    public Object getItem(int i) {
        return this.dades.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

}
