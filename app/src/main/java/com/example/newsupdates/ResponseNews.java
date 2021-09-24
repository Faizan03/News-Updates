package com.example.newsupdates;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
class source{
//    @SerializedName("id")
    String id;
//    @SerializedName("name")
    String name;

}

public class ResponseNews  {
    public static class article implements Parcelable {
//       @SerializedName()
        source source;
//        @SerializedName()
       String author;
//        @SerializedName()
        String title;
//        @SerializedName()
        String description;
//        @SerializedName()
        String url;
//        @SerializedName()
        String urlToImage;
//        @SerializedName()
        String publishedAt;
//        @SerializedName()
        String Content;

        public article( String title, String publishedAt) {

            this.title = title;

            this.publishedAt = publishedAt;

        }

        protected article(Parcel in) {
            author = in.readString();
            title = in.readString();
            description = in.readString();
            url = in.readString();
            urlToImage = in.readString();
            publishedAt = in.readString();
            Content = in.readString();
        }

        public static final Creator<article> CREATOR = new Creator<article>() {
            @Override
            public article createFromParcel(Parcel in) {
                return new article(in);
            }

            @Override
            public article[] newArray(int size) {
                return new article[size];
            }
        };

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrlToImage() {
            return urlToImage;
        }

        public void setUrlToImage(String urlToImage) {
            this.urlToImage = urlToImage;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(author);
            dest.writeString(title);
            dest.writeString(description);
            dest.writeString(url);
            dest.writeString(urlToImage);
            dest.writeString(publishedAt);
            dest.writeString(Content);
        }
    }
    String Status;
    int totalResults;
    List<article> articles;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<article> getArticles() {
        return articles;
    }

    public void setArticles(List<article> articles) {
        this.articles = articles;

    }
}

