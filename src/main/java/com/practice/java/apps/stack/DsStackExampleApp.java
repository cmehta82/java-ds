package com.practice.java.apps.stack;

import com.practice.java.ds.stack.DsStack;

public class DsStackExampleApp {
    private DsStack<String> stack = new DsStack<>(100);

    public static void main(String[] args) {
        DsStackExampleApp dsStackExampleApp = new DsStackExampleApp();
        dsStackExampleApp.stackCards();
        dsStackExampleApp.unstackCards();

        //restack cards
        dsStackExampleApp.stackCards();

        //how many cards are on the deck
        dsStackExampleApp.desckSize();

        //do we have queen of hearts in the deck
        dsStackExampleApp.containsCard("Queen of Hearts");

        //do we have a joker
        dsStackExampleApp.containsCard("Joker");

        //go to the king of diamonds
        dsStackExampleApp.goToCard(14);

        //now how many cards are on the deck
        dsStackExampleApp.desckSize();
    }

    private void stackCards() {
        //stack the spade suit
        stack.push("Ace of Spades");
        stack.push("2 of Spades");
        stack.push("3 of Spades");
        stack.push("4 of Spades");
        stack.push("5 of Spades");
        stack.push("6 of Spades");
        stack.push("7 of Spades");
        stack.push("8 of Spades");
        stack.push("9 of Spades");
        stack.push("10 of Spades");
        stack.push("Jack of Spades");
        stack.push("Queen of Spades");
        stack.push("King of Spades");

        //stack the diamond suit
        stack.push("Ace of Diamonds");
        stack.push("2 of Diamonds");
        stack.push("3 of Diamonds");
        stack.push("4 of Diamonds");
        stack.push("5 of Diamonds");
        stack.push("6 of Diamonds");
        stack.push("7 of Diamonds");
        stack.push("8 of Diamonds");
        stack.push("9 of Diamonds");
        stack.push("10 of Diamonds");
        stack.push("Jack of Diamonds");
        stack.push("Queen of Diamonds");
        stack.push("King of Diamonds");

        //stack the club suit
        stack.push("Ace of Clubs");
        stack.push("2 of Clubs");
        stack.push("3 of Clubs");
        stack.push("4 of Clubs");
        stack.push("5 of Clubs");
        stack.push("6 of Clubs");
        stack.push("7 of Clubs");
        stack.push("8 of Clubs");
        stack.push("9 of Clubs");
        stack.push("10 of Clubs");
        stack.push("Jack of Clubs");
        stack.push("Queen of Clubs");
        stack.push("King of Clubs");

        //stack the heart suit
        stack.push("Ace of Hearts");
        stack.push("2 of Hearts");
        stack.push("3 of Hearts");
        stack.push("4 of Hearts");
        stack.push("5 of Hearts");
        stack.push("6 of Hearts");
        stack.push("7 of Hearts");
        stack.push("8 of Hearts");
        stack.push("9 of Hearts");
        stack.push("10 of Hearts");
        stack.push("Jack of Hearts");
        stack.push("Queen of Hearts");
        stack.push("King of Hearts");
    }

    private void unstackCards() {
        //now pull the cards off the stack and print them
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    private void containsCard(String card) {
        System.out.println(stack.contains(card));
    }

    private void goToCard(int position) {
        System.out.println(stack.access(position));
    }

    private void desckSize() {
        System.out.println(stack.size());
    }
}
