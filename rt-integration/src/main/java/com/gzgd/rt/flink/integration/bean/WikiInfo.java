package com.gzgd.rt.flink.integration.bean;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

public class WikiInfo {
    @NotBlank
    private String model;
    @NotBlank
    private String cover;
    private String aspect;
    private ArrayList<String> screenshots;
    private String language;
    private ArrayList<String> directors;
    private ArrayList<String> actors;
    private String released;
    private String episodes;
    private String runtime;
    private ArrayList<String> hosts;
    private ArrayList<String> guests;
    private String channel;
    private String playTime;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAspect() {
        return aspect;
    }

    public void setAspect(String aspect) {
        this.aspect = aspect;
    }

    public ArrayList<String> getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(ArrayList<String> screenshots) {
        this.screenshots = screenshots;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ArrayList<String> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<String> directors) {
        this.directors = directors;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public ArrayList<String> getHosts() {
        return hosts;
    }

    public void setHosts(ArrayList<String> hosts) {
        this.hosts = hosts;
    }

    public ArrayList<String> getGuests() {
        return guests;
    }

    public void setGuests(ArrayList<String> guests) {
        this.guests = guests;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getPlay_time() {
        return playTime;
    }

    public void setPlay_time(String play_time) {
        this.playTime = play_time;
    }

    @Override
    public String toString() {
        return "WikiInfo{" +
                "model='" + model + '\'' +
                ", cover='" + cover + '\'' +
                ", aspect='" + aspect + '\'' +
                ", screenshots=" + screenshots +
                ", language='" + language + '\'' +
                ", directors=" + directors +
                ", actors=" + actors +
                ", released='" + released + '\'' +
                ", episodes='" + episodes + '\'' +
                ", runtime='" + runtime + '\'' +
                ", hosts=" + hosts +
                ", guests=" + guests +
                ", channel='" + channel + '\'' +
                ", play_time='" + playTime + '\'' +
                '}';
    }
}
