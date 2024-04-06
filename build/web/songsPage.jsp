<%-- 
    Document   : songsPage
    Created on : Dec 12, 2023, 2:45:57 PM
    Author     : Admin
--%>

<%@page import="Songs.SongDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="songsPage.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spotify Premium</title>
    </head>
    <body>
        <%
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
        %>
        <div class="container">
            <header>Spotify Premium</header>
            <section>
                <form action ="MainController">
                    <div class="button-container">
                        <button type="submit" name="action" value="Search">Search</button>
                        <button type="submit" name="action" value="Insert">Insert</button>
                        <button type="submit" name="action" value="Play">Play a random song</button>
                    </div>
                </form>
                <% if (!action.equals("Insert")) {%>
                <%

                    List<SongDTO> songList = (List<SongDTO>) request.getAttribute("LIST_SONG");
                    if (songList != null) {
                        if (songList.size() > 0) {
                %>
                <div class="song-list">
                    <table>
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Song ID</th>
                                <th>Song Name</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>

                            <%
                                int count = 0;
                                for (SongDTO song : songList) {

                            %>
                        <form action="MainController" method="POST">
                            <tr>
                                <td><%= ++count%></td>
                                <td>
                                    <input type = "text" name = "songId" value ="<%= song.getSongId()%>" readonly=""/>
                                </td>
                                <td>
                                    <input type = "text" name = "songName" value ="<%= song.getSongName()%>" readonly=""/>
                                </td>
                                <td>
                                    <button type="submit" name="action" value="Delete">Delete</button>
                                </td>
                            </tr>
                        </form>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
                <%
                        }
                    }
                %> 
                <%
                    String error = (String) request.getAttribute("ERROR");
                    if (error == null) {
                        error = "";
                    }
                %>
                <div class="message">
                    <h2><%= error%></h2>
                    <% String message = (String) request.getAttribute("MESSAGE");
                        if (message == null) {
                            message = "";
                        }

                    %>
                    <h2><%=message%></h2>
                </div>

                <% }
                    if (action.equals("Insert")) { %>
                <div class="add-song-form">
                    <h1 style="color: #33cc00">Add new Song</h1>
                    <form action="MainController" method="POST">
                        <div>
                            <label style="color: #33cc00">Song ID</label>
                            <input type="text" name="songId" required=""/>
                        </div>
                        <div>
                            <label style="color: #33cc00">Song Name</label>
                            <input type="text" name="songName" required=""/>
                        </div>
                        <div>
                            <button type="submit" name="action" value="Insert">Save</button>
                            <a href="songsPage.jsp">
                                <button type="button">Back</button>
                            </a>
                        </div>
                    </form>

                    <% String message = (String) request.getAttribute("MESSAGE");
                        if (message == null) {
                            message = "";
                        }

                    %>
                    <h2><%=message%></h2>
                </div>
                <%

                    }
                    if (action.equals("Play")) {
                        SongDTO song = (SongDTO) request.getAttribute("songRandom");
                %> 
                <div class="now-playing">
                    <p>You are listening to:</p>
                    <h1>Song ID: <%= song.getSongId()%></h1>
                    <h2>Song Name: <%= song.getSongName()%></h2>
                </div>                
                <%
                    }
                %>


            </section>
        </div>
    </body>
</html>
