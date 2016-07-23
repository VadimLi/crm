package crm_controller;

import crm_model.Model;
import crm_view.CRMView;

import java.awt.event.ActionListener;


public class VisualController {

    private final Model model;

    private final CRMView view;

    public VisualController(final Model model,
                            final CRMView view) {
        this.model = model;
        this.view = view;
        new VisualControllerListeners();
    }

    public class VisualControllerListeners implements ActionListener{

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            view.getAddButton();
            view.getDeleteButton();
        }

    }

}
