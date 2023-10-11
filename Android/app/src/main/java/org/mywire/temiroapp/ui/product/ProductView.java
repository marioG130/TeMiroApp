package org.mywire.temiroapp.ui.product;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import org.mywire.temiroapp.data.remote.ProductService;
import org.mywire.temiroapp.R;
import org.mywire.temiroapp.model.Product;

import java.util.List;

public class ProductView extends Fragment {

    private ProductService apiService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.product_ppal, container, false);

        Button btnProduct1 = rootView.findViewById(R.id.btnproduct1);
        btnProduct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("ProductView", "Botón Ver Más clickeado");


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://temiro.mywire.org:8000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                ProductService productService = retrofit.create(ProductService.class);

                int productId = 305;
                Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
                intent.putExtra("productId", productId);
                startActivity(intent);


                Call<List<Product>> call = productService.getProducts();
                call.enqueue(new Callback<List<Product>>() {
                    @Override
                    public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                        if (response.isSuccessful()) {
                            List<Product> products = response.body();
                            Log.d("ProductView", "Respuesta exitosa: " + products.size() + " productos obtenidos");
                        } else {

                            Toast.makeText(getContext(), "Error al cargar los productos", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Product>> call, Throwable t) {

                        Toast.makeText(getContext(), "Error de red", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button btnProduct2 = rootView.findViewById(R.id.btnproduct2);
        btnProduct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("ProductView", "Botón Ver Más clickeado");


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://temiro.mywire.org:8000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                ProductService productService = retrofit.create(ProductService.class);

                int productId = 308;
                Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
                intent.putExtra("productId", productId);
                startActivity(intent);


                Call<List<Product>> call = productService.getProducts();
                call.enqueue(new Callback<List<Product>>() {
                    @Override
                    public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                        if (response.isSuccessful()) {
                            List<Product> products = response.body();
                            Log.d("ProductView", "Respuesta exitosa: " + products.size() + " productos obtenidos");
                        } else {

                            Toast.makeText(getContext(), "Error al cargar los productos", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Product>> call, Throwable t) {

                        Toast.makeText(getContext(), "Error de red", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button btnProduct3 = rootView.findViewById(R.id.btnproduct3);
        btnProduct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("ProductView", "Botón Ver Más clickeado");


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://temiro.mywire.org:8000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                ProductService productService = retrofit.create(ProductService.class);

                int productId = 303;
                Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
                intent.putExtra("productId", productId);
                startActivity(intent);


                Call<List<Product>> call = productService.getProducts();
                call.enqueue(new Callback<List<Product>>() {
                    @Override
                    public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                        if (response.isSuccessful()) {
                            List<Product> products = response.body();
                            Log.d("ProductView", "Respuesta exitosa: " + products.size() + " productos obtenidos");
                        } else {

                            Toast.makeText(getContext(), "Error al cargar los productos", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Product>> call, Throwable t) {

                        Toast.makeText(getContext(), "Error de red", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        Button btnProduct4 = rootView.findViewById(R.id.btnproduct4);
        btnProduct4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("ProductView", "Botón Ver Más clickeado");


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://temiro.mywire.org:8000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                ProductService productService = retrofit.create(ProductService.class);

                int productId = 309;
                Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
                intent.putExtra("productId", productId);
                startActivity(intent);


                Call<List<Product>> call = productService.getProducts();
                call.enqueue(new Callback<List<Product>>() {
                    @Override
                    public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                        if (response.isSuccessful()) {
                            List<Product> products = response.body();
                            Log.d("ProductView", "Respuesta exitosa: " + products.size() + " productos obtenidos");
                        } else {

                            Toast.makeText(getContext(), "Error al cargar los productos", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Product>> call, Throwable t) {

                        Toast.makeText(getContext(), "Error de red", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button btnProduct5 = rootView.findViewById(R.id.btnproduct5);
        btnProduct5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("ProductView", "Botón Ver Más clickeado");


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://temiro.mywire.org:8000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                ProductService productService = retrofit.create(ProductService.class);

                int productId = 306;
                Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
                intent.putExtra("productId", productId);
                startActivity(intent);


                Call<List<Product>> call = productService.getProducts();
                call.enqueue(new Callback<List<Product>>() {
                    @Override
                    public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                        if (response.isSuccessful()) {
                            List<Product> products = response.body();
                            Log.d("ProductView", "Respuesta exitosa: " + products.size() + " productos obtenidos");
                        } else {

                            Toast.makeText(getContext(), "Error al cargar los productos", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Product>> call, Throwable t) {

                        Toast.makeText(getContext(), "Error de red", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button btnProduct6 =rootView.findViewById(R.id.btnproduct6);
        btnProduct6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("ProductView", "Botón Ver Más clickeado");


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://temiro.mywire.org:8000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                ProductService productService = retrofit.create(ProductService.class);

                int productId = 310;
                Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
                intent.putExtra("productId", productId);
                startActivity(intent);


                Call<List<Product>> call = productService.getProducts();
                call.enqueue(new Callback<List<Product>>() {
                    @Override
                    public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                        if (response.isSuccessful()) {
                            List<Product> products = response.body();
                            Log.d("ProductView", "Respuesta exitosa: " + products.size() + " productos obtenidos");
                        } else {

                            Toast.makeText(getContext(), "Error al cargar los productos", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Product>> call, Throwable t) {

                        Toast.makeText(getContext(), "Error de red", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button btnProduct7 =rootView.findViewById(R.id.btnproduct7);
        btnProduct7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("ProductView", "Botón Ver Más clickeado");


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://temiro.mywire.org:8000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                ProductService productService = retrofit.create(ProductService.class);

                int productId = 307;
                Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
                intent.putExtra("productId", productId);
                startActivity(intent);


                Call<List<Product>> call = productService.getProducts();
                call.enqueue(new Callback<List<Product>>() {
                    @Override
                    public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                        if (response.isSuccessful()) {
                            List<Product> products = response.body();
                            Log.d("ProductView", "Respuesta exitosa: " + products.size() + " productos obtenidos");
                        } else {

                            Toast.makeText(getContext(), "Error al cargar los productos", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Product>> call, Throwable t) {

                        Toast.makeText(getContext(), "Error de red", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button btnProduct8 =rootView.findViewById(R.id.btnproduct8);
        btnProduct8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("ProductView", "Botón Ver Más clickeado");


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://temiro.mywire.org:8000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                ProductService productService = retrofit.create(ProductService.class);

                int productId = 301;
                Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
                intent.putExtra("productId", productId);
                startActivity(intent);


                Call<List<Product>> call = productService.getProducts();
                call.enqueue(new Callback<List<Product>>() {
                    @Override
                    public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                        if (response.isSuccessful()) {
                            List<Product> products = response.body();
                            Log.d("ProductView", "Respuesta exitosa: " + products.size() + " productos obtenidos");
                        } else {

                            Toast.makeText(getContext(), "Error al cargar los productos", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Product>> call, Throwable t) {

                        Toast.makeText(getContext(), "Error de red", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button btnProduct9 =rootView.findViewById(R.id.btnproduct9);
        btnProduct9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("ProductView", "Botón Ver Más clickeado");


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://temiro.mywire.org:8000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                ProductService productService = retrofit.create(ProductService.class);

                int productId = 302;
                Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
                intent.putExtra("productId", productId);
                startActivity(intent);


                Call<List<Product>> call = productService.getProducts();
                call.enqueue(new Callback<List<Product>>() {
                    @Override
                    public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                        if (response.isSuccessful()) {
                            List<Product> products = response.body();
                            Log.d("ProductView", "Respuesta exitosa: " + products.size() + " productos obtenidos");
                        } else {

                            Toast.makeText(getContext(), "Error al cargar los productos", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Product>> call, Throwable t) {

                        Toast.makeText(getContext(), "Error de red", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button btnProduct10=rootView.findViewById(R.id.btnproduct10);
        btnProduct10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("ProductView", "Botón Ver Más clickeado");


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://temiro.mywire.org:8000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                ProductService productService = retrofit.create(ProductService.class);

                int productId = 304;
                Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
                intent.putExtra("productId", productId);
                startActivity(intent);


                Call<List<Product>> call = productService.getProducts();
                call.enqueue(new Callback<List<Product>>() {
                    @Override
                    public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                        if (response.isSuccessful()) {
                            List<Product> products = response.body();
                            Log.d("ProductView", "Respuesta exitosa: " + products.size() + " productos obtenidos");
                        } else {

                            Toast.makeText(getContext(), "Error al cargar los productos", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Product>> call, Throwable t) {

                        Toast.makeText(getContext(), "Error de red", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return rootView;
    }
}