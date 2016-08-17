package crm_controller;

import crm_view.CrmView;

public class VisualController {

    private final System system;

    private final CrmView crmView;

    public VisualController(final System system,
                            final CrmView crmView) {
        this.system = system;
        this.crmView = crmView;
    }

}
