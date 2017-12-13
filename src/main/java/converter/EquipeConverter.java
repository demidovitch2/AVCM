package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import model.Equipe;
import repository.EquipeRepository;

@FacesConverter(forClass = Equipe.class)
public class EquipeConverter implements Converter {

	@Inject
	private EquipeRepository equipeRepository;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Equipe equipe = null;

		if (arg2 != null && !"".equals(arg2))
			equipe = equipeRepository.findById(new Long(arg2));
		return equipe;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			Equipe equipe = ((Equipe) arg2);

			return equipe.getId() == null ? null : equipe.getId().toString();
		}
		return null;
	}

}
