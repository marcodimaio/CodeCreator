package it.capgemini.archetype.web.enumerator;

public enum ViewState {
	
	READONLY("READONLY", "READONLY"), 
	UPDATE("UPDATE", "UPDATE"), 
	SAVE("SAVE", "SAVE"), 
	DELETE("DELETE", "DELETE"), 
	CREATE("CREATE", "CREATE");
	
	private String codice;
	private String descrizione;

	private ViewState(String codice, String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public static String getDescrizione(String codice) {
		if (codice == null)
			return "";

		for (ViewState value : ViewState.values()) {
			if (value.getCodice().equals(codice))
				return value.getDescrizione();
		}

		return "";
	}
}
