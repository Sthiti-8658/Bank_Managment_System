package java_projects;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String type;
    private double amount;
    private String dateTime;

    public Transaction(String type,double amount){
        this.type=type;
        this.amount=amount;
        this.dateTime=LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

    }
    @Override
    public String toString(){
        return type +"$"+amount+"on"+dateTime;
    }

}
