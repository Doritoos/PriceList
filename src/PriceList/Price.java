package PriceList;

public class Price {
    private int rub;
    private int kop;

    public Price(int rub, int kop) {
        if (rub > 0 && kop > 0 && kop <= 99) {
            this.rub = rub;
            this.kop = kop;

        }
      else throw new IllegalArgumentException();
    }

    int getRub() {
        return rub;
    }

    int getKop() {
        return kop;
    }

    @Override
    public String toString() {
        return rub + " руб " + kop + " коп ";
    }


    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof Price))
            return false;
        Price other = (Price) object;
        return other.rub == rub && other.kop == kop;
    }

    @Override
    public final int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(rub);
        result = 31 * result + Integer.hashCode(kop);
        return result;
    }
}

