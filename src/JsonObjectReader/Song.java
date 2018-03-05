/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonObjectReader;

import java.util.Objects;

/**
 *
 * @author patri
 */
public class Song {
    private String name;
    private String artist;
    private double runTime;

    public Song() {
    }

    public Song(String name, String artist, double runTime) {
        this.name = name;
        this.artist = artist;
        this.runTime = runTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getRunTime() {
        return runTime;
    }

    public void setRunTime(double runTime) {
        this.runTime = runTime;
    }

    @Override
    public String toString() {
        return "Song{" + "name=" + name + ", artist=" + artist + ", runTime=" + runTime + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.artist);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.runTime) ^ (Double.doubleToLongBits(this.runTime) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Song other = (Song) obj;
        if (Double.doubleToLongBits(this.runTime) != Double.doubleToLongBits(other.runTime)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.artist, other.artist)) {
            return false;
        }
        return true;
    }
    
    
    
}
