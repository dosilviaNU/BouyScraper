import java.util.ArrayList;
import java.util.List;

/**
 * Created by brendanrejevich on 10/1/16.
 */
public class View implements IView {

    List<BouyData> dataCopy = new ArrayList<>();

    @Override
    public void dataToView(List<BouyData> data) {
        List<BouyData> temp = data;
        this.dataCopy = temp;
    }
}
