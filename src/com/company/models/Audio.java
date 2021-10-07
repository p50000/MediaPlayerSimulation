package com.company.models;

import java.time.Duration;

import static com.company.enums.MediaFormat.MP3;

public class Audio extends MediaFile {
    public Audio(Duration duration, String name, int id) {
        super(duration, name, id, MP3);
    }
}
