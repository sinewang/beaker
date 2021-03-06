package wang.yanjiong.beaker.combi;

import org.junit.Test;
import org.smartea.beaker.example.frontdesk.api.WelcomeProcess;
import org.smartea.beaker.example.regulation.frontdesk.api.Welcome;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.IdentityCard;
import org.smartea.beaker.example.regulation.frontdesk.core.entity.Stranger;
import wang.yanjiong.beaker.combi.cubes.basic.api.Response;
import wang.yanjiong.beaker.remix.SimpleMixer;

import java.util.concurrent.*;

/**
 * Created by WangYanJiong on 10/11/2016.
 */
public class CombinatorStrangerTest {


    @Test
    public void main() {

        Stranger stranger = new Stranger();
        IdentityCard identityCard = new IdentityCard();
        identityCard.setName("lisi");
        stranger.setIdentityCard(identityCard);


        SerialCombinator combinator = new SerialCombinator(new SimpleMixer());

        combinator.addCubes(Welcome.class, new WelcomeProcess());
        combinator.addDroplets(stranger);

        ExecutorService threadPool = Executors.newCachedThreadPool();
        CompletionService<Response> cs = new ExecutorCompletionService<Response>(threadPool);


        cs.submit(combinator);
        try {
            System.out.println(cs.take().get().getResult());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
