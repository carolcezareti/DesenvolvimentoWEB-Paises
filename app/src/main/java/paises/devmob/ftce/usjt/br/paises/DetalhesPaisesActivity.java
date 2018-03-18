package paises.devmob.ftce.usjt.br.paises;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetalhesPaisesActivity extends Activity {
    TextView txtNome = (TextView) findViewById(R.id.pais_nome);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_paises);
        Intent intent = getIntent();
        String nome = intent.getStringExtra(ListarPaisesActivity.PAIS);
        txtNome.setText(nome);
    }
}
