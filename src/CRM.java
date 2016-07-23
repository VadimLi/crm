import crm_controller.VisualController;
import crm_model.Model;
import crm_view.CRMView;
import javafx.application.Application;
import javafx.stage.Stage;

public class CRM extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final Model model = new Model();
        final CRMView crmView = new CRMView();
        final VisualController visualController= new VisualController();

    }

}

