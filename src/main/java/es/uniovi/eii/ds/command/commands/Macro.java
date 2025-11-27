package es.uniovi.eii.ds.command.commands;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.eii.ds.command.Instruction;

public class Macro implements Instruction {
	private List<Instruction> macro = new ArrayList<Instruction>();
	
	public void addInstruction(Instruction instruction) {
		macro.add(instruction);
	}

	@Override
	public void execute() {
		for (Instruction ins : macro) {
			ins.execute();
		}

	}

}
