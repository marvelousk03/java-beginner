package jadvanced.chap11;

import java.util.List;

public class SongApp {
    public static void main(String[] args) {
        // Get the list of songs from the MockSongs utility class
        List<SongV2> songs = MockSongs3.getSongsV2();
        System.out.println(songs);
    }
}
