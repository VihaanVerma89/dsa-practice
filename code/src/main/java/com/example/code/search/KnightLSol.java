package com.example.code.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by vihaan on 17/9/17.
 */

public class KnightLSol {

    private int n;

    int N =42;

    int q[] = new int [N*N];
    int d[][] = new int [N][N];

    public static void main(String [] args) throws IOException {
        KnightLSol knightL = new KnightLSol();
        knightL.input();
    }

    public  int solve(int n, int da, int db)
    {
        System.out.println("solve" + n+","+da+","+db);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                d[i][j]=-1;
            }
        }
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
                    moves.add(new Tuple(db*i, da*j));
                }
            }
        }


        while(head<tail)
        {
            int v = q[head++];
            int cx = v/n;
            int cy = v%n;

            System.out.println("v="+v);
            System.out.println("cx,cy=" + cx + "," + cy);
            for(Tuple tuple: moves)
            {
                int dx = tuple.getS();
                int dy = tuple.getE();

                System.out.println("=============");
                System.out.println("Next Move");
                System.out.println("dx,dy=" + dx + "," + dy);
                System.out.println("new tuple");

                if(Math.abs(dx) == Math.abs(dy)  && da != db)
                {
                    System.out.println("dx,dy=" + dx + "," + dy);
                    System.out.println("da,db=" + da + "," + db);
                    System.out.println("invalid value");
                    continue;
                }

                int nx = cx + dx;
                int ny = cy + dy;


                if(nx < 0||ny<0||nx>=n||ny>=n||d[nx][ny] != -1)
                {
                    System.out.println("nx,ny=" + nx + "," + ny);
                    System.out.println("boundary condition mismatch");
                    continue;
                }


                System.out.println("valid value");

                System.out.println("cx,cy=" + cx + "," + cy);
                System.out.println("dx,dy=" + dx + "," + dy);
                System.out.println("nx,ny=" + nx + "," + ny);
                d[nx][ny] = d[cx][cy] + 1;
                System.out.println("d[cx][cy]=[" + cx+ "," +cy +"]="+d[cx][cy]);
                System.out.println("d[nx][ny]=" + d[nx][ny]);
                int temp = nx * n + ny;
                System.out.println("q["+tail+"]=" + temp);
                q[tail++]=  nx * n + ny;

                System.out.println();
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
