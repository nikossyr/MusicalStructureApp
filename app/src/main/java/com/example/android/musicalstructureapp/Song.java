package com.example.android.musicalstructureapp;

import android.os.Parcel;
import android.os.Parcelable;


public class Song implements Parcelable {

    //Song title
    private String mSongTitle;

    //Song Artist
    private String mSongArtist;

    /**
     * Create a new Song object.
     *
     * @param songTitle  is the title of the song
     * @param songArtist is the artist of the song
     */
    public Song(String songTitle, String songArtist) {
        mSongTitle = songTitle;
        mSongArtist = songArtist;
    }

    /**
     * Get the title of the song
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Get the artist name of the song
     */
    public String getSongArtist() {
        return mSongArtist;
    }

    /**
     * Here we make the array parcelable in order to be able to transfer its contents between activities
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mSongTitle);
        parcel.writeString(mSongArtist);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int i) {
            return new Song[i];
        }
    };

    public Song(Parcel in) {
        mSongTitle = in.readString();
        mSongArtist = in.readString();
    }

}
