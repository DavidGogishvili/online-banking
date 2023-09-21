package ge.davidgogishvili.onlinebanking.test;



public class TestGeneric<T> {

    //შევქმენი ობიექტის ტიპი ელემენტი
    private Object element;


    //სეტერი
    public void setElement(T el) {
        this.element = el;
    }

    //გეთერი
    public T getElement(){
        return (T) element;
    }


    //ფუნქციები - უდრის თუ არა ნალს
    public boolean IsEmpty() {
        return element == null;
    }

    public  boolean IsPresent() {
        return element !=null;
    }

    public void setFirstName(String დავით) {
    }
}
