package paises.devmob.ftce.usjt.br.paises;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    public static final String Fila = "br.usjt.deswebmob.paises.fila";
    private EditText txtfila;
    private Intent ListarPaisesActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtfila = (EditText) findViewById(R.id.buscar_fila);



    }
    public void buscarPaises(View view) {
        String fila = txtfila.getText().toString();
        Intent intent = new Intent(this, ListarPaisesActivity.class);
        intent.putExtra(Fila, fila);
        startActivity(intent);
    }
}
