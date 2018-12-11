
package cellularautomata.dao;

import cellularautomata.logic.Grid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileGridDao implements GridDao{

    @Override
    public void saveGrid(String key, Grid grid) throws IOException{
        List<String> data = serialize(grid);
        String file = key +".csv";
        
        Path path = Paths.get(file);
        
        Files.write(path, data);
    }

    @Override
    public void deleteGrid(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Grid findGrid(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    private List<String> serialize(Grid grid){
        List<String> lines = new ArrayList<>();
        
        boolean[][] states = grid.getStates();
        lines.add(grid.getHeight() + ";" + grid.getWidth());

        for(int y = 0; y< grid.getWidth(); y++){
            for(int x = 0; x<grid.getHeight(); x++){
                System.out.println(y);
                System.out.println(x);
                if(states[y][x]){
                    
                    lines.add(y + ";" + x);
                }
            }
        }
        return lines;
    }
    
    
}
