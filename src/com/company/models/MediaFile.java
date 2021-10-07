package com.company.models;

import com.company.enums.MediaFormat;

import java.io.Serializable;
import java.time.Duration;

abstract public class MediaFile implements Serializable {
    private Duration duration;
    private String name;
    private int id;
    private MediaFormat format;

    public MediaFile(Duration duration, String name, int id, MediaFormat format) {
        this.duration = duration;
        this.name = name;
        this.id = id;
        this.format = format;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "{'name': '" + this.name + "', 'duration': '" + this.duration + "'}";
    }
}
