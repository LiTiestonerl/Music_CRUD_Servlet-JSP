/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Songs;

import Utils.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SongDAO {

    private static final String INSERT = "insert into tbl_Songs(songId,songName) values (?,?)";
    private static final String GET_ALL_SONGS = "select * from tbl_Songs";
    private static final String DELETE = "delete from tbl_Songs\n"
            + "where songId =?";
    private static final String GET_SONG_RANDOM = "SELECT TOP 1 * FROM tbl_Songs ORDER BY NEWID()";

    public List<SongDTO> getAllSongs() throws SQLException {
        List<SongDTO> SongsList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Utils.getConnection();
            if (conn != null) {
                ps = conn.prepareStatement(GET_ALL_SONGS);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String songId = rs.getString("songId");
                    String songName = rs.getString("songName");
                    SongsList.add(new SongDTO(songId, songName));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return SongsList;
    }

    public boolean insert(SongDTO song) throws SQLException, ClassNotFoundException {
        boolean checkInsert = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = Utils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, song.getSongId());
                ptm.setString(2, song.getSongName());
                checkInsert = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception ex) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkInsert;
    }

    public boolean deleteMobile(String songId) throws SQLException {
        boolean checkDelete = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Utils.getConnection();
            if (conn != null) {
                ps = conn.prepareStatement(DELETE);
                ps.setString(1, songId);
                checkDelete = ps.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkDelete;
    }

    public SongDTO getRandomSong() throws SQLException {
        SongDTO song = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Utils.getConnection();
            if (conn != null) {
                ps = conn.prepareStatement(GET_SONG_RANDOM);
                rs = ps.executeQuery();
                if (rs.next()) {
                    song = new SongDTO(rs.getString("songId"), rs.getString("songName"));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return song;
    }

    public static void main(String[] args) {
        try {
            SongDAO dao = new SongDAO();
            SongDTO song = dao.getRandomSong();
            System.out.println(song.getSongId());
            System.out.println(song.getSongName());
        } catch (Exception e) {
        }

    }

}
