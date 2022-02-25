package code.coderd;

//    your given a coordinate of graph, with x y plane, return length of straight line with
//    maximum number of points on that line.
//      coder-dipesh

import java.math.BigInteger;
import java.util.*;
import java.lang.Math;

 class Coord {
     int[][] points;

     public Coord(int[][] p) {
         this.points = p;
     }

     public String coPrimeSlope(int i, int j) {
         int delX = this.points[i][0] - this.points[j][0];
         int delY = this.points[i][1] - this.points[j][1];
         if (delX == 0)
             return "inf";
         else if (delY == 0)
             return "zero";
         if (delX < 0) {
             delX = -delX;
             delY = -delY;
         }
         int gcd = BigInteger.valueOf(delX).gcd(BigInteger.valueOf(delY)).intValue();
         delX = delX / gcd;
         delY = delY / gcd;
         return Integer.toString(delX) + '.' + Integer.toString(delY);
     }

     public ArrayList<Integer> maxPointsThrough(int i) {
         HashMap<String, ArrayList<Integer>> slopes = new HashMap<String, ArrayList<Integer>>();
         ArrayList<Integer> duplicates = new ArrayList<Integer>();

         for (int j = i + 1; j < this.points.length; j++) {
             if (points[i] == points[j]) {
                 duplicates.add(j);
                 continue;
             }
             String slope = coPrimeSlope(i, j);
             if (slopes.containsKey(slope)) {
                 slopes.get(slope).add(j);
             } else {
                 slopes.put(slope, new ArrayList<>(Arrays.asList(i, j)));
             }
         }

         //Finding the array with maximum points in it
         int maxSize = 0;
         ArrayList<Integer> maxArr = new ArrayList<Integer>();
         for (ArrayList<Integer> a : slopes.values()) {
             if (a.size() > maxSize) {
                 maxSize = a.size();
                 maxArr = a;
             }
         }
         maxArr.addAll(duplicates);
         return maxArr;
     }

     public double lengthOfLine(ArrayList<Integer> coords) {
    /*We have an array of points of a line. We have to find two extreme points of the line and
    calculate the distance between them. For that, we search for min and max value of x-coordinate.
    If the line is vertical, all x-coordinates are same, so we search for min and max value of y-coordinate
    and calculate the distance between the corresponding coordinates*/
         int min = this.points[coords.get(0)][0];
         int max = this.points[coords.get(1)][0];
         int c = 0; //0 for x, 1 for y
         if (min == max)
             c = 1;

         int minInd = 0;
         int maxInd = 0;
         for (int i : coords) {
             int[] p = points[i];
             if (p[c] < min) {
                 min = p[c];
                 minInd = i;
             }
             if (p[c] > max) {
                 max = p[c];
                 maxInd = i;
             }
         }
         int x1, x2, y1, y2;
         x1 = this.points[minInd][0];
         y1 = this.points[minInd][1];
         x2 = this.points[maxInd][0];
         y2 = this.points[maxInd][1];
         return Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
     }

     public double solution() {
         ArrayList<Integer> maxPointsInd = new ArrayList<Integer>();
         int l = this.points.length;
         for (int i = 0; i < l - 1; i++) {
             ArrayList<Integer> pointsInd = maxPointsThrough(i);
             if (pointsInd.size() > maxPointsInd.size()) {
                 maxPointsInd = pointsInd;
             }
         }
         return lengthOfLine(maxPointsInd);
     }
 }
 
//Running program from here
public class StraightLineLengthWeek4{
    public static void main(String[] arg){
        int[][] points = {{1,1}, {5,5}, {4,4}, {2,2}, {3,3}, {6,6}, {7,7}};
        Coord my = new Coord(points);
        double length = my.solution();
        System.out.println(" Length of Straight Line: " + length);
    }


}
