package com.works.desing_patterns.bridge;


public class CompleteShip extends ShipOperation{

    public CompleteShip( IShip ship) {
        super(ship);
    }

    @Override
    public void operation(long pid) {
        ship.sendShip(pid);
    }

}
