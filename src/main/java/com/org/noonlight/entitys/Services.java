package com.org.noonlight.entitys;

public class Services {
	private boolean other;
	private boolean medical;
	private boolean police;
	private boolean fire;

	public Services(boolean other, boolean medical, boolean police, boolean fire) {
		super();
		this.other = other;
		this.medical = medical;
		this.police = police;
		this.fire = fire;
	}

	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Services [other=" + other + ", medical=" + medical + ", police=" + police + ", fire=" + fire + "]";
	}

	public boolean isOther() {
		return other;
	}

	public void setOther(boolean other) {
		this.other = other;
	}

	public boolean isMedical() {
		return medical;
	}

	public void setMedical(boolean medical) {
		this.medical = medical;
	}

	public boolean isPolice() {
		return police;
	}

	public void setPolice(boolean police) {
		this.police = police;
	}

	public boolean isFire() {
		return fire;
	}

	public void setFire(boolean fire) {
		this.fire = fire;
	}

}