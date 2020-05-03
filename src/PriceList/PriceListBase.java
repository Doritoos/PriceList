package PriceList;

import java.util.HashMap;



public class PriceListBase {

    public HashMap<Integer, Names> list = new HashMap<>();

    public boolean add(Integer code, Names name) {
        if (!list.containsKey(code)) {
            list.put(code, name);
            return true;
        } else return false;
    }

    public boolean delete(Integer code){
        if (list.containsKey(code)) {
            list.remove(code);
            return true;
        }
        else return false;
    }

    public Names getNames(int code){
        return list.get(code);
    }

    public boolean changeN(Integer code, String name){

        if (list.containsKey(code)) {
            Names n = new Names(name, list.get(code).getPrice());
            list.put(code, n);
            return true;
        }
        else return false;
    }

    public boolean changeP(Integer code, Price price){
        if (list.containsKey(code)) {
            list.put(code, new Names(list.get(code).getName(), price));
            return true;
        }
        else return false;
    }



    public Price fc(Integer code, Integer amount) {
        int rub = list.get(code).getPrice().getRub()  * amount + list.get(code).getPrice().getKop() * amount/ 100;
        int kop = list.get(code).getPrice().getKop() * amount % 100;
        return new Price(rub, kop);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        {
            for (Integer code : list.keySet()) {
                builder.append("Code: ").append(code).
                        append(" Name: ").append(list.get(code).getName()).
                        append(" Price: ").append(list.get(code).getPrice()).append("\n");
            }
            return builder.toString();
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object ) return true;
        if (object instanceof PriceListBase) {
            PriceListBase other = (PriceListBase) object;
            return list.equals(other.list);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }
}
