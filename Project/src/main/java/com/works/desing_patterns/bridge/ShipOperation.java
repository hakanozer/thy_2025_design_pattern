package com.works.desing_patterns.bridge;

public abstract class ShipOperation {

    public IShip ship;
    public ShipOperation(IShip ship) {
        this.ship = ship;
    }

    public abstract void operation(long pid);

}
