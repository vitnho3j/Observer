package observer;

import java.util.Observable;
import java.util.Observer;

public class Inscrito implements Observer {

    private String nome;

    private String ultimaNotificacao;

    public Inscrito(String nome){
        this.nome = nome;
    }

    public String getUltimaNotificacao(){
        return this.ultimaNotificacao;
    }

    public void ativarSinoNotificacao(observer.Canal canal){
        canal.addObserver(this);
    }

    public void update(Observable canal, Object arg1){
        this.ultimaNotificacao = this.nome + ", O " + canal.toString() +  "acabou de lançar um novo vídeo";
    }

}
