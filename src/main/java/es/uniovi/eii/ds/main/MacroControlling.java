package es.uniovi.eii.ds.main;

import es.uniovi.eii.ds.command.Instruction;
import es.uniovi.eii.ds.command.commands.Macro;

public class MacroControlling {
	private boolean isRecording = false;
	private Macro actual;
	
	public void record() {
		isRecording = true;
		actual = new Macro();
	}
	public Macro stop() {
		isRecording = false;
		return actual;
	}
	public void add(Instruction ins) {
		if (isRecording) {
			actual.addInstruction(ins);
		}
	}
	public void execute() {
		actual.execute();
	}
	public Macro getMacro() {
		return actual;
	}

}
