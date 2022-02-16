package android.example.recyclerviewpractical;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder> {

    Context context;
    String[] programNameList;
    String[] programDescriptionList;
    int[] images;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView rowName;
        TextView rowDescription;
        ImageView rowImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowName = itemView.findViewById(R.id.textView1);
            rowDescription = itemView.findViewById(R.id.textView2);
            rowImage = itemView.findViewById(R.id.imageView);
        }
    }

    public ProgramAdapter(Context context, String[] programNameList, String[] programDescriptionList, int[] images) {
        this.context = context;
        this.programNameList = programNameList;
        this.programDescriptionList = programDescriptionList;
        this.images = images;
    }

    @NonNull
    @Override
    public ProgramAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramAdapter.ViewHolder holder, int position) {
        holder.rowName.setText(programNameList[position]);
        holder.rowDescription.setText(programDescriptionList[position]);
        holder.rowImage.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return programNameList.length;
    }
}
