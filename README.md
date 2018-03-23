# MovieTracker
* The app consists of a MainActivity that calls REST API provided by https://www.themoviedb.org/ to display Now Playing and Upcoming Movies.

* The name, popularity, image and the genre of each movie of now playing and upcoming movies are displayed.

* Since multiple network calls were required RXJava2 and Retrofit2 were used to call the API's to improve code readibility and response handling.

* The app uses a MVP pattern throughout for seperation of View, Logic and the Data.

A Viewpager is set along with the Tablayout to display both:

1. Now playing 

![screenshot_20180323-092559](https://user-images.githubusercontent.com/17389305/37831996-ab72ccca-2e7d-11e8-9ca0-1b4ac2a49abb.jpg)

2. Upcoming movies

![screenshot_20180323-092606](https://user-images.githubusercontent.com/17389305/37832017-bd426730-2e7d-11e8-9ce7-f334e75fb838.jpg)

Users can refresh the data by pulling down on their screen.

![screenshot_20180323-092621](https://user-images.githubusercontent.com/17389305/37832131-137aa810-2e7e-11e8-93c5-d8c867cae59a.jpg)

The User also get notified when the data is loading using a Progress Dialog.

![screenshot_20180323-092626](https://user-images.githubusercontent.com/17389305/37832241-81bb9b4a-2e7e-11e8-8083-6c1cd8764556.jpg)


