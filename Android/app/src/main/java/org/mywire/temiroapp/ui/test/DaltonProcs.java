package org.mywire.temiroapp.ui.test;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;

public class DaltonProcs {

    Context context;
    String[] botones;
    String nombreImagen;
    int correcta;

    public DaltonProcs(Context ctx) {
        context = ctx;
        botones = new String[5];
    }

    public void cargarPasoBasico(int paso) {
        char tipo = 'G';
        switch (paso) {
            case 1: nombreImagen = tipo + "_12s";
                    botones[0] = "2";
                    botones[1] = "12";
                    botones[2] = "NADA";
                    correcta = 12;
                    break;
            case 2: nombreImagen = tipo + "_26s";
                    botones[0] = "6";
                    botones[1] = "NADA";
                    botones[2] = "26";
                    correcta = 26;
                    break;
            case 3: nombreImagen = tipo + "_42s";
                    botones[0] = "NADA";
                    botones[1] = "42";
                    botones[2] = "2";
                    correcta = 42;
                    break;
            default:
                nombreImagen = tipo + "_???";
        }
    }

    public void cargarPasoAvanzado(int paso) {
        char tipo = 'Y';
        switch (paso) {

        }
    }

    public void colocarImagen(ImageView img) {
        // Imagenes desde res/drawable:
        // placa.setImageResource(R.drawable.test_placa_uk);
        // placa.setImageDrawable(getResources().getDrawable(R.drawable.test_placa_uk, ctx.getTheme()));
        try  {
            InputStream istr = context.getAssets().open("dalton1/placa"+nombreImagen+".png");
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inDensity = 58;   // DisplayMetrics.DENSITY_LOW;
            Drawable d = Drawable.createFromResourceStream(null, null, istr, null, opts);
         // Drawable d = Drawable.createFromStream(istr, null);
            img.setImageDrawable(d);
            istr.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
