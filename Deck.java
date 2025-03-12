import java.util.Collections;
import java.util.Random;

public class Deck {
    // This is a class variable so we don't have to create
    // a new Random object every time we call randomInt.
    private static Random random = new Random();

    private Card[] cards;
    private int length;


    /**
     * Constructs a standard deck of 52 cards.
     */
    public Deck() {
        this.cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    /**
     * Constructs a deck of n cards (all null).
     */
    public Deck(int n) {
        this.cards = new Card[n];
    }

    /**
     * Gets the internal cards array.
     */
    public Card[] getCards() {
        return this.cards;
    }

    /**
     * Displays each of the cards in the deck.
     */
    public void print() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }

    /**
     * Returns a string representation of the deck.
     */
    public String toString() {
        String result="";
        for(Card card: this.cards){
            result+= card.toString() + "";
        }
        return result;
        //return "TODO";
    }

    /**
     * Randomly permutes the array of cards.
     */
    public void shuffle() {
        for (int i = 0; i < this.cards.length; i++) {

            // choose a random number between i and length - 1
           int rand= randomInt(i,cards.length);
            // swap the ith card and the randomly-chosen card
            swapCards(i,rand);
        }

    }

    /**
     * Chooses a random number between low and high, including both.
     */
    private static int randomInt(int low, int high) {
       return random.nextInt(high-low) + low;

    }


    /**
     * Swaps the cards at indexes i and j.
     */
    private void swapCards(int i, int j) {//helper methods
        Card temp = this.cards[i];
        this.cards[i] = this.cards[j];
        this.cards[j] = temp;
    }

    /**
     * Sorts the cards (in place) using selection sort.
     */
    public void selectionSort() {
        for(int index=0; index<cards.length; index++){
            int lowest= indexLowest(index, cards.length-1);
            //swap the ith card and the lowest card found
            if(lowest !=lowest){
                swapCards(lowest, index-1);
            }
        }
    }

    /**
     * Finds the index of the lowest card
     * between low and high inclusive.
     */
    private int indexLowest(int low, int high) {
        int min = low;
        for(int i=low;i<=high;i++){
            if(this.cards[i].compareTo(this.cards[min])<0){
                min=i;


            }

        }
        return min;
    }



    static Deck merge(Deck d1, Deck d2) {
        //d1 and d2 are inputs
        // create a new deck, d3, big enough for all the cards
        Deck d3 = new Deck(d1.length + d2.length);

        // use the index i to keep track of where we are at in
        // the first deck, and the index j for the second deck
        int i = 0; //first step
        int j = 0; // second step

        // the index k traverses the result deck
        for (int k = 0; k < d3.length; k++) {
            // if d1 is empty, use top card from d2
            if (i >= d1.cards.length ) {
                d3.cards[k] = d2.cards[j++];
            // if d2 is empty, use top card from d1
            } else if (j >= d2.cards.length ) {
                d3.cards[k] = d1.cards[i++];
            // otherwise, compare the top two cards
            } else  {
                int result = d2.cards[j].compareTo(d1.cards[i]);
                // add lowest card to the new deck at k
                // and increment i or j (depending on card)

                if (result == -1){
                    d3.cards[k] = d2.cards[j];
                    j++;
                }
                else {
                    d3.cards[k] = d1.cards[i];
                    i++;
                }
            }
        }
        // return the new deck
        return d3;
    }




    /**
     * Returns a subset of the cards in the deck.
     */
    public Deck subdeck(int low, int high) {
        Deck sub = new Deck(high - low + 1);
        for (int i = 0; i < sub.cards.length; i++) {
            sub.cards[i] = this.cards[low + i];
        }
        return sub;
    }

    /**
     * Combines two previously sorted subdecks.
     */

    /**
     * Returns a sorted copy of the deck using selection sort.
     */
    public static Deck almostMergeSort(Deck deck) {
        // divide the deck into two subdecks
        Deck subdeck1 = deck.subdeck(0 , deck.cards.length/2-1);
        Deck subdeck2 = deck.subdeck(deck.cards.length/2 , deck.cards.length-1);
        // sort the subdecks using selectionSort
        subdeck1.selectionSort();
        subdeck2.selectionSort();
        // merge the subdecks, return the result

        return Deck.merge(subdeck1, subdeck2);
    }

    /**
     * Returns a sorted copy of the deck using merge sort.
     */
    public Deck mergeSort(Deck deck) {
       // if the deck has 0 or 1 cards, return it
        if(deck.cards.length <= 1){
            return deck;
        }
        // otherwise, divide the deck into two subdecks
        Deck subdeck1 = deck.subdeck(0 , deck.cards.length/2-1);
        Deck subdeck2 = deck.subdeck(deck.cards.length/2 , deck.cards.length-1);
        // sort the subdecks using   mergeSort
        subdeck1 = mergeSort(subdeck1);
        subdeck2 = mergeSort(subdeck2);
        // merge the subdecks
        // return the result
        return merge(subdeck1, subdeck2);



    }
    /**
     * Reorders the cards (in place) using insertion sort.
     */
    public void insertionSort() {
        for (int i = 1; i < cards.length; i++) {

        }
    }

    /**
     * Helper method for insertion sort.
     */
    private void insert(Card card, int i) {
    }
    public void selectSort() {


        }




}// end deck class


