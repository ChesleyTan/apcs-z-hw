/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;


public class Jumper extends Actor {

    public Jumper() {
    }

    public void act() {
        Location myLoc = getLocation();
        int myDir = getDirection();
        Grid myGrid = getGrid();
        Location loc1 = myLoc.getAdjacentLocation(myDir);
        Location loc2 = myLoc.getAdjacentLocation(myDir).getAdjacentLocation(myDir);
        if (
                !myGrid.isValid(loc1)
                || !myGrid.isValid(loc2)
                || !(myGrid.get(loc1) == null || myGrid.get(loc1) instanceof Flower || myGrid.get(loc1) instanceof Rock)
                || !(myGrid.get(loc2) == null)
           ){

            //System.out.println(!myGrid.isValid(loc1));
            //System.out.println(!myGrid.isValid(loc2));
            //System.out.println(!(myGrid.get(loc1) == null || myGrid.get(loc1) instanceof Flower || myGrid.get(loc1) instanceof Rock));
            //System.out.println(!(myGrid.get(loc2) == null));
            //System.out.println(!myGrid.isValid(loc1));

            setDirection(getDirection() + 45);
        }
        else {
            moveTo(loc2);
        }
    }
}
