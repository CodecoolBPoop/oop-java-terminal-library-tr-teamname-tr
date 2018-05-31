package com.codecool.game;

import com.codecool.termlib.Coordinate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class MapReader {
    private static final String MAP1 = "map.txt";

    
    public static int[][] mapReader() {
        
        return new int[][]{
                {4, 3, 3, 3, 3, 3, 3, 3,10, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5},
                {2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0,10, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 4,10, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 2,0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 1, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2},
                {6, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 7}
        };

        /*try {
            Scanner fileReader = new Scanner(new BufferedReader(new FileReader(MapReader.MAP1)));
            
            ArrayList<ArrayList<Character>> map = new ArrayList<>();
            
            while (fileReader.hasNext()) {
                String row = fileReader.next();
                
                ArrayList<Character> rowOfChars = new ArrayList<Character>();
                
                for (int i = 0; i < row.length(); i++) {
                    rowOfChars.add(row.charAt(i));
                }
                
                map.add(rowOfChars);
                
                return map;
            }
            
        } catch (IOException e) {
            
            System.out.println(e);
        }
        
        return null;*/
    }
}
