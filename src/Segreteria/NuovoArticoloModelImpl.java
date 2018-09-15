package Segreteria;

public class NuovoArticoloModelImpl {
	private String Nome;
	private String Sport;
	private String Materiale;
	private String Descrizione;
	
	public NuovoArticoloModelImpl() {
		String Nome=null;
		String Sport= null;
		String Materiale=null;
		String Descrizione=null;
	}
	
	// get e set di nome 
	public String getNome() {
		String nome=this.Nome;
		return nome;
	}
	
	public void setNome(String nuova) {
		Nome=nuova;
	}
	
	//get e set di Sport
	public String getSport() {
		String sport=this.Sport;
		return sport;
	}
	
	public void setSport(String nuova) {
		Sport=nuova;
	}
	
	//get e set di Materiale
	public String getMateriale() {
		String materiale=this.Materiale;
		return materiale;
	}
	
	public void setMateriale(String nuova) {
		Materiale=nuova;
	}
	
	//get e set di descrizione
	public String getDescrizione() {
		String descrizione=this.Descrizione;
		return descrizione;
	}
	
	public void setDescrizione(String nuova) {
		Descrizione=nuova;
	}
	
}
