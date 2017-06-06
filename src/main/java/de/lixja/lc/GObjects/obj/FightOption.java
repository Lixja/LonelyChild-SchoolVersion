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
package de.lixja.lc.GObjects.obj;

/**
 *
 * @author Dimitrios Diamantidis &lt;Dimitri.dia@ledimi.com&gt;
 */
public class FightOption {
    
    private String option;
    private int helpValue;

    public FightOption(String option, int helpValue){
        this.option = option;
        this.helpValue = helpValue;
    }
    
    
    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getHelpValue() {
        return helpValue;
    }

    public void setHelpValue(int helpValue) {
        this.helpValue = helpValue;
    }
    
    
    
}
