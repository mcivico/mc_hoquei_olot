package mcivico.com.clubhoqueiolot.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mcivico.com.clubhoqueiolot.Model.Jugador;
import mcivico.com.clubhoqueiolot.R;

public class Plantilla_adapter extends BaseAdapter {

    private Activity context;
    private ArrayList<Jugador> dades;

    class Vista{
        private ImageView foto;
        private TextView id,titol,cognom,number;
    }

    public Plantilla_adapter(Activity context, ArrayList<Jugador> dades){
        this.context = context;
        this.dades = dades;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Vista holder;
        if(view == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            view = layoutInflater.inflate(R.layout.plantilla_adapter, null);

            holder = new Vista();
            holder.foto = (ImageView) view.findViewById(R.id.imgJugador);
            holder.titol = (TextView) view.findViewById(R.id.txtNomJugador);
            holder.cognom = (TextView) view.findViewById(R.id.txtCognomJugador);
            holder.number = (TextView) view.findViewById(R.id.txtNumJugador);
            holder.foto = (ImageView) view.findViewById(R.id.imgJugador);
            view.setTag(holder);
        }else{
            holder = (Vista)view.getTag();
        }

        String txtTitol, txtCognom,txtNumero;
        txtTitol = dades.get(i).title;
        txtNumero = dades.get(i).getNumber();
        txtCognom = dades.get(i).getCognom();

        holder.titol.setText(txtTitol);
        holder.cognom.setText(txtCognom);
        holder.number.setText(txtNumero);
        holder.foto.setImageResource(dades.get(i).image);

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
