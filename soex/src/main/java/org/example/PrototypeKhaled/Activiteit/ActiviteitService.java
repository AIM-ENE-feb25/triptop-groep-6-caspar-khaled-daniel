package org.example.PrototypeKhaled.Activiteit;
import org.example.PrototypeKhaled.BoekingStrategy;

public class ActiviteitService {
    private ActiviteitRepository activiteitRepository;
    private BoekingStrategy boekingStrategy;
    public ActiviteitService(ActiviteitRepository activiteitRepository) {
        this.activiteitRepository = activiteitRepository;
    }
}
