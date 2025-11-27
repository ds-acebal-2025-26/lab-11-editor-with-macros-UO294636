package es.uniovi.eii.ds.command.commands;

import es.uniovi.eii.ds.command.Instruction;
import es.uniovi.eii.ds.main.Editor;

public class Remove implements Instruction{
	private Editor editor;

	public Remove(Editor editor) {
		this.editor = editor;
	}

	@Override
	public void execute() {
		editor.delete();		
	}
	
	
	
	

}
