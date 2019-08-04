package org.dav.learn.mcdowell.ch01_arrays_strings;

public class TestFlight
{
	public static void main(String[] args)
	{
		/*testUniqueness();
		testCompress();
		testMyRotate();
		testMyRotate();*/

		//testZeros();

		testStringRotation();
	}

	static void testStringRotation()
	{
		String baseStr = "aqueduct";
		System.out.println("Base string: '" + baseStr + "'");

		String[] candidates = {"duct", "ducteect", "uctaqued"};
		for (String str : candidates)
			System.out.println("String '" + str + "' " +
					(Util.isRotation(baseStr, str) ? "is " : "isn't") + " a rotation.");
	}

	static void testZeros()
	{
		int[][] matrix = new int[3][4];
		matrix[0] = new int[4];
		matrix[0][0] = 0;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[0][3] = 4;
		matrix[1] = new int[4];
		matrix[1][0] = 5;
		matrix[1][1] = 6;
		matrix[1][2] = 7;
		matrix[1][3] = 8;
		matrix[2] = new int[4];
		matrix[2][0] = 9;
		matrix[2][1] = 1;
		matrix[2][2] = 2;
		matrix[2][3] = 0;

		Util.printMatrix(matrix);
		System.out.println();

		Util.setZeros(matrix);
		Util.printMatrix(matrix);
	}

	static void testUniqueness()
	{
		String str = "Unique";
		String str2 = "unique";

		String messagePattern = "All characters in the string '%s' are unique: %b";

		System.out.println(String.format(messagePattern, str, Util.isUniqueChars(str)));
		System.out.println(String.format(messagePattern, str2, Util.isUniqueChars(str2)));
	}

	static void testCompress()
	{
		String str = "aavvffssssssssssssssret";
		System.out.println(Util.compressAlternate(str));
	}

	static void testMyRotate()
	{
		int[][] cube = new int[3][3];
		cube[0] = new int[3];
		cube[0][0] = 1;
		cube[0][1] = 2;
		cube[0][2] = 3;
		cube[1] = new int[3];
		cube[1][0] = 4;
		cube[1][1] = 5;
		cube[1][2] = 6;
		cube[2] = new int[3];
		cube[2][0] = 7;
		cube[2][1] = 8;
		cube[2][2] = 9;

		Util.printMatrix(cube);
		System.out.println();

		int[][] rotatedCube = Util.rotateCube(cube, true);

		Util.printMatrix(rotatedCube);
		System.out.println();

		rotatedCube = Util.rotateCube(cube, false);

		Util.printMatrix(rotatedCube);
		System.out.println();
	}

	static void testRotate()
	{
		int[][] cube = new int[3][3];
		cube[0] = new int[3];
		cube[0][0] = 1;
		cube[0][1] = 2;
		cube[0][2] = 3;
		cube[1] = new int[3];
		cube[1][0] = 4;
		cube[1][1] = 5;
		cube[1][2] = 6;
		cube[2] = new int[3];
		cube[2][0] = 7;
		cube[2][1] = 8;
		cube[2][2] = 9;

		Util.printMatrix(cube);
		System.out.println();

		for (int i = 0; i < 4; i++)
		{
			Util.rotate(cube, cube.length);
			Util.printMatrix(cube);
			System.out.println();
		}
	}
}
