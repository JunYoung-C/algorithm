package programmers.lv3.퍼즐조각맞추기;

import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        ArrayList<ArrayList<Point>> emptyShapes = createShapes(game_board, 0);
        ArrayList<ArrayList<Point>> shapes = createShapes(table, 1);
        boolean[] isUsed = new boolean[shapes.size()];
        for (ArrayList<Point> emptyShape : emptyShapes) {
            boolean isFilled = false;
            for (int i = 0; i < shapes.size(); i++) {
                if (isUsed[i]) {
                    continue;
                }

                for (int j = 0; j < 4; j++) {
                    if (isSame(emptyShape, shapes.get(i))) {
                        answer += emptyShape.size();
                        isUsed[i] = true;
                        isFilled = true;
                        // for (Point p : emptyShape) {
                        //     System.out.print(p.y + " " + p.x + ", ");
                        // }
                        // System.out.println();
                        // for (Point p : shapes.get(i)) {
                        //     System.out.print(p.y + " " + p.x + ", ");
                        // }
                        // System.out.println();
                        // System.out.println();
                        break;
                    } else {
                        rotate(shapes.get(i));
                    }
                }

                if (isFilled) {
                    break;
                }
            }
        }

        // System.out.println(emptyShapes.size() + " " + shapes.size());
        // for (ArrayList<Point> emptyShape : emptyShapes) {
        //     for (Point p : emptyShape) {
        //         System.out.print(p.y + " " + p.x + ", ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        // for (int i = 0; i < shapes.size(); i++) {
        //     if (isUsed[i]) {
        //         for (Point p : shapes.get(i)) {
        //             System.out.print(p.y + " " + p.x + ", ");
        //         }
        //         System.out.println();
        //     }
        // }

        return answer;
    }

    private boolean isSame(ArrayList<Point> emptyShape, ArrayList<Point> shape) {
        int len = emptyShape.size();
        if (len != shape.size()) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            if ((emptyShape.get(i).y != shape.get(i).y) || (emptyShape.get(i).x != shape.get(i).x)) {
                return false;
            }
        }

        return true;
    }

    private void rotate(ArrayList<Point> shape) {
        for (Point p : shape) {
            int tmp = p.x;
            p.x = -p.y;
            p.y = tmp;
        }

        initShape(shape);
    }

    private ArrayList<ArrayList<Point>> createShapes(int[][] board, int status) {
        ArrayList<ArrayList<Point>> shapes = new ArrayList<>();
        int len = board.length;
        boolean[][] isVisited = new boolean[len][len];

        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                if (board[row][col] == status && !isVisited[row][col]) {
                    ArrayList<Point> shape = new ArrayList<>();
                    dfs(board, isVisited, status, row, col, shape);

                    initShape(shape);
                    shapes.add(shape);
                }
            }
        }

        return shapes;
    }

    private void initShape(ArrayList<Point> shape) {
        Collections.sort(shape);
        int initY = shape.get(0).y;
        int initX = shape.get(0).x;

        for (Point p : shape) {
            p.y -= initY;
            p.x -= initX;
        }
    }

    private void dfs(int[][] board, boolean[][] isVisited, int status, int y, int x, ArrayList<Point> shape) {
        shape.add(new Point(x, y));
        isVisited[y][x] = true;

        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board.length) {
                continue;
            }

            if (!isVisited[ny][nx] && board[ny][nx] == status) {
                dfs(board, isVisited, status, ny, nx, shape);
            }
        }
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        if (this.x == p.x) {
            return this.y - p.y;
        }
        return this.x - p.x;
    }
}
