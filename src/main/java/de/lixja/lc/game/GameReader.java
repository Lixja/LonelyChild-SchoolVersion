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

    public String getInputWithOptions(LinkedList<String> options, String question) {
        System.out.println("---------");
        int max = options.size();
        for (int i = 0; i < max; i++) {
            System.out.println("[" + i + "] - " + options.get(i));
        }
        System.out.print(question + " ");
        int answer = input.nextInt();
        if (answer > max || answer < 0) {
            System.out.println("Incorrect Input!\nTry Again!");
            return getInputWithOptions(options, question);
        }
        return options.get(answer);
    }

    public boolean getInputWithQuestionYesNo(String question) {
        System.out.println("---------");
        System.out.print(question + "[j/n]: ");
        String answer = input.next();
        if (answer.equals("j")) {
            return true;
        } else if (answer.equals("n")) {
            return false;
        }
        return getInputWithQuestionYesNo(question);
    }
    
    public String getInputWithQuestion(String question) {
        System.out.println("---------");
        System.out.print(question + " ");
        return input.next();
    }

}
