package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import model.Treinador;
import repository.TreinadorRepository;

@FacesConverter(forClass = Treinador.class)
public class TreinadorConverter implements Converter {

	@Inject
	TreinadorRepository treinadorRepository;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Treinador treinador = null;

		if (arg2 != null && !"".equals(arg2))
			treinador = treinadorRepository.findById(new Long(arg2));
		return treinador;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			Treinador treinador = ((Treinador) arg2);

			return treinador.getId() == null ? null : treinador.getId().toString();
		}
		return null;
	}

}