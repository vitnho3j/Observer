import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class InscritoTest {

    @Test
    public void deveNotificarInscrito(){

        observer.Canal canal = new observer.Canal("CanalTest1", 129);
        observer.Inscrito inscrito = new observer.Inscrito("InscritoTest 1");
        inscrito.ativarSinoNotificacao(canal);
        canal.lancarVideo();
        assertEquals("InscritoTest 1, O Canal{nome=CanalTest1, quantidadeVideos=130}acabou de lançar um novo vídeo", inscrito.getUltimaNotificacao());

    }

    @Test
    public void deveNotificarInscritos(){
        observer.Canal canal = new observer.Canal("CanalTest1", 129);
        observer.Inscrito inscrito1 = new observer.Inscrito("Inscrito1");
        observer.Inscrito inscrito2 = new observer.Inscrito("Inscrito2");
        inscrito1.ativarSinoNotificacao(canal);
        inscrito2.ativarSinoNotificacao(canal);
        canal.lancarVideo();
        assertEquals("Inscrito1, O Canal{nome=CanalTest1, quantidadeVideos=130}acabou de lançar um novo vídeo", inscrito1.getUltimaNotificacao());
        assertEquals("Inscrito2, O Canal{nome=CanalTest1, quantidadeVideos=130}acabou de lançar um novo vídeo", inscrito2.getUltimaNotificacao());
    }

    @Test
    public void naoDeveNotificarInscrito(){
        observer.Canal canal = new observer.Canal("CanalTest1", 129);
        observer.Inscrito inscrito = new observer.Inscrito("Inscrito1");
        canal.lancarVideo();
        assertEquals(null, inscrito.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarInscritosCanalA(){

        observer.Canal canalA = new observer.Canal("CanalTest1", 129);
        observer.Canal canalB = new observer.Canal("CanalTest2", 129);
        observer.Inscrito inscrito1 = new observer.Inscrito("Inscrito1");
        observer.Inscrito inscrito2 = new observer.Inscrito("Inscrito2");
        inscrito1.ativarSinoNotificacao(canalA);
        inscrito2.ativarSinoNotificacao(canalB);
        canalA.lancarVideo();
        assertEquals("Inscrito1, O Canal{nome=CanalTest1, quantidadeVideos=130}acabou de lançar um novo vídeo", inscrito1.getUltimaNotificacao());
        assertEquals(null, inscrito2.getUltimaNotificacao());
    }



}

