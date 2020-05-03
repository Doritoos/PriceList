package PriceList;

public class Names {
   private String name;
   private Price price;

   public Names(String name, Price price) {
       this.name = name;
       this.price = price;
   }

   String getName(){
       return name;
   }

   Price getPrice(){
       return price;
   }

   @Override
    public boolean equals(Object object){
       if (this == object) return true;
       if (object instanceof Names) {
          Names it =  (Names) object;
          return name.equals(it.name) && price.equals(it.price);
       }
       return false;
   }

    @Override
    public final int hashCode(){
       int result = 1;
       if (name != null){
           result = 31 * result + name.hashCode();
       }
       if (price != null){
           result = (31 * result) + price.hashCode();
       }
       return result;
    }










}
