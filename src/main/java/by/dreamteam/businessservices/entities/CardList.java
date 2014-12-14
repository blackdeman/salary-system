package by.dreamteam.businessservices.entities;

import java.util.List;

/**
 * @author Pavel
 * @version 1.0
 * @created 06-Dec-2014 3:35:01 PM
 */
public class CardList {

    private List<Card> list;

    public CardList() {
    }

    public CardList(List<Card> list) {
        this.list = list;
    }

    public List<Card> getList() {
        return list;
    }
    
    public Card getCard(int i) {
        if (getList().size() > i) {
            return getList().get(i);
        }
        return null;
    }
    
    public int getSize() {
        return getList().size();
    }

}//end CardList
