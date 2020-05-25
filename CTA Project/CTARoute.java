package ctaProject;

import java.util.ArrayList;

public class CTARoute extends CTAStation {
	// lines
	private ArrayList<CTAStation> redLine;
	private ArrayList<CTAStation> greenLine;
	private ArrayList<CTAStation> blueLine;
	private ArrayList<CTAStation> brownLine;
	private ArrayList<CTAStation> purpleLine;
	private ArrayList<CTAStation> pinkLine;
	private ArrayList<CTAStation> orangeLine;
	private ArrayList<CTAStation> yellowLine;
	private ArrayList<ArrayList<CTAStation>> Lineset;

	public CTARoute() {
		redLine = new ArrayList<CTAStation>();
		greenLine = new ArrayList<CTAStation>();
		blueLine = new ArrayList<CTAStation>();
		brownLine = new ArrayList<CTAStation>();
		purpleLine = new ArrayList<CTAStation>();
		pinkLine = new ArrayList<CTAStation>();
		orangeLine = new ArrayList<CTAStation>();
		yellowLine = new ArrayList<CTAStation>();
		Lineset = new ArrayList<ArrayList<CTAStation>>();
	}

	//set each color lines and put them into line Arraylist. and sort them by order of the index.
	public void setLine() {
		Lineset.add(redLine);
		Lineset.add(greenLine);
		Lineset.add(blueLine);
		Lineset.add(brownLine);
		Lineset.add(purpleLine);
		Lineset.add(pinkLine);
		Lineset.add(orangeLine);
		Lineset.add(yellowLine);

		try {
			for (CTAStation s : Stations) {
				for (int i = 0; i < Lineset.size(); i++) {
					if (s.getColorIdx()[i] != -1) {
						Lineset.get(i).add(s);
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {;}

		for (int i = 0; i < Lineset.size(); i++) {
			sortLine(Lineset.get(i), i);
		}
	}

	// sorting lines into Ascending
	public void sortLine(ArrayList<CTAStation> line, int lineindex) {
		for (int i = 0; i < line.size(); i++) {
			if (line.get(i).getColorIdx()[i] != -1) {
				for (int j = 0; j < line.get(i).getColorIdx().length; j++) {
					for (int k = j + 1; k < line.get(i).getColorIdx().length; k++) {
						if (line.get(i).getColorIdx()[j] > line.get(i).getColorIdx()[k]) {
							int temp = line.get(i).getColorIdx()[j];
							line.get(i).getColorIdx()[j] = line.get(i).getColorIdx()[k];
							line.get(i).getColorIdx()[k] = temp;
						}
					}
				}
			}
			CTAStation s = line.get(i);
			line.set(i, line.get(i));
			line.set(i, s);

		}
	}

	public ArrayList<ArrayList<CTAStation>> getRoute() {
		return this.Lineset;
	}

//	@Override method of the class CTAStation
	public void addStation() {
		super.addStation();
		setLine();
	}

//	@Override method of the class CTAStation
	public void deleteStation() {
		super.deleteStation();
		setLine();
	}

//	@Override method of the class CTAStation
	public void modifyStation() {
		super.modifyStation();
		setLine();
	}

}
