package mcivico.com.clubhoqueiolot.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import mcivico.com.clubhoqueiolot.Calendari_1e_fragment;
import mcivico.com.clubhoqueiolot.Classificacio_fragment;
import mcivico.com.clubhoqueiolot.Partits_1E_fragment;
import mcivico.com.clubhoqueiolot.Plantilla_fragment;

public class Primer_equip_pageAdapter extends FragmentStatePagerAdapter{
    int mNumOfTabs;

    public Primer_equip_pageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Partits_1E_fragment partits = new Partits_1E_fragment();
                return partits;
            case 1:
                Classificacio_fragment classificacio = new Classificacio_fragment();
                return classificacio;
            case 2:
                Calendari_1e_fragment calendari = new Calendari_1e_fragment();
                return calendari;
            case 3:
                Plantilla_fragment plantilla = new Plantilla_fragment();
                return plantilla;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
