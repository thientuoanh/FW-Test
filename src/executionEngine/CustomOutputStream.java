package executionEngine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;



public class CustomOutputStream extends OutputStream {
	private JTextArea textArea;
	public BufferedWriter writerr;
	private String str = "";
	private boolean logActionCmd = false;

	public CustomOutputStream(JTextArea textArea) throws IOException {
		this.textArea = textArea;
	}

	@Override
	public void write(int b) throws IOException {
		str += String.valueOf((char) b);
		if (str.endsWith("\r\n")) {
			if ((str.contains("org.openqa.selenium.interactions.Actions")
					|| str.contains("When using the W3C Action commands")) && !logActionCmd) {
				str = "";
			}

			if (!str.isEmpty()) {
				// redirects data to the text area
				textArea.append(str);
				// scrolls the text area to the end of data
				textArea.setCaretPosition(textArea.getDocument().getLength());
				// keeps the textArea up to date
				textArea.update(textArea.getGraphics());
				try {
					writerr = new BufferedWriter(new FileWriter("LogFile333.txt", true));
					writerr.write(str);

				} catch (Exception e) {
					System.out.println(e);
				} finally {
					writerr.close();
					str = "";
				}
			}
		}
	}

	public void closeFile() throws IOException {
		writerr.close();
	}
}