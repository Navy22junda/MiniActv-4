package com.android.mdw.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity implements OnClickListener {
    private Intent in;
    Button btnSonido;
    Button btnCancion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btnFin = (Button) findViewById(R.id.btnFin);

        btnSonido = (Button)findViewById(R.id.btnSonido);
        btnCancion = (Button)findViewById(R.id.btnCancion);

        btnSonido.setOnClickListener(this);
        btnCancion.setOnClickListener(this);
        btnFin.setOnClickListener(this);

        in = new Intent(this, ElServicio.class);
    }

    @Override
    public void onClick(View src) {
        switch (src.getId()) {
            case R.id.btnSonido:
                in.putExtra("opcio", btnSonido.getText());
                startService(in);
                break;
            case R.id.btnCancion:
                in.putExtra("opcio", btnCancion.getText());
                startService(in);
                break;
            case R.id.btnFin:
                stopService(in);
                break;
        }
    }
}