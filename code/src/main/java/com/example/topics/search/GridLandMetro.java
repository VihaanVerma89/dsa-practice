package com.example.topics.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;


/**
 * Created by vihaan on 12/9/17.
 */

public class GridLandMetro {

    public static void main(String [] args) throws IOException {
        Logger.log(System.currentTimeMillis()+"");
        GridLandMetro gridLandMetro = new GridLandMetro();
        gridLandMetro.input();
//        gridLandMetro.testInput();
        gridLandMetro.process();
        Logger.log(System.currentTimeMillis()+"");
    }

    long r,c,k;
    HashMap<Long, ArrayList<Tuple>> rowTracks;

    public void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        String line = br.readLine();

        String [] parts = line.split(" ");

        r = Long.parseLong(parts[0]);
        c = Long.parseLong(parts[1]);
        k = Long.parseLong(parts[2]);

        rowTracks = new HashMap<>();

        for(long i=0;i<k;i++)
        {
            line = br.readLine();
            parts = line.split(" ");

            long row = Long.parseLong(parts[0]);
            long s= Long.parseLong(parts[1]);
            long e = Long.parseLong(parts[2]);

            ArrayList<Tuple> track = rowTracks.get(row);
            Tuple tuple = new Tuple(s, e);
            if(track == null)
            {
               track = new ArrayList<>();
                track.add(tuple);
                rowTracks.put(row, track);
            }
            else
            {
                track.add(tuple);
            }
        }

    }

    public void testInput()
    {
      /*  rowTracks = new HashMap<>();

        r = 1;
        c = 5;
        k = 3;

        String [] lines  = new String[]{
                "1 1 2",
                "1 2 4",
                "1 3 5"
        };
        String line;
        String [] parts;
        for(long i=0;i<k;i++)
        {
            line = lines[i];
            parts = line.split(" ");

            long row = Integer.parseInt(parts[0]);
            long s= Integer.parseInt(parts[1]);
            long e = Integer.parseInt(parts[2]);

            ArrayList<Tuple> track = rowTracks.get(row);
            Tuple tuple = new Tuple(s, e);
            if(track == null)
            {
                track = new ArrayList<>();
                track.add(tuple);
                rowTracks.put(row, track);
            }
//            else
            {
                track.add(tuple);
            }
        }*/

    }

    long roadLen=0;
    public void process()
    {
        ArrayList<Tuple> tracks;
        for(long i=0;i<=r;i++)
        {
            tracks = rowTracks.get(i);
            if(tracks != null)
            {
                tracks.sort(new Comparator<Tuple>() {
                    @Override
                    public int compare(Tuple tuple, Tuple t1) {
                        long s1 = tuple.getS();
                        long s2 = t1.getS();
//                        long value=0;
//                        if(s1 < s2)
//                        {
//                            value = -1;
//                        }
//                        else if( s1 == s2)
//                        {
//                            value = 0;
//                        }
//                        else if( s1 > s2)int
//                        {
//                           value = 1;
//                        }
//                        return value;

                        return Long.compare(s1,s2);
                    }
                });

                boolean merged = false;
                for(int j=0;j<tracks.size() -1;)
                {
                    Tuple t1 = tracks.get(j);
                    Tuple t2 = tracks.get(j+1);

                    if(t2.getS() <= t1.getE())
                    {

                        if(t1.getE() <= t2.getE())
                        {
                            // s1 e2
                            t1.setE(t2.getE());
                            tracks.remove(j+1);
//                            tempTracks.remove(j+1);

                            merged = true;
                        }
                        else if(t2.getE() <= t1.getE())
                        {
                            // s1 e1
                            tracks.remove(j+1);
//                            tempTracks.remove(j+1);
                            merged = true;
                        }
                    }
                    if(!merged)
                    {
                        j++;
                    }
                    {
                        merged = false;
                    }

                }

                for(int j=0;j<tracks.size(); j++)
//                    for(long j=0;j<tracks.size(); j++)
//                for(long j=0;j<tempTracks.size(); j++)
                {
                    Tuple t  = tracks.get(j);
//                    Tuple t  = tempTracks.get(j);
                    long distance = t.getE() - t.getS() + 1;
                    roadLen += distance;
                }
            }
        }

        long lampPosts = (r * c) - roadLen;
        System.out.println(lampPosts);
    }


    static class Logger
    {
        private static boolean shouldLog= false;
        public static void log(String log)
        {
           if(shouldLog)
           {
               System.out.println(log);
           }
        }
    }
    class Tuple
    {
        long s, e;
        public Tuple(long s, long e)
        {
            this.s = s;
            this.e = e;
        }

        public long getS() {
            return s;
        }

        public void setS(long s) {
            this.s = s;
        }

        public long getE() {
            return e;
        }

        public void setE(long e) {
            this.e = e;
        }
    }



}
