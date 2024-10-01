package behavioural.mediator;

import java.util.ArrayList;
import java.util.List;

interface AuctionMediator {
    void addBidder(Bidder bidder);
    void placeBid(Bidder bidder, int bidAmount);
    void declareWinner();
}

class Auction implements AuctionMediator {
    private List<Bidder> bidders;
    private Bidder highestBidder;
    private int highestBid;

    public Auction() {
        this.bidders = new ArrayList<>();
        this.highestBid = 0;
    }

    @Override
    public void addBidder(Bidder bidder) {
        bidders.add(bidder);
    }

    @Override
    public void placeBid(Bidder bidder, int bidAmount) {
        if (bidAmount > highestBid) {
            highestBid = bidAmount;
            highestBidder = bidder;
            System.out.println(bidder.getName() + " placed a bid of $" + bidAmount);
        } else {
            System.out.println(bidder.getName() + "'s bid of $" + bidAmount + " was too low.");
        }
    }

    @Override
    public void declareWinner() {
        if (highestBidder != null) {
            System.out.println("The winner is " + highestBidder.getName() + " with a bid of $" + highestBid);
        } else {
            System.out.println("No bids were placed.");
        }
    }
}

abstract class Bidder {
    protected AuctionMediator mediator;
    protected String name;

    public Bidder(AuctionMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void bid(int amount);
}

class ConcreteBidder extends Bidder {
    public ConcreteBidder(AuctionMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void bid(int amount) {
        mediator.placeBid(this, amount);
    }
}

public class MediatorDesignExample {
    public static void main(String[] args) {
        AuctionMediator auction = new Auction();

        Bidder bidder1 = new ConcreteBidder(auction, "Alice");
        Bidder bidder2 = new ConcreteBidder(auction, "Bob");
        Bidder bidder3 = new ConcreteBidder(auction, "Charlie");

        auction.addBidder(bidder1);
        auction.addBidder(bidder2);
        auction.addBidder(bidder3);

        bidder1.bid(100);
        bidder2.bid(150);
        bidder3.bid(120);

        auction.declareWinner();
    }
}
