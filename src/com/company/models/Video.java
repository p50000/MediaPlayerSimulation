package com.company.models;

import java.time.Duration;

import static com.company.enums.MediaFormat.MP4;

public class Video extends MediaFile {

    public Video(Duration duration, String name, int id) {
        super(duration, name, id, MP4);
    }
}
