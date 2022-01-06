package testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

	private Calculator moCalculatorUnderTest;
	private int miA, miB;
	private static final int SOMME = 6;
	private static final double MULTIPLY = 8;

	private static Instant moStartedAt;

	@BeforeAll
	static void startedTesting() {
		moStartedAt = Instant.now();
		System.out.println("Début des tests ");
	}

	@AfterAll
	static void showDurationTest() {
		Instant oEndAt = Instant.now();
		long lDuration = Duration.between(moStartedAt, oEndAt).toMillis();
		System.out.println("Les tests ont mis  " + lDuration + " s à s'exécuter" );
	}

	@BeforeEach
	void initEntrerSUT() {
		System.out.println("Initialisation des entrées pour addition et multiplication");
		miA = 2;
		miB = 4;
	}

	/**
	 * Méthode permettant de créer le SUT avant  chaque teste
	 */
	@BeforeEach
	void iniCalculator() {
		System.out.println("Création du SUT avant chaque méthode de Test");
		moCalculatorUnderTest = new Calculator();
	}

	@AfterEach
	void removeCalculator() {
		System.out.println("Non disponibilité du SUT après chaque méthode de Test");
		moCalculatorUnderTest = null;
	}

	@Test
	void testAddTwoPositivesNumbers() {

		int iSomme = moCalculatorUnderTest.add(miA, miB);
		assertThat(iSomme).isEqualTo(SOMME);
		//		assertEquals(SOMME, iSomme);
	}

	@Test
	void multiply_shouldReturn_twoNumbersMultiplied() {

		double dMultiply = moCalculatorUnderTest.multiply(miA, miB);
		assertThat(dMultiply).isEqualTo(MULTIPLY);
		//		assertEquals(MULTIPLY, dMultiply);
	}


	@ParameterizedTest(name = "{0} *  0  doit être= 0")
	@ValueSource(ints = {1, 15, 26, 42})
	void multiply_shouldReturnZero (int arg) {
		//		assertEquals(0, moCalculatorUnderTest.multiply(0, arg));
		assertThat(moCalculatorUnderTest.multiply(0, arg)).isEqualTo(0);
	}

	@Test
	void should_return_lenghtOfString () {
		//		assertEquals(4, moCalculatorUnderTest.getLenght("PAPA"));
		assertThat(moCalculatorUnderTest.getLenght("PAPA")).isEqualTo(4);
	}


	@ParameterizedTest(name = "La longueur de {0} doit être = 5")
	@ValueSource(strings = {"tatao","piopi","xdioe","aidnd","hfhfy","fjfjf"})
	void should_always_return_five (String mTexte) {
		//		assertEquals(5, moCalculatorUnderTest.getLenght(mTexte));
		assertThat(moCalculatorUnderTest.getLenght(mTexte)).isEqualTo(5);
	}

	@ParameterizedTest(name = "{0} + {1} doit être = {2}")
	@CsvSource({"1,5,6", "7,8,15", "12,7,19"})
	void should_return_additionOfTwoNumbers (int pNum1, int pNum2, int pAddRes) {
		//		assertEquals(pAddRes, moCalculatorUnderTest.add(pNum1, pNum2));
		assertThat(moCalculatorUnderTest.add(pNum1, pNum2)).isEqualTo(pAddRes);
	}


	@Test
	@Timeout(value = 1)
	void should_make_twoSeconds() {
		moCalculatorUnderTest.sleepThread();
	}


	@Test
	void should_return_additionTwoDecimals() {
		double dSomme = moCalculatorUnderTest.add(0.5, 0.5);
		assertThat(dSomme).isEqualTo(1);
	}


}
