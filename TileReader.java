package start.Java;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @param fname: grabs file name
 * @param fsc: scanner
 * @param tilesread: tiles stored within list 
 *
 */
public class TileReader {
	public ArrayList<Tile> readFromText(String fname) {
		File f = new File(fname);
		return readFromText(f);
	}
	public ArrayList<Tile> readFromText(File f) {
		try {
			ArrayList<Tile> tilesRead = new ArrayList<Tile>();
			Scanner fsc = new Scanner(f); //opens scanner
			String line;
			String[] parts;
			int color, shape;
			Tile tile; //new params are set
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				parts = line.split(" ");
				color = Integer.parseInt(parts[0]);
				shape = Integer.parseInt(parts[1]);
				tile = new Tile(color,shape);
				tilesRead.add(tile);
			}
			fsc.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;  
						  
		}
	}
	/**
	 * 
	 * @param fname: file
	 * @return if true
	 * These functions allow for file type conversions to be made 
	 */
	public ArrayList<Tile> readFromBinary(String fname) {
		File f = new File(fname); //file can be opened
		return readFromBinary(f);
	}
	public ArrayList<Tile> readFromBinary(File f) {
		try {
			ArrayList<Tile> tilesRead;
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			tilesRead = (ArrayList<Tile>)ois.readObject();
			ois.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;
		}
	}
	public ArrayList<Tile> readFromXML(String fname) {
		File f = new File(fname);
		return readFromXML(f);
	}
	public ArrayList<Tile> readFromXML(File f) { //can determine different file types
		try {
			ArrayList<Tile> tilesRead;
			XMLDecoder dec = new XMLDecoder(
					new BufferedInputStream(new FileInputStream(f)));
			tilesRead = (ArrayList<Tile>)dec.readObject();
			dec.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;
		}
	}
	public ArrayList<Tile> read(String fname) {
		File f = new File(fname);
		return read(f);
	}
	public ArrayList<Tile> read(File f) {
		try {
			String fname = f.getName().toUpperCase(); //more file types
			if (fname.endsWith(".TXT")) {
				return readFromText(f);
			} else if (fname.endsWith(".BIN")) {
				return readFromBinary(f);
			} else if (fname.endsWith(".XML")) {
				return readFromXML(f);
			} else {
				return null;  
			}
		} catch (Exception ex) {
			return null;
		}
	}
}
