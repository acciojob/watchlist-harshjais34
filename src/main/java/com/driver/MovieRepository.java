package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movieDb = new HashMap<>();
    HashMap<String,Director>directorDb = new HashMap<>();
    HashMap<String,List<String>> directorMovieDb = new HashMap<>();

    public void addMovieToDb(Movie movie)
    {
        movieDb.put(movie.getName(),movie);
    }

    public void addDirectorToDb(Director director)
    {
        directorDb.put(director.getName(),director);
    }

    public void directorMoviePair(String movie, String director){



        if(movieDb.containsKey(movie)&&directorDb.containsKey(director)){

            List<String> moviesBythisDirector = new ArrayList<>();

            if(directorMovieDb.containsKey(director))
                moviesBythisDirector = directorMovieDb.get(director);

            moviesBythisDirector.add(movie);

            directorMovieDb.put(director,moviesBythisDirector);

        }

    }

    public Movie findMovieFromDb(String movie){
        return movieDb.get(movie);
    }

    public Director findDirectorFromDb(String director){
        return directorDb.get(director);
    }

    public List<String> findMoviesFromDirector(String director){
        List<String> moviesList = new ArrayList<String>();
        if(directorMovieDb.containsKey(director)) moviesList = directorMovieDb.get(director);
        return moviesList;
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieDb.keySet());
    }

    public void deleteDirector(String director){

        List<String> movies = new ArrayList<String>();
        if(directorMovieDb.containsKey(director)){

            movies = directorMovieDb.get(director);

            //2. Deleting all the movies from movieDb by using movieName
            for(String movie: movies){
                if(movieDb.containsKey(movie)){
                    movieDb.remove(movie);
                }
            }

            //3. Deleteing the pair
            directorMovieDb.remove(director);
        }

        //4. Delete the director from directorDb.
        if(directorDb.containsKey(director)){
            directorDb.remove(director);
        }
    }

    public void deleteAllDirector(){

        HashSet<String> moviesSet = new HashSet<String>();

        //Deleting the director's map
        directorDb = new HashMap<>();

        //Finding out all the movies by all the directors combined
        for(String director: directorMovieDb.keySet()){

            //Iterating in the list of movies by a director.
            for(String movie: directorMovieDb.get(director)){
                moviesSet.add(movie);
            }
        }

        //Deleting the movie from the movieDb.
        for(String movie: moviesSet){
            if(movieDb.containsKey(movie)){
                movieDb.remove(movie);
            }
        }
        //clearing the pair.
        directorMovieDb = new HashMap<>();
    }


}