package observer;
import java.util.Observable;

public class Canal extends Observable {

    private String nome;

    private Integer quantidadeVideos;

    public Canal(String nome, Integer quantidadeVideos){
        this.nome = nome;
        this.quantidadeVideos = quantidadeVideos;
    }

    public void lancarVideo(){
        quantidadeVideos = quantidadeVideos + 1;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString(){
        return "Canal{" +
                "nome=" + nome +
                ", quantidadeVideos=" + quantidadeVideos +
                '}';
    }

}
