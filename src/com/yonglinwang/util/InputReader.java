package com.yonglinwang.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yonglin Wang on 5/7/2017.
 */
public class InputReader {
    private File file;
    private BufferedReader br;
    private FileReader fr;
    private List<String> records = new ArrayList<>();
    public InputReader(String path) throws FileNotFoundException {
        this.file = new File(path);
        this.fr = new FileReader(this.file);
        this.br = new BufferedReader(this.fr);
    }

    /**
     *
     * @return A String containing the content in the exact same format as the input file
     * @throws IOException
     */
    public String getRawInput() throws IOException {
        String records = "";
        String line;

        while((line = br.readLine()) != null){
            records += line + "\n";
        }

        return records;
    }

    public List<String> getRawListInput() throws IOException{
        String line;
        while((line = br.readLine()) != null){
            records.add(line);
        }
        return records;
    }

    /**
     * @return A two dimensional array of the input.
     * @throws IOException
     */
    public int[][] get2DArray() throws IOException, NumberFormatException{
        int[][] map = null;
        getRawListInput();
        int col = records.size();
        int row = (int)records.get(0).length();
        map = new int[col][row];
        for (int i = 0; i < col; i++) {
            String[] temp = records.get(i).split("");
            for(int j=0; j<temp.length; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        return map;
    }
}
