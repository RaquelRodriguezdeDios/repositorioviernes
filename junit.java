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
	
	