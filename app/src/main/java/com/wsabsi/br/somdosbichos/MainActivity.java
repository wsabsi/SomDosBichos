package com.wsabsi.br.somdosbichos;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {
    private ImageView botaoCao;
    private ImageView botaoGato;
    private ImageView botaoLeao;
    private ImageView botaoMacaco;
    private ImageView botaoOvelha;
    private ImageView botaoVaca;
    private MediaPlayer player;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(player != null){
            cleanMemory();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botaoCao = (ImageView) findViewById(R.id.caoID);
        botaoGato = (ImageView) findViewById(R.id.gatoID);
        botaoLeao = (ImageView) findViewById(R.id.leaoID);
        botaoMacaco = (ImageView) findViewById(R.id.macacoID);
        botaoOvelha = (ImageView) findViewById(R.id.ovelhaID);
        botaoVaca = (ImageView) findViewById(R.id.vacaID);

        botaoCao.setOnClickListener(this);
        botaoGato.setOnClickListener(this);
        botaoLeao.setOnClickListener(this);
        botaoMacaco.setOnClickListener(this);
        botaoOvelha.setOnClickListener(this);
        botaoVaca.setOnClickListener(this);




    }
    public void tocar(){
        if(player != null){
            player.start();
        }
    }
    public void pausar(){
        if(player.isPlaying()){
            player.pause();
        }
    }
    public void cleanMemory(){
        if(player.isPlaying()){
            player.stop();
            player.release();
            player = null;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.caoID:
                player = MediaPlayer.create(getApplicationContext(),R.raw.cao);
                tocar();
                break;
            case R.id.gatoID:
                player = MediaPlayer.create(getApplicationContext(),R.raw.gato);
                tocar();
                break;
            case R.id.leaoID:
                player = MediaPlayer.create(getApplicationContext(),R.raw.leao);
                tocar();
                break;
            case R.id.macacoID:
                player = MediaPlayer.create(getApplicationContext(),R.raw.macaco);
                tocar();
                break;
            case R.id.ovelhaID:
                player = MediaPlayer.create(getApplicationContext(),R.raw.ovelha);
                tocar();
                break;
            default:
                player = MediaPlayer.create(getApplicationContext(),R.raw.vaca);
                tocar();
        }

    }
}
