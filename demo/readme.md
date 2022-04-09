# songr App
this project about creating web app using spring java framework and postgres database 

### FirstController rout 
- http://localhost:8081

   the root rout 
- http://localhost:8081/hello 

   rout to print hello world page 
- http://localhost:8081/cap/{name}

    rout use path variable and print them in the screen in capitalize way it can be used by passing variable like **http://localhost:8081/cap/helloworld**  
- http://localhost:8081/albumsBasic

   rout to get albums object as hard coded and render it on the screen  

### AlbumController rout
- http://localhost:8081/Albums

   rout present page with form to insert new album to the database 
- http://localhost:8081/newAlbum

   rout to retrieve all album from database to the screen
- http://localhost:8081/addAlbum

  posting rout linked to the form to save new album to database this end point used when user click submit in the form in **Albums** rout then it redirects the user to **newAlbum** rout to see all the albums 


### SongController
- http://localhost:8081/Songs

  rout present page with form to insert new song to the database
- http://localhost:8081/addSong

  posting rout linked to the form to save new song to database this end point used when user click submit in the form in **Songs** rout then it redirects the user to **allSongs** rout to see all the songs
- http://localhost:8081/allSongs

  rout to retrieve all songs from database to the front of user 
- http://localhost:8081/albumsSong/{id}

  rout to retrieve songs on specific album depending on **Album id** passed py path variable it used like http://localhost:8081/albumsSong/5   "5" => album id 
- http://localhost:8081/oneAlbums/{id}

  rout to retrieve all data about one album including the songs from database depending on **Album id** passed py path variable it used like http://localhost:8081/oneAlbums/1   "1" => album id 



### to use this application 
in order to use this app you need first to run the postgres database server , create new database then link it to this app, and change the database configuration using **application.properties** File

**in first time you ringing this app *spring.jpa.hibernate.ddl-auto=create* then change it to become *spring.jpa.hibernate.ddl-auto=update***

///bootRun