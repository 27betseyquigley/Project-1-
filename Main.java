// this is from IntelliJ
public class Main {
    public static void main (String[]args){

        Card[] cards = Card.makeDeck();
        Card threeOfClubs= new Card(3,0);
        Card jack= new Card(11,1);
        Card ace= new Card(1,0);
        Card king = new Card(13,0);
        Card hearts = new Card(4,0);
        Card spades= new Card(1,0);

//compare to

        System.out.println("Test Ace");
        System.out.println(jack.compareTo(ace));

        System.out.println("Testing my deck");
        Deck deck = new Deck();
        System.out.println("Shuffled");
        deck.print();
        System.out.println("Sorted");
        deck.shuffle();
        deck.selectionSort();
        deck.print();
        
        Deck sub = deck.subdeck(0,3);
        sub.shuffle();
        System.out.println("Subdeck");
        sub.print();
        Deck sub2 = deck.subdeck(0,3);
        sub2.shuffle();
        
        Deck mergedDeck = Deck.merge(sub, sub2);
        System.out.println("Merged Deck");
        mergedDeck.print();
        
        System.out.println("Almost merged deck");
        deck.shuffle();
        Deck almostMergeSort = Deck.almostMergeSort(deck);
        almostMergeSort.print();
        
        deck.shuffle();
        System.out.println("Merged Deck");
        deck.mergeSort(deck);

        deck.shuffle();
        System.out.println("Insertion Sort");
        Deck selectionSort = deck.selectionSort(deck);
        selectionSort.print();

         deck.shuffle();
        System.out.println("Bubble Sort");
        Deck bubbleSort = deck.bubbeSort(deck);
        bubbeSort.print();

        

    }
    public static int [] suitHist(Card[] cards){
        int[]numSuits= new int[4];
        for(int i=0; i<cards.length; i++){
            int index = cards[i].getSuit();
            numSuits[index]++;
        }
        return numSuits;
    }
    public static boolean hasFlush(Card[] cards){
        int[]numSuits= suitHist(cards);
        for(int i=0; i<numSuits.length; i++){
            if(numSuits[i]>=5){
                return true;
            }
        }
        return false;
    }
    public static boolean hasRoyal(Card[]cards){
        if(!hasFlush(cards)){
            return false;
        }
        boolean[]ranks= new boolean[14];
        for(Card c: cards){
            if(c.getRank()>=10 && c.getRank()<=13|| c.getRank()==1){
                ranks[c.getRank()]=true;
            }
        }
        return ranks[1] && ranks[10] && ranks[11] && ranks[12] && ranks[13];
    }


}// end main class



