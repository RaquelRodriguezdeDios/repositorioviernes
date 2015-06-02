//Primer apartado examen

package prBinaryString;

import static org.junit.Assert.*;

public class Prueba {

	private BinaryString bitset1, bitset2, bitset3, bitset4, bitset5;
	private String pruebaString2 = "1010101010", pruebaString3 = "100101", pruebaString4 ="0110101", pruebaString5 = "1111000";

	//Para cada Test inicializamos antes su correspondiente bitset con su String asociado.
	@Before
	public void antesDelTest() {
		bitset1 = new BinaryString(10);
		bitset2 = new BinaryString(pruebaString2);
		bitset3 = new BinaryString(pruebaString3);
		bitset4 = new BinaryString(pruebaString4);
		bitset5 = new BinaryString(pruebaString5);
	}

	//Comprobamos si al inicializar el bitset (con los dos contructores) el tamaño es el esperado
	@Test
	public void testLenght() {
		assertEquals(10, bitset1.length());
		assertEquals(10, bitset2.length());
	}
	
// Segundo apartado examen

	//Comprobamos si al cambiar una posición del bitset a un '1' el cambio se hace efectivo.
	@Test
	public void testSetBit() {
		bitset3(1,'1');
		assertEquals('1',bitset3.get(1));
	}
	
// Tercer apartado examen

	package prBinaryString;
	
	public class BinaryStringException extends RuntimeException {
		
		public BinaryStringException () {
			super();
		}
		
		public BinaryStringException (String msg) {
			super(msg);
		}
		
	}
	
	public char get (int index) {
		try {
			return bits[index];
		} catch (RuntimeException e) {
			throw new BinaryStringException;
		}
	}

	//Comprobamos si al acceder fuera de los límites del array nos lanza una excepción tipo BinaryStringException
	@Test(expected = BinaryStringException.class)
	public void testGetOutOfLimitBit(){
		bitset4.get(56);
	}
	
// Apartado 4 examen

	public void set(int index, char value){
		try{
			bits[index] = value;
		} catch(RuntimeException e){
			throw new BinaryStringException();
		}
	}
	
	//Lo mismo que en el apartado anterior pero esta vez utilizando el método set().
	@Test(expected = BinaryStringException.class)
	public void testSetOutOfLimitBit(){
		bitset4.set(56,'0');
	}
	
// Apartado 5 examen

	//Lo mismo que el apartado anterior pero utilizando un try-catch en el mismo método del test
	
	@Test
	public void testSetOutOfLimitBitV2(){
		try{
			bitset4.set(56,'0');
			fail("Se esperaba excepción BinaryStringException");
		} catch (BinaryStringException e) {
			
			
		}
	}
	
// Apartado 6 examen

	public void set(int index, char value){
		try{
			if (value=='1' || value=='0') {
				bits[index] = value;
			} else {
				throw new BinaryStringException();
			}
		} catch (RuntimeException e) {
			throw new BinaryStringException();
		}
	}
	
	//Comprobamos si al intentar meter un char que no sea 1 o 0 lanza una excepción BinaryStringException
	
	@Test(expected = BinaryStringException.class)
	public void tesInvalidBitValue() {
		bitset4.set(1,'a');
	}
	
// Apartado 7 examen

	//Comprobamos que al realizar toString el resultado es el esperado
	
	@Test
	public void testToString() {
		assertEquals("1111000",bitset5.toString());
	}
	
	