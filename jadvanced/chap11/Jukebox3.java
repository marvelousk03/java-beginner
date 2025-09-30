package jadvanced.chap11;

import java.util.*;

public class Jukebox3 {
    public static void main(String[] args) {
        new Jukebox3().go();
    }

    public void go() {
        // Get list of SongV2 objects from MockSongs
        List<SongV3> songList = MockSongs4.getSongsV2();

        // Print the list before sorting
        System.out.println("Before sorting:");
        System.out.println(songList);

        // Sort the list (requires SongV2to implement Comparable)
//        Collections.sort(songList);  //uncomment to test

        // Print the list after sorting
        System.out.println("After sorting:");
        System.out.println(songList);
    }
}
