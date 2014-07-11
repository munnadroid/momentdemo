package com.example.momentdemo.datamodel;

/**
 * Created by munnadroid on 7/10/14.
 */
public class MomentData {

    private int id;
    private String username;
    private String title;
    private String avatarImageUrl;
    private String backgroundImageUrl;
    private int photoCount;
    private int videoCount;
    private int audioCount;


    public MomentData() {
    }

    public MomentData(int id, String username, String title, String avatarImageUrl,
                      String backgroundImageUrl, int photoCount, int videoCount, int audioCount) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.avatarImageUrl = avatarImageUrl;
        this.backgroundImageUrl = backgroundImageUrl;
        this.photoCount = photoCount;
        this.videoCount = videoCount;
        this.audioCount = audioCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvatarImageUrl() {
        return avatarImageUrl;
    }

    public void setAvatarImageUrl(String avatarImageUrl) {
        this.avatarImageUrl = avatarImageUrl;
    }

    public String getBackgroundImageUrl() {
        return backgroundImageUrl;
    }

    public void setBackgroundImageUrl(String backgroundImageUrl) {
        this.backgroundImageUrl = backgroundImageUrl;
    }

    public int getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(int photoCount) {
        this.photoCount = photoCount;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

    public int getAudioCount() {
        return audioCount;
    }

    public void setAudioCount(int audioCount) {
        this.audioCount = audioCount;
    }
}
