import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

public class DFTGui {
	private JPanel panelMain;
	private JToggleButton performButton;
	private JRadioButton oldSyncRadioButton;
	private JRadioButton newSyncRadioButton;
	private JTextField numThreadTF;
	private JTextField matrixSizeTF;
	private JTextArea testResultTA;
	private JToggleButton showTestResultsButton;
	private JTextArea warningMsg;

	private String syncModel = "old";
	private final int DEF_THREAD_NUM = 1;
	private final int DEF_MATRIX_SIZE = 4;
	private int numThreads;
	private int matrixSize;
	private DFTSwingWorker worker;
	private List<ThreadsIncorporated.ParallelDFT> threads;

	class DFTSwingWorker extends SwingWorker<Void, Void>
	{
		protected Void doInBackground() throws Exception {
			long startTime = System.nanoTime();
			testDFT();
			long endTime = System.nanoTime();
			double executionTime = (endTime - startTime) / 1000000000.0;
			if (numThreads > 1) {
				testResultTA.setText(">> Execution Time of " + numThreads + " thread is " + executionTime + " seconds.");
			}
			else {
				testResultTA.append("\n>> Execution Time of single thread is " + executionTime + " seconds.");
			}
			return null;
		}

		@Override
		protected void done() {
			if (!isCancelled()) {
				if (numThreads > DEF_THREAD_NUM) {
					showTestResultsButton.setVisible(true);
				} else {
					showTestResultsButton.setVisible(false);
					performButton.setEnabled(true);
				}
				System.out.println("DFT Calculation complete.");
				performButton.setText("R U N");
				showTestResultsButton.setText("Show Test Results");
				performButton.setSelected(false);
				showTestResultsButton.setSelected(false);
			}
			else {
				System.out.println("DFT Calculation aborted.");
				if (threads != null) {
					for (ThreadsIncorporated.ParallelDFT thread : threads) {
						thread.finished = true;
					}
				}
			}
		}

	}

