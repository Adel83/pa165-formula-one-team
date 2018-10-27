package cz.muni.fi.pa165.entity;

import cz.muni.fi.pa165.entity.base.BaseEntity;


public class RaceParticipation extends BaseEntity {

    private CarSetup car;
    private Driver driver;
    private Race race;
    private int resultPosition;

    public CarSetup getCar() {
        return car;
    }

    public void setCar(CarSetup car) {
        this.car = car;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getResultPosition() {
        return resultPosition;
    }

    public void setResultPosition(int resultPosition) {
        this.resultPosition = resultPosition;
    }

    public String toString() {
        return "RaceParticipation{" +
                "car='" + getCar() + '\'' +
                ", driver='" + getDriver() + '\'' +
                ", race='" + getRace() + '\'' +
                ",  resultPosition='" + getResultPosition() + '\'' +
                "} " + super.toString();
    }


}
