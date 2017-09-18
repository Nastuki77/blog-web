package com.nastuki.blog;

import com.nastuki.blog.vo.Maze;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nastuki on 2017/9/18.
 */
public class mazeQueue {

    public static void main(String[] args) {
        int[][] maze = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 0, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 1, 1},
                {1, 0, 1, 1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 0, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        maze = useQueue(maze, new Maze(1, 1), new Maze(8, 8), 10);
        outPut(new Maze(8, 8), maze, 10);
    }

    static int[][] useQueue(int[][] map, Maze start, Maze end, int N) {
        Queue<Maze> mazeQueue = new LinkedList<>();
        Queue<Integer> countQueue = new LinkedList<>();
        int flag = 3, Count = 1, count = 0;
        Maze maze;
        Maze mazeTemp = new Maze();

        mazeQueue.add(start);
        while (!mazeQueue.isEmpty()) {
            maze = mazeQueue.poll();
            //mazeQueue.poll();
            if (Count < 1 && !countQueue.isEmpty()) {
                Count = countQueue.poll();
            }
            if (0 == Count) {
                continue;
            }
            --Count;
            int i, j;
            i = maze.x;
            j = maze.y;
            if (0 == map[i][j]) {
                map[i][j] = flag;
            }

            if (i > 0 && i < N - 1) {
                if (0 == map[i - 1][j]) {
                    mazeTemp.x = i - 1;
                    mazeTemp.y = j;
                    mazeQueue.add(mazeTemp);
                    ++count;
                } else if (3 == map[i - 1][j]) {
                    break;
                }

                if (0 == map[i + 1][j]) {
                    mazeTemp.x = i + 1;
                    mazeTemp.y = j;
                    mazeQueue.add(mazeTemp);
                    ++count;
                } else if (3 == map[i + 1][j]) {
                    break;
                }
            }
            if (j > 0 && j < N - 1) {
                if (0 == map[i][j - 1]) {
                    mazeTemp.x = i;
                    mazeTemp.y = j - 1;
                    mazeQueue.add(mazeTemp);
                    ++count;
                } else if (3 == map[i][j - 1]) {
                    break;
                }

                if (0 == map[i][j + 1]) {
                    mazeTemp.x = i;
                    mazeTemp.y = j + 1;
                    mazeQueue.add(mazeTemp);
                    ++count;
                } else if (3 == map[i][j + 1]) {
                    break;
                }
            }
            if (Count < 1) {
                countQueue.add(count);
                ++flag;
                count = 0;
            }
        }
        return map;
    }

    static void outPut(Maze end, int[][] map, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        int i, j, ni, nj, w;
        ni = i = end.x;
        nj = j = end.y;
        w = map[i][j];
        if (i > 0 && i < N - 1) {
            if (map[i - 1][j] > w) {
                ni = i - 1;
                w = map[i - 1][j];
            }
            if (map[i + 1][j] > w) {
                ni = i + 1;
                w = map[i + 1][j];
            }
        }

        if (j > 0 && j < N - 1) {
            if (map[i][j - 1] > w) {
                nj = j - 1;
                w = map[i][j - 1];
            }

            if (map[i][j + 1] > w) {
                nj = j + 1;
                w = map[i][j + 1];
            }
        }

        i = ni;
        j = nj;

        while (2 != map[i][j]) {
            if (i > 0 && i < N - 1) {
                if (map[i - 1][j] == w - 1) {
                    map[i][j] = -1;
                    i = i - 1;
                    --w;
                    continue;
                } else if (map[i + 1][j] == w - 1) {
                    map[i][j] = -1;
                    i = i + 1;
                    --w;
                    continue;
                } else if (map[i - 1][j] == 2 || map[i + 1][j] == 2)
                    break;
            }
            // 左右判断
            if (j > 0 && j < N - 1) {
                if (map[i][j - 1] == w - 1) {
                    map[i][j] = -1;
                    j = j - 1;
                    --w;
                    continue;
                } else if (map[i][j + 1] == w - 1) {
                    map[i][j] = -1;
                    j = j + 1;
                    --w;
                    continue;
                } else if (map[i][j - 1] == 2 || map[i][j + 1] == 2)
                    break;
            }

        }
        // 最后补充为-1 因为设置权值时 2-4 非连续
        map[i][j] = -1;

        for (int a = 0; i < N; i++) {
            for (int b = 0; j < N; j++) {
                // 标记为路径
                if (-1 == map[a][b])
                    System.out.print("- ");

                    // 回复原来的值
                else if (map[a][b] > 3)
                    System.out.print("0 ");

                else
                    System.out.print(map[a][b] + " ");

            }
            System.out.println();
        }
    }

}
