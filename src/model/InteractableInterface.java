package model;

import java.util.ArrayList;

// Denna lär antagligen bli ganska onödig, då allting nu ska stoppas in i InteractableModel istället

public interface InteractableInterface extends EntityModelInterface {
	public Event clicked(ActionType action);
}
