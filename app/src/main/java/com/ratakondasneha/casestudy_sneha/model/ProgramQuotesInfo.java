package com.ratakondasneha.casestudy_sneha.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class ProgramQuotesInfo {
    @SerializedName("_id")
    String id;
    @SerializedName("en")
    String programQuoteText;
    @SerializedName("author")
    String proramQuoteAuthor;

    public String getId() {
        return id;
    }

    public String getProgramQuoteText() {
        return programQuoteText;
    }

    public String getProramQuoteAuthor() {
        return proramQuoteAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgramQuotesInfo that = (ProgramQuotesInfo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
