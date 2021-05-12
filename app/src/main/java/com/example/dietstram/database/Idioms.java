package com.example.dietstram.database;

import java.util.Random;

public class Idioms {
   public String currentIdiom;

    private String[] idioms={
        "After dinner sit a while, after supper walk a mile.",
            "Don’t live to eat, but eat to live.",
            "Eat at pleasure, drink with measure.",
            "I am as hungry as a hunter.",
            "A hungry man is an angry man.",
            "A hungry belly has no ears.",
            "Hunger breaks stone walls.",
            "Hunger is the best sauce.",
            "To lengthen thy life, lessen thy meals.",
            "Every cook praises his own broth.",
            "Too many cooks spoil the broth.",
            "After meat mustard.",
            "Every vegetable has its season.",
            "You can't make an omelet without breaking eggs.",
            "An apple a day keeps the doctor away.",
            "All griefs are less with bread.",
            "Half a loaf is better than no bread.",
            "A spoon is dear when lunch time is near.",
            "It's easy as pie.",
            "He apple never falls far from the tree.",
            "The rotten apple injures its neighbors.",
            "The appetite comes with eating ."
    };
   final private Random random=new Random();
    public  Idioms(){
        currentIdiom=idioms[random.nextInt(idioms.length)];
    }

}
