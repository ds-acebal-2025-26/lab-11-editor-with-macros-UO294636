package es.uniovi.eii.ds.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;

import es.uniovi.eii.ds.command.commands.InsertWord;
import es.uniovi.eii.ds.command.commands.Remove;
import es.uniovi.eii.ds.command.commands.Replace;

public class Editor {
	StringBuilder text = new StringBuilder();
	MacroControlling macroControlling;
	public Editor() {
		macroControlling = new MacroControlling();
	}
	public MacroControlling getMacroController() {
		return macroControlling;
	}
	
	public void insert(String[] wordToInsert) {
		if (macroControlling.getMacro() == null) {
			macroControlling.add(new InsertWord(this, wordToInsert));
		}
		for (String word : wordToInsert) {
			text.append(" ").append(word);
		}
	}
	
	public void delete() {
		if (macroControlling.getMacro() == null) {
			macroControlling.add(new Remove(this));
		}
		int indexOfLastWord = text.toString().trim().lastIndexOf(" ");
		if (indexOfLastWord == -1)
			text = new StringBuilder("");
		else
			text.setLength(indexOfLastWord);
	}
	public void replace(String[] args) {
		if (macroControlling.getMacro() == null) {
			macroControlling.add(new Replace(this, args));
		}
		if (!checkArguments(args, 2, "replace <find> <replace>"))
			return;
		String find = args[0];
		String replace = args[1];
		text = new StringBuilder(text.toString().replace(find, replace));
	}
	
	public void open(String[] args) {
		if (!checkArguments(args, 1, "open <file>"))
			return;
		try {
			String filename = args[0];
			text = new StringBuilder(readFile(filename));
		} catch (Exception e) {
			System.out.println("Document could not be opened");
		}
	}
	private boolean checkArguments(String[] args, int expected, String syntax) {
        if (args.length != expected) {
            System.out.println("Invalid number of arguments => " + syntax);
            return false;
        }
        return true;
    }
	
	
	
	
	
	
	private String readFile(String filename) {
		InputStream in = getClass().getResourceAsStream("/" + filename);
		if (in == null)
			throw new IllegalArgumentException("File not found: " + filename);

		try (BufferedReader input = new BufferedReader(new InputStreamReader(in))) {
			StringBuilder result = new StringBuilder();
			String line;
			boolean firstLine = true;
			while ((line = input.readLine()) != null) {
				if (!firstLine)
					result.append(System.lineSeparator());
				result.append(line);
				firstLine = false;
			}
			return result.toString();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	
}
