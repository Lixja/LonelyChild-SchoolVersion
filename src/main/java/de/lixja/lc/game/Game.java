/*
 * Copyright (C) 2017 Dimitrios Diamantidis &lt;Dimitri.dia@ledimi.com&gt;
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.lixja.lc.game;

import com.google.gson.Gson;
import de.lixja.lc.Stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dimitrios Diamantidis &lt;Dimitri.dia@ledimi.com&gt;
 */
public class Game {

    private final String GAMEFILE = "gamedata.json";
    private Stage currentStage;
    public GameReader in;
    public GameWriter out;
    private GameData data;

    public Game() {
        in = new GameReader();
        out = new GameWriter();
        data = readGameData();
    }

    public void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setStage(Stage stage) {
        currentStage = stage;
        currentStage.setGame(this);
        currentStage.start();
    }

    private GameData readGameData() {
        try {
            FileInputStream istream = new FileInputStream(new File(GAMEFILE));
            String dataAsString = "";
            int c;
            while((c = istream.read()) != -1){
                dataAsString += (char) c;
            }
            Gson gson = new Gson();
            return gson.fromJson(dataAsString, GameData.class);
        } catch (IOException ex) {
            //Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        GameData data = new GameData();
        return data;
    }

    public void saveGameData() {
        try {
            Gson gson = new Gson();
            FileOutputStream ostream = new FileOutputStream(GAMEFILE);
            ostream.write(gson.toJson(data).getBytes());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public GameData getData() {
        return data;
    }

}
