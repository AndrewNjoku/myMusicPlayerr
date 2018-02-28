package com.example.andria.musicplayer.Model;



        import java.util.ArrayList;
        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Classic {

    @SerializedName("resultCount")
    @Expose
    private Integer resultCount;

    @SerializedName("results")
    @Expose
    private List<Results> results;


    public Integer getResultCount() {
        return resultCount;
    }


    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public List<Results> geResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = this.results;
    }



}


