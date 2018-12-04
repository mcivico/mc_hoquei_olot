package mcivico.com.clubhoqueiolot.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import mcivico.com.clubhoqueiolot.Model.Posicio;
import mcivico.com.clubhoqueiolot.R;

public class Classificacio_adapter extends BaseAdapter {

    class Vista{
        private TextView pos, equip, pj, pts;
    }

    private Activity context;
    private ArrayList<Posicio> dades;

    public Classificacio_adapter(Activity context, ArrayList<Posicio> dades){
        this.context = context;
        this.dades = dades;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Vista holder;

        if(view == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            view = layoutInflater.inflate(R.layout.classificacio_adapter,null);

            holder = new Vista();
            holder.pos = (TextView)view.findViewById(R.id.txtPosicio);
            holder.equip = (TextView)view.findViewById(R.id.txtEquip);
            holder.pj = (TextView)view.findViewById(R.id.txtPartitsJugats);
            holder.pts = (TextView)view.findViewById(R.id.txtPunts);
            view.setTag(holder);
        }else{
            holder = (Vista)view.getTag();
        }

        if(dades.get(i).equip.toUpperCase().contains("OLOT")){
            holder.pos.setTextSize(17);
            holder.pos.setTextColor(context.getResources().getColor(R.color.colorPrimary));
            holder.equip.setTextSize(17);
            holder.equip.setTextColor(context.getResources().getColor(R.color.colorPrimary));
            holder.pj.setTextSize(17);
            holder.pj.setTextColor(context.getResources().getColor(R.color.colorPrimary));
            holder.pts.setTextSize(17);
            holder.pts.setTextColor(context.getResources().getColor(R.color.colorPrimary));
        } else{
            holder.pos.setTextSize(14);
            holder.pos.setTextColor(context.getResources().getColor(R.color.colorNegre));
            holder.equip.setTextSize(14);
            holder.equip.setTextColor(context.getResources().getColor(R.color.colorNegre));
            holder.pj.setTextSize(14);
            holder.pj.setTextColor(context.getResources().getColor(R.color.colorNegre));
            holder.pts.setTextSize(14);
            holder.pts.setTextColor(context.getResources().getColor(R.color.colorNegre));
        }

        String posicio, equip, pjug, punts;
        posicio = dades.get(i).position;
        equip = dades.get(i).equip;
        pjug = dades.get(i).partitsJugats;
        punts = dades.get(i).punts;

        holder.pos.setText(posicio);
        holder.equip.setText(equip);
        holder.pj.setText(pjug);
        holder.pts.setText(punts);

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
