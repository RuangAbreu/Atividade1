package com.example.alunos.meus_livros;

import android.support.v7.widget.RecyclerView;

public class LivroListAdapter extends RecyclerView.Adapter<LivroListAdapter.LivroViewHolder> {

    class LivroViewHolder extends RecyclerView.ViewHolder {
        private final TextView tituloItemView;
        private final TextView autorItemView;
        private final TextView editoraItemView;

        private LivroViewHolder (View itemView){
            super(itemView);
            tituloItemView = itemView.findViewById(R.id.titulo);
            autorItemView = itemView.findViewById(R.id.autor);
            editoraItemView = itemViewById(R.id.editora);
        }
    }

    private final LayoutInflater mInflater;
    private List<Livros> listaLivros;

    LivroListAdapter(Context context){
        mInflater = LayoutInflater.from(contenxt);
    }

    @Override
    @NonNull
    public LivroViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new LivroViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LivroViewHolder holder, int position){
        if(listaLivros != null){
            Livro current = listaLivros.get(position);
            holder.tituloItemView.setText(current.getTitulo());
            holder.autorItemVIew.setText(current.getAutor());
            holder.editoraItemView.setText(current.getEditora());
        }else{
            //Covers the case of data not being ready yet.
            holder.tituloItemView.setText("Sem dados");
            holder.autorItemView.setText("Sem dados");
            holder.editoraItemView.setText("Sem dados");
        }
    }

    holder.editaLivro.setOnClickListenet(new View.OnClickListener(){
        public void onClick(View view){
            if(listaLivros!=null){
                Livro current=listaLivros.get(holder.getAdapterPosition());
                Intent intent=new Intent(context,EditActivity.class);
                intent.putExtra("livro",current);
                ((Activity)context).startActivityForResult(intent,
                        MainActivity.EDIT_LIVRO_ACTIVITY_REQUEST_CODE);
            }
        }
    });

    void setWords(List<Livros> livros){
        listaLivros = livros;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        if(listaLivros != null){
            return listaLivros.size();
        }else{
            return 0;
        }
    }
    private LivroViewHolder(View itemView) { //mudança apenas nessa parte meninas, para acrescentar botões edita e deleta livro
        super((itemView));
        tituloItemView = itemView.findViewById(R.id.titulo);
        autorItemView = item.View.findViewById(R.id.autor);
        editoraItemView = itemView.findViewById(R.id.editora);
        editaLivro = itemView.findViewById(R.id.editora);
        deletaLivro = itemView.findViewById(R.id.editora);
    }
}