	private DFTGui() {
		numThreads = DEF_THREAD_NUM;
		matrixSize = DEF_MATRIX_SIZE;
		performButton.addItemListener(itemEvent -> {

			int state = itemEvent.getStateChange();

			if (state == ItemEvent.SELECTED) {
				// start the threads.
				performButton.setText("C A N C E L");
				System.out.println(syncModel);
				showTestResultsButton.setVisible(false);

				String text = numThreadTF.getText();
				numThreads = text.equals("") ? DEF_THREAD_NUM : Integer.parseInt(text);
				warningMsg.setText("Calculating the DFT with " + numThreads + " threads. Please wait...");
				text = matrixSizeTF.getText();
				matrixSize = text.equals("") ? 4 : Integer.parseInt(text);

				(worker = new DFTSwingWorker()).execute();
			}
			else {
				performButton.setText("R U N");
				warningMsg.setText("");
				worker.cancel(true);
			}
		});

		showTestResultsButton.addItemListener(itemEvent -> {
			int state = itemEvent.getStateChange();

			if (state == ItemEvent.SELECTED) {
				// Calculate for single thread
				// It takes the previous matrix size from the multiple thread dft calculation.
				showTestResultsButton.setText("cancel");
				numThreads = DEF_THREAD_NUM;
				warningMsg.setText("Calculating the DFT with " + DEF_THREAD_NUM + " thread. Please wait...");
				performButton.setEnabled(false);
				(worker = new DFTSwingWorker()).execute();
			}
			else {
				worker.cancel(true);
				showTestResultsButton.setText("Show Test Results");
				warningMsg.setText("");
				performButton.setEnabled(true);
			}
		});
		oldSyncRadioButton.addActionListener(e -> syncModel = "old");
		newSyncRadioButton.addActionListener(e -> syncModel = "new");
		showTestResultsButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				showTestResultsButton.setForeground(Color.WHITE);
				showTestResultsButton.setBackground(new Color(36,39,41));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				showTestResultsButton.setForeground(new Color(255,164,51));
				showTestResultsButton.setBackground(new Color(60,63,65));
			}
		});

		// TODO: Multiple buttons to same event
		performButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				performButton.setForeground(Color.WHITE);
				performButton.setBackground(new Color(36,39,41));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				performButton.setForeground(new Color(255,164,51));
				performButton.setBackground(new Color(60,63,65));
			}
		});
	}

	public static void main(String[] args) throws InterruptedException {
		SwingUtilities.invokeLater(() -> {
			DFTGui dftGui = new DFTGui();
			JFrame frame = new JFrame("DFTGui");
			frame.setContentPane(dftGui.panelMain);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setSize(500,400);
			frame.setVisible(true);
			dftGui.performButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			dftGui.showTestResultsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

			dftGui.testResultTA.setEditable(false);
			dftGui.showTestResultsButton.setVisible(false);
		});

	}

	private void testDFT() throws InterruptedException{
		System.out.println("matrixSize: " + matrixSize);
		int rowSize = matrixSize;
		int colSize = matrixSize;

		Complex[][] A = UtilsMatrix.createComplexMatrix(rowSize, colSize);
		Complex[][] B = UtilsMatrix.createComplexMatrix(rowSize, colSize);

		// To test these inputs comment the parts above and uncomment this section.
		/*double[][] testReal = {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 70, 80, 90, 0, 0, 0},
				{0, 0, 90, 100, 110, 0, 0, 0},
				{0, 0, 110, 120, 130, 0, 0, 0},
				{0, 0, 130, 140, 150, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0}
		};
		int rowSize = 8;
		int colSize = 8;
		Complex[][] A = UtilsMatrix.createComplexMatrix(rowSize, colSize);
		Complex[][] B = UtilsMatrix.createComplexMatrix(rowSize, colSize);
		UtilsMatrix.setRealPart2D(A, testReal);*/

		// Test 2
		/*double[][] testReal = {{0.5, 0.5, 0.5, 0.5},
							 {0, 0, 0, 0},
							 {0.5, 0.5, 0.5, 0.5},
							 {0, 0, 0, 0}};
		int rowSize = 4;
		int colSize = 4;
		Complex[][] A = UtilsMatrix.createComplexMatrix(rowSize, colSize);
		Complex[][] B = UtilsMatrix.createComplexMatrix(rowSize, colSize);
		UtilsMatrix.setRealPart2D(A, testReal);*/

		int numParts = numThreads;
		int rowPartSize;
		int curRowPartSize;
		int lastRowPartSize;

		threads = new ArrayList<>();

		ThreadsIncorporated threadsIncorporated = new ThreadsIncorporated();

		if (syncModel.equals("old")) {
			threadsIncorporated.barrier = new BarrierV1(numThreads, rowSize, colSize);
		}
		else {
			threadsIncorporated.barrier = new BarrierV2(numThreads, rowSize, colSize);
		}
		System.out.println(threadsIncorporated.barrier.syncModel);

		rowPartSize = rowSize / numParts;
		curRowPartSize = rowPartSize;
		for (int i = 0; i < numParts; i++) {
			if (i == numParts - 1) {
				lastRowPartSize = rowPartSize + rowSize % numParts;
				if (lastRowPartSize != curRowPartSize) {
					curRowPartSize = lastRowPartSize;
				}
			}
			threads.add(new ThreadsIncorporated.ParallelDFT(threadsIncorporated.barrier, A, B,
					rowPartSize * i, curRowPartSize,
					0, colSize));
			threads.get(threads.size()-1).start();
		}
		// Wait for threads to terminate after they calculate dft of A+B.
		for (int i = 0; i < numThreads; i++)
			threads.get(i).join();
		System.out.println("Calculation of DFT of A+B is completed.");
		if (A.length <= 16 && A[0].length <= 16) {
			UtilsMatrix.print2DComplexMatrix(threadsIncorporated.barrier.getResult());
		}
	}
}
