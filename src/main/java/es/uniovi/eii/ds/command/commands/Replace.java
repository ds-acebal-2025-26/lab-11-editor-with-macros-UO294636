package es.uniovi.eii.ds.command.commands;

import es.uniovi.eii.ds.command.Instruction;
import es.uniovi.eii.ds.main.Editor;

public class Replace implements Instruction {
	
	private Editor editor;
	private String[] args;
	

	public Replace(Editor editor,String[] argsToCheck) {
		this.editor = editor;
		this.args = argsToCheck;
	}


	@Override
	public void execute() {
		editor.replace(args);

	}

}
