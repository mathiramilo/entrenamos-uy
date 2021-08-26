package datatypes;

import java.util.Set;

public class DtActividadDeportivaExt extends DtActividadDeportiva{
	private Set<String> cl;
	private Set<String> cup;
	public DtActividadDeportivaExt(String nombre, String desc, int durmin, float costo, DtFecha fechaReg, Set<String> clases, Set<String> cuponeras){
		super(nombre,desc,durmin,costo,fechaReg);
		cl = clases;
		cup = cuponeras;
	}
	public Set<String> getClases(){
		return cl;
	}
	public Set<String> getCuponeras(){
		return cup;
	}
}
