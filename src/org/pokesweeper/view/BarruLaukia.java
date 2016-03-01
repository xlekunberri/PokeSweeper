package org.pokesweeper.view;

public class BarruLaukia {
	
	private boolean mina;
	private boolean aztertuta;
	private int zenbakia;
	private int egoera;
	
	public BarruLaukia() {}

	public boolean isMina() {
		return mina;
	}

	public void setMina(boolean pMina) {
		this.mina = pMina;
	}

	public boolean isAztertuta() {
		return aztertuta;
	}

	public void setAztertuta(boolean pAztertuta) {
		this.aztertuta = pAztertuta;
	}

	public int getEgoera() {
		return egoera;
	}

	public void setEgoera(int pEgoera) {
		this.egoera = pEgoera;
	}
	
	public int getZenbakia() {
		return zenbakia;
	}

	public void setZenbakia(int pZenbakia) {
		this.zenbakia = pZenbakia;
	}

}
