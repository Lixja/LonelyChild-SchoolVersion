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

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dimitrios Diamantidis &lt;Dimitri.dia@ledimi.com&gt;
 */
public class GameWriter {
    
    
    public void write(String msg){
        System.out.print(msg);
    }
        
    public void writeln(String msg){
        System.out.println(msg);
    }
    
    public void writeWall(){
        System.out.println("-----------------");
    }
    
    public void writeSlow(String msg, int time){
        for(char c : msg.toCharArray()){
            System.out.print(c);
            try {
                Thread.sleep(time);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void writeS(String msg){
        writeSlow(msg+"\n", 75);
    }
    
    public void writelnSlow(String msg, int time){
        writeSlow(msg, time);
        System.out.println();
    }
    
}
