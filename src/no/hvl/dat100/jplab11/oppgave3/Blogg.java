package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {
	private int antalllengde;
	private int nesteLedig;
	private Innlegg[] innleggtabell;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteLedig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];

	}

	public int getAntall() {
		return nesteLedig;

	}

	public Innlegg[] getSamling() {
		return innleggtabell;

	}

	public int finnInnlegg(Innlegg innlegg) {
		boolean funnet = false;
		int pos = 0;
		while (pos < nesteLedig && !funnet) {
			if (innleggtabell[pos].erLik(innlegg))
				funnet = true;
			else
				pos++;
		}

		if (funnet)
			return pos;
		else
			return -1;

	}

	public boolean finnes(Innlegg innlegg) {

		if (finnInnlegg(innlegg) >= 0) {
			return true;
		}
		return false;
	}

	public boolean ledigPlass() {

		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i] == null) {
				return true;
			}
		}
		return false;

	}

	public boolean leggTil(Innlegg innlegg) {

		if (!finnes(innlegg) && ledigPlass()) {
			innleggtabell[nesteLedig] = innlegg;
			nesteLedig++;
			return true;

		}
		return false;
	}

	public String toString() {
		String s = nesteLedig + "\n";

		for (int i = 0; i < innleggtabell.length; i++) {
			s += innleggtabell[i];
		}
		return s;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());

	}

	public boolean slett(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
	}

	public int[] search(String keyword) {

		throw new UnsupportedOperationException(TODO.method());

	}
}