package com.ratakondasneha.casestudy_sneha.views;

import android.view.View;
import android.widget.TextView;
import android.app.AlertDialog;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ratakondasneha.casestudy_sneha.R;
import com.ratakondasneha.casestudy_sneha.model.LifeQuotesInfo;

import java.util.ArrayList;

public class LifeQuotesVewHolder extends RecyclerView.ViewHolder {

    private ArrayList<LifeQuotesInfo> data;
    private TextView quotesText;

    public TextView getQuotesText()
    {
        return quotesText;
    }

    public LifeQuotesVewHolder(@NonNull View itemView) {
        super(itemView);
        this.quotesText = itemView.findViewById(R.id.quote_text);
    }

    public void populate(LifeQuotesInfo lifeQuotesInfo)
    {
        quotesText.setText(lifeQuotesInfo.getQuoteText());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle(R.string.life_quote_title)
                        .setMessage("Quote::"+lifeQuotesInfo.getQuoteText()+"\n\n"+
                                "Author::"+formatText(lifeQuotesInfo.getQuoteAuthor()+"\n"))
                        .setNegativeButton(R.string.quote_cancel,(d,which) -> {})
                        .show();

            }
        });
    }

    public String formatText(String authorName){

        if(authorName.length()==1){

            return "Unknown";
        }

        return authorName;
    }


}
