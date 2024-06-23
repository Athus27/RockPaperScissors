package com.example.pedrapapeltesoura;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void selecionarPedra(View view ){
        verificarGanhador("pedra");
    }
    public void selecionarPapel(View view ){
        verificarGanhador("papel");

    }
    public void selecionarTesoura(View view ){
        verificarGanhador("tesoura");

    }
    public void selecionarLargato(View view ){
        verificarGanhador("largato");

    }
    public void selecionarSpock(View view ){
        verificarGanhador("spock");

    }

    public String gerarEscolhaApp(){
        String[] escolhas = {"pedra","papel","tesoura","largato", "spock"};
        Random random = new Random();
        String resultado =  escolhas[random.nextInt(5)];
        ImageView image = findViewById(R.id.image_app);
        switch (resultado){
            case "pedra":{
                image.setImageResource(R.drawable.pedra);
                break;
            }

            case "papel":{
                image.setImageResource(R.drawable.papel);
                break;
            }

            case "tesoura":{
                image.setImageResource(R.drawable.tesoura);
                break;
            }
            case "largato":{
                image.setImageResource(R.drawable.lagarto);
                break;
            }
            case "spock":{
                image.setImageResource(R.drawable.spok);
                break;
            }


        }
        return resultado;

    }

    private void verificarGanhador(String escolhaUser){
        String escolhaApp = gerarEscolhaApp();
        TextView textoResultado = findViewById(R.id.resultadoText);

        if (
            (escolhaApp == "pedra" && escolhaUser == "tesoura") ||
            (escolhaApp == "pedra" && escolhaUser == "largato") ||
            (escolhaApp == "papel" && escolhaUser == "spock") ||
            (escolhaApp == "papel" && escolhaUser == "pedra") ||
            (escolhaApp == "tesoura" && escolhaUser == "papel") ||
            (escolhaApp == "tesoura" && escolhaUser == "largato") ||
            (escolhaApp == "largato" && escolhaUser == "papel") ||
            (escolhaApp == "largato" && escolhaUser == "spock") ||
            (escolhaApp == "spock" && escolhaUser == "tesoura") ||
            (escolhaApp == "spock" && escolhaUser == "pedra")
        ){
            textoResultado.setText("Você perdeu! :(");
        } else if (
            (escolhaUser == "pedra" && escolhaApp == "tesoura") ||
            (escolhaUser == "pedra" && escolhaApp == "largato") ||
            (escolhaUser == "papel" && escolhaApp == "spock") ||
            (escolhaUser == "papel" && escolhaApp == "pedra") ||
            (escolhaUser == "tesoura" && escolhaApp == "papel") ||
            (escolhaUser == "tesoura" && escolhaApp == "largato") ||
            (escolhaUser == "largato" && escolhaApp == "papel") ||
            (escolhaUser == "largato" && escolhaApp == "spock") ||
            (escolhaUser == "spock" && escolhaApp == "tesoura") ||
            (escolhaUser == "spock" && escolhaApp == "pedra")
        ) {
            textoResultado.setText("Você ganhou! :)");

        }else {
            textoResultado.setText("empate! o_O");
        }

    }


}