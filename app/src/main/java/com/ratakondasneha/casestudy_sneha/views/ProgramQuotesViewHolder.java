package com.ratakondasneha.casestudy_sneha.views;

import android.view.View;
import android.widget.TextView;
import android.app.AlertDialog;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ratakondasneha.casestudy_sneha.R;
import com.ratakondasneha.casestudy_sneha.model.ProgramQuotesInfo;

import java.util.ArrayList;

public class ProgramQuotesViewHolder extends RecyclerView.ViewHolder {
    private ArrayList<ProgramQuotesInfo> data;
    private TextView quotesText;

    public ProgramQuotesViewHolder(@NonNull View itemView) {
        super(itemView);
        this.quotesText = itemView.findViewById(R.id.quote_text);
    }

    public TextView getQuotesText()
    {
        return quotesText;
    }

    public void populate(ProgramQuotesInfo programQuotesInfo){
        quotesText.setText(programQuotesInfo.getProgramQuoteText());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle(R.string.life_quote_title)
                        .setMessage("Quote::"+programQuotesInfo.getProgramQuoteText()+"\n\n"+
                                "Author::"+formatText(programQuotesInfo.getProramQuoteAuthor()+"\n"))
                        .setNegativeButton(R.string.quote_cancel,(d,which) -> {})
                        .show();

            }
        });
    }

    public String formatText(String authorName){
        if(authorName.length()==1)
        {
            return "Unknown";
        }

        return authorName;
    }


}
