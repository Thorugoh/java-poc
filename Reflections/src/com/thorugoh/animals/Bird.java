package com.thorugoh.animals;

public class Bird extends Animal {
    private boolean walks;

    public Bird(){
        super("bird");
    }

    public Bird(String name, boolean walks) {
        super(name);
        setWalks(walks);
    }

    public Bird(String name) {
        super(name);
    }


    public boolean walks(){
        return walks;
    }

    public void setWalks(boolean walks){
        this.walks = walks;
    }


    @Override
    public String eats() {
        return "";
    }

    @Override
    protected String getSound() {
        return "";
    }

}


