package cellularautomata.dao;

import cellularautomata.logic.Grid;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileGridDao implements GridDao {

    @Override
    public void saveGrid(String key, Grid grid) throws IOException {
        List<String> data = serialize(grid);
        String file = key + ".csv";

        Path path = Paths.get(file);

        Files.write(path, data);
    }

    @Override
    public void deleteGrid(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Grid loadGrid(String name) throws IOException, FileNotFoundException {
        File fileName = new File(name + ".csv");
        try (Scanner scanner = new Scanner(fileName)) {
            return fromString(scanner);
        }

    }

    private List<String> serialize(Grid grid) {
        List<String> lines = new ArrayList<>();

        boolean[][] states = grid.getStates();
        lines.add(grid.getWidth() + ";" + grid.getHeight());

        for (int x = 0; x < grid.getHeight(); x++) {
            for (int y = 0; y < grid.getWidth(); y++) {
                System.out.println(x);
                System.out.println(y);
                if (states[y][x]) {
                    lines.add(y + ";" + x);
                }
            }
        }
        return lines;
    }

    private Grid fromString(Scanner scanner) {
        boolean[][] states;

        String dimensions = scanner.next(); // reads dimensions and intitializes a dead Grid
        String[] dims = dimensions.split(";");
        states = new boolean[Integer.parseInt(dims[0])][Integer.parseInt(dims[1])];
        Grid grid = new Grid(states);

        String[] current; // reads alive states from the file and switches the states
        while (scanner.hasNext()) {
            current = scanner.next().split(";");
            int x = Integer.parseInt(current[0]);
            int y = Integer.parseInt(current[1]);
            grid.switchState(x, y);
        }

        return grid;
    }

}
