package pe.edu.ulima.pichangers.login;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.beans.RespuestaLogin;
import pe.edu.ulima.pichangers.beans.Usuario;
import pe.edu.ulima.pichangers.listaequipos.ListadoEquiposActivity;
import pe.edu.ulima.pichangers.remote.LoginService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //https://www.youtube.com/watch?v=LVK1H7_EHK4  ver video

    EditText eteUsername, etePassword;
    Button butIncribirse;
    LoginService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        eteUsername=(EditText)findViewById(R.id.eteUsername);
        etePassword=(EditText)findViewById(R.id.etePassword);
        butIncribirse=(Button)findViewById(R.id.butIncribirse);

        butIncribirse.setOnClickListener(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service =retrofit.create(LoginService.class);

    }

    @Override
    public void onClick(View v) {
        
        String username = eteUsername.getText().toString();
        String password = etePassword.getText().toString();
        Usuario usuario = new Usuario(username,password);

            Call<RespuestaLogin> respuestaLog =service.login(usuario);
            respuestaLog.enqueue(new Callback<RespuestaLogin>() {


                @Override
                public void onResponse(Call<RespuestaLogin> call, Response<RespuestaLogin> response) {
                    // para llamar a un nuevo activity, seteas a que nuevo activity a cual quieres ir
                    if(response.body().getMsg().equals("OK")){
                        // Login correcto
                        Toast.makeText(LoginActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, ListadoEquiposActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                    }

                    @Override
                    public void onFailure (Call < RespuestaLogin > call, Throwable t){
                        Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();

                    }
                }

                );

            }

    }
