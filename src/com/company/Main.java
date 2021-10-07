package com.company;

import java.time.Duration;

public class Main {

    private String formatDuration(Duration d) {
        long s = d.toSeconds();
        return String.format("%d:%02d:%02d", s / 3600, (s % 3600) / 60, (s % 60));
    }

    public static void main(String[] args) {
        Duration duration = Duration.ofSeconds(33);
    }
}
