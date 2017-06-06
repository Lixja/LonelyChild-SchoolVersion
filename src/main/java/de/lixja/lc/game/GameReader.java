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

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dimitrios Diamantidis &lt;Dimitri.dia@ledimi.com&gt;
 */
public class GameReader {

    Scanner input;

    public GameReader() {
        input = new Scanner(System.in);
    }

    public String getInput() {
        return input.next();
    }
    
    public int getInputWithOptionsV(List<String> options, String question) {
        System.out.println("---------");
        int max = options.size()-1;
        for (int i = 0; i <= max; i++) {
            System.out.println("[" + i + "] - " + options.get(i));
        }
        System.out.print(question + " ");
        int answer = input.nextInt();
        if (answer > max || answer < 0) {
            System.out.println("Incorrect Input!\nTry Again!");
            return getInputWithOptionsV(options, question);
        }
        return answer;
    }

    public int getInputWithOptionsH(List<String> options, String question) {
        System.out.println("------------");
        int max = options.size()-1;
        for (int i = 0; i <= max; i++) {
            System.out.print("|" + options.get(i) + "|   ");
        }
        System.out.println();
        for (int i = 0; i <= max; i++) {
            for (int c = 0; c < options.get(i).length(); c++) {
                if (c == options.get(i).length() / 2 -1) {
                    System.out.print("[");
                } else if (c == options.get(i).length() / 2) {
                    System.out.print(i);
                } else if (c == options.get(i).length() / 2 +1) {
                    System.out.print("]");
                }
                System.out.print(" ");
            }
            System.out.print("  ");
        }
        System.out.println();
        System.out.print(question + " ");
        int answer = input.nextInt();
        if (answer > max || answer < 0) {
            System.out.println("Incorrect Input!\nTry Again!");
            return getInputWithOptionsH(options, question);
        }
        return answer;
    }

    public boolean getInputWithQuestionYesNo(String question) {
        System.out.println("------------");
        System.out.print(question + "[y/n]: ");
        String answer = input.next();
        if (answer.equals("y")) {
            return true;
        } else if (answer.equals("n")) {
            return false;
        }
        return getInputWithQuestionYesNo(question);
    }

    public String getInputWithQuestion(String question) {
        System.out.println("------------");
        System.out.print(question + " ");
        return input.next();
    }

}
