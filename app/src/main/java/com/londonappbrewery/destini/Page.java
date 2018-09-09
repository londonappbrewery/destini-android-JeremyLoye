package com.londonappbrewery.destini;

public class Page {
    private int textId;
    private int topBtnId;
    private int topLink;
    private int btmBtnId;
    private int btmLink;

    public Page(int textId, int topId, int topLink,
                int btmId, int btmLink ) {
        this.textId = textId;
        this.topBtnId = topId;
        this.topLink = topLink;
        this.btmBtnId = btmId;
        this.btmLink = btmLink;
    }

    public Page(int textId) {
        this.textId = textId;
        this.topBtnId = -1;
    }

    public int getTextId() {
        return textId;
    }

    public int getTopBtnId() {
        return topBtnId;
    }

    public int getTopLink() {
        return topLink;
    }

    public int getBtmBtnId() {
        return btmBtnId;
    }

    public int getBtmLink() {
        return btmLink;
    }
}
