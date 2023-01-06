package com.driver;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addmovie(Movie movie)
    {
        movieRepository.addMovieToDb(movie);
    }
    public void addDirector(Director director)
    {
        movieRepository.addDirectorToDb(director);
    }
    public void directorMoviePair(String movie,String director)
    {
        movieRepository.directorMoviePair(movie,director);
    }
    public Movie findMovies(String movie)
    {
        return movieRepository.findMovieFromDb(movie);
    }
    public Director finddirector(String director)
    {
        Director di = movieRepository.findDirectorFromDb(director);
        return di;
    }
    public List<String> findMoviesFromDirector(String director)
    {
        return movieRepository.findMoviesFromDirector(director);
    }
    public List<String> findAllMovies()
    {
        return movieRepository.findAllMovies();
    }
    public void deleteDirector(String director)
    {
        movieRepository.deleteDirector(director);
    }
    public void deleteAllDirectors()
    {
        movieRepository.deleteAllDirector();
    }
}