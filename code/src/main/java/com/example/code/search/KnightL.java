package com.example.code.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static android.R.attr.x;
import static android.R.id.input;

/**
 * Created by vihaan on 17/9/17.
 */

public class KnightL {

    private int n;

    int q[] = new int [42*42];
    int d[][] = new int [42][42];

    public static void main(String [] args) throws IOException {
        KnightL knightL = new KnightL();
        knightL.input();
    }

    public  int solve(int n, int da, int db)
    {
        int head = 0;
        int tail =0;
        q[tail++] = 0;
        d[0][0]=0;

        ArrayList<Tuple> moves = new ArrayList<>();

        for(int i=-1;i<=1;i+=2)
        {
            for(int j=-1;j<=1;j+=2)
            {
                moves.add(new Tuple(da*i, db*j));
                if(da!=db)
                {
                    moves.add(new Tuple(da*i, db*j));
                }
            }
        }


        while(head<tail)
        {
            int v = q[head++];
            int cx = v/n;
            int cy = v%n;
            for(Tuple tuple: moves)
            {
                int dx = tuple.getS();
                int dy = tuple.getE();

                if(Math.abs(dx) == Math.abs(dy)  && da != db)
                    continue;

                int nx = cx + dx;
                int ny = cy + dy;

                if(nx < 0||ny<0||nx>=n||ny>=n||d[nx][ny] != 0) continue;

                d[nx][ny] = d[cx][cy] + 1;
                q[tail++]= nx * n + ny;

            }
        }

        return d[n-1][n-1] == 0 ? -1 : d[n-1][n-1];
    }

    public void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(j > 1)
                {
                    System.out.print(" ");
                }
                System.out.print(solve(n,i,j));
            }
            System.out.println(" ");

        }
    }






    class Tuple
    {
        int s, e;
        public Tuple(int s, int e)
        {
            this.s = s;
            this.e = e;
        }

        public int getS() {
            return s;
        }

        public void setS(int s) {
            this.s = s;
        }

        public int getE() {
            return e;
        }

        public void setE(int e) {
            this.e = e;
        }
    }


}
