/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class MusicLibrary {

    private List<SongDTO> songCollection = new ArrayList<>();

    public void addSong(SongDTO song) {
        songCollection.add(song);
    }

    public void removeSong(SongDTO song) {
        songCollection.remove(song);
    }

    public SongDTO playRandomSong() {
        if (songCollection.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(songCollection.size());
        return songCollection.get(randomIndex);
    }

}
