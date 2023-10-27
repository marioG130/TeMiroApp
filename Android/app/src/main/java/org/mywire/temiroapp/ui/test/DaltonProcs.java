package org.mywire.temiroapp.ui.test;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;

public class DaltonProcs {

    public static int[] TDRespuestas = { -1, -1, -1, -1};

    Context context;
    String[] botones;
    String nombreImagen;
    int botonCorrecto;

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
                    botonCorrecto = 2;
                    break;
            case 2: nombreImagen = tipo + "_26s";
                    botones[0] = "6";
                    botones[1] = "NADA";
                    botones[2] = "26";
                    botonCorrecto = 3;
                    break;
            case 3: nombreImagen = tipo + "_42s";
                    botones[0] = "NADA";
                    botones[1] = "42";
                    botones[2] = "2";
                    botonCorrecto = 2;
                    break;
            default:
                nombreImagen = tipo + "_???";
        }
    }

    public void cargarPasoAvanzado(int paso) {
        char tipo = 'Y';
        switch (paso) {
            case 1: nombreImagen = tipo + "_16s";
                botones[0] = "6";
                botones[1] = "16";
                botones[2] = "NADA";
                botonCorrecto = 2;
                break;
            case 2: nombreImagen = tipo + "_05s";
                botones[0] = "25";
                botones[1] = "NADA";
                botones[2] = "5";
                botonCorrecto = 3;
                break;
            case 3: nombreImagen = tipo + "_07s";
                botones[0] = "73";
                botones[1] = "7";
                botones[2] = "17";
                botonCorrecto = 2;
                break;
            case 4: nombreImagen = tipo + "_73s";
                botones[0] = "17";
                botones[1] = "7";
                botones[2] = "73";
                botonCorrecto = 3;
                break;
            default:
                nombreImagen = tipo + "_???";
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
