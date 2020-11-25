package com.example.todolist;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoAdaptor  extends RecyclerView.Adapter<TodoAdaptor.ViewHolder>{
Context context ;
Intent data;

    Boolean ischicked;

ArrayList<Pair<Boolean,Pair<String,String>>> arr;
public TodoAdaptor(Context context, ArrayList<Pair<Boolean,Pair<String,String>>> todos){
    this.arr = todos;
    this.context = context;
}
     @NonNull
    @Override
    public TodoAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    
    LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.todo,parent,false);

         ViewHolder viewHolder = new ViewHolder(view);


            return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull TodoAdaptor.ViewHolder holder, int position) {

        holder.title.setText(arr.get(position).second.first);
        holder.disc.setText(arr.get(position).second.second);
        ischicked = arr.get(position).first;

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,MainActivity2.class);
                intent.putExtra("todoname",arr.get(position).second.first);
                intent.putExtra("tododis",arr.get(position).second.second);
                intent.putExtra("check",ischicked);
               context.startActivity(intent);

            }

        });


        holder.title.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder
                        = new AlertDialog
                        .Builder(context);
                builder.setMessage("Do you want to delete?");
                builder.setTitle("Alert !");
                builder.setCancelable(true);

                builder
                        .setPositiveButton(
                                "Yes",
                                new DialogInterface
                                        .OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which)
                                    {
                                            arr.remove(position);
                                        notifyDataSetChanged();


                                    }
                                });
                AlertDialog alertDialog = builder.create();

                // Show the Alert Dialog box
                alertDialog.show();
                return false;
            }

        });


        holder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.pic){
                    if(ischicked){
                        holder.check.setChecked(false);
                        ischicked=false;
                    }else{
                        holder.check.setChecked(true);
                        ischicked=true;
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {

    return arr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    TextView title;
    CheckBox check;
    TextView disc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.todotitle);
            check = itemView.findViewById(R.id.pic);
            disc = itemView.findViewById(R.id.disc);

        }

    }

}
