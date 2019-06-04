package br.com.digitalhouse.recyclerviewlistener.contatos.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.recyclerviewlistener.R;
import br.com.digitalhouse.recyclerviewlistener.contatos.RecycleViewClickListener;
import br.com.digitalhouse.recyclerviewlistener.contatos.adapters.RecyclerViewContatosAdapter;
import br.com.digitalhouse.recyclerviewlistener.contatos.model.Contato;

public class ContatoActivity extends AppCompatActivity implements RecycleViewClickListener {
    private RecyclerView recyclerView;
    private RecyclerViewContatosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerViewContatos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerViewContatosAdapter(getContatos(),this);

        recyclerView.setAdapter(adapter);

    }

    private List<Contato> getContatos() {
        List<Contato> contatos = new ArrayList<>();

        contatos.add(new Contato("Android A","11-11111-1111",R.drawable.android));
        contatos.add(new Contato("Android B","11-22222-2222",R.drawable.android2));
        contatos.add(new Contato("Android C","11-33333-3333",R.drawable.android3));
        contatos.add(new Contato("Android D","11-44444-4444",R.drawable.android4));
        contatos.add(new Contato("Android E","11-55555-5555",R.drawable.android5));

        return contatos;
    }


    @Override
    public void onClick(Contato contato) {
        Intent intent = new Intent(this, DetalheContatoActivity.class);
        intent.putExtra("CONTATO",contato);
        startActivity(intent);
    }
}
