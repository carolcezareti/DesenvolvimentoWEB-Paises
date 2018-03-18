package paises.devmob.ftce.usjt.br.paises;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarPaisesActivity extends Activity {
    public static final String PAIS = "br.usjt.deswebmob.agenda";
    ArrayList<String> paises;
    ListView listView;
    Activity contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_paises);
        Intent intent = getIntent();
        String nomeFila = intent.getStringExtra(MainActivity.Fila);
        final ArrayList<String> paises = buscarPaises(nomeFila);
        listView = (ListView) findViewById(R.id.Listar_paises);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paises);
        listView.setAdapter(adapter);
        contexto = this;

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String contato = paises.get(position);
                        Intent intent1 = new Intent(contexto, DetalhesPaisesActivity.class);
                        intent1.putExtra(PAIS, paises);
                        startActivity(intent1);
                    }
                }

        );
    }

    private ArrayList<String> buscarPaises(String chave) {
        ArrayList<String> lista = geraListaPaises();
        if (chave == null || chave.length()== 0) {
            return lista;
        }
        ArrayList<String> resultado = new ArrayList<>();
        {
            for (String paises : lista) {
                if (paises.toUpperCase().contains(chave.toUpperCase())) {
                    resultado.add(paises);
                }
            }
        }
        return lista;
    }

    private ArrayList<String> geraListaPaises() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Brasil");
        lista.add("Estados Unidos");
        lista.add("Canadá");
        lista.add("México");
        lista.add("Itália");
        lista.add("Alemanha");
        lista.add("França");
        lista.add("Rússia");
        lista.add("China");
        lista.add("Japão");
        lista.add("Austrália");
        lista.add("África");
        return lista;
    }
}
