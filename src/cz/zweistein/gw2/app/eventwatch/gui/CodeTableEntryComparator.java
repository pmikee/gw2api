package cz.zweistein.gw2.app.eventwatch.gui;

import java.util.Comparator;

public class CodeTableEntryComparator implements Comparator<CodeTableItem> {

	@Override
	public int compare(CodeTableItem arg0, CodeTableItem arg1) {
		return arg0.toString().compareTo(arg1.toString());
	}

}
