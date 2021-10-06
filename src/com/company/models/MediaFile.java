package com.company.models;

import java.io.Serializable;
import java.time.Duration;

abstract public class MediaFile implements Serializable {
    private Duration duration;
    private String name;

    public MediaFile(Duration duration, String name) {
        this.duration = duration;
        this.name = name;
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

    public String toString() {
        return "{'name': '" + this.name + "', 'duration': '" + this.duration + "'}";
    }
}
