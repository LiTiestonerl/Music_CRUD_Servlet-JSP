/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Songs;

/**
 *
 * @author Admin
 */
public class SongDTO {
    private String songId ;
    private String songName;

    public SongDTO(String songId, String songName) {
        this.songId = songId;
        this.songName = songName;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    @Override
    public String toString() {
        return "SongDTO{" + "songId=" + songId + ", songName=" + songName + '}';
    }
    
    
    
}
