package testing;

public class Calculator {
	public static void main(String[] args) {
	}

	/**
	 * Addition de 2 nombres positifs
	 * @param pA
	 * @param pB
	 * @return
	 */
	public int add(int pA, int pB) {
		return pA + pB;
	}

	/**
	 * Addition de 2 nombres décimaux
	 * @param pA
	 * @param pB
	 * @return
	 */
	public double add(double pA, double pB) {
		return pA+pB;
	}

	/**
	 * Multiplication de deux nombres positifs
	 * @param iA
	 * @param iB
	 * @return
	 */
	public double multiply(int pA, int pB) {
		return pA*pB;
	}


	/**
	 *  La longueur d'un texte
	 * @param pTexte
	 * @return
	 */
	public Integer getLenght(String pTexte) {
		return pTexte.length();
	}


	/**
	 * Faire trainer le processus durant 2 s
	 */
	public void sleepThread() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
