package labs.lab3.controller;

import labs.lab3.model.Human;
import labs.lab3.model.Sex;


public class HumanCreator {

    public Human createHuman(String firstName, String lastName, String middleName, Sex sex) {
        return new Human(firstName, lastName, middleName, sex);
    }
}