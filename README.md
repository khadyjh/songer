# songr App
this project about creating web app using spring java framework 

### FirstController rout 
- http://localhost:8081/hello 
   rout to print hello world page 
- http://localhost:8081/cap/{name}
    rout use path variable and print them in the screen in capitalize way 
- http://localhost:8081/albums
   rout to print album objects as json 

### AlbumController rout
- http://localhost:8081/Albums
   rout present page with form to insert new album to the database 
- http://localhost:8081/newAlbum
   rout to retrieve all album from database to the screen
- http://localhost:8081/addAlbum
  posting rout linked to the form to save new album to database 


### SongController
- http://localhost:8081/Songs
  rout present page with form to insert new song to the database
- http://localhost:8081/addSong
  posting rout linked to the form to save new song to database 
- http://localhost:8081/allSongs
  rout to retrieve all songs from database 
- http://localhost:8081/albumsSong/{id}
  rout to retrieve songs on specific album depending on id passed py path variable 
- http://localhost:8081/oneAlbums/{id}
  rout to retrieve album from database depending on id passed py path variable