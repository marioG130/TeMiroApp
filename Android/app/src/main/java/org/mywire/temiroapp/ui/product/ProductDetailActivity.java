package org.mywire.temiroapp.ui.product;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import org.mywire.temiroapp.R;
import org.mywire.temiroapp.model.Product;
import org.mywire.temiroapp.data.remote.ProductService;

public class ProductDetailActivity extends AppCompatActivity {

    private ImageView productImage;
    private TextView productName, productPrice, productDescription,productDetalle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);

        int productId = getIntent().getIntExtra("productId", -1);

        productImage = findViewById(R.id.productImage);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);
        productDescription = findViewById(R.id.productDescription);
        productDetalle = findViewById(R.id.productDetalle);

        if (productId != -1) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://temiro.mywire.org:8000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ProductService productService = retrofit.create(ProductService.class);
            Call<Product> call = productService.getProductById(productId);
            call.enqueue(new Callback<Product>() {
                @Override
                public void onResponse(Call<Product> call, Response<Product> response) {
                    if (response.isSuccessful()) {
                        Product product = response.body();

                        productName.setText(product.getDescripcion());
                        productPrice.setText("Precio: $" + product.getPrecio());
                        productDescription.setText(product.getEspecificaciones());
                        productDetalle.setText(product.getDetalle());

                        Glide.with(ProductDetailActivity.this)
                                .load(product.getImagen())
                                .apply(new RequestOptions()
                                        .placeholder(R.drawable.ic_launcher_background)
                                        .error(R.drawable.ic_launcher_background)
                                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                                .into(productImage);

                    } else {
                        Toast.makeText(ProductDetailActivity.this, "Error al cargar los detalles del producto", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Product> call, Throwable t) {
                    Toast.makeText(ProductDetailActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(ProductDetailActivity.this, "Producto incorrecto !", Toast.LENGTH_LONG).show();
        }
    }

}
