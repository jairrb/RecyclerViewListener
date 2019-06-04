package br.com.digitalhouse.recyclerviewlistener.contatos.adapters;

import android.support.annotation.NonNull;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.recyclerviewlistener.R;
import br.com.digitalhouse.recyclerviewlistener.contatos.RecycleViewClickListener;
import br.com.digitalhouse.recyclerviewlistener.contatos.model.Contato;

public class RecyclerViewContatosAdapter extends RecyclerView.Adapter<RecyclerViewContatosAdapter.ViewHolder> {
    private List<Contato> contatos;
    private RecycleViewClickListener listener;

    public RecyclerViewContatosAdapter(List<Contato> contatos, RecycleViewClickListener listener) {
        this.contatos = contatos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contato_recycleview_item, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Contato contato = contatos.get(position);
        viewHolder.bind(contato);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(contato);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contatos.size();
    }

    //Class ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewFoto;
        private TextView textViewNome;
        private TextView textViewTelefone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewFoto = itemView.findViewById(R.id.imageViewFoto);
            textViewNome = itemView.findViewById(R.id.textViewNome);
            textViewTelefone = itemView.findViewById(R.id.textViewTelefone);
        }

        public void bind(Contato contato) {
            imageViewFoto.setImageDrawable(ContextCompat
                    .getDrawable(imageViewFoto.getContext(), contato.getFoto()));
            textViewNome.setText(contato.getNome());
            textViewTelefone.setText(contato.getNumero());
        }
    }
}
