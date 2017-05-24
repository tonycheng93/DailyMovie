package com.sky.dailymovie.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import android.os.Parcelable;

import java.util.List;

/**
 * Created by tonycheng on 2017/5/24.
 */
@AutoValue
public abstract class IssueList implements Parcelable {

    public abstract long releaseTime();

    public abstract String type();

    public abstract long date();

    public abstract long publishTime();

    public abstract List<ItemList> itemList();

    public abstract int count();

    public static TypeAdapter<IssueList> typeAdapter(Gson gson){
        return new AutoValue_IssueList.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_IssueList.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder releaseTime(long releaseTime);

        public abstract Builder type(String type);

        public abstract Builder date(long date);

        public abstract Builder publishTime(long publishTime);

        public abstract Builder itemList(List<ItemList> itemList);

        public abstract Builder count(int count);

        public abstract IssueList build();
    }
}
