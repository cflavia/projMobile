package com.example.demo.service;

import java.io.IOException;

public class PhotoLoaderFactory {
    public static void create(String url) throws IOException {
        if (url.toLowerCase().endsWith("jpg")) {
            JPGPhotoLoader.load(url);
        }
        else if (url.toLowerCase().endsWith("png")) {
            PNGPhotoLoader.load(url);
        }else {
            throw new RuntimeException("Unsupported format: " + url);
        }
    }
}
