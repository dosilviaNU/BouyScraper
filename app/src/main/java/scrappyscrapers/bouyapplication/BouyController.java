/**
 * To link and manage the flow of data between the Views and the Model.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class BouyController implements ActionListener {

    List<BouyData> data = new ArrayList<>();
    IView view = new View();

    public void setDataToView() {
        view.dataToView(this.data);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
