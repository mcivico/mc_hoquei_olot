package mcivico.com.clubhoqueiolot.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mcivico.com.clubhoqueiolot.Model.Noticia;
import mcivico.com.clubhoqueiolot.R;

public class Noticies_adapter extends BaseAdapter {

    private Activity context;
    private ArrayList<Noticia> dades;

    class Vista{
        private ImageView foto;
        private TextView titol,data, web;
    }

    public Noticies_adapter(Activity context, ArrayList<Noticia> dades){
        this.context = context;
        this.dades = dades;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Vista holder;
        if(view == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            view = layoutInflater.inflate(R.layout.noticies_adapter, null);

            holder = new Vista();
            holder.foto = (ImageView) view.findViewById(R.id.img_noticies);
            holder.titol = (TextView) view.findViewById(R.id.txtTitolNoticia);
            holder.data = (TextView) view.findViewById(R.id.txtDataNoticia);
            holder.web = (TextView) view.findViewById(R.id.txtWebNoticia);
            view.setTag(holder);
        }else{
            holder = (Vista)view.getTag();
        }

        String txtTitol, txtData;
        txtTitol = dades.get(i).title;
        txtData = dades.get(i).date;

        holder.titol.setText(txtTitol);
        holder.data.setText(txtData);
        holder.web.setText("www.hoqueiolot.com");

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
