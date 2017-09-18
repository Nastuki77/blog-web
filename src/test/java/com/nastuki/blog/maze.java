package com.nastuki.blog;

import com.nastuki.blog.vo.Maze;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nastuki on 2017/9/18.
 */
public class maze {

    private static int N = 10;

    private static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        int[][] maze = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 0, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 1, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 0, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        maze[1][1] = 2;
        maze[8][8] = -1;
        if (useQueue(maze, 1, 1)) {
            System.out.println("存在迷宫最短路径:");
            outPutMaze(maze, N-2, N-2);
        } else {
            System.out.println("不存在迷宫路径:");
        }
    }

    static boolean useQueue(int[][] map, int x, int y) {
        Queue<Maze> mazeQueue = new LinkedList<>();

        mazeQueue.add(new Maze(x, y));
        Maze maze;

        int level;
        while (!mazeQueue.isEmpty()) {
            maze = mazeQueue.poll();
            int i = maze.x;
            int j = maze.y;
            level = map[i][j] + 1;
            if (map[i][j] == -1) {
                return true;
            }
            for (int k = 0; k < 4; k++) {
                if (map[i + dir[k][0]][j + dir[k][1]] == -1) {
                    return true;
                } else if (map[i + dir[k][0]][j + dir[k][1]] == 0) {
                    map[i + dir[k][0]][j + dir[k][1]] = level;
                    mazeQueue.add(new Maze(i + dir[k][0], j + dir[k][1]));
                }
            }
        }
        return false;
    }

    static void outPutMaze(int[][] map, int i, int j) {
        String s = "     ";
        for (int k = 0; k < N; k++) {
            for (int g = 0; g < N; g++) {
                System.out.print(map[k][g] + s.substring((map[k][g]+"").length()));
            }
            System.out.println();
        }
        System.out.println("===================");
        int w = map[1][1];
        for (int k = 0; k < 4; k++) {
            if (map[i + dir[k][0]][i + dir[k][1]] > w) {
                i = i + dir[k][0];
                j = j + dir[k][1];
                w = map[i][j];
                map[i][j] = -2;
                break;
            }
        }


        int x = 1;
        int y = 1;

        while (i != x || j != y) {
            for (int k = 0; k < 4; k++) {
                if (map[i + dir[k][0]][j + dir[k][1]] == w - 1) {
                    w--;
                    i = i + dir[k][0];
                    j = j + dir[k][1];
                    map[i][j] = -2;
                    break;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int g = 0; g < N; g++) {
                if (k==1&&g==1) {
                    System.out.print("@  ");
                }else if (map[k][g] == 2) {
                    System.out.print("@  ");
                } else if (map[k][g] == -2) {
                    System.out.print("*  ");
                } else if (map[k][g] == -1) {
                    System.out.print("#  ");
                } else if (map[k][g] == 1) {
                    System.out.print("1  ");
                } else {
                    System.out.print("0  ");
                }
            }
            System.out.println();
        }


    }
}
