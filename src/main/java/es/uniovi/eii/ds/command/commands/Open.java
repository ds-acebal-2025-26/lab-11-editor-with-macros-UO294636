package es.uniovi.eii.ds.command.commands;

import es.uniovi.eii.ds.command.Instruction;
import es.uniovi.eii.ds.main.Editor;

public class Open implements Instruction {
	private String[] text;
	private Editor editor;
	
	

	public Open(String[] text, Editor editor) {
		this.text = text;
		this.editor = editor;
	}



	@Override
	public void execute() {
		editor.open(text);
	}

}
