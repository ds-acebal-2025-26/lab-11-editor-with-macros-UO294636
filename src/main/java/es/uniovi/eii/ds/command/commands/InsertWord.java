package es.uniovi.eii.ds.command.commands;

import es.uniovi.eii.ds.command.Instruction;
import es.uniovi.eii.ds.main.Editor;

public class InsertWord implements Instruction{
	private Editor editor;
	private String[] palabra;
	
	public InsertWord(Editor editor, String[] palabra) {
		this.editor = editor;
		this.palabra = palabra;
	}

	@Override
	public void execute() {
		editor.insert(palabra);
		
	}
	
	

}
