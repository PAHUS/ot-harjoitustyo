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

/**
 * This class contains methods for saving Grid objects to a files and converting files to Grid objects
 * @author Tande
 */
public class FileGridDao implements GridDao {
    /**
     * This saves a Grid to a CSV file
     * @param key the name of the created file. Also the key of the Grid.
     * @param grid  Grid to be converted
     * @throws IOException 
     */
    @Override
    public void saveGrid(String key, Grid grid) throws IOException {
        List<String> data = serialize(grid);
        String file = key + ".csv";

        Path path = Paths.get(file);

        Files.write(path, data);
    }

    /**
     * Deletes the specified file.
     * @param key The name of the file to be deleted
     */
    @Override
    public void deleteGrid(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Load a Grid of the specified name from a file
     * @param name the name of the Grid that will be loaded
     * @return returns the Grid
     * @throws IOException
     * @throws FileNotFoundException 
     */
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
