package org.dav.learn.mcdowell.ch01_arrays_strings;

import java.util.HashMap;
import java.util.Map;

public class Util
{
	public static void bubbleSortArray(char[] array)
	{
		int out, in;

		for (out = array.length - 1; out > 0; out--)
			for (in = 0; in < out; in++)
				if (array[in] > array[in + 1])
				{
					char temp = array[in];
					array[in] = array[in + 1];
					array[in + 1] = temp;
				}
	}

	public static void bubbleSortArray(int[] array)
	{
		int out, in;

		for (out = array.length - 1; out > 0; out--)
			for (in = 0; in < out; in++)
				if (array[in] > array[in + 1])
				{
					int temp = array[in];
					array[in] = array[in + 1];
					array[in + 1] = temp;
				}
	}

	public static void bubbleSortArray(double[] array)
	{
		int out, in;

		for (out = array.length - 1; out > 0; out--)
			for (in = 0; in < out; in++)
				if (array[in] > array[in + 1])
				{
					double temp = array[in];
					array[in] = array[in + 1];
					array[in + 1] = temp;
				}
	}

	public static boolean areAllCharactersUnique(String str)
	{
		if (str == null)
			throw new IllegalArgumentException("Input a not null string.");

		char[] chars = str.toCharArray();

		if (chars.length < 2)
			return true;

		bubbleSortArray(chars);

		for (int i = 0; i < chars.length - 1; i++)
			if (chars[i + 1] == chars[i])
				return false;

		return true;
	}

	public static boolean areAllCharactersUniqueByMap(String str)
	{
		if (str == null)
			throw new IllegalArgumentException("Input a not null string.");

		if (str.isEmpty() || str.length() < 2)
			return true;

		Map<Character, Integer> charMap = new HashMap<>();

		for (int i = 0; i < str.length(); i++)
		{
			char character = str.charAt(i);
			int count = 1;

			if (charMap.containsKey(character))
				return false;

			charMap.put(character, count);
		}

		return true;
	}

	public static boolean isUniqueChars(String str)
	{
		if (str.length() > 256)
			return false;

		int checker = 0;

		for (int i = 0; i < str.length(); i++)
		{
			int val = str.charAt(i);

			if ((checker & (1 << val)) > 0)
				return false;

			checker |= (1 << val);
		}

		return true;
	}

	public static boolean isUniqueChars2(String str)
	{
		if (str.length() > 256)
			return false;

		boolean[] char_set = new boolean[256];

		for (int i = 0; i < str.length(); i++)
		{
			int val = str.charAt(i);

			if (char_set[val])
				return false;

			char_set[val] = true;
		}

		return true;
	}

	public static String compressBad(String str)
	{
		String myStr = "";
		char last = str.charAt(0);
		int count = 1;

		for (int i = 1; i < str.length(); i++)
		{
			if (str.charAt(i) == last)
				count++;
			else
			{
				myStr += last + "" + count;
				last = str.charAt(i);
				count = 1;
			}
		}

		return myStr + last + count;
	}

	public static String compressBetter(String str)
	{
		int size = countCompression(str);
		if (size >= str.length())
			return str;

		StringBuilder myStr = new StringBuilder();
		char last = str.charAt(0);
		int count = 1;

		for (int i = 1; i < str.length(); i++)
		{
			if (str.charAt(i) == last)
				count++;
			else
			{
				myStr.append(last);
				myStr.append(count);

				last = str.charAt(i);
				count = 1;
			}
		}

		myStr.append(last);
		myStr.append(count);

		return myStr.toString();
	}

	public static String compressAlternate(String str)
	{
		int size = countCompression(str);
		if (size >= str.length())
			return str;

		char[] array = new char[size];
		int index = 0;
		char last = str.charAt(index);
		int count = 1;

		for (int i = 1; i < str.length(); i++)
		{
			if (str.charAt(i) == last)
				count++;
			else
			{
				index = setChar(array, last, index, count);
				last = str.charAt(i);
				count = 1;
			}
		}

		index = setChar(array, last, index, count);
		return String.valueOf(array);
	}

	public static int[][] rotateCube(int[][] source, boolean toLeft)
	{
		int side = source.length;
		int[][] dest = new int[side][side];

		for (int row = 0; row < side; row++)
		{
			int[] line = new int[side];

			for (int col = 0; col < side; col++)
			{
				if (toLeft)
					line[col] = source[col][side - row - 1];
				else
					line[side - col - 1] = source[col][row];
			}

			dest[row] = line;
		}

		return dest;
	}

	public static void rotate(int[][] matrix, int n)
	{
		for (int layer = 0; layer < n / 2; ++layer)
		{
			int first = layer;
			int last = n - 1 - layer;

			for (int i = first; i < last; ++i)
			{
				int offset = i - first;

				int top = matrix[first][i];

				matrix[first][i] = matrix[last - offset][first];

				matrix[last - offset][first] = matrix[last][last - offset];

				matrix[last][last - offset] = matrix[i][last];

				matrix[i][last] = top;
			}
		}
	}

	public static void setZeros(int[][] matrix)
	{
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				if (matrix[i][j] == 0)
				{
					row[i] = true;
					column[j] = true;
				}

		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				if (row[i] || column[j])
					matrix[i][j] = 0;
	}

	public static void fillMarixWithZeros(int[][] matrix, int m, int n)
	{
		int[] zeroRows = new int[m];
		int[] zeroColumns = new int[n];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (matrix[i][j] == 0)
				{
					zeroRows[i] = 1;
					zeroColumns[j] = 1;
				}

		for (int i = 0; i < m; i++)
			if (zeroRows[i] == 1)
				for (int j = 0; j < n; j++)
					matrix[i][j] = 0;

		for (int j = 0; j < n; j++)
			if (zeroColumns[j] == 1)
				for (int i = 0; i < m; i++)
					matrix[i][j] = 0;
	}

	public static void printMatrix(int[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
				System.out.print(matrix[i][j] + "\t");

			System.out.println();
		}
	}

	public static boolean isRotation(String s1, String s2)
	{
		int len = s1.length();

		if (len > 0 && len == s2.length())
		{
			String s1s1 = s1 + s1;

			return isSubstring(s1s1, s2);
		}

		return false;
	}

	private static boolean isSubstring(String s1, String s2)
	{
		return s1.contains(s2);
	}

	private static int countCompression(String str)
	{
		int size = 0;
		char last = str.charAt(0);
		int count = 1;

		for (int i = 1; i < str.length(); i++)
		{
			if (str.charAt(i) == last)
				count++;
			else
			{
				size += 1 + String.valueOf(count).length();
				last = str.charAt(i);
				count = 1;
			}
		}

		size += 1 + String.valueOf(count).length();
		return size;
	}

	private static int setChar(char[] array, char c, int index, int count)
	{
		array[index] = c;
		index++;

		char[] cnt = String.valueOf(count).toCharArray();
		for (char x : cnt)
		{
			array[index] = x;
			index++;
		}

		return index;
	}
}
